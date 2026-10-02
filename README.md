# Registration Login Application

Full-stack registration and login application using React, Spring Boot, PostgreSQL, and JWT authentication.

## Tech Stack

### Frontend
- React
- Vite
- React Router

### Backend
- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- JWT
- BCrypt

### Database
- PostgreSQL

## Features

- User registration
- Input validation
- BCrypt password hashing
- User login
- JWT authentication
- Protected API endpoints
- Protected React routes
- Logout
- PostgreSQL persistence

## Backend

Runs on:

http://localhost:8080

## Frontend

Runs on:

http://localhost:5173

## API Endpoints

### Register

POST /api/auth/register

### Login

POST /api/auth/login

### Current User

GET /api/user/me

Requires:

Authorization: Bearer <JWT_TOKEN>

## Environment Variables

Backend requires:

DB_PASSWORD

JWT_SECRET

Example PowerShell:

```powershell
$env:DB_PASSWORD="your-password"
$env:JWT_SECRET="your-long-secret"