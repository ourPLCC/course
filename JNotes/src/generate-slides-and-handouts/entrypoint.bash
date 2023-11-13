#!/usr/bin/env bash

set -euxo pipefail

JNOTES="/JNotes/src/src"
WORKDIR="/workdir"
cd "$JNOTES"
for i in 0 1 1a 2 3 3a 4 5 6 7 8 ; do
    ./MakeSlides $i
done

rm -rf "${WORKDIR}/slides" "${WORKDIR}/handouts"
mkdir -p "${WORKDIR}/slides" "${WORKDIR}/handouts"
rm "${JNOTES}"/slides*.tex
mv "${JNOTES}"/slides* "${WORKDIR}/slides/"
mv "${JNOTES}"/hand* "${WORKDIR}/handouts/"
