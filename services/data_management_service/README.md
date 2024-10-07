### **data_management_service**

#### Description

The `data_management_service` is a microservice built using **FastAPI** that handles the management of user and item data. It includes features such as user registration, item creation, and querying user and item data. The service is lightweight and highly efficient, designed to scale seamlessly within a microservices architecture.

#### Key Features

- Fast and asynchronous API using **FastAPI**
- CRUD operations for users and items
- Easy-to-extend and modular codebase
- Unit tests with **Pytest**

#### Tech Stack

- Python
- FastAPI
- Docker
- Pytest

#### Getting Started

To run the service locally:

1. Install the dependencies:
   ```bash
   pip install -r requirements.txt wheel
   ```
2. Start the FastAPI application:
   ```bash
   uvicorn app.main:app --reload
   ```
3. Build the Docker image:
   ```bash
   docker build -t data_management_service .
   ```
