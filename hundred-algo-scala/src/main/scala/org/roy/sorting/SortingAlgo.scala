package org.roy.sorting

object SortingAlgo {

  def quickSort[A](elems: Array[A])(implicit ordering: Ordering[A]): Array[A] = {

    def quickSort(low: Int, high: Int)(implicit ordering: Ordering[A]): Unit = {
      if (low < high) {
        val par = partition(low, high)
        quickSort(low, par - 1)
        quickSort(par + 1, high)
      }

    }

    def partition(low: Int, high: Int)(implicit ordering: Ordering[A]): Int = {

      val pivot: A = elems(high)

      var minIdx = low - 1

      for (idx <- low until high) {

        if (ordering.lteq(elems(idx), pivot)) {

          minIdx += 1

          if (minIdx < idx) {
            val temp = elems(minIdx)
            elems(minIdx) = elems(idx)
            elems(idx) = temp
          }

        }
      }

      if (minIdx + 1 <= high) {
        val temp = elems(minIdx + 1)
        elems(minIdx + 1) = elems(high)
        elems(high) = temp

        minIdx + 1
      } else {
        minIdx
      }


    }

    val low: Int = 0
    val high: Int = elems.length - 1

    quickSort(low, high)

    elems
  }


}
