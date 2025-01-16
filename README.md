# AuditBank

## Overview
AuditBank is a reactive auditing system built using **Spring WebFlux**, **MongoDB**, and **Java 17**. It allows users to view their balances and transaction history in real-time.

## Features
1. **Real-Time Balance Updates**: View the effects of deposits and withdrawals immediately.
2. **Transaction Auditing**:
    - **Deposit**: Logs initial balance, deposit amount, final balance, user, and timestamp.
    - **Withdrawal**: Logs initial balance, withdrawal amount, final balance, withdrawal type, user, and timestamp.

## Technologies
- **Java 17**
- **Spring WebFlux** (Reactive programming model)
- **Spring Data MongoDB** (Reactive integration with MongoDB Atlas)
- **Lombok** (Reduces boilerplate code)
- **Swagger/OpenAPI** (API documentation)
- **JUnit & Reactor Test** (Testing)

## Getting Started

### Prerequisites
1. **Java 17** installed.
2. MongoDB Atlas connection details.
3. Add environment variables to `.env` file