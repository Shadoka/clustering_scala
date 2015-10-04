package algorithm

import scala.collection.mutable.ArrayBuffer
import util.Cluster
import util.Point

abstract class ClusteringAlgorithm {
  def cluster(points: ArrayBuffer[Point], amount: Int): ArrayBuffer[Cluster]
}