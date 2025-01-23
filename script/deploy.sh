#!/bin/bash

# Print a message indicating the deployment script is running
echo "Deployment script running..."

# Move the Addition.jar file to the desired location
mv /home/ec2-user/Addition.jar /home/ec2-user/app/Addition.jar

# Set the necessary permissions for the JAR file
chmod 755 /home/ec2-user/app/Addition.jar

# Restart the application service (if applicable)
# For example, if you're using a service manager like systemd:
# sudo systemctl restart my-java-app

# Print a message indicating the deployment script has completed
echo "Deployment script completed successfully."
