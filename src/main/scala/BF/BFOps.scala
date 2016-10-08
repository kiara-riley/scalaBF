package BF

object BFOps {
  /*
   * Applys a BF program to a left and a right value
   * Returns the value at the last index of the pointer
   */
  implicit class BinaryBF(x: Int) {
    def apply(prog: String): Int => Int = apply(BFProgram(prog))

    def apply(prog: BFProgram): Int => Int = { y =>
      prog.run(x, y).get
    }
  }
}
