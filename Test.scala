object Test extends App {
  import BF.BFProgram

  val data = BFProgram(">[-<+>]<").run(1,2).get
  println(data)

  import BF.BFData
  val helloWorld = "++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++.>+.+++++++..+++.>++.<<+++++++++++++++.>.+++.------.--------.>+.>."
  val empty = BFData()
  BFProgram(helloWorld).run(empty)

  import BF.BFOps._
  val thing = (1000)("[->+<]>")(3000)
  println(thing)
}
