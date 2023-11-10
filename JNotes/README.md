# JNotes

Timothy Fossum wrote a comprehensive set of notes for a Programming
Language course. This is effectively a textbook for Programming Languages
using PLCC. This directory and its subdirectories contains these notes.

slides/ and handouts/ contain course notes for a Programming Language
course organized as follows:

Slide Set | Contents
--------- | --------
0         | Syntax and semantics; Tokens
1         | Induction, recursion, and scope
1a        | PLCC (reference manual)
2         | Specifying data; Environments
3         | Expression-based languages
3a        | Parameter passing and mutation
4         | Typed languages
5         | Object-oriented languages
6         | Infix expressions and arrays
7         | Logic languages
8         | Continuations, parallelism, exception handling, and concurrency

src/ contains the latex for these files.

generate-slides-and-handouts/ contains a container for generating
slides/ and handouts/ from src/. Assuming you have bash and Docker installed
and Docker is running, run `./JNotes/generate-slides-and-handouts/run.bash`
to regenerate slides/ and handouts/.