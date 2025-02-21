package bai1

import Category
import bai1.model.Product

class StoreManagement {
    private val categories = mutableListOf<Category>()

    fun addCategory() {
        print("Nhập mã danh mục: ")
        val categoryId = readln()
        print("Nhập tên danh mục: ")
        val categoryName = readln()

        val category = Category(categoryId, categoryName)
        categories.add(category)
        println("Đã thêm danh mục: $categoryName")
    }

    fun addProduct() {
        print("Nhập mã danh mục chứa sản phẩm: ")
        val categoryId = readln()
        val category = categories.find { it.id == categoryId }

        if (category != null) {
            print("Nhập mã sản phẩm: ")
            val productId = readln()
            print("Nhập tên sản phẩm: ")
            val productName = readln()
            print("Nhập giá sản phẩm: ")
            val productPrice = readln().toDouble()
            print("Nhập xuất xứ sản phẩm: ")
            val productOrigin = readln()

            val product = Product(productId, productName, productPrice, productOrigin)
            category.products.add(product)
            println("Đã thêm sản phẩm: $productName vào danh mục ${category.name}")
        } else {
            println("Không tìm thấy danh mục!")
        }
    }

    fun listProductsByCategory() {
        print("Nhập mã danh mục cần xem sản phẩm: ")
        val categoryId = readln()
        val category = categories.find { it.id == categoryId }

        if (category != null) {
            println("Danh sách sản phẩm trong danh mục ${category.name}:")
            category.products.forEach { println("mã: ${it.id} - tên: ${it.name} - giá: ${it.price} VND - nguồn gốc${it.origin}") }
        } else {
            println("Không tìm thấy danh mục!")
        }
    }

    fun updateProduct() {
        print("Nhập mã danh mục chứa sản phẩm: ")
        val categoryId = readln()
        val category = categories.find { it.id == categoryId }

        if (category != null) {
            print("Nhập mã sản phẩm cần cập nhật: ")
            val productId = readln()
            val product = category.products.find { it.id == productId }

            if (product != null) {
                print("Nhập tên mới: ")
                product.name = readln()
                print("Nhập giá mới: ")
                product.price = readln().toDouble()
                print("Nhập xuất xứ mới: ")
                product.origin = readln()
                println("Sản phẩm đã được cập nhật: ${product.name}")
            } else {
                println("Không tìm thấy sản phẩm!")
            }
        } else {
            println("Không tìm thấy danh mục!")
        }
    }

    fun deleteProduct() {
        print("Nhập mã danh mục chứa sản phẩm: ")
        val categoryId = readln()
        val category = categories.find { it.id == categoryId }

        if (category != null) {
            print("Nhập mã sản phẩm cần xóa: ")
            val productId = readln()
            val removed = category.products.removeIf { it.id == productId }

            if (removed) {
                println("Sản phẩm đã được xóa!")
            } else {
                println("Không tìm thấy sản phẩm!")
            }
        } else {
            println("Không tìm thấy danh mục!")
        }
    }

    fun calculateTotalValue() {
        val total = categories.flatMap { it.products }.sumOf { it.price }
        println("Tổng giá trị của tất cả sản phẩm: $total VND")
    }

    fun listChineseProducts() {
        val chineseProducts = categories.flatMap { it.products }.filter { it.origin.equals("Trung Quốc", true) }

        if (chineseProducts.isNotEmpty()) {
            println("Danh sách sản phẩm có xuất xứ từ Trung Quốc:")
            chineseProducts.forEach { println("mã: ${it.id} - tên: ${it.name} - nguồn gốc: ${it.price} VND") }
        } else {
            println("Không có sản phẩm nào có xuất xứ từ Trung Quốc.")
        }
    }
}

fun main() {
    val store = StoreManagement()

    while (true) {
        println("\n--- QUẢN LÝ BÁN HÀNG ---")
        println("1. Thêm danh mục sản phẩm")
        println("2. Thêm sản phẩm")
        println("3. Xuất danh sách sản phẩm theo danh mục")
        println("4. Cập nhật sản phẩm")
        println("5. Xóa sản phẩm")
        println("6. Tính tổng giá trị hàng hóa")
        println("7. Liệt kê sản phẩm xuất xứ Trung Quốc")
        println("0. Thoát")
        print("Chọn chức năng: ")

        val choice = readln().toIntOrNull() ?: -1

        when (choice) {
            1 -> store.addCategory()
            2 -> store.addProduct()
            3 -> store.listProductsByCategory()
            4 -> store.updateProduct()
            5 -> store.deleteProduct()
            6 -> store.calculateTotalValue()
            7 -> store.listChineseProducts()
            0 -> {
                println("Thoát chương trình.")
                return
            }
            else -> println("Lựa chọn không hợp lệ!")
        }
    }
}
