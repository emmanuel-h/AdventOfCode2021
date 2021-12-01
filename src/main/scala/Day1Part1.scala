import scala.io.Source

object Day1Part1 {

  def main(args: Array[String]): Unit = {
    val depths = Source.fromResource("day_01_input").getLines()
      .toList
      .map(i => i.toInt)

    println(computeMeasure(depths, 1))
    println(computeMeasure(depths, 3))
  }

  def computeMeasure(depths: List[Int], measurementSize: Int): Int = {
    depths.view.zipWithIndex
      .count(tuple => tuple._2 >= measurementSize && depths.slice(tuple._2 - measurementSize, tuple._2).sum > depths.slice(tuple._2 - measurementSize - 1, tuple._2 - 1).sum)
  }
}
