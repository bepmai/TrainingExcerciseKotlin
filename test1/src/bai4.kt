/*Xây dựng chương trình Triangle: nhập vào 3 số a,b,c là 3 cạnh của tam giác. Xây dựng hành vi tính chu vi, diện tích tam giác được tạo từ 3 cạnh trên, chú ý kiểm tra xem a,b,c có thỏa mãn là 3 cạnh của tam giác hay không?
- Phương thức nhập giá trị có 3 tham số để nhập giá trị đầu vào cho a,b,c
- Phương thức tính chu vi
- Phương thức tính diện tích tam giác
- Phương thức inTT	*/
import kotlin.math.sqrt

class Triangle {
    var a: Double = 0.0
    var b: Double = 0.0
    var c: Double = 0.0

    fun enterValue() {
        println("Nhập vào 3 số thực:")
        print("a: ")
        val inputA = readln().toDoubleOrNull()
        print("b: ")
        val inputB = readln().toDoubleOrNull()
        print("c: ")
        val inputC = readln().toDoubleOrNull()

        if (inputA == null || inputB == null || inputC == null) {
            println("Dữ liệu nhập vào không hợp lệ!")
            return
        }

        if (inputA <= 0 || inputB <= 0 || inputC <= 0) {
            println("Các cạnh của tam giác phải là số dương!")
            return
        }

        if (!check(inputA, inputB, inputC)) {
            println("Ba số vừa nhập không thể tạo thành tam giác!")
            return
        }

        a = inputA
        b = inputB
        c = inputC
    }

    fun check(a: Double, b: Double, c: Double): Boolean {
        return a + b > c && a + c > b && b + c > a
    }

    fun perimeter(): Double {
        return a + b + c
    }

    fun area(): Double {
        val p = perimeter() / 2
        return sqrt(p * (p - a) * (p - b) * (p - c))
    }

    fun printInfo() {
        println("Tam giác có các cạnh: a = $a, b = $b, c = $c")
        println("Chu vi của tam giác: ${perimeter()}")
        println("Diện tích của tam giác: ${area()}")
    }
}

fun main() {
    val triangle = Triangle()
    triangle.enterValue()

    if (triangle.a != 0.0 && triangle.b != 0.0 && triangle.c != 0.0) {
        triangle.printInfo()
    }
}
