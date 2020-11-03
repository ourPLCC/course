# Demonstrate Python's ability to define functions anonymously, thereby
# completely changing them to be viewed as any other object.

# "lambda" is Python's keyword to denote the start of a function definition.
# PLC sample languages: "proc"
# Lisp/Scheme: "lambda"
# Haskell "\"
# ML: "fn"
# Java and C# have no keyword.
#     They depend on the parameter/body separator "->" or "=>"

less_than = lambda a,b : a < b


def sort( data, comp ):
    "An inefficient insertion sort function"

    insert = lambda value, data: \
              [ value ] + data if len( data ) == 0 or comp( value, data[ 0 ] ) \
              else [ data[ 0 ] ] + insert( value, data[ 1: ] )

    result = []
    for item in data:
        result = insert( item, result )
    return result

DATA = [ 1, 3, 5, 7, 8, 6, 4, 2, 9, 0 ]

# >>> sort(DATA,less_than)
# [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
# >>> sort(DATA, lambda x,y: x>y )
# [9, 8, 7, 6, 5, 4, 3, 2, 1, 0]
