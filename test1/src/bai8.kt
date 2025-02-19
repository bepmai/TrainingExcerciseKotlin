/*Viết chương trình nhập từ bàn phím 2 số a, b và một ký tự ch. Nếu (dùng Switch-case):
− ch là ‘+’ thì thực hiện phép tính a + b và in kết quả lên màn hình.
− ch là ‘–’ thì thực hiện phép tính a - b và in kết quả lên màn hình.
− ch là ‘*’ thì thực hiện phép tính a * b và in kết quả lên màn hình.
− ch là ‘/’ thì thực hiện phép tính a / b và in kết quả lên màn hình.
- ch là kí tự khác thì in ra: không hợp lệ	*/
fun main(){
    print("a: ")
    val a = readln().toDoubleOrNull()

    print("b: ")
    val b = readln().toDoubleOrNull()

    print("ch: ")
    val ch = readln().firstOrNull()

    if (a == null || b == null || ch == null) {
        println("Dữ liệu nhập vào không hợp lệ!")
        return
    }

    when (ch) {
        '+' -> println(a.toString() + " + " + b + " = " + (a + b))
        '-' -> println(a.toString() + " - " + b + " = " + (a - b))
        '*' -> println(a.toString() + " * " + b + " = " + (a * b))
        '/' -> if (b != 0.0) {
            println(a.toString() + " / " + b + " = " + (a / b))
        } else {
            println("Không thể chia cho 0!")
        }

        else -> println("Ký tự không hợp lệ!")
    }
}