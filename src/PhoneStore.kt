interface PhoneStore {
    fun displayPhones(): List<Phone>
    fun sellPhone(model: String): Boolean
    fun showSalesStatistics()
}