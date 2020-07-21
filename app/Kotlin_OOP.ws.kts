class BankAccount {
    var balance: Double = 10000.0
    val accNo = "11773171-12345678"

    fun info() {
        println("$accNo: $balance")
    }
}

val acc = BankAccount()
acc.info()

// Primary konstruktor
class BankAccountImproved(val accNo: String, var balance: Double) {

    private var owner: String? = null

    // Object-tol orokoljuk.
    override fun toString(): String {
        return "$owner >> $accNo: $balance"
    }

    // Secondary konstruktor
    // FONTOS: vegyuk eszre a lancolt konstruktor hivast!
    constructor(someString: String, someDouble: Double, customerName: String): this(someString, someDouble)  {
        owner = customerName
    }

    // Az init blokk mindig a konstruktor lefutasa UTAN fut le
    init {
        if (owner == null) {
            owner = "Unknown"
        }
    }
}

val bai1 = BankAccountImproved("1234", 1200000.0)
bai1

val bai2 = BankAccountImproved("98765432", 55000000.0, "John Doe")
bai2

bai2.balance

// TODO: probaljuk dot notation-on keresztul elerni az owner propety-t!

// TODO: adjunk hozza egy withdraw() metodust, hivjuk meg, ellenorizzuk az uj balance-ot

// TODO: Alkalmazzuk a DATA HIDING elvet, tegyuk private eleresuve a property-ket!
class OTPAccount(private val accNo: String, private var balance: Double) {
    // Mi lesz igy a baj? Probaljuk lekerdezni a balance-ot!
}

val otpAcc1 = OTPAccount("334455", 1234.5)
//otpAcc1.balance

// TODO: ugy modositsuk, hogy csak a property setter legyen private!
class OTPAccountImproved(val accNo: String) {

    var balance: Double = 0.0
        private set

    var overdrawn: Boolean = false
        get() {
            return balance < 0
        }

    fun deposit(amount: Double) {
        balance += amount
    }

    fun withdraw(amount: Double) {
        balance -= amount
    }

    override fun toString(): String {
        return "$accNo: $balance"
    }

}

val otpAcc2 = OTPAccountImproved("3456-6545-3001")
otpAcc2

otpAcc2.deposit(2_000_000.0)
otpAcc2
otpAcc2.overdrawn
otpAcc2.withdraw(2_500_000.0)
otpAcc2
otpAcc2.overdrawn




