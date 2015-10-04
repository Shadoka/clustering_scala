package app

import util.Point
import util.Cluster
import algorithm.HierarchicalClustering

object Starter {
  def main(args: Array[String]): Unit = {
    val points = Point.generateSamplePoints()
    val algo = new HierarchicalClustering
    val cluster = algo.cluster(points, 3)
    println(cluster.toString())
  }
}