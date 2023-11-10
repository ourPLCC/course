FROM registry.gitlab.com/islandoftex/images/texlive:latest
COPY . /JNotes
RUN chmod +x \
    /JNotes/generate-slides-and-handouts/entrypoint.bash \
    /JNotes/src/Base/ListTexFiles \
    /JNotes/src/Base/MakeMasterTexFile \
    /JNotes/src/MakeSlides \
    /JNotes/src/*/MakeSlides
WORKDIR /workdir
ENTRYPOINT [ "/JNotes/generate-slides-and-handouts/entrypoint.bash" ]
