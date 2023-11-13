#!/usr/bin/env bash
SCRIPT_DIR="$( cd -- "$( dirname -- "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )"
set -euxo pipefail
JNOTES_DIR="$(cd -- "$SCRIPT_DIR/../.." && pwd)"
docker build --tag jnotes-generator --file "${JNOTES_DIR}/src/generate-slides-and-handouts/Dockerfile" "$JNOTES_DIR"
