
# */15 0 1,15 * 1-5 /usr/bin/find
#!/bin/bash

# Navigate to the project root directory (where the script is located)
cd "$(dirname "$0")"

# Set the classpath to include the target/classes directory
CLASSPATH="target/classes"

# Prompt for the string input
echo "Enter the cron expression string:"
read cronExpression

# Check if the Application.class exists in the target directory
if [ ! -f "target/classes/Application.class" ]; then
    echo "Compiling the Java project..."
    # Compile the project (correct the path to Application.java)
    javac -d target/classes src/main/java/Application.java

    if [ $? -ne 0 ]; then
        echo "Compilation failed. Please check the source code for errors."
        exit 1
    fi
fi

echo "Running the Application with input: $cronExpression"

# Run the Application class with the input
java -cp "$CLASSPATH" Application "$cronExpression"
