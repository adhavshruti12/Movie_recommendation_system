import pandas as pd
import pickle
from flask import Flask, request, jsonify

app = Flask(__name__)

# Load the saved KNN model
with open('knn_model.pkl', 'rb') as f:
    model = pickle.load(f)

# Sample user-movie ratings data (same as before)
data = {
    'user_id': [1, 1, 2, 2, 3, 3],
    'movie_id': [101, 102, 101, 103, 102, 103],
    'rating': [5, 3, 4, 4, 2, 5]
}
df = pd.DataFrame(data)
user_movie_matrix = df.pivot(index='user_id', columns='movie_id', values='rating').fillna(0)

# Route to get movie recommendations for a user
@app.route('/recommend', methods=['POST'])
def recommend():
    user_id = request.json['user_id']
    if user_id not in user_movie_matrix.index:
        return jsonify({"error": "User not found"}), 404
    
    # Get the user's movie ratings
    user_ratings = user_movie_matrix.loc[user_id].values.reshape(1, -1)
    
    # Find similar users
    distances, indices = model.kneighbors(user_ratings, n_neighbors=2)
    
    similar_user_id = user_movie_matrix.index[indices.flatten()[1]]  # Get the first nearest neighbor (skip self)
    
    # Recommend movies rated highly by the similar user
    similar_user_ratings = user_movie_matrix.loc[similar_user_id]
    recommended_movie_ids = similar_user_ratings[similar_user_ratings > 4].index.tolist()
    
    return jsonify({
        "recommended_movies": recommended_movie_ids
    })

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000)
