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
    var measurementIncreased = 0
    for ((depth, index) <- depths.view.zipWithIndex)
      if index >= measurementSize && depths.slice(index - measurementSize, index).sum > depths.slice(index - measurementSize - 1, index - 1).sum
      then measurementIncreased = measurementIncreased + 1
    measurementIncreased
  }
}
