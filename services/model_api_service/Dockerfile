FROM python:3.11

WORKDIR /code

RUN pip install --upgrade pip

COPY ./requirements.txt /code/requirements.txt
RUN pip install --no-cache-dir --upgrade -r /code/requirements.txt wheel

COPY ./requirements_testpypi.txt /code/requirements_testpypi.txt
RUN pip install --no-cache-dir -i https://test.pypi.org/simple/ -r requirements_testpypi.txt --extra-index-url https://pypi.org/simple/

COPY ./app /code/app

CMD ["uvicorn", "app.main:app", "--host", "0.0.0.0", "--port", "3333", "--reload"]
EXPOSE 3333
