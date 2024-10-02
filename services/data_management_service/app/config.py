USER = "postgres"
PASSWORD = "1234"
DBNAME = "user_item_db"

DATABASE_URL = f"postgresql+asyncpg://{USER}:{PASSWORD}@db-service:5555/{DBNAME}"
