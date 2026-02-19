# 🗳 Decentralized Voting System

A secure and transparent voting application built using **Spring Boot, Java, and Blockchain Concepts**.
This project demonstrates how blockchain principles like **hash chaining, immutability, and verification** can be applied to build a tamper-proof digital voting system without using cryptocurrency.

---

## 📌 Project Objective

Traditional digital voting systems rely on centralized databases that can be altered.
This project introduces a **blockchain-inspired architecture** where:

* Each vote is stored as a **block**
* Blocks are **cryptographically linked using SHA-256 hashing**
* Votes become **immutable (cannot be modified or deleted)**
* Duplicate voting is prevented
* Results are **transparent and verifiable**

---

## 🚀 Features

✅ One-Person-One-Vote Enforcement
✅ Blockchain-Based Vote Storage
✅ SHA-256 Hashing for Data Integrity
✅ Tamper Detection via Chain Validation
✅ Real-Time Voting Analytics (Chart.js Dashboard)
✅ Automatic Winner Detection
✅ RESTful API Architecture
✅ Responsive Frontend using HTML, CSS & Bootstrap
✅ In-Memory H2 Database for Fast Testing

---

## 🏗️ System Architecture

Frontend (HTML + JS + Bootstrap)
⬇ REST API Calls
Spring Boot Backend
⬇
Blockchain Engine (Hash Linked Blocks)
⬇
H2 Database (Duplicate Vote Validation)

---

## 🔐 How Blockchain Is Used

Each vote becomes a block containing:

* Voter ID
* Candidate Name
* Timestamp
* Previous Block Hash
* Current Block Hash

If any vote is modified:
→ Hash changes
→ Chain breaks
→ System detects tampering instantly.

---

## 🛠️ Tech Stack

| Layer            | Technology                       |
| ---------------- | -------------------------------- |
| Backend          | Spring Boot, Java                |
| Blockchain Logic | Custom Hash-Chained Blocks       |
| Database         | H2 (In-Memory)                   |
| Frontend         | HTML, CSS, Bootstrap, JavaScript |
| Visualization    | Chart.js                         |
| Build Tool       | Maven                            |
| IDE              | Eclipse / IntelliJ               |

---

## 📂 Project Structure

```
com.voting
│
├── controller      → REST APIs
├── service         → Business Logic
├── model           → Vote Entity
├── repository      → Database Access
├── blockchain      → Block & Chain Implementation
└── resources/static → Frontend Files
```

---

## ▶️ How to Run the Project

### 1️⃣ Clone Repository

```
git clone https://github.com/your-username/blockchain-voting.git
```

### 2️⃣ Open in IDE

Import as **Maven Project** in Eclipse / IntelliJ.

### 3️⃣ Run Application

```
Run As → Spring Boot App
```

### 4️⃣ Access Web App

```
http://localhost:8080
```

---

## 🔎 API Endpoints

| Method | Endpoint             | Description        |
| ------ | -------------------- | ------------------ |
| POST   | `/api/vote`          | Cast a vote        |
| GET    | `/api/vote/chain`    | View blockchain    |
| GET    | `/api/vote/validate` | Validate integrity |

---

## 📊 Dashboard Capabilities

* Visual vote distribution using charts
* Detect leading candidate automatically
* Validate blockchain authenticity in real time

---

## 🧠 Learning Outcomes

This project demonstrates:

* Applying **blockchain principles without cryptocurrency**
* Designing tamper-proof systems using **hash functions**
* Building full-stack applications with **Spring Boot + JS**
* Creating transparent and auditable workflows

---

## 📷 Screenshots (Add Yours)

Add screenshots here after running the project:

```
/screenshots/dashboard.png
/screenshots/chart.png
/screenshots/blockchain.png
```

---

## 🌟 Future Enhancements

* JWT-based voter authentication
* Distributed node simulation
* Smart-contract-style validation
* Cloud deployment (AWS / Docker)
* Real database integration (MySQL/PostgreSQL)

---

## 👨‍💻 Author

**Rajkumar**
Java Full Stack Developer

---

## 📜 License

This project is for educational and demonstration purposes.

