package com.github.lette1394.p1

import java.io.{File, PrintWriter}
import java.nio.file.{Path, Paths}

object Sample11 {

  def main(args: Array[String]): Unit = {
    myNameAssert({
      println("wow")
      3 > 0
    })
    myNameAssert(1 < 0)
  }

  def myNameAssert(predicate: => Boolean): Unit = {
    if (predicate) return
    throw new AssertionError
  }
}
