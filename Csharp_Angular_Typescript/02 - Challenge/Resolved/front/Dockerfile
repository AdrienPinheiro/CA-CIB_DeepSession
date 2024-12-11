
# Use the official Node.js image
FROM node:22 AS build
WORKDIR /app

# Install dependencies
COPY package*.json ./
RUN npm install

# Copy the rest of the application code
COPY . ./

# Build the Angular application
RUN npm run build --prod

# Use the official Nginx image to serve the application
FROM nginx:alpine
COPY --from=build /app/dist/csharp_angular_typescript /usr/share/nginx/html