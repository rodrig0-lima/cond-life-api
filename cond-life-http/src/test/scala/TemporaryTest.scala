import org.scalatest.flatspec.AnyFlatSpec

class TemporaryTest extends AnyFlatSpec  {

  "An empty Set" should "have size 0" in {
    assert(Set.empty.size == 0)
  }
}
