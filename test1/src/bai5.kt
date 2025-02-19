/*Bài toán giải phương trình bậc 2 dùng để mô tả việc giải phương trình ax2 + bx + c = 0.
Trong đó a,b,c được gọi là hệ số của bài toán, x1,x2 là nghiệm có thể có. Bài toán sẽ in ra câu trả lời cho việc giải phương trình này.
*/
import kotlin.math.sqrt

fun main() {
    println("Giải phương trình bậc 2: ax² + bx + c = 0")

    print("a: ")
    val a = readln().toDoubleOrNull()
    print("b: ")
    val b = readln().toDoubleOrNull()
    print("c: ")
    val c = readln().toDoubleOrNull()

    if (a == null || b == null || c == null) {
        println("Dữ liệu nhập vào không hợp lệ!")
        return
    }

    if (a == 0.0) {
        if (b == 0.0) {
            if (c == 0.0) {
                println("Phương trình có vô số nghiệm.")
            } else {
                println("Phương trình vô nghiệm.")
            }
        } else {
            val x = -c / b
            println("Đây là phương trình bậc 1 có nghiệm: x = $x")
        }
        return
    }
    else{
        val delta = b * b - 4 * a * c
        if (delta > 0){
            val x1 = (-b + sqrt(delta)) / (2 * a)
            val x2 = (-b - sqrt(delta)) / (2 * a)
            println("Phương trình có 2 nghiệm phân biệt:")
            println("x₁ = $x1")
            println("x₂ = $x2")
        }
        else if (delta == 0.0){
            val x = -b / (2 * a)
            println("Phương trình có nghiệm kép:")
            println("x₁ = x₂ = $x")
        }
        else
            println("Phương trình vô nghiệm (delta < 0).")
    }
}
