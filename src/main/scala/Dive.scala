import scala.io.Source

object Dive {

  def main(args: Array[String]): Unit = {
    val movements = readInputs()
    val finalPosition = course(movements)
    println(finalPosition._1 * finalPosition._2)
  }

//  result: (horizontalPosition, depth)
  def course(movements: List[(String, Int)]): (Int, Int) = {
    var depth = 0
    var position = 0
    var aim = 0
    for (m <- movements) {
      if m._1 == "forward" then {
        position = position + m._2
        depth = depth + (aim * m._2)
      }
      else aim = if (m._1 == "up") aim - m._2 else aim + m._2
    }
    (position, depth)
  }

  private def readInputs(): List[(String, Int)] = {
    Source.fromResource("day_02_input").getLines().toList.map(s => {
      val stringSplit = s.split(" ")
      (stringSplit(0), stringSplit(1).toInt)
    })
  }
}
