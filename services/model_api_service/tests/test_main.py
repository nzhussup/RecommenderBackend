import pytest
from fastapi.testclient import TestClient
from app.main import app

client = TestClient(app)

def test_root():
    response = client.get("/")
    assert response.status_code == 200
    assert response.json()["message"] == "Welcome to the Recommender System!"

def test_get_recommendation():
    response = client.post("/recommend", json={"user_id": 1, "item_id": 1})
    assert response.status_code == 200
    assert "score" in response.json()  # Assuming the response contains a score

def test_update_data():
    new_data = {
        "user_id": 1,
        "item_id": 2,
        "score": 3.0,
        "timestamp": 121412
    }
    response = client.put("/updateData", json=new_data)
    assert response.status_code == 200
    assert response.json() == {"message": "Data updated successfully!"}

def test_train_model():
    response = client.post("/train")
    assert response.status_code == 200
    assert "rmse" in response.json()
    assert response.json()["rmse"] < 1.5

def test_get_data_length():
    response = client.get("/dataLength")
    assert response.status_code == 200
    assert "length" in response.json()
