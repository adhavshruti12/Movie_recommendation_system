# Movie Recommendation System

## Overview

The Movie Recommendation System leverages machine learning to provide personalized movie recommendations based on user preferences. The system combines collaborative filtering and content-based filtering techniques to suggest movies. The architecture consists of a Spring Boot backend for API requests and a Flask-based recommendation engine that handles the machine learning algorithms.

## Features

- **User-specific recommendations:** Provides movie recommendations based on user history.
- **Collaborative filtering:** Recommends movies by analyzing user ratings and preferences.
- **Content-based filtering:** Suggests movies by analyzing movie metadata, genres, and user reviews.
- **NLP Analysis:** Improves recommendations by analyzing user reviews with Natural Language Processing (NLP) techniques.
- **Modular system:** The backend and recommendation engine are separate, allowing for easy scalability and independent improvement.

## Tech Stack

- **Backend API:** Spring Boot
- **Recommendation Engine:** Flask
- **Machine Learning:** Scikit-learn
  - Collaborative filtering
  - Content-based filtering
- **Database Management:** JPA (Java Persistence API)
- **Datasets:** `movies.csv`, `ratings.csv`
  - `movies.csv` contains `movieId`, `title`, and `genres`
  - `ratings.csv` contains `userId`, `movieId`, `rating`, and `timestamp`

## Architecture

1. **Spring Boot Backend**: 
   - Handles API requests for movie recommendations.
   - Provides real-time responses to users when they request recommendations via user ID.
   
2. **Flask-based Recommendation Engine**: 
   - Processes the data using machine learning models (collaborative filtering and content-based filtering) to generate recommendations.
   - Communicates with the Spring Boot API to deliver personalized recommendations.

## Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/yourusername/movierecommendation.git
   ```

2.Backend Setup (Spring Boot):

  Open the backend folder in your preferred IDE.
  Run the Spring Boot application

3. Flask Recommendation Engine:

   - Navigate to the Flask folder.
   - Install the required Python dependencies:

     ```bash
     pip install -r requirements.txt
     ```

   - Run the Flask server:

     ```bash
     python app.py
     ```

4. **Usage**

   **Requesting Recommendations via Postman**:

   1. Open Postman.
   2. Create a new request.
   3. Set the request method to `GET`.
   4. In the URL field, enter the following URL:

      ```
      http://localhost:8080/recommend/{userId}
      ```

      Replace `{userId}` with the actual user ID (e.g., `1`).

   5. Click **Send**.
   6. The response will return a list of recommended movies for the user with the specified `userId`.
