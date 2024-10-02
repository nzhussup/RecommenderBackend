from sqlalchemy import Column, Integer, String, Float
from app.dependencies import Base

class Item(Base):
    __tablename__ = "items" 

    itemid = Column(Integer, primary_key=True, index=True, autoincrement=True)
    userid = Column(Integer, index=True)
    title = Column(String, nullable=False)
    description = Column(String)
    score = Column(Float)

