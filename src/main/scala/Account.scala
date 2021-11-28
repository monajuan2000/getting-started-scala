import java.text.DateFormat
import java.time.{LocalDate, LocalDateTime}
import java.util.UUID
import javax.security.auth.login.AccountException

abstract class Account(id: UUID, name: String, dateOpened: LocalDateTime){

  private val _id: UUID = id
  private var _name: String = name
  private val _dateOpened: LocalDateTime = dateOpened
  val _accountType: String

  def this(name:String){
    this(UUID.randomUUID(), name, LocalDateTime.now())
  }
  def getId:UUID = this._id
  def getName: String = this._name
  def getDateOpened: LocalDateTime = this._dateOpened
  def getAccountType: String = this._accountType
  def setName(name:String): Unit = this._name = name
  override def toString:String = s"Account id=${_id}, name=${_name}, dateOpened=${_dateOpened}"
}
class CreditAccount(name:String) extends Account(name: String){
  override val _accountType: String = "CREDIT"
  override def toString:String = s"Account id=${getId}, name=${getName}, dateOpened=${getDateOpened}, " +
    s"${getAccountType}"
}
class DebitAccount(name:String) extends Account(name: String){
  override val _accountType: String = "DEBIT"
  override def toString:String = s"Account id=${getId}, name=${getName}, dateOpened=${getDateOpened}, " +
    s"${getAccountType}"
}
object AccountRunner extends App{
   val ca1:Account = new CreditAccount("MASTED CARD")
   print(ca1)
}
