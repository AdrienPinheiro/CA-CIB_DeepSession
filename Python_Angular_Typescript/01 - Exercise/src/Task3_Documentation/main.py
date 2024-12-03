from fastapi import FastAPI, HTTPException
from datetime import datetime

app = FastAPI()

@app.get("/days-between")
def calculate_days(startDate: str, endDate: str):
    try:
        # Parse the start and end dates
        start_date = datetime.strptime(startDate, "%Y-%m-%d")
        end_date = datetime.strptime(endDate, "%Y-%m-%d")
        
        # Ensure that the start date is not after the end date
        if start_date > end_date:
            raise HTTPException(status_code=400, detail="Start date cannot be after end date.")
        
        # Calculate the difference in days
        delta = end_date - start_date
        return {"days_between": delta.days}
    except ValueError:
        raise HTTPException(status_code=400, detail="Invalid date format. Use YYYY-MM-DD.")
