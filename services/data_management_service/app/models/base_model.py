from pydantic import BaseModel

class ItemCreate(BaseModel):
    userid: int
    title: str
    description: str
    score: float

class UserCreate(BaseModel):
    firstname: str
    lastname: str
    email: str
    password: str
    username: str
