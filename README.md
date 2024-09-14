# QuizApp

### Project Title
**QuizApp Microservices**

### Description
QuizApp is a microservices-based application designed for educational purposes. It consists of two main services: **Question Service** and **Quiz Service**. The application utilizes an **API Gateway** for URL management, **Eureka Server** and **Eureka Client** for service discovery, and **OpenFeign** for seamless inter-service communication.

### Architecture Overview
- **Question Service**: Responsible for managing the questions used in quizzes.
- **Quiz Service**: Handles the creation and management of quizzes, including quiz logic.
- **API Gateway**: Serves as a single entry point to the microservices, generalizing URLs for easier access.
- **Eureka Server**: Acts as a service registry for service discovery.
- **Eureka Client**: Enables services to register with the Eureka Server.
- **OpenFeign**: Simplifies inter-service communication, eliminating the need for hardcoded values like port numbers and IP addresses.

### Usage Instructions
1. **Access the API Gateway**:
   - The API Gateway is accessible at `http://localhost:8765`.
  
2. **Service Endpoints**:
   - Question Service: `http://localhost:8765/question-service`
   - Quiz Service: `http://localhost:8765/quiz-service`

### API Endpoints
#### Question Service
1. **Get All Questions**
   - **Method**: `GET`
   - **Endpoint**: `/question-service/question/allQuestions`
  
2. **Get Questions by Category**
   - **Method**: `GET`
   - **Endpoint**: `/question-service/question/category/{category}`
   - **Example**: 
     ```
     GET /question-service/question/category/Math
     ```
     Returns all Math questions.
  
3. **Add a New Question**
   - **Method**: `POST`
   - **Endpoint**: `/question-service/question/addQuestion`
   - **Request Payload**:
     ```json
     {
         "questionId": 1,
         "category": "Math",
         "difficultyLevel": "Easy",
         "questionTitle": "What is 2 + 2?",
         "option1": "3",
         "option2": "4",
         "option3": "5",
         "option4": "6",
         "rightAnswer": "option2"
     }
     ```

#### Quiz Service
4. **Create a New Quiz**
   - **Method**: `POST`
   - **Endpoint**: `/quiz-service/quiz/create`
   - **Request Payload**:
     ```json
     {
         "category": "Math",
         "numQues": 5,
         "title": "Math Basics Quiz"
     }
     ```
  
5. **Get a Quiz by ID**
   - **Method**: `GET`
   - **Endpoint**: `/quiz-service/quiz/get/{id}`
  
6. **Submit Quiz Answers**
   - **Method**: `POST`
   - **Endpoint**: `/quiz-service/quiz/submit/{id}`
   - **Request Payload**:
     ```json
     [
         {
             "id": 1,
             "answerSubmitByUser": "option2"
         },
         {
             "id": 2,
             "answerSubmitByUser": "option1"
         },
         {
             "id": 3,
             "answerSubmitByUser": "option4"
         }
         // Additional answers can be added as needed
     ]
     ```

---
