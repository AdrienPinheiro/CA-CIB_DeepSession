from fastapi import FastAPI, HTTPException
from datetime import datetime

app = FastAPI()

@app.get("/days-between")
def calculate_days(startDate: str, endDate: str):
    """
    Calculate the number of days between two dates.

    Args:
    - startDate: The start date in `YYYY-MM-DD` format.
    - endDate: The end date in `YYYY-MM-DD` format.

    Returns:
    - A dictionary with the number of days between the two dates.
    - If the dates are invalid, an error message will be returned.
    """
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
