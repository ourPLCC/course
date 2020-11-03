import sys

#
# Closure example 1: Passing a function as an argument
# to another function
#

def less_than( a, b ):
    return a < b

lt = lambda a,b : a < b

# Just to be complete, here is a little inefficient insertion sort function.
def sort( data, comp ):
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

print( "sorting", DATA )

print( "\nForward" )
print( sort( DATA, less_than ) )

print( "\nForward" )
print( sort( DATA, lt ) )

print( "\nBackward" )
print( sort( DATA, lambda a,b: b < a ) )

#
# Closure example 2: Inner function retains environment of outer function
# after outer function has returned.
#

def add_curried( x ):
    def step2( y ):
        return x + y
    return step2

print()
print( "add_curried( 3 ) =", add_curried( 3 ) )
print()
try:
    print( "add_curried( 3, 5 ) =", end=" " )
    sys.stdout.flush()
    print( add_curried( 3, 5 ) )
except Exception as e:
    print( e, file=sys.stderr )
print()
f = add_curried( 3 )
print( "f = add_curried( 3 ); f( 5 ) =", f( 5 ) )
print()
print( "add_curried( 3 )( 5 ) =", add_curried( 3 )( 5 ) )


