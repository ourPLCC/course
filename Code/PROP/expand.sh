#!/bin/bash

FILES="class code env grammar list prim ref val"
echo -n "expanding "
for i in $FILES; do
    TMP=$(mktemp) && expand "$i" > "$TMP" && mv "$TMP" "$i"
    echo -n "$i "
done
echo ""
