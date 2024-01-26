# Use an official Nginx runtime as a base image
FROM nginx:latest

# Set the working directory to the default Nginx web root
WORKDIR /usr/share/nginx/html

# Copy the local contents to the working directory
COPY . .

# Expose port 80 for incoming HTTP traffic
EXPOSE 80

# CMD specifies the command to run when the container starts
CMD ["nginx", "-g", "daemon off;"]
