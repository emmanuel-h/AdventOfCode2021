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
    (measurementSize - 1 until depths.size)
      .count(i => depths.slice(i - measurementSize, i).sum > depths.slice(i - measurementSize - 1, i - 1).sum)
  }
}
