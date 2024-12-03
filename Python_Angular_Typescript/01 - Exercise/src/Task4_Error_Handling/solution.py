from fastapi import FastAPI, HTTPException
from pydantic import BaseModel
import datetime

app = FastAPI()

class DateRequest(BaseModel):
    start_date: str
    end_date: str

@app.get("/api/task4/days-between")
async def calculate_days_between(start_date: str, end_date: str):
    """
    Calculate the number of days between two dates.
    """
    try:
        start_date = datetime.datetime.strptime(start_date, "%Y-%m-%d")
        end_date = datetime.datetime.strptime(end_date, "%Y-%m-%d")
    except ValueError:
        raise HTTPException(status_code=400, detail="Invalid date format. Use YYYY-MM-DD.")

    if start_date > end_date:
        raise HTTPException(status_code=400, detail="start_date cannot be after end_date")

    delta = end_date - start_date
    return {"days_between": delta.days}