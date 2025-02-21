package model

data class Employmen(var id: String, var name: String, private var product_quantity: Int){

    init {
        if (product_quantity < 0) {
            this.product_quantity = 0
        }
    }

    fun setProductQuantity(product_quantity: Int) {
        this.product_quantity = if (product_quantity >= 0) product_quantity else 0
    }

    fun getProductQuantity(): Int {
        return product_quantity
    }
}