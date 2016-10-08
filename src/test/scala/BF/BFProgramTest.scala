package BF

class BFProgramTest extends test.TestBase {
  behavior of "A BFProgram"

  it should "interpret an empty program" in {
    BFProgram("").run().get shouldBe (0)
  }

  it should "be able to increment a value" in {
    BFProgram("+").run().get shouldBe (1)
  }

  it should "be able to decrement a value" in {
    BFProgram("-").run().get shouldBe (-1)
  }

  it should "be able to move right" in {
    BFProgram(">+").run().data shouldBe (Vector(0, 1))
  }

  it should "be able to move left" in {
    BFProgram("+>+<+").run().data shouldBe (Vector(2, 1))
  }

  it should "be able to loop" in {
    BFProgram("[-]").run(5).data shouldBe (Vector(0))
  }

  it should "be able to have a loop within a loop" in {
    BFProgram("[>[-]<-]").run(5, 5).data shouldBe (Vector(0, 0))
  }

  it should "run the addition program" in {
    BFProgram("[->+<]>").run(5, 6).get shouldBe (11)
  }

  it should "Noop with non-symbol characters" in {
    BFProgram("test this is a comment//#comment()").run().get shouldBe (0)
  }

  import org.scalacheck.Gen
  val smallInts = for (n <- Gen.choose(0, 1000)) yield n

  forAll(smallInts, smallInts) { (x: Int, y: Int) =>
    BFProgram("[->+<]>").run(x, y).get shouldBe (x + y)
  }

  forAll(smallInts, smallInts) { (x: Int, y: Int) =>
    // http://stackoverflow.com/a/5607721
    BFProgram("""
      [> go to cell #2
        [
          ->+>+<< move data to cell #3 #4
        ]
        >> go to cell #4
        [
         -<<+>> move data to cell #2
        ]
        <<< go to cell #1
        - decrement cell #1
      ]>> go to cell 3 for answer""").run(x, y).get shouldBe (x * y)
  }
}
