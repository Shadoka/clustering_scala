package util

import scala.collection.mutable.ArrayBuffer

class Cluster(private var privatePoints: ArrayBuffer[Point] = new ArrayBuffer[Point], private var privateCentroid: Point = new Point()) {
  def points = privatePoints
  def points_=(newBuffer: ArrayBuffer[Point]) {
    privatePoints = newBuffer
    calculateNewCentroid()
  }
  
  def centroid = privateCentroid
  
  override def toString(): String = {
    var result = "Cluster with " + points.length + " Points:\n"
    for (p <- points) {
      result += p.toString() + "\n"
    }
    result
  }
  
  def +=(newPoint: Point): Unit = {
    points += newPoint
    calculateNewCentroid()
  }
  
  def ++=(other: Cluster) {
    for (elem <- other.points) privatePoints += elem
    calculateNewCentroid()
  }
  
  private def calculateNewCentroid() {
    var sumX = 0.0
    var sumY = 0.0
    for (p <- points) {
      sumX += p.x
      sumY += p.y
    }
    privateCentroid = new Point(sumX/points.length, sumY/points.length)
  }
}

object Cluster {
  def distance(c1: Cluster, c2: Cluster) = {
    Point.distance(c1.centroid, c2.centroid)
  }
}



