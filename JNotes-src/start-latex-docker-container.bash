#!/usr/bin/env bash

SCRIPT_DIR="$( cd -- "$( dirname -- "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )"
cd "${SCRIPT_DIR}"

docker run -it --rm -v "$PWD:/workdir" registry.gitlab.com/islandoftex/images/texlive:latest
