import requests

BASE_URL = "http://localhost:4444"


def test_read_main():
    response = requests.get(f"{BASE_URL}/")
    assert response.status_code == 200
    assert response.json() == {
        "status": "OK",
        "message": "Welcome to the CRUD API",
        "author": "Nurzhanat Zhussup"
    }


