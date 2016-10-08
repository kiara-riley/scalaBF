package BF

class BFProgram(prog: List[BFOperation]) {
  def exec(data: Int*): Unit = { run(data: _*); () }
  def exec(data: BFData): Unit = { run(data); () }
  def run(data: Int*): BFData = run(BFData(data: _*))
  def run(data: BFData): BFData = prog match {
    case head :: tail => BFProgram(tail).run(head(data))
    case _ => data
  }
}

object BFProgram {
  def apply(prog: List[BFOperation]) = new BFProgram(prog)
  def apply(prog: String): BFProgram = BFProgramBuilder(prog.toList)
}
