from fastapi import FastAPI, HTTPException, Query
import httpx

app = FastAPI()

GITHUB_API_URL = "https://api.github.com/users"

@app.get("/api/task5/github-user")
async def get_github_user_details(
    username1: str = Query(..., description="First GitHub username to fetch"),
    username2: str = Query(None, description="Second GitHub username to fetch (optional)"),
    username3: str = Query(None, description="Third GitHub username to fetch (optional)")
):
    """
    Fetch GitHub user details for up to three usernames.
    """

    results = {}

    # Fetch details for username1
    try:
        async with httpx.AsyncClient() as client:
            response = await client.get(f"{GITHUB_API_URL}/{username1}")
            if response.status_code == 404:
                raise HTTPException(status_code=404, detail=f"GitHub user {username1} not found")
            elif response.status_code != 200:
                raise HTTPException(
                    status_code=response.status_code,
                    detail=f"Error fetching details for {username1}: {response.json()}"
                )
            user_data = response.json()
            results["username1"] = {
                "login": user_data.get("login"),
                "name": user_data.get("name"),
                "public_repos": user_data.get("public_repos"),
                "followers": user_data.get("followers"),
                "following": user_data.get("following"),
            }
    except Exception as e:
        raise HTTPException(status_code=500, detail=f"Error fetching user {username1}: {str(e)}")

    # Fetch details for username2
    if username2:
        try:
            async with httpx.AsyncClient() as client:
                response = await client.get(f"{GITHUB_API_URL}/{username2}")
                if response.status_code == 404:
                    raise HTTPException(status_code=404, detail=f"GitHub user {username2} not found")
                elif response.status_code != 200:
                    raise HTTPException(
                        status_code=response.status_code,
                        detail=f"Error fetching details for {username2}: {response.json()}"
                    )
                user_data = response.json()
                results["username2"] = {
                    "login": user_data.get("login"),
                    "name": user_data.get("name"),
                    "public_repos": user_data.get("public_repos"),
                    "followers": user_data.get("followers"),
                    "following": user_data.get("following"),
                }
        except Exception as e:
            raise HTTPException(status_code=500, detail=f"Error fetching user {username2}: {str(e)}")

    # Fetch details for username3
    if username3:
        try:
            async with httpx.AsyncClient() as client:
                response = await client.get(f"{GITHUB_API_URL}/{username3}")
                if response.status_code == 404:
                    raise HTTPException(status_code=404, detail=f"GitHub user {username3} not found")
                elif response.status_code != 200:
                    raise HTTPException(
                        status_code=response.status_code,
                        detail=f"Error fetching details for {username3}: {response.json()}"
                    )
                user_data = response.json()
                results["username3"] = {
                    "login": user_data.get("login"),
                    "name": user_data.get("name"),
                    "public_repos": user_data.get("public_repos"),
                    "followers": user_data.get("followers"),
                    "following": user_data.get("following"),
                }
        except Exception as e:
            raise HTTPException(status_code=500, detail=f"Error fetching user {username3}: {str(e)}")

    return results
