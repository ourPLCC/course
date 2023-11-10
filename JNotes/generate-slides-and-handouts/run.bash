#!/usr/bin/env bash
SCRIPT_DIR="$( cd -- "$( dirname -- "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )"
set -euxo pipefail
JNOTES_DIR="$SCRIPT_DIR/.."
cd "$JNOTES_DIR"
docker build --tag jnotes-generator --file generate-slides-and-handouts/Dockerfile .
docker run -it --rm -v "$PWD:/workdir" jnotes-generator
