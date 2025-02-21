import model.Employee

class SalaryEmployee{
    companion object{
        fun getSalary(employmen: Employee): Double{
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

class CompareEmployee{
    fun compareEmployee(employmen1: Employee, employmen2: Employee): Boolean {
        return employmen1.getProductQuantity() > employmen2.getProductQuantity()
    }

    fun printCompareResult(employmen1: Employee, employmen2: Employee) {
        println("\n--- So sánh số sản phẩm (Dùng hàm compareEmployee()) ---")
        if (compareEmployee(employmen1, employmen2)) {
            println("${employmen1.name} có số sản phẩm nhiều hơn ${employmen2.name} ${employmen1.getProductQuantity() - employmen2.getProductQuantity()} sản phẩm.")
        } else if (compareEmployee(employmen2, employmen1)) {
            println("${employmen2.name} có số sản phẩm nhiều hơn ${employmen1.name} ${employmen2.getProductQuantity() - employmen1.getProductQuantity()} sản phẩm.")
        } else {
            println("Cả hai nhân viên có số sản phẩm bằng nhau.")
        }

        println("\n--- So sánh số sản phẩm (Không dùng hàm compareEmployee()) ---")
        if (employmen1.getProductQuantity() > employmen2.getProductQuantity()) {
            println("${employmen1.name} có số sản phẩm nhiều hơn ${employmen2.name} ${employmen1.getProductQuantity() - employmen2.getProductQuantity()} sản phẩm.")
        } else if (employmen2.getProductQuantity() > employmen1.getProductQuantity()) {
            println("${employmen2.name} có số sản phẩm nhiều hơn ${employmen1.name} ${employmen2.getProductQuantity() - employmen1.getProductQuantity()} sản phẩm.")
        } else {
            println("Cả hai nhân viên có số sản phẩm bằng nhau.")
        }
    }
}

fun main() {
    print("Nhập mã nhân viên 1: ")
    val id1 = readln()

    print("Nhập họ tên nhân viên 1: ")
    val name1 = readln()

    print("Nhập số lượng sản phẩm 1: ")
    val productQuantity1 = readln().toIntOrNull() ?: 0

    print("Nhập mã nhân viên 2: ")
    val id2 = readln()

    print("Nhập họ tên nhân viên 2: ")
    val name2 = readln()

    print("Nhập số lượng sản phẩm 2: ")
    val productQuantity2 = readln().toIntOrNull() ?: 0

    val employmen1 = Employee(id1, name1, productQuantity1)
    println("-- Thông tin nhân viên 1 --")
    println("Mã nhân viên 1: ${employmen1.id}")
    println("Tên nhân viên 1: ${employmen1.name}")
    println("Số lượng sản phẩm 1: ${employmen1.getProductQuantity()}")
    println("Lương nhân viên 1: ${SalaryEmployee.getSalary(employmen1)}")

    val employmen2 = Employee(id2, name2, productQuantity2)
    println("-- Thông tin nhân viên 2 --")
    println("Mã nhân viên 2: ${employmen2.id}")
    println("Tên nhân viên 2: ${employmen2.name}")
    println("Số lượng sản phẩm 2: ${employmen2.getProductQuantity()}")
    println("Lương nhân viên 2: ${SalaryEmployee.getSalary(employmen2)}")

    val compareEmployee = CompareEmployee()
    compareEmployee.printCompareResult(employmen1, employmen2)
}