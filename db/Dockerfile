FROM postgres:latest

ENV POSTGRES_DB=user_item_db
ENV POSTGRES_USER=postgres
ENV POSTGRES_PASSWORD=1234

COPY init.sql /docker-entrypoint-initdb.d/

EXPOSE 5555
