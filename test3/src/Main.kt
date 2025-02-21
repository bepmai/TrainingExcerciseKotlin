import model.Employmen
import salary.SalaryEmployee
import compare.CompareEmployee

fun main() {
    print("Nhập mã nhân viên 1: ")
    val id1 = readln()

    print("Nhập họ tên nhân viên 1: ")
    val name1 = readln()

    print("Nhập số lượng sản phẩm 1: ")
    val product_quantity1 = readln().toIntOrNull() ?: 0

    print("Nhập mã nhân viên 2: ")
    val id2 = readln()

    print("Nhập họ tên nhân viên 2: ")
    val name2 = readln()

    print("Nhập số lượng sản phẩm 2: ")
    val product_quantity2 = readln().toIntOrNull() ?: 0

    val employmen1 = Employmen(id1, name1, product_quantity1)
    println("-- Thông tin nhân viên 1 --")
    println("Mã nhân viên 1: ${employmen1.id}")
    println("Tên nhân viên 1: ${employmen1.name}")
    println("Số lượng sản phẩm 1: ${employmen1.getProductQuantity()}")
    println("Lương nhân viên 1: ${SalaryEmployee.getSalary(employmen1)}")

    val employmen2 = Employmen(id2, name2, product_quantity2)
    println("-- Thông tin nhân viên 2 --")
    println("Mã nhân viên 2: ${employmen2.id}")
    println("Tên nhân viên 2: ${employmen2.name}")
    println("Số lượng sản phẩm 2: ${employmen2.getProductQuantity()}")
    println("Lương nhân viên 2: ${SalaryEmployee.getSalary(employmen2)}")

    val compareEmployee = CompareEmployee()
    compareEmployee.printCompareResult(employmen1, employmen2)
}