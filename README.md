# kotlin-azure-functions-payments

A lightweight payment backend built with **Kotlin** and **Azure Functions**, designed for mobile apps.  
This project demonstrates how to build serverless HTTP APIs using the Azure Functions Java worker, Gradle, and clean Kotlin code.

---

## 🚀 Features

- Serverless backend using **Azure Functions**
- Written entirely in **Kotlin**
- Built with **Gradle 8.14.4**
- JSON serialization using **Jackson Kotlin module**
- Two fully working endpoints:
  - `POST /payments` — Create a payment
  - `GET /payments/{id}` — Retrieve a payment by ID
- No database yet — uses in‑memory storage for simplicity
- Deployable directly from **VS Code** using the Azure Functions extension
- Designed to be consumed by a Jetpack Compose Android app

---


## 📂 Project Structure
│  
├── src/main/kotlin/com/learn/payment/  
│   ├── functions/        # Azure Function triggers (POST, GET)  
│   ├── models/           # Request/response data classes  
│   ├── services/         # Business logic layer  
│   └── repository/       # In-memory storage (placeholder for DB)  
│  
├── build.gradle.kts      # Gradle build configuration  
├── host.json             # Azure Functions host config  
├── local.settings.json   # Local secrets (ignored in Git)  
└── README.md  

---

## 🛠️ Tech Stack

| Component | Technology |
|----------|------------|
| Language | Kotlin |
| Runtime | Azure Functions (Java worker) |
| Build Tool | Gradle 8.1.4 |
| JSON | Jackson Kotlin module |
| Deployment | VS Code Azure Functions extension |
| Storage | In-memory (no DB yet) |

---

## 📡 API Endpoints

### **POST /api/payments**
Creates a new payment.

**Request Body**
```json
{
  "amount": 120,
  "currency": "GBP",
  "description": "Annual Fees"
}

Response: 
{
  "id": "generated-id",
  "status": "SUCCESS",
  "amount": 120,
  "currency": "GBP"
}
