import java.util.*

class CityPhoneStore(private val city: String) : PhoneStore {
    private val phones = mutableListOf<Phone>()
    private var repairOffered = false

    init {
        phones.add(ConcretePhone("Model A", 500.0))
        phones.add(ConcretePhone("Model B", 700.0))
        phones.add(ConcretePhone("Model C", 600.0))
    }

    override fun displayPhones(): List<Phone> {
        println("Телефоны в магазине $city:")
        phones.forEach { println("${it.model} - ${it.price} $") }
        return phones
    }

    override fun sellPhone(model: String): Boolean {
        val phone = phones.find { it.model == model }
        return if (phone != null) {
            phone.soldCount++
            println("Вы купили телефон ${phone.model} за ${phone.price}$ в городе $city.")
            true
        } else {
            println("Телефон с моделью $model не найден.")
            false
        }
    }

    override fun showSalesStatistics() {
        println("Статистика продаж в магазине $city:")
        phones.forEach { println("Модель: ${it.model}, Продано: ${it.soldCount} штук") }
        val totalSales = phones.sumOf { it.price * it.soldCount }
        println("Общая сумма продаж: $totalSales$")
    }

    fun offerRepairService() {
        if (!repairOffered) {
            println("У вас есть сломанный телефон, хотите отремонтировать его? (да/нет)")
            val scanner = Scanner(System.`in`)
            val response = scanner.nextLine()
            if (response.equals("да", ignoreCase = true)) {
                println("Ваш телефон отремонтирован.")
                repairOffered = true
            } else {
                println("Не нуждаетесь в ремонте.")
            }
        } else {
            println("Вы уже получили предложение о ремонте.")
        }
    }
}