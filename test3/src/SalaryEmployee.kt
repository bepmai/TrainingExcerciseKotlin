package salary
import model.Employmen

class SalaryEmployee{
    companion object{
        fun getSalary(employmen: Employmen): Double{
            val product_quantity = employmen.getProductQuantity()
            val unit_price = when{
                product_quantity >= 600 -> 0.65
                product_quantity >= 400 -> 0.65
                product_quantity >= 200 -> 0.65
                else -> 0.5
            }
            return product_quantity * unit_price
        }
    }
}