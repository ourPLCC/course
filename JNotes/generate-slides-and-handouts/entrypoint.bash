#!/usr/bin/env bash

cd /JNotes/src
for i in 0 1 1a 2 3 3a 4 5 6 7 8 ; do
    ./MakeSlides $i
done

cd /JNotes
rm -rf slides handouts
mkdir -p slides handouts
rm src/slides*.tex
mv src/slides* slides/
mv src/hand* handouts/
