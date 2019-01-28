package org.roy.searching

class SearchingAlgo[T](ls: Seq[T]) {

  private val length: Int = ls.length

  def linearSearch(searchElem: T)(implicit ordering: Ordering[T]): Int = {

    val notFound: Int = -1

    for (i <- 0 until length) {
      if (ordering.equiv(ls(i), searchElem)) {
        return i
      }
    }

    notFound
  }


  def binarySearch(searchElem: T)(implicit ordering: Ordering[T]): Int = {

    val minLen: Int = 0
    val maxLen: Int = length - 1

    val notFound: Int = -1

    def loop(minLen: Int, maxLen: Int): Int = {

      if (minLen > maxLen) {
        notFound
      } else {

        val mid = (minLen + maxLen) / 2

        mid match {
          case m if (ordering.equiv(ls(m), searchElem)) => m
          case m if (ordering.gt(ls(m), searchElem)) => loop(minLen, m - 1)
          case m if (ordering.lt(ls(m), searchElem)) => loop(m + 1, maxLen)
        }
      }


    }

    loop(minLen, maxLen)
  }


  def ternarySearch(searchElem: T)(implicit ordering: Ordering[T]): Int = {

    val notFound: Int = -1
    val minLen: Int = 0
    val maxLen: Int = length - 1

    def loop(minLen: Int, maxLen: Int): Int = {
      if(minLen > maxLen){
        notFound
      } else {

        val searchLen: Int = (maxLen - minLen) / 3
        val mid1: Int = minLen + searchLen
        val mid2: Int = maxLen - searchLen

        (mid1, mid2) match {
          case mids if(ordering.equiv(ls(mids._1), searchElem)) => mids._1
          case mids if(ordering.equiv(ls(mids._2), searchElem)) => mids._2
          case mids if(ordering.lt(searchElem, ls(mids._1))) => loop(minLen, mids._1 - 1)
          case mids if(ordering.gt(searchElem, ls(mids._2))) => loop(mids._2 + 1, maxLen)
          case mids => loop(mids._1 + 1, mids._2 - 1 )
        }
      }
    }

    loop(minLen, maxLen)
  }

}

object SearchingAlgo {


}

