#!/bin/bash

# Define the backup directory
BACKUP_DIR="/home/ec2-user/backup"

# Create the backup directory if it doesn't exist
mkdir -p $BACKUP_DIR

# Get the current date
DATE=$(date +%Y%m%d)

# Define the backup file name with date
BACKUP_FILE="$BACKUP_DIR/Addition_$DATE.jar"

# Check if the Addition.jar file exists
if [ -f /home/ec2-user/Addition.jar ]; then
  # Move the existing Addition.jar to the backup directory with date
  mv /home/ec2-user/Addition.jar $BACKUP_FILE
  echo "Backup of Addition.jar created at $BACKUP_FILE"
else
  echo "No existing Addition.jar file to backup."
fi
