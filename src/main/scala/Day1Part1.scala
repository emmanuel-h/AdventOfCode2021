import scala.io.Source

object Day1Part1 {

  def main(args: Array[String]): Unit = {
    var measurementIncreased = 0
    val list = Source.fromFile("/home/eherrmann/Documents/AdventOfCode2021/src/main/scala/day_01_part_1_input").getLines()
      .toList
      .map(i => i.toInt)

    var previousDepth = list.head

    list.foreach(actualDepth => {
      if actualDepth > previousDepth then measurementIncreased = measurementIncreased + 1
      previousDepth = actualDepth
    })
    println(measurementIncreased)
  }
}
