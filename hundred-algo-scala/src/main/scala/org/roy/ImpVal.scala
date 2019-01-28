package org.roy

object ImpVal {

  implicit class print[T](elem: T){
    def printElem(str: String): Unit = println(str + " : " + elem)
  }
}
