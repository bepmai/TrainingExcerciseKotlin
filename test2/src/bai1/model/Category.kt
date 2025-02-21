import bai1.model.Product

class Category(var id: String, var name: String) {
    val products: MutableList<Product> = mutableListOf()
}