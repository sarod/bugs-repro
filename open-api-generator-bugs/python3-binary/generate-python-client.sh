#bin/bash
#!/bin/bash
SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"


# checked out openapi-generator cli if needed
OPENAPI_GENERATOR_GIT_PATH="$SCRIPT_DIR/.openapi-generator"
if [ ! -d "$OPENAPI_GENERATOR_GIT_PATH" ]; then
    echo "Cloning api-generator"
    git clone --depth 1 https://github.com/OpenAPITools/openapi-generator.git "$OPENAPI_GENERATOR_GIT_PATH"
    cd "$OPENAPI_GENERATOR_GIT_PATH"
fi

# checked out build openapi-generator cli if needed
OPENAPI_GENERATOR_CLI_JAR="$OPENAPI_GENERATOR_GIT_PATH/modules/openapi-generator-cli/target/openapi-generator-cli.jar"
if [ ! -f "$OPENAPI_GENERATOR_CLI_JAR" ]; then
    echo "Compiling api-generator-cli"
    cd "$OPENAPI_GENERATOR_GIT_PATH"
    mvn clean package -DskipTests
fi



OPENAPI_GENERATOR_PYTHON_MODULE="$OPENAPI_GENERATOR_GIT_PATH/modules/openapi-generator/src/main/resources/python"
GENERATE_COMMAND="java -Xmx1024M -jar $OPENAPI_GENERATOR_CLI_JAR generate -g python -t $OPENAPI_GENERATOR_PYTHON_MODULE --skip-validate-spec"
echo $GENERATE_COMMAND
cd $SCRIPT_DIR

echo "Regenerating python-client"
rm -rf .python_client
$GENERATE_COMMAND -i ./api-with-binary.yaml -o .python_client  --additional-properties=packageName=python_client,projectName=python_client
