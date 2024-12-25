
import java.util.*


fun main() {
    val scanner = Scanner(System.`in`)
    val store1 = CityPhoneStore("Город 1")
    val store2 = CityPhoneStore("Город 2")

    while (true) {
        println("Добро пожаловать в магазин телефонов!")
        println("Выберите город:")
        println("1. Город 1")
        println("2. Город 2")
        println("3. Выход")
        val choice = scanner.nextLine()

        if (choice == "3") {
            println("Спасибо за покупку! До свидания.")
            break
        }

        val selectedStore = if (choice == "1") store1 else if (choice == "2") store2 else continue

        selectedStore.offerRepairService()

        while (true) {
            selectedStore.displayPhones()
            println("Введите модель телефона для покупки (или введите '1' для 1.статистики или '0' для 0.возврата в меню города):")
            val modelChoice = scanner.nextLine()

            if (modelChoice.equals("1", ignoreCase = true)) {
                selectedStore.showSalesStatistics()
            } else if (modelChoice.equals("0", ignoreCase = true)) {
                break
            } else {
                selectedStore.sellPhone(modelChoice)
            }
        }
    }
}