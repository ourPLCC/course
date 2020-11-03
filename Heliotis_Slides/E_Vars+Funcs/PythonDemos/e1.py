# Demonstrate Python's ability to nest functions and treat them as
# "first-class objects".

def less_than( a, b ):
    return a < b

def greater_than( a, b ):
    return a > b

def sort( data, comp ):
    "An inefficient insertion sort function"

    def insert( value, data ):
        if len( data ) == 0 or comp( value, data[ 0 ] ):
            return [ value ] + data
        else:
            return [ data[ 0 ] ] + insert( value, data[ 1: ] )
    result = []
    for item in data:
        result = insert( item, result )
    return result

DATA = [ 1, 3, 5, 7, 8, 6, 4, 2, 9, 0 ]

# >>> sort(DATA,less_than)
# [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
# >>> sort(DATA,greater_than)
# [9, 8, 7, 6, 5, 4, 3, 2, 1, 0]
