# SwiggyBackend
Swiggy-Like Food Delivery System: A Spring Boot application for managing a food delivery platform with efficient data retrieval using pagination and sorting. Includes detailed API documentation with Swagger and error handling for a seamless user experience."


# Swiggy-Like Food Delivery System

## Description
This Spring Boot application is designed to manage a food delivery system similar to Swiggy, encompassing Users, Restaurants, Customers, Orders, and Delivery Partners. The application provides a range of features, including user authentication, role-based access control, pagination, sorting, logging, and API documentation with Swagger.

## Features

### User Authentication and Authorization (this is pending)
- Role-Based Access Control: Users are assigned roles (User or Admin) and access rights are restricted accordingly. Admins have unrestricted access to all APIs.
- Secure Login: Users must authenticate as either User or Admin to access the application.

### Role-Based APIs
- User Level APIs (User Role):
  - Register User: POST /users - Register a new user.
  - User Authentication: POST /auth/login - Authenticate a user and return JWT.
  - Create Order: POST /orders/{userId} - Allow a user to create an order.
  - Add Product to Order: PUT /orders/{orderId}/products - Allow a user to add a product to an order.
  - Update Order Details: PUT /orders/{orderId} - Allow a user to update order details.
  - Fetch Order History: GET /users/{userId}/orders - Fetch a user's order history.
  - Recommend Products: GET /users/{userId}/recommended-products - Recommend products to a user based on order history.

- Admin Level APIs (Admin Role):
  - Add Products: POST /products - Add new products.
  - Add Categories: POST /categories - Add new categories.
  - Add Admin User: POST /users/admin - Add new users (admin).
  - Delete Order (Admin): DELETE /orders/{orderId}/admin - Delete an order (admin).
  - Fetch Users (Admin): GET /users/admin - Fetch all users (admin).
  - Fetch Products (Admin): GET /products/admin - Fetch all products (admin).
  - Fetch Categories (Admin): GET /categories/admin - Fetch all categories (admin).

### Implementation Points
- Entity Classes: User, Restaurant, Customer, Order, Delivery Partner.
- Role-Based Access Control: Users are authenticated and authorized based on their roles (User or Admin).
- Pagination and Sorting: GET APIs support pagination and sorting for efficient data retrieval.
- Logging: Utilizes a logging framework to record important events during application execution.
- Swagger Documentation: API documentation with Swagger, including endpoint details and input/output models.

### Frontend Requirements
- Basic frontend interface for user interaction using HTML, CSS, and JavaScript.
- User-friendly Sign In/Sign Up page for user registration and authentication.
- Forms for adding new Restaurants, Customers, and Delivery Partners, placing orders, and updating order status.
- Page to display a customer's order history.

### Exception Handling and Data Validation
- Custom exception classes for handling specific validation and exception cases.
- Appropriate HTTP status codes for error handling in the controller class.
- Input validation on the backend (Java) and frontend (JavaScript) for data consistency.
- Display of backend validation error messages on the frontend.





### Feel free to contribute to this project by making pull requests or raising issues.



