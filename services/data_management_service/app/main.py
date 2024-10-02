from fastapi import FastAPI, Depends, HTTPException
from sqlalchemy.ext.asyncio import AsyncSession
from sqlalchemy.exc import SQLAlchemyError
from sqlalchemy.future import select
from app.dependencies import get_db, handle_db_exception
from app.models.item_model import Item
from app.models.user_model import User
from app.models.base_model import ItemCreate, UserCreate

app = FastAPI()


@app.get("/")
async def root():
    return {
        "status": "OK",
        "message": "Welcome to the CRUD API",
        "author": "Nurzhanat Zhussup"
    }

# CRUD FOR ITEMS

@app.post("/items/", response_model=ItemCreate)
async def create_item(item: ItemCreate, db: AsyncSession = Depends(get_db)):
    try:
        db_item = Item(**item.model_dump())
        db.add(db_item)
        await db.commit()
        await db.refresh(db_item)
        return db_item
    except SQLAlchemyError as e:
        raise handle_db_exception(e)

@app.get("/items/{itemid}", response_model=ItemCreate)
async def read_item(itemid: int, db: AsyncSession = Depends(get_db)):
    try:
        result = await db.execute(select(Item).where(Item.itemid == itemid))
        db_item = result.scalars().first()
        if db_item is None:
            raise HTTPException(status_code=404, detail="Item not found")
        return db_item
    except SQLAlchemyError as e:
        raise handle_db_exception(e)

@app.put("/items/{itemid}", response_model=ItemCreate)
async def update_item(itemid: int, item: ItemCreate, db: AsyncSession = Depends(get_db)):
    try:
        result = await db.execute(select(Item).where(Item.itemid == itemid))
        db_item = result.scalars().first()
        if db_item is None:
            raise HTTPException(status_code=404, detail="Item not found")
        
        for k, v in item.model_dump().items():
            setattr(db_item, k, v)
        
        await db.commit()
        await db.refresh(db_item)
        return db_item
    except SQLAlchemyError as e:
        raise handle_db_exception(e)

@app.delete("/items/{itemid}")
async def delete_item(itemid: int, db: AsyncSession = Depends(get_db)):
    try:
        result = await db.execute(select(Item).where(Item.itemid == itemid))
        db_item = result.scalars().first()
        if db_item is None:
            raise HTTPException(status_code=404, detail="Item not found")
        
        await db.delete(db_item)
        await db.commit()
        return {"detail": "Item deleted"}
    except SQLAlchemyError as e:
        raise handle_db_exception(e)







# CRUD FOR USERS

@app.post("/users/", response_model=UserCreate)
async def create_user(user: UserCreate, db: AsyncSession = Depends(get_db)):
    try:
        db_user = User(**user.model_dump())
        db.add(db_user)
        await db.commit()
        await db.refresh(db_user)
        return db_user
    except SQLAlchemyError as e:
        raise handle_db_exception(e)

@app.get("/users/{userid}", response_model=UserCreate)
async def read_user(userid: int, db: AsyncSession = Depends(get_db)):
    try:
        result = await db.execute(select(User).where(User.userid == userid))
        db_user = result.scalars().first()
        if db_user is None:
            raise HTTPException(status_code=404, detail="User not found")
        return db_user
    except SQLAlchemyError as e:
        raise handle_db_exception(e)

@app.put("/users/{userid}", response_model=UserCreate)
async def update_user(userid: int, user: UserCreate, db: AsyncSession = Depends(get_db)):
    try:
        result = await db.execute(select(User).where(User.userid == userid))
        db_user = result.scalars().first()
        if db_user is None:
            raise HTTPException(status_code=404, detail="User not found")
        
        for k, v in user.model_dump().items():
            setattr(db_user, k, v)
        
        await db.commit()
        await db.refresh(db_user)
        return db_user
    except SQLAlchemyError as e:
        raise handle_db_exception(e)

@app.delete("/users/{userid}")
async def delete_user(userid: int, db: AsyncSession = Depends(get_db)):
    try:
        result = await db.execute(select(User).where(User.userid == userid))
        db_user = result.scalars().first()
        if db_user is None:
            raise HTTPException(status_code=404, detail="User not found")
        
        await db.delete(db_user)
        await db.commit()
        return {"detail": "User deleted"}
    except SQLAlchemyError as e:
        raise handle_db_exception(e)

