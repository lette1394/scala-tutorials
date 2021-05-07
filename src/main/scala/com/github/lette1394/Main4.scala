package com.github.lette1394

import scala.collection.immutable.TreeSet

object Main4 {
  def main(args: Array[String]): Unit = {


    println(List("a", "b", "c") to TreeSet)
    println(List(1, 2, 3) to TreeSet)

  }

  def msort[T](less: (T, T) => Boolean)(xs: List[T]): List[T] = {
    def merge(xs: List[T], ys: List[T]): List[T] = {
      (xs, ys) match {
        case (Nil, _) => ys
        case (_, Nil) => xs
        case (x :: xs1, y :: ys1) => {
          if (less(x, y)) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
        }
      }
    }

    val mid = xs.length / 2
    if (mid == 0)
      return xs

    val (ys, zs) = xs splitAt mid
    merge(msort(less)(ys), msort(less)(zs))
  }
}
