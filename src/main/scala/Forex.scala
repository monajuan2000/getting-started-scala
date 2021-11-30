import scala.xml._
import scala.collection.immutable

object Forex{
 def getExchangesRates():Map[String, Double ] = {
   val apiURL = "https://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml"
   val response = requests.get(apiURL)
   val xmlResponse = XML.loadString(response.text())
   val currencyCodes: immutable.Seq[String] = (xmlResponse \\ "@currency").map(node => node.text)
   val euroToCurrencyMultipliers: immutable.Seq[Double] = (xmlResponse \\ "@rate").map(node => node.text.toDouble)
   val currencyCodeMultipliers = (currencyCodes zip euroToCurrencyMultipliers).toMap
   currencyCodeMultipliers
 }
  def main(args: Array[String]): Unit = {
    print(getExchangesRates())
  }
}
