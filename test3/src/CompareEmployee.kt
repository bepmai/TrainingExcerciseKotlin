package compare
import model.Employmen

class CompareEmployee{
    fun compareEmployee(employmen1: Employmen, employmen2: Employmen): Boolean {
        return employmen1.getProductQuantity() > employmen2.getProductQuantity()
    }

    fun printCompareResult(employmen1: Employmen, employmen2: Employmen) {
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