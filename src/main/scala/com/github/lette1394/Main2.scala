package com.github.lette1394

import scala.util.Random

trait AbsIterator {
  type T

  def hasNext: Boolean

  def next: T
}

class StringIterator(s: String) extends AbsIterator {
  type T = Char
  private var i = 0

  override def hasNext: Boolean = i < s.length

  override def next: Char = {
    val ch = s charAt i
    i += 1
    ch
  }
}

trait RichIterator extends AbsIterator {
  def foreach(f: T => Unit): Unit = while (hasNext) f(next)
}

object Main2 {
  def main(args: Array[String]): Unit = {
    class RichStringIterator extends StringIterator("Wowaaaaa") with RichIterator
    val iter = new RichStringIterator
    iter.foreach(ch => println(ch))

    val test: () => Int = {
      val r = util.Random.nextInt
      () => r
    }
    println(test())
    println(test())
    println(test())

    println("-------------")
    println(evenVal())
    println(evenVal())
    println(evenVal())
    println(evenVal())
    println(evenVal())
    println(evenVal())

    println("---------------")
    println(even(10))
    println(even(11))
    println(even(12))
  }

  lazy val evenVal: () => Long = {
    () => Random.nextLong
  }

  def even(i: Int): Boolean = i % 2 == 0
}

trait B

trait A {
  this: C =>

  def wow: Unit = {
    printInC()
  }
}

trait C {
  def printInC(message: String = "im 'c"): Unit = {
    println(message)
  }
}

class MyMy extends A with C {
}

object AA {
  case class A()


  def main(args: Array[String]): Unit = {
    val xs = List(1, 2, 3)
    val ys = List(10, 20, 30)
    (xs zip ys) map {
      case (x, y) => x * y
    } foreach println
  }

  def foo(n: Int, v: Int) =
    for (i <- 0 until n;
         j <- 0 until n if i + j == v)
    yield (i, j, i)
}

trait User {
  def username: String

  def username2(): String
}

trait Tweeter {
  this: User =>
  def tweet(tweetText: String) = println(s"$username: $tweetText")
}

class VerifiedTweeter(username_ : String) extends Tweeter with User {
  override def username: String = {
    "hello"
  }

  override def username2(): String = {
    var aa: Any = math.Pi
    aa = "11"
    "wow"
  }
}

class Holder[+T](initialValue: Option[T]) {
  // without [this] it will not compile
  var value: Option[Any] = initialValue

  def getValue = value

  def makeEmpty() {
    value = None
  }
}