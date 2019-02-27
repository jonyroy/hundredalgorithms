package org.roy

import org.roy.searching.SearchingAlgo
import ImpVal._

import java.io._

import org.roy.sorting.SortingAlgo
import scala.io.Source

object MainApp {

  def main(args: Array[String]): Unit = {
    //val so = new SearchingAlgo(Seq(2,3,4,5,61,8,6,4,3))

    // so.linearSearch(10).printElem("Linear Search")

    //val so1 = new SearchingAlgo(Seq("a", "b", "c", "d"))
    //so1.binarySearch("d").printElem("Binary Search")
    //so1.binarySearch("").printElem("Ternary Search")

    //SortingAlgo.quickSort(Array(3,2,4,5,6,1,100)).printlnSeq


    //words.foreach(elem =>  println(elem + " "))
   // println(finalString)
  }

  def wordCount = {
    val fileContents = Source.fromFile("/home/roy/Downloads/Algorithms-JeffE.txt").getLines.mkString

    def validTheWord(str: String): Option[String] = {
      val leftOver = str.foldLeft(("", true)){ (acc, elem) =>
        if(elem.isLetter && acc._2) (acc._1 + elem, true) else (acc._1, false)
      }._1

      if(leftOver.length > 2) Option(leftOver.toLowerCase) else None
    }

    val words = fileContents.split(' ').flatMap(validTheWord).distinct.sorted

    val finalString = words.reduceLeft((acc, elem) => acc + "," + elem)

    val pw = new PrintWriter(new File("/home/roy/Downloads/algorithms-JeffE-words.txt" ))
    pw.write(finalString)
    pw.close
  }

}
