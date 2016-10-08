package BF

object BFProgramBuilder {
  def apply(prog: String): BFProgram = apply(prog.toList)
  def apply(prog: List[Char]): BFProgram = BFProgram(toOperationsList(prog))

  import BF.BFOperation._
  private def toOperationsList(prog: List[Char]): List[BFOperation] = prog match {
    case Nil => Nil
    case '>' :: tail => Right +: toOperationsList(tail)
    case '<' :: tail => Left +: toOperationsList(tail)
    case '+' :: tail => Plus +: toOperationsList(tail)
    case '-' :: tail => Minus +: toOperationsList(tail)
    case '.' :: tail => Out +: toOperationsList(tail)
    case ',' :: tail => In +: toOperationsList(tail)
    case '[' :: tail => {
      val loopEnd = findMatchingBracket(tail)
      Loop(tail.take(loopEnd)) +: toOperationsList(tail.drop(loopEnd))
    }
    // skip this, we should've handled it in Loop
    case ']' :: tail => Noop +: toOperationsList(tail)
    // skip tokens that aren't operations
    case _ :: tail => toOperationsList(tail)
  }

  private def findMatchingBracket(str: List[Char]): Int = {
    @scala.annotation.tailrec
    def go(str: List[Char], numBrackets: Int, index: Int): Int = str match {
      case Nil => sys.error("Never found matching bracket")
      case '[' :: tail => go(tail, numBrackets + 1, index + 1)
      case ']' :: _ if (numBrackets == 0) => index
      case ']' :: tail => go(tail, numBrackets - 1, index + 1)
      case _ :: tail => go(tail, numBrackets, index + 1)
    }
    go(str, 0, 0)
  }
}
