from fastapi import FastAPI, Depends, HTTPException
from app.dependencies import get_cbsvdpp, get_testset, add_data, train_cbsvdpp, get_data_len
from app.models.data_model import UserInput, RecommendationResponse, DataInput

app = FastAPI()

# Root endpoint
@app.get("/")
def root():
    return {
        "message": "Welcome to the Recommender System!",
        "methods": [
            {
                "HTTP_method": "GET: /",
                "description": "The root of the API"
            },
            {
                "HTTP_method": "POST: /recommend",
                "description": "Returns the recommendation score for a user and item",
                "exampleInput": {
                    "user_id": 1,
                    "item_id": 1
                }
            },
            {
                "HTTP_method": "PUT: /updateData",
                "description": "Appends the new data to train on",
                "exampleInput": {
                    "data": """
                    1\t2\t3\t121412
                    2\t4\t5\t124151
                    """
                }
            },
            {
                "HTTP_method": "POST: /train",
                "description": "Trains a new model"
            },
            {
                "HTTP_method": "GET: /dataLength",
                "description": "Returns the length of the current data"
            },
        ]
    }


@app.post("/recommend", response_model=RecommendationResponse)
def get_recommendation(data: UserInput,
                       recommender_model=Depends(get_cbsvdpp),
                       testset=Depends(get_testset)):
    try:
    
        prediction = recommender_model.predict_user(testset, data.user_id, data.item_id)
        return RecommendationResponse(user_id=data.user_id, item_id=data.item_id, score=prediction[0])
    except Exception as e:
        raise HTTPException(status_code=400, detail=f"Error in prediction: {e}")


@app.put("/updateData")
def update_data(new_data: DataInput):
    try:
        response = add_data(new_data)
        if response['status'] == 'success':
            return {"message": "Data updated successfully!"}
        else:
            raise HTTPException(status_code=400, detail=response['message'])
    except Exception as e:
        raise HTTPException(status_code=500, detail=f"Error updating data: {e}")


@app.post("/train")
def train_model():
    try:
        rmse = train_cbsvdpp()
        return {"message": "Model trained successfully!",
                "rmse": rmse}
    except Exception as e:
        raise HTTPException(status_code=500, detail=f"Error in training: {e}")

@app.get("/dataLength")
def get_length():
    try:
        length = get_data_len()
        return {"status": "success",
                "length": length}
    except Exception as e:
        raise HTTPException(status_code=500, detail=f"Error calculating the length: {e}")