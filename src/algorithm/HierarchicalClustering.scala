package algorithm

import scala.collection.mutable.ArrayBuffer
import util.Cluster
import util.Point

class HierarchicalClustering extends ClusteringAlgorithm {

  def cluster(points: ArrayBuffer[Point], amount: Int) = {
    var clusters = new ArrayBuffer[Cluster](points.length)
    clusters = for (p <- points) yield {
      val current = new Cluster()
      current += p
      current
    }
    while (clusters.length != amount) {
      val distances = new ArrayBuffer[(Cluster, Cluster, Int,  Double)]
      for (i <- 0 until clusters.length - 1) {
        for (j <- i+1 until clusters.length) {
          val current = (clusters(i), clusters(j), j,  Cluster.distance(clusters(i), clusters(j)))
          distances += current
        }
      }
      var maxDistance = (distances(0)._4)
      var index = 0
      for (i <- 0 until distances.length) {
        if (maxDistance > (distances(i)_4)) {
          maxDistance = (distances(i)_4)
          index = i
        }
      }
      (distances(index)_1) ++= (distances(index)_2)
      clusters.remove((distances(index)_3))
    }
    clusters
  }
}