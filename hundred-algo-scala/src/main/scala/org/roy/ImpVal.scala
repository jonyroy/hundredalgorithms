package org.roy

import scala.collection.GenSeq

object ImpVal {

  implicit class print[T](elem: T){
    def printElem(str: String): Unit = println(str + " : " + elem)
  }

  implicit class printSeq[T](elems: Array[T]){
    def printlnSeq: Unit = elems.foreach(println _)
  }
}

