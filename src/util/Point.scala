package util

import scala.collection.mutable.ArrayBuffer

class Point(private var privateX: Double = 0.0, private var privateY: Double = 0.0) {
  def x = privateX;
  def x_=(newValue: Double) { privateX = newValue }
  def y = privateY;
  def y_=(newValue: Double) { privateY = newValue }
  override def toString(): String = {
    "[" + x + ", " + y + "]"
  }
}

object Point {
  def generateRandomNumbers(n: Int, range: Int) = {
    val r = scala.util.Random
    for (i <- 0 until n) yield {
      r.nextDouble() * range
    }
  }
  
  def generateSamplePoints() = {
    val buffer = new ArrayBuffer[Point]
    buffer += new Point(4,10)
    buffer += new Point(12,6)
    buffer += new Point(7,10)
    buffer += new Point(4,8)
    buffer += new Point(6,8)
    buffer += new Point(10,5)
    buffer += new Point(11,4)
    buffer += new Point(12,3)
    buffer += new Point(9,3)
    buffer += new Point(5,2)
    buffer += new Point(3,4)
    buffer += new Point(2,2)
  }
  
  def distance(p1: Point, p2: Point) = {
    val dx = p1.x - p2.x
    val dy = p1.y - p2.y
    dx*dx + dy*dy
  }
}