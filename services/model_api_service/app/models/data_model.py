from pydantic import BaseModel, confloat

class UserInput(BaseModel):
    user_id: int
    item_id: int

class RecommendationResponse(BaseModel):
    user_id: int
    item_id: int
    score: float
    
class DataInput(BaseModel):
    user_id: int
    item_id: int
    score: confloat(ge=1.0, le=5.0) # type: ignore
    timestamp: int
    

