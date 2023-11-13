FROM registry.gitlab.com/islandoftex/images/texlive:latest
COPY . /JNotes
COPY src/generate-slides-and-handouts/renumber /usr/local/bin
RUN chmod +x \
    /JNotes/src/generate-slides-and-handouts/entrypoint.bash \
    /JNotes/src/src/Base/ListTexFiles \
    /JNotes/src/src/Base/MakeMasterTexFile \
    /JNotes/src/src/MakeSlides \
    /JNotes/src/src/*/MakeSlides \
    /usr/local/bin/renumber
WORKDIR /workdir
ENTRYPOINT [ "/JNotes/src/generate-slides-and-handouts/entrypoint.bash" ]
