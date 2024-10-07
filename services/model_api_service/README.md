### **model_api_service**

#### Description

The `model_api_service` is a microservice that provides model-related functionalities, such as handling and managing data models. This service is built using **FastAPI** and is highly performant, designed to support operations such as creating and managing models, validating inputs, and more.

#### Key Features

- API to manage and validate data models
- Built with **FastAPI** for quick, asynchronous requests
- Focused on handling machine learning or statistical models
- Unit testing with **Pytest**

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
   pip install --no-cache-dir -i https://test.pypi.org/simple/ -r requirements_testpypi.txt --extra-index-url https://pypi.org/simple/
   ```
2. Start the FastAPI application:
   ```bash
   uvicorn app.main:app --reload
   ```
3. Build the Docker image:
   ```bash
   docker build -t model_api_service .
   ```
