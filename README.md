# 💰 Personal Habit Tracker (Spring Boot + MySQL)

This is a simple personal expense tracker built using **Spring Boot**, **MySQL**, and **Postman**.  
It allows users to perform basic CRUD operations (Create, Read, Update, Delete) on their expenses.

---

## ✅ Features

- Add a new expense
- View all expenses
- Update an existing expense
- Delete an expense
- Backend validation using Java Bean Validation (`@Valid`)
- RESTful API with JSON
- MySQL database integration

---

## ⚙️ Tech Stack

- Java 17
- Spring Boot 3.2.5
- Spring Data JPA
- MySQL
- Maven
- Postman (for testing API)

---

## 🧪 API Endpoints

| Method | Endpoint             | Description             |
|--------|----------------------|-------------------------|
| GET    | `/api/expenses`      | Get all expenses        |
| GET    | `/api/expenses/{id}` | Get expense by ID       |
| POST   | `/api/expenses`      | Add new expense         |
| PUT    | `/api/expenses/{id}` | Update an expense       |
| DELETE | `/api/expenses/{id}` | Delete an expense       |

> All POST & PUT requests require a JSON body:
```json
{
  "title": "Grocery",
  "amount": 500.0,
  "date": "2024-06-01"
}
