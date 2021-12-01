import scala.io.Source

object Day1Part2 {

  def main(args: Array[String]): Unit = {
    var measurementIncreased = 0
    val depths = Source.fromResource("day_01_input").getLines()
      .toList
      .map(i => i.toInt)

    var previousPreviousDepth = depths.head
    var previousDepth = depths(1)

    var previousDepthSum = previousPreviousDepth + previousDepth + depths(2)

    depths.drop(2)
      .foreach(actualDepth => {
        if actualDepth + previousPreviousDepth + previousDepth > previousDepthSum then measurementIncreased = measurementIncreased + 1
        previousDepthSum = actualDepth + previousPreviousDepth + previousDepth
        previousPreviousDepth = previousDepth
        previousDepth = actualDepth
      })
    println(measurementIncreased)
  }
}
