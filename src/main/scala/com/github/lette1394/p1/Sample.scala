package com.github.lette1394.p1

import com.github.lette1394.Holder

object Sample {
  def main(args: Array[String]): Unit = {
    val h = new Holder(Some("123213"))

    println(h.value)
  }

}
