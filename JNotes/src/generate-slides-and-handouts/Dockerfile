FROM registry.gitlab.com/islandoftex/images/texlive:latest
COPY . /JNotes
RUN chmod +x \
    /JNotes/src/generate-slides-and-handouts/entrypoint.bash \
    /JNotes/src/generate-slides-and-handouts/renumber \
    /JNotes/src/src/Base/ListTexFiles \
    /JNotes/src/src/Base/MakeMasterTexFile \
    /JNotes/src/src/MakeSlides \
    /JNotes/src/src/*/MakeSlides
ENV PATH="/JNotes/src/generate-slides-and-handouts:${PATH}"
WORKDIR /workdir
ENTRYPOINT [ "/JNotes/src/generate-slides-and-handouts/entrypoint.bash" ]
