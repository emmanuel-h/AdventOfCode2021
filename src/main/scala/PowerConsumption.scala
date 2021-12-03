import scala.annotation.tailrec
import scala.io.Source
import scala.language.postfixOps

object PowerConsumption {

  def main(args: Array[String]): Unit = {
    val report = readInputs()
    val rate = getPowerConsumption(report)
    println(rate._1 * rate._2)
    val oxygenGenerator = getRating(report, 0, x => x('0').size > x('1').size)
    val co2Scrubber = getRating(report, 0, x => x('1').size >= x('0').size)
    println(oxygenGenerator * co2Scrubber)
  }

  @tailrec
  private def getRating(report: List[String], index: Int, op: (Map[Char, List[String]]) => Boolean): Int = {
    if report.size == 1 then return Integer.parseInt(report.head, 2)
    val most = report.groupBy(_.charAt(index))
    if op(most) then getRating(most('0'), index + 1, op) else getRating(most('1'), index + 1, op)
  }

  // returns (gamma rate, epsilon rate)
  private def getPowerConsumption(report: List[String]): (Int, Int) = {
    val list = Array.fill(report.head.length)(0)
    report.foreach { r => r.view.zipWithIndex.foreach { (c, i) => list(i) = list(i) + (if c == '0' then 1 else -1) } }
    val gammaRate = Integer.parseInt(list.map(a => if a > 0 then '0' else '1').mkString, 2)
    (gammaRate, (~gammaRate & ~(~0 << report.head.length)))
  }

  private def readInputs(): List[String] = {
    Source.fromResource("day_03_input").getLines().toList
  }
}
