This ABC language directory provides a PLCC implementation of ABCDatalog,
a subset of Prolog that implements first-order logic. See

    http://abcdatalog.seas.harvard.edu/

for more information. ABCDatalog is NOT turing complete.

The PLCC lexical and grammar structure of this language follows that
of ABCDatalog.  The semantics uses Java classes drawn directly from
the Harvard ABCDatalog implementation to drive the ABCDatalog logic
engine. These classes are in a Jar file named abcdatalog.jar, which
is included in this directory.  To compile the interpreter and to run
programs in the ABC language, be sure to make this jar file visible to
the Java compiler and runtime system by defining the CLASSPATH environment
variable as follows (in the ABC language directory):

    export CLASSPATH="$PWD/Java:$PWD/abcdatalog.jar"

Here is a program that you can run using the Rep loop:

    bear(fuzzy).
    bear(wuzzy).
    bear(X)?    % yields "bear(fuzzy)" and "bear(wuzzy)"

The "~" operator removes facts from the database. For example,

    bear(fuzzy)~

would remove this fact.

ABC language-specific details
-----------------------------

A) This implementation allows for removing all of the facts obtained
from a query. For example,

    bear(X)~

would remove all facts arising from the query "bear(X)?".

B) This implementation requires that the first term of the relational
operators "=" and "!=" must be a variable. So instead of

    a=X

you would need to write

    X=a

C) The Print command will report on all of the facts and rules currently
known by the engine. Its syntax is just

    Print

D) Similarly the Clear command will clear all facts and rules, starting
with a clean slate.

Examples
--------

1) The Prog directory has examples copied from the Harvard ABCDatalog
implementation. It includes an example 'eqv' that shows how to derive an
equivalence relation as the reflexive, symmetric, and transitive closure
of a given relation.

2) The Prog directory has some additional examples. In particular, the
group.dtlg file contains some rules for processing the elements of a
finite group g whose multiplication table is given by facts of the form

    g(x,y,z).

each of which represents the fact that xy = z in the group g. The query

    ident(X)?

reports on the identity of g, and the query

    center(X)?

reports on all of the elements in the center of g. The group-chk.dtlg
rules check to make sure that g represents a group (well-defined binary
operation, associativity, identity, inverses).

Some examples of groups g are given in the Prog directory:

    S3.dtlg is the symmetric group of order 6
    S4.dtlg is the symmetric group of order 24
    A5.dtlg is the alternating group of order 60
    Z3.dtlg is the (additive) group of integers modulo 3

The Python program make-sn.py in the Prog directory can be used to create
the full symmetric group g on n elements. Be aware that for a given n,
the number of facts defined by g is (n!)*(n!).
    
The Z3.dtlg group has elements 'a', 'b', and 'c', with the following
multiplication table given as facts:

g(e,e,e).
g(e,a,a).
g(e,b,b).
g(a,e,a).
g(a,a,b).
g(a,b,e).
g(b,e,b).
g(b,a,e).
g(b,b,a).

To find the center of Z3, for example, enter the Prog directory and run
the Rep loop with the following input:

    cat group.dtlg Z3.dtlg - | (cd ../Java ; java Rep)

Then perform the following query:

    center(X)?

In this example, the result of the query should be:

    center(e)
    center(a)
    center(b)

Similarly, performing the query:

    ident(X)?

will result in

    ident(e)

3) The River directory contains ABCDatalog files for solving the river
crossing problems fox/goose/corn (FGC) and missionaries and cannibals
(MC). The java files in this directory are used to create these files,
specifically so that only the legal states are built and the legal
river crossings between states are identified.

NOTE
----

All of the examples described above must be run with the CLASSPATH
environment variable set as described above.
