# Blogging Application API

* Blogging Application, which allows users to create
account, sign in their account and manage posts, comment on posts, manage categories, and perform user-related operations.


* Implemented CRUD operations with data validation, MySQL database configuration, Hibernate ORM tool,
Swagger integration, JWT authentication and established table relationships.

* Tech stack used: Spring Boot, Hibernate, MySQL, OOPs, Postman, Swagger, and Java

## Prerequisites
* ![MySql](https://img.shields.io/badge/DBMS-MYSQL%205.7%20or%20Higher-red)
 * ![SpringBoot](https://img.shields.io/badge/Framework-SpringBoot-green)
 * ![Java](https://img.shields.io/badge/Language-Java%208%20or%20higher-yellow)
 * ![Hibernate](https://img.shields.io/badge/ORM-Hibernate-green)


## Installation

To run this application locally, you will need to have Java and MySQL installed on your machine.

* Clone the repository to your local machine.
* Create a new MySQL database called `restaurant_management`
* Update the `application.properties` file in the `src/main/resources` directory to include your MySQL username and password
* Run the application using your IDE or by running the command `mvn spring-boot:run` in the project directory
* Access the APIs using any HTTP client such as Postman or cURL.
 
 >## API Documentation
The API endpoints will be available at swagger documentation
```
http://localhost:8080/swagger-ui/index.html#/
```


## Schemas

The following schemas are used in the API responses:

### ApiResponse
```json
{
  "message": "string",
  "success": true
}
```

### CategoryDto
```json
{
  "categoryId": 1,
  "categoryTitle": "string",
  "categoryDescription": "string"
}
```

### CommentDto
```json
{
  "content": "string",
  "id": 1
}
```

### JwtAuthRequest
```json
{
  "username": "string",
  "password": "string"
}
```

### JwtAuthResponse
```json
{
  "token": "string"
}
```

### ModelAndView
```json
{
  "empty": true,
  "model": {},
  "modelMap": {},
  "reference": true,
  "status": "string",
  "view": {},
  "viewName": "string"
}
```

### PostDtoReq
```json
{
  "addedDate": "string (date-time)",
  "category": {...},
  "comments": [...],
  "content": "string",
  "imageName": "string",
  "postId": 1,
  "title": "string",
  "user": {...}
}
```

### PostDtoRes
```json
{
  "addedDate": "string (date-time)",
  "category": {...},
  "comments": [...],
  "content": "string",
  "imageName": "string",
  "postId": 1,
  "title": "string",
  "user": {...}
}
```

### PostResponse
```json
{
  "content": [...],
  "lastPage": true,
  "pageNumber": 1,
  "pageSize": 10,
  "totalElements": 20,
  "totalPages": 2
}
```

### RoleDto
```json
{
  "id": 1,
  "name": "string"
}
```

### UserDtoReq
```json
{
  "about": "string",
  "email": "string",
  "id": 1,
  "name": "string",
  "password": "string",
  "roles": [...]
}
```

### UserDtoRes
```json
{
  "about": "string",
  "email": "string",
  "id": 1,
  "name": "string",
  "roles": [...]
}
```

### View
```json
{
  "contentType": "string"
}
```

## Endpoints

>**Auth controller**

```
POST /api/v1/auth/login
```

Description: Authenticates a user and generates a JWT token.

```
POST /api/v1/auth/register
```
Description: Registers a new user.

>**Category Controller**

```
GET /api/categories/
```
Description: Get all categories.

```
POST /api/categories/
```
Description: Create a new category.

```
GET /api/categories/{catId}
```
Description: Get a category by its ID.

```
PUT /api/categories/{catId}
```
Description: Update a category by its ID.
```
DELETE /api/categories/{catId}
```
Description: Delete a category by its ID.

>**Comment Controller**

```
DELETE /api/comments/{commentId}
```
Description: Delete a comment by its ID.

```
POST /api/comments/post/{postId}/comments
```
Description: Create a new comment for a post.

>**Post Controller**

```
GET /api/category/{categoryId}/posts
```
Description: Get all posts for a specific category.

```
GET /api/post/image/{imageName}
```
Description: Download an image associated with a post by its image name.

```
POST /api/post/image/{postId}
```
Description: Upload an image for a post.
Request Body: (Form data with an image file)

```
GET /api/posts/
```
Description: Get all posts.
```
GET /api/posts/{postId}
```
Description: Get a post by its ID.

```
PUT /api/posts/{postId}
```
Description: Update a post by its ID.

>**User controller**

```
POST : localhost:8080/api/v1/auth/register
```
Description: Register a user

```
Post: localhost:8080/api/v1/auth/login
```
Description: Login a user

## Contributors
Satyam Jaiswal [LinkedIn](https://www.linkedin.com/in/satyam-jais/)

## Conclusion
The Blogging Application using Spring Boot is a user-friendly and efficient application that helps to write blogs. This application provides an easy-to-use interface for user to attach a image, write blog, comment on other blogs without revealing their identity and perform CRUD operations.

### **Feedback**

Feel free to update this project and contribute. Always ready to further feedback as many things need to be improved in this project
