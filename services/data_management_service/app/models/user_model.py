from sqlalchemy import Column, Integer, String
from app.dependencies import Base

class User(Base):
    __tablename__ = "users"

    userid = Column(Integer, primary_key=True, index=True)
    firstname = Column(String(50), index=True)
    lastname = Column(String(50), index=True)
    email = Column(String(50), unique=True, index=True)
    password = Column(String(150))
    username = Column(String(50), unique=True, index=True)
