/**
 * Operator overloading
 */

data class Vector(val x:Int,val y:Int)

operator fun Vector.inc() = Vector(x+1,y+1)

operator fun Vector.unaryMinus() = Vector(-x,-y)

operator fun Vector.plus( other : Point) = Vector(x+other.x,y+other.y)

fun main() {

  var pt = Point(3,4)
  var ptPlus = -(++pt)

  println(Point(1,-1) + Point(1,-1))

}