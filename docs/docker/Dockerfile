FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file into the container
COPY llm-knowledge-0.0.1-SNAPSHOT.jar /app/

# Create logs directory
RUN mkdir -p /app/logs

# Set permissions for the JAR file
RUN chmod +x /app/llm-knowledge-0.0.1-SNAPSHOT.jar

# Expose the port the app runs on
EXPOSE 10086

# Run the application
CMD ["sh", "-c", "java -Xmx100M -jar /app/llm-knowledge-0.0.1-SNAPSHOT.jar"]

# Map the logs directory to the host
VOLUME ["/app/"]