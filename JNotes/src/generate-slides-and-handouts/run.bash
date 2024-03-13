#!/usr/bin/env bash
SCRIPT_DIR="$( cd -- "$( dirname -- "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )"

set -euo pipefail

JNOTES_DIR="$(cd -- "${SCRIPT_DIR}/../.." && pwd)"
"${SCRIPT_DIR}/build.bash"
docker run -it --rm -v "${JNOTES_DIR}:/workdir" -w /workdir jnotes-generator
