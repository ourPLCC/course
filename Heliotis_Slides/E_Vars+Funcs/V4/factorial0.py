
def fact(x):
    return x * fact( x-1 ) if x else 1

print( fact(5) )

