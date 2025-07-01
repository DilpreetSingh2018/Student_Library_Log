# Student Library Log System

## Overview

The Student Library Entry Management System is a web-based application designed to manage and track student entries and exits in a library environment. Built using Spring Boot, Thymeleaf, and MySQL, this system provides a streamlined interface for administrators and students to monitor library usage, maintain accurate attendance logs, and manage student records efficiently.

## Features

- Student check-in/check-out with automatic time logging
- View and manage all student records
- View entry/exit logs, sorted by in-library status and recency
- Add new students via a user-friendly form
- Error handling with prompts to add a student if UID not found
- Responsive, modern UI with separate CSS

## Technical Stack

- Backend: Spring Boot, Spring Data JPA
- Frontend: Thymeleaf (HTML/CSS/JavaScript)
- Database: MySQL
- Build Tool: Maven or Gradle

## Installation and Setup

1. Clone the repository
2. Configure your MySQL database and update `application.properties` with your credentials
3. Build the project using Maven or Gradle
4. Run the Spring Boot application
5. Access the application at `http://localhost:8080`

## Usage

- Admins can add and view students and logs
- Students check in/out using their UID; system records attendance

## Project Structure

- `controller/`: Spring MVC controllers
- `model/`: JPA entity classes
- `repositories/`: Spring Data JPA repositories
- `templates/`: Thymeleaf HTML templates
- `static/`: CSS and static resources

## Contributing

Contributions are welcome! Please fork the repository and submit pull requests.

## License

This project is licensed under the MIT License.

## Contact

For questions or support, please contact the project maintainer.
+91 9888042018
Dilpreet2018singh@gmail.com

