package com.github.lette1394

import com.github.lette1394.Element.elem
import com.github.lette1394.Spiral.spiral

sealed abstract class Element {
  def contents: Array[String]
  def width: Int = contents(0).length
  def height: Int = contents.length

  def above(that: Element): Element = {
    val nextThis = this widen that.width
    val nextThat = that widen this.width

    elem(nextThis.contents ++ nextThat.contents)
  }

  def beside(that: Element): Element = {
    val nextThis = this heighten that.height
    val nextThat = that heighten this.height

    elem(for ((line1, line2) <- nextThis.contents zip nextThat.contents)
      yield line1 ++ line2)
  }

  def widen(w: Int): Element = {
    if (w <= this.width)
      return this

    val left = elem(' ', (w - width) / 2, height)
    val right = elem(' ', w - width - left.width, height)
    left beside this beside right
  }

  def heighten(h: Int): Element = {
    if (h <= this.height)
      return this

    val top = elem(' ', width, (h - height) / 2)
    val bottom = elem(' ', width, h - height - top.height)
    top above this above bottom
  }

  override def toString: String = contents mkString "\n"
}

object Element {
  private class ArrayElement(val contents: Array[String]) extends Element

  private class LineElement(s: String) extends Element {
    val contents: Array[String] = Array(s)

    override def width: Int = s.length
    override def height: Int = 1
  }

  private class UniformElement(ch: Char, override val width: Int, override val height: Int) extends Element {
    private val line: String = ch.toString * width

    def contents: Array[String] = Array.fill(height)(line)
  }

  def elem(contents: Array[String]): Element = new ArrayElement(contents)
  def elem(ch: Char, width: Int, height: Int): Element = new UniformElement(ch, width, height)
  def elem(line: String): Element = new LineElement(line)
}

object Spiral {
  val space: Element = elem(" ")
  val corner: Element = elem("+")

  sealed trait Direction {
    def next: Direction
  }
  case object Left extends Direction {
    override def next: Direction = Down
  }
  case object Down extends Direction {
    override def next: Direction = Right
  }
  case object Right extends Direction {
    override def next: Direction = Up
  }
  case object Up extends Direction {
    override def next: Direction = Left
  }

  def spiral(nEdges: Int, direction: Direction): Element = {
    if (nEdges == 1)
      return corner

    val next = spiral(nEdges - 1, direction.next)
    def verticalBar = elem('|', 1, next.height)
    def horizontalBar = elem('-', next.width, 1)

    direction match {
      case Left => (corner beside horizontalBar) above (next beside space)
      case Down => (verticalBar above corner) beside (space above next)
      case Right => (space beside next) above (horizontalBar beside corner)
      case Up => (next above space) beside (corner above verticalBar)
    }
  }
}

object ElementMain {
  def main(args: Array[String]): Unit = {
    println(spiral(10, Spiral.Left))
  }
}