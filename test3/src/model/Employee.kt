package model

data class Employee(var id: String, var name: String, private var productQuantity: Int){

    init {
        if (productQuantity < 0) {
            this.productQuantity = 0
        }
    }

    fun setProductQuantity(productQuantity: Int) {
        this.productQuantity = if (productQuantity >= 0) productQuantity else 0
    }

    fun getProductQuantity(): Int {
        return productQuantity
    }
}