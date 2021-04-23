package com.github.wow

import com.github.wow.EEE.whileLoop
import com.github.wow.Helpers._
import scala.collection.parallel.CollectionConverters._

import scala.annotation.tailrec
import scala.util.Random

object Sample2 extends {
  def main(args: Array[String]): Unit = {
    val e = EEE(1)
    e(123) = "hello"

    5 times println(Random.nextInt())

    val xs = Vector(1,2,3,45).par
    
    var i = 5
    whileLoop(i > 0)({
      println(i)
      i -= 1
    })
  }
}


class EEE private(a: Int) {

  def aaa(): Unit = {

  }

  def update(i: Int, x: String): Unit = {
    println(s"음... $i")
    println(s"음... $x")
  }
}


object EEE {
  def apply(a: Int): EEE = new EEE(a)

  def whileLoop(condition: => Boolean)(body: => Unit): Unit =
    if (condition) {
      body
      whileLoop(condition)(body)
    }
}

object Helpers {
  implicit class IntWithTimes(x: Int) {
    def times(f: => Any): Unit = {
      @tailrec
      def loop(current: Int): Unit =
        if (current > 0) {
          f
          loop(current - 1)
        }

      loop(x)
    }
  }
}


