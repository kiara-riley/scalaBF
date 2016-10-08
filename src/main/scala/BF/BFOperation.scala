package BF

object BFOperation {
  def Right: BFOperation = _.moveRight
  def Left: BFOperation = _.moveLeft
  def Plus: BFOperation = _.++
  def Minus: BFOperation = _.--
  def Out: BFOperation = _.out
  def In: BFOperation = _.in('z')
  def Noop: BFOperation = identity _
  def Loop(loopProg: List[Char]): BFOperation = loopGo(loopProg) _

  @scala.annotation.tailrec
  private def loopGo(loopProg: List[Char])(data: BFData): BFData = {
    if (data.get == 0) {
      data
    } else {
      val res = BFProgramBuilder(loopProg).run(data)
      if (res.get == 0)
        res
      else
        loopGo(loopProg)(res)
    }
  }
}
