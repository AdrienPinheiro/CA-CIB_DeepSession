from fastapi import FastAPI, HTTPException, Query
from typing import List
import httpx

app = FastAPI()

GITHUB_API_URL = "https://api.github.com/users"

async def fetch_github_user_details(username: str):
    async with httpx.AsyncClient() as client:
        response = await client.get(f"{GITHUB_API_URL}/{username}")
        if response.status_code == 404:
            raise HTTPException(status_code=404, detail=f"GitHub user {username} not found")
        elif response.status_code != 200:
            raise HTTPException(
                status_code=response.status_code,
                detail=f"Error fetching details for {username}: {response.json()}"
            )
        user_data = response.json()
        return {
            "login": user_data.get("login"),
            "name": user_data.get("name"),
            "public_repos": user_data.get("public_repos"),
            "followers": user_data.get("followers"),
            "following": user_data.get("following"),
        }

@app.get("/api/task5/github-user")
async def get_github_user_details(
    usernames: List[str] = Query(..., description="List of GitHub usernames to fetch")
):
    """
    Fetch GitHub user details for a list of usernames.
    """
    results = {}

    for username in usernames:
        try:
            results[username] = await fetch_github_user_details(username)
        except Exception as e:
            raise HTTPException(status_code=500, detail=f"Error fetching user {username}: {str(e)}")

    return results