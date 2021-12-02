import scala.io.Source

object Dive {

  def main(args: Array[String]): Unit = {
    val movements = readInputs()
    val finalPosition = course(movements)
    println(finalPosition._1 * finalPosition._2)
  }

  def course(movements: List[(String, Int)]): (Int, Int) = {
    movements.map {
      case _@move if move._1 == "forward" => (move._2, 0)
      case _@move if move._1 == "up" => (0, -move._2)
      case _@move if move._1 == "down" => (0, move._2)
      case _ => (0, 0)
    }
      .reduce((x: (Int, Int), y: (Int, Int)) => (x._1 + y._1, x._2 + y._2))
  }

  private def readInputs(): List[(String, Int)] = {
    Source.fromResource("day_02_input").getLines().toList.map(s => {
      val stringSplit = s.split(" ")
      (stringSplit(0), stringSplit(1).toInt)
    })
  }
}
