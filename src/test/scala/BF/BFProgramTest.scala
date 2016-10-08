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
}
