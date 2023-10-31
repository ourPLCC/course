def add1( a, b ):
    return a + b

def add2( *values ):
    result = 0
    for v in values: result += v
    return result

def sub1( a, b ):
    return a - b

def sub2( **values ):
    return values[ "a" ] - values[ "b" ]

def cutoff( *values, **limits ):
    if "lower" in limits:
        result1 = [ x
                    for x in values
                    if x >= limits[ "lower" ]
        ]
    else:
        result1 = values[:]
    if "upper" in limits:
        result2 = [ x
                    for x in result1
                    if x <= limits[ "upper" ]
        ]
    else:
        result2 = result1[:]
    return result2

for example in (
                "add1(2,7)", "add1(*(13,8))",
                "add2(2,7)", "add2(*(13,8))",
                "sub1(50,8)", "sub1(*(50,8))",
                "sub2(b=8,a=50)",
                "sub2(**{'a':50,'b':8})",
                "cutoff(1,2,3,4,5,6,7,8,9,10,lower=4)",
                "cutoff(1,2,3,4,5,6,7,8,9,10,**{'upper':9,'lower':2})",
                "cutoff(1,2,3,4,5,6,7,8,9,10,lower=6,upper=8)"
):
    print( example, "=", eval( example ), end="\n\n" )

