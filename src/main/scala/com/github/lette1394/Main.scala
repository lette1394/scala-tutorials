package com.github.lette1394

import java.text.DateFormat._
import java.util.{Date, Locale}
import scala.annotation.tailrec

object Main {
  type TATA
  def main(args: Array[String]): Unit = {
    val now = new Date
    val df = getDateInstance(LONG, Locale.KOREA)
    println(df format now)

    println(2.+(2))
  }
}

object Timer {
  def oncePerSecond(callback: () => Unit): Unit = {
    while (true) {
      callback()
      Thread sleep 1000
    }
  }

  def main(args: Array[String]): Unit = {
    var index = 0

    val c = new Complex(imaginary = 1.4, real = 44.4)
    val b = (c re1 11).toInt
    println(b)

    val a: Unit = 44
    println(a + "22")
    println(a)
  }

  class Point(var x: Int, val y: Int) {
    private var __aaaa = 0
    private var _y = 0

    val aa: String = "11"
    if (aa ne null) {

    }
  }

}


class Complex(real: Double, imaginary: Double) {
  println(List)

  def re: Double = real

  def re1(aa: Int): Double = real

  def im: Double = imaginary

  def <><><><>(that: Any): Boolean = {
    true
  }
}

trait Similar {
  def isSimilar(x: Any): Boolean
}
case class MyInt(x: Int) extends Similar {
  def isSimilar(m: Any): Boolean =
    m.isInstanceOf[MyInt] &&
      m.asInstanceOf[MyInt].x == x
}
object UpperBoundTest extends App {
  def findSimilar[T <: Similar](e: T, xs: List[T]): Boolean =
    if (xs.isEmpty) false
    else if (e.isSimilar(xs.head)) true
    else findSimilar[T](e, xs.tail)
  val list: List[MyInt] = List(MyInt(1), MyInt(2), MyInt(3))
  println(findSimilar[MyInt](MyInt(4), list))
  println(findSimilar[MyInt](MyInt(2), list))
}
abstract class Printer[+A] {
  def print[T >: Printer[A]](value: T): Unit
}


// https://docs.scala-lang.org/ko/tutorials/scala-for-java-programmers.html
// 상속과 재정의 부터