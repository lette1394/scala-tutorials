import org.scalacheck.Prop.forAll
import org.scalacheck.{Gen, Properties}

object StringSpecification extends Properties("String") {
  val g1to5: Gen[List[Int]] = Gen.containerOf[List, Int](Gen.choose(1, 5))



  property("concatenate11") = forAll { (a: String, b: String) =>
    (a + b).length >= a.length && (a + b).length >= b.length
  }

  property("substring") = forAll { (a: String, b: String, c: String) =>
    (a + b + c).substring(a.length, a.length + b.length) == b
  }

}