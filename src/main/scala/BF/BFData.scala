package BF

case class BFData(data: Vector[Int], index: Int) {
  def moveRight(): BFData = {
      val newIndex = index + 1
      if (newIndex >= data.length)
          BFData(data :+ 0, newIndex)
      else
          BFData(data, newIndex)
  }

  def moveLeft(): BFData = {
    val newIndex = index - 1
    if (newIndex < 0)
      BFData(data :+ 0, 0)
    else
      BFData(data, newIndex)
  }

  def get(): Int = data(index)
  def ++(): BFData = BFData(data.updated(index, get + 1),index)
  def --(): BFData = BFData(data.updated(index, get - 1),index)

  def out(): BFData = {
    print(get.toChar)
    this
  }

  def in(char: Char) = BFData(data.updated(index, char.toInt),index)
}

object BFData {
    def apply(): BFData = BFData(Vector(0), 0)
    def apply(values: Int*): BFData = BFData(values.toVector, 0)
}
