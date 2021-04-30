package com.github.lette1394

import scala.collection.mutable.ArrayBuffer

trait IntQueue {
  def head: Int

  def append(x: Int)
}

object IntQueue {
  def withPrintLogger: IntQueue = new ArrayBufferIntQueue with Doubling with Incrementing {
    override val logger: Logger = new PrintLogger
  }
}

class ArrayBufferIntQueue extends IntQueue {
  private val buf = new ArrayBuffer[Int]

  override def head: Int = buf.remove(0)

  override def append(x: Int): Unit = buf addOne x

}

trait Doubling extends IntQueue {
  abstract override def append(x: Int): Unit = super.append(2 * x)
}

trait Logger {
  def log(s: String)
}

class PrintLogger extends Logger {
  override def log(s: String): Unit = println(s)
}

trait Incrementing extends IntQueue {
  protected val logger: Logger

  abstract override def append(x: Int): Unit = {
    super.append(x + 1)
    logger log s"log: ${x + 1}"
  }
}

trait Filtering extends IntQueue {
  abstract override def append(x: Int): Unit = if (x >= 0) super.append(x)
}
trait Searchable[T] {
  def uri(obj: T): String
}


object Runner {

}

