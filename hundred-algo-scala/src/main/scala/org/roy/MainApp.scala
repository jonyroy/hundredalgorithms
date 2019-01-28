package org.roy

import org.roy.searching.SearchingAlgo
import ImpVal._

object MainApp {

  def main(args: Array[String]): Unit = {
    val so = new SearchingAlgo(Seq(2,3,4,5,61,8,6,4,3))

    so.linearSearch(10).printElem("Linear Search")

    val so1 = new SearchingAlgo(Seq("a", "b", "c", "d"))
    so1.binarySearch("d").printElem("Binary Search")
    so1.binarySearch("").printElem("Ternary Search")
  }

}
