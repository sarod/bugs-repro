#!/bin/bash
SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"
cd $SCRIPT_DIR



python3 -m venv .python_env
source .python_env/bin/activate
if [ ! -d ".python_client" ]; then
    ./generate-python-client.sh
fi
pip install -e .python_client

# Dev Tools
pip install pylint
pip install autopep8