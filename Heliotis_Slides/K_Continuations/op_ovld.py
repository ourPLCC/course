# Operator Overloading in Python

class Coordinates:

    def __init__( self, x, y, z ):
        self.x = x
        self.y = y
        self.z = z

    def __str__( self ):
        return "@<" + str(self.x) + "," + str(self.y) + "," + str(self.z) + ">"

    def __add__( self, coord ):
        return Coordinates( self.x+coord.x, self.y+coord.y, self.z+coord.z )

    def __sub__( self, coord ):
        return Coordinates( self.x-coord.x, self.y-coord.y, self.z-coord.z )

    def __mul__( self, factor ):
        return Coordinates( self.x * factor, self.y * factor, self.z * factor )

    def __truediv__( self, factor ):
        return Coordinates( self.x / factor, self.y / factor, self.z / factor )


c1 = Coordinates( 1, 2, 3 )
print( "c1:", str(c1) )

c2 = Coordinates( 4, 5, 6 )
print( "c2:", str(c2) )

print( "c1+c2:", str( c1 + c2 ) )
print( "c1-c2:", str( c1 - c2 ) )
print( "c1*3:", str( c1 * 3 ) )
print( "c2/3:", str( c2 / 3 ) )

# OUTPUT
#
# c1: @<1,2,3>
# c2: @<4,5,6>
# c1+c2: @<5,7,9>
# c1-c2: @<-3,-3,-3>
# c1*3: @<3,6,9>
# c2/3: @<1.3333333333333333,1.6666666666666667,2.0>

