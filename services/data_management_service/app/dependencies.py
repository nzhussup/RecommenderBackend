from sqlalchemy.ext.asyncio import AsyncSession, create_async_engine
from sqlalchemy.orm import declarative_base
from sqlalchemy.exc import SQLAlchemyError
from fastapi.exceptions import HTTPException
from sqlalchemy.orm import sessionmaker
from app import config



engine = create_async_engine(config.DATABASE_URL, echo=True)
SessionLocal = sessionmaker(bind=engine, class_=AsyncSession)
Base = declarative_base()

async def get_db():
    async with SessionLocal() as db:
        yield db
        

def handle_db_exception(exc: SQLAlchemyError):
    return HTTPException(status_code=500, detail=str(exc))