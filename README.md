A Programming Languages Course using PLCC
=========================================

This repository contains course notes, example languages, and sample homework
assignments for an upper-level CS Programming Languages course that makes use
PLCC -- a Programming Languages Compiler Compiler.

Set 1a of the course notes serves as a reference manual for PLCC. It describes
the format of a language 'grammar' file that PLCC translates into Java classes
to implement a scanner, parser, and interpreter for the language.

The course notes are organized as follows:


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
7         | Continuations, parallelism, exception handling, and concurrency
(8)       | Logic languages -- not yet written

The ABC language (see the Code directory) is an implementation of ABCDatalog
(see http://abcdatalog.seas.harvard.edu/), a Prolog-like language that
implements first-order logic. The implementation uses the ABCDatalog logic
engine. The corresponding Logic Languages Course Notes are not yet written.
(Feel free to offer to write Slide Set 8 for inclusion in this distribution!)
