import io.pianka.cadence.model.{Month, Day, Ordinal}
import io.pianka.cadence.parser.Cadence

/**
 * @author richardpianka
 */
object Program extends App {

  val result = Cadence.parse(Cadence.days, "Wednesday, Thursday and Friday")
  println(result)
}