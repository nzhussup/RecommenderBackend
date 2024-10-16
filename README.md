# Recommender Backend Project

This is a backend project as an extension for a [Clustering-Based-SVDpp algorithm](https://github.com/nzhussup/Clustering-Based-SVDpp). In this project I implement my knowledge in code packaging, API development, microservices, containerization, container orchestration and CI/CD

## Technologies Used

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Python](https://img.shields.io/badge/Python-3670A0?style=for-the-badge&logo=python&logoColor=ffdd54)
![REST API](https://img.shields.io/badge/REST_API-005571?style=for-the-badge)
![Microservices](https://img.shields.io/badge/Microservices-0078D7?style=for-the-badge)
![Kubernetes](https://img.shields.io/badge/Kubernetes-326CE5?style=for-the-badge&logo=kubernetes&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)
![CI/CD](https://img.shields.io/badge/CI%2FCD-239120?style=for-the-badge&logo=github-actions&logoColor=white)
![GitHub Actions](https://img.shields.io/badge/GitHub_Actions-2088FF?style=for-the-badge&logo=github-actions&logoColor=white)
![Python Packaging](https://img.shields.io/badge/Python%20Packaging-3776AB?style=for-the-badge&logo=python&logoColor=white)
![FastAPI](https://img.shields.io/badge/FastAPI-009688?style=for-the-badge&logo=fastapi&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![Spring Web](https://img.shields.io/badge/Spring_Web-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Spring JDBC](https://img.shields.io/badge/SpringJDBC-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)
![Pytest](https://img.shields.io/badge/Pytest-0A9EDC?style=for-the-badge&logo=pytest&logoColor=white)
![JUnit](https://img.shields.io/badge/JUnit-25A162?style=for-the-badge&logo=junit5&logoColor=white)

## Project Overview

This project demonstrates the use of a microservices architecture to build scalable and modular applications, with services written in Python and Java. Each service is containerized using Docker, orchestrated with Kubernetes, and designed to interact with other services seamlessly. The project also includes a CI/CD pipeline for automated testing, building, and deployment using GitHub Actions.

## Features

- **Python-based microservices** for data processing and machine learning model management.
- **Java-based microservices** for handling user and item data with a well-defined API.
- **Kubernetes deployment** configurations for scalability and service orchestration.
- **Docker support** for containerization of all microservices.
- **GitHub Actions CI/CD pipeline** for automated builds and deployments.
- **Model Training Package** for a custom machine learning model pipeline.
- **Unit Testing** for all services using `pytest` and `JUnit`.

## Directory Structure

The repository is organized into the following sections:

```
.
├── LICENSE                      # Project License
├── README.md                    # Project documentation (This file)
├── .github                      # CI/CD pipeline configurations using GitHub Actions
│   └── workflows
│       ├── docker-image-apiService.yml        # CI/CD for Python API service
│       ├── docker-image-javaApiService.yml    # CI/CD for Java API service
│       └── docker-image-modelApiService.yml   # CI/CD for Model API service
│       └── testpypi-modeltrain.yml            # CI/CD for Model Package
├── db                           # Database initialization and Docker setup for database service
│   ├── Dockerfile               # Dockerfile for the database service
│   └── init.sql                 # SQL script to initialize the database
├── k8s                          # Kubernetes configurations for deployment
│   ├── api-deployment.yml       # Deployment and Service config for the Python API
│   ├── db-deployment.yml        # Deployment and Service config for the database
│   ├── java-api-deployment.yml  # Deployment and Service config for Java API
│   └── model-api-deployment.yml # Deployment and Service config for the Model API
├── packages                     # Custom Python packages for model training
│   └── model_train              # Model training package
├── quickstart.sh                # Shell script for quick project setup
├── services                     # Contains microservices written in Python and Java
│   ├── JavaDataManagementService # Java microservice for data management
│   ├── data_management_service   # Python FastAPI-based service for data management
│   └── model_api_service         # Python FastAPI-based service for model serving
```

### **CI/CD Pipeline**

The CI/CD pipeline is configured using **GitHub Actions**. The `.github/workflows/` directory contains YAML files defining workflows for each service:

- **docker-image-apiService.yml**: Automates the build and push of Docker images for the Python API service.
- **docker-image-javaApiService.yml**: Automates the build and push of Docker images for the Java-based data management service.
- **docker-image-modelApiService.yml**: Automates the build and push of Docker images for the model API service.
- **testpypi-modeltrain.yml**: Automates the testing, build and push of "Model Train" Python package.

The pipeline is triggered on new commits to the corresponding folder in the services folder. Each service workflow ensures that the corresponding Docker image is built, tested, and deployed to a container registry if all tests pass.

### **Key Components**

1. **Database (`db/`)**:

   - A Docker container that runs the database service.
   - `init.sql` script initializes the schema and necessary tables.

2. **Kubernetes Configurations (`k8s/`)**:

   - Contains the deployment and service configurations for running the services in a Kubernetes cluster.

3. **Model Training Package (`packages/model_train/`)**:

   - This package contains Python code for training and managing Clusering-Based SVDpp algorithm.

4. **Microservices (`services/`)**:

   - **JavaDataManagementService**: Java-based REST API for user and item data management.
   - **data_management_service**: Python-based API built with FastAPI for CRUD operations on data.
   - **model_api_service**: Python-based API for serving trained machine learning models.

5. **Testing**:
   - Each service has dedicated test suites using `pytest` for Python and `JUnit` for Java.

### **Setup and Usage**

#### Prerequisites

- Docker
- Kubernetes (Minikube)
- Python 3.11
- Java 21
- `kubectl` (for Kubernetes management)

#### How to Start

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/nzhussup/RecommenderBackend.git
   cd RecommenderBackend
   ```

2. **Start Kubernetes with the Shell Script**

   ```bash
   sh quickstart.sh
   ```

3. **Get the Service URLs**

   First wait until all the pods are started. To check, run:

   ```bash
    kubectl get pods
   ```

   After all pods are started, you can get URLs for each service in separate terminal windows by running:

   ```bash
    minikube service api-service --url
    minikube service model-api-service --url
    minikube service java-api-service --url
   ```

   To get the api documentations:

   - Python-based API: <URL>/docs
   - Java-basedAPI: <URL>/swagger-ui/index.html
