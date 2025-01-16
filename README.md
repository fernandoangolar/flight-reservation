# ✈ Flight Reservation System

A simple **Flight Reservation System** built with **Spring Boot**, providing a structured way to book flights, manage users, process payments, and notify customers.

---

## 📌 Features

### 1. User Management
- User registration and authentication (JWT-based).
- Role-based access control (`CUSTOMER`, `ADMIN`).

### 2. Flight Management
- Create, update, and cancel flights (Admin only).
- View available flights.
- Search flights by destination, date, and price.

### 3. Booking System
- Customers can book flights.
- Seat selection (automated or manual).
- Booking confirmation and cancellation.

### 4. Payment Processing
- Secure payment integration (simulated).
- Multiple payment methods (`Credit Card`, `PayPal`, `Bank Transfer`).
- Payment status tracking (`Pending`, `Completed`, `Failed`).

### 5. Notifications
- Email/SMS notifications for booking confirmations and flight updates.

### 6. Admin Dashboard (Optional - Future Scope)
- View booking analytics.
- Generate revenue and occupancy reports.

---

## 🛠 Tech Stack

| Technology  | Description |
|-------------|------------|
| **Spring Boot** | Backend framework |
| **Spring Security** | Authentication & Authorization |
| **Spring Data JPA** | ORM for database management |
| **PostgreSQL / MySQL** | Relational database |
| **Hibernate** | ORM implementation |
| **Flyway** | Database migration tool |
| **Lombok** | Reduces boilerplate code |
| **JWT** | Secure user authentication |
| **Thymeleaf (Optional)** | Server-side templating (if needed) |

---

## 📑 System Architecture

The system follows a **layered architecture**:

1. **Controller Layer** (Handles API requests)
2. **Service Layer** (Business logic)
3. **Repository Layer** (Database operations with JPA)
4. **Security Layer** (Authentication & Authorization)

---

## 📌 API Endpoints

### 1. User Authentication
| Method | Endpoint | Description |  
|--------|---------|-------------|  
| `POST` | `/auth/register` | User registration |  
| `POST` | `/auth/login` | User login (JWT) |  

### 2. Flight Management (Admin Only)
| Method | Endpoint | Description |  
|--------|---------|-------------|  
| `POST` | `/flights` | Add a new flight |  
| `PUT` | `/flights/{id}` | Update flight details |  
| `DELETE` | `/flights/{id}` | Cancel a flight |  

### 3. Flight Search (Public Access)
| Method | Endpoint | Description |  
|--------|---------|-------------|  
| `GET` | `/flights` | View all flights |  
| `GET` | `/flights/search?origin=X&destination=Y` | Search flights by route |  

### 4. Booking System
| Method | Endpoint | Description |  
|--------|---------|-------------|  
| `POST` | `/bookings` | Create a new booking |  
| `GET` | `/bookings/{id}` | View booking details |  
| `DELETE` | `/bookings/{id}` | Cancel a booking |  

### 5. Payments
| Method | Endpoint | Description |  
|--------|---------|-------------|  
| `POST` | `/payments` | Process a payment |  
| `GET` | `/payments/{id}` | View payment status |  

### 6. Notifications (Automatic)
| Event | Notification Type |  
|--------|-----------------|  
| Flight booked | Email/SMS confirmation |  
| Flight canceled | Email/SMS alert |  

---

## 🚀 Installation Guide

### 1️⃣ Prerequisites
- **JDK 17+**
- **Maven**
- **PostgreSQL/MySQL**
- **Postman (for testing API)**

### 2️⃣ Clone the Repository
```sh
git clone https://github.com/your-repo/flight-reservation.git
cd flight-reservation
```

### 3️⃣ Configure the Database
- Create a new database in PostgreSQL/MySQL
- Update `application.properties` or `application.yml`

Example for **PostgreSQL** (`src/main/resources/application.yml`):
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/flight_db
    username: postgres
    password: secret
  jpa:
    hibernate:
      ddl-auto: update
```

### 4️⃣ Run the Application
Use **Maven** to build and run the project:
```sh
mvn clean install
mvn spring-boot:run
```

Or use **Docker Compose** (if configured):
```sh
docker-compose up --build
```

### 5️⃣ Test the API
Open **Postman** and send requests to:
- `http://localhost:8080/auth/register`
- `http://localhost:8080/flights`

Or access **Swagger UI** (if enabled):
```sh
http://localhost:8080/swagger-ui/index.html
```

---

## 🛡 Security Features
✔ **JWT Authentication** for secure API access.
✔ **Role-based access control (RBAC)** (`CUSTOMER`, `ADMIN`).
✔ **Password encryption** using **BCrypt**.
✔ **Rate limiting** (Optional).

---

## 📌 Future Enhancements
✅ Add **seat selection** feature.
✅ Integrate with **real payment gateways (e.g., Stripe, PayPal)**.
✅ Build a **React/Vue frontend** for a complete web app.

---

## 🤝 Contributing
Contributions are welcome! Fork the repo, create a new branch, and submit a pull request.

---

## 📄 License
MIT License © 2025 Your Name

---

## 📞 Contact
✉ **Email**: your.email@example.com  
🌍 **LinkedIn**: [Your LinkedIn](https://linkedin.com/in/yourprofile)  
🚀 **GitHub**: [Your GitHub](https://github.com/yourgithub)  
