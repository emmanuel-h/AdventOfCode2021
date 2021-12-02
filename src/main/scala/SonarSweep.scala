import scala.io.Source

object SonarSweep {

  def main(args: Array[String]): Unit = {
    val depths = readInputs()
    println(computeMeasure(depths, 1))
    println(computeMeasure(depths, 3))
  }

  private def computeMeasure(depths: List[Int], measurementSize: Int) =
    (measurementSize until depths.size).count(i => depths.slice(i - measurementSize, i).sum > depths.slice(i - measurementSize - 1, i - 1).sum)

  private def readInputs() = Source.fromResource("day_01_input").getLines().toList.map((_: String).toInt)
}
