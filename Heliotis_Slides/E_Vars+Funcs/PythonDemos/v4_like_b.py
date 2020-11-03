import functools

def sort( data, comp ):
    "An inefficient insertion sort function"

    insert = lambda data, value: \
              [ value ] + data \
                           if len( data ) == 0 or comp( value, data[ 0 ] ) \
              else [ data[ 0 ] ] + insert( data[ 1: ], value )

    return functools.reduce( insert, DATA, [] )

DATA = [ 1, 3, 5, 7, 8, 6, 4, 2, 9, 0 ]
