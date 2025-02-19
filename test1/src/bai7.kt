/*Viết class UCLNBCNN trình tính:
- Thuộc tính a,b
- Phương thức khởi tạo có 2 tham số để nhập giá trị cho a,b
- Xây dựng phương thức tìm ước chung lớn nhất của 2 số a, b.	*/

class UCLNBCNN(var a: Int, var b: Int) {

    fun timUCLN(): Int {
        var x = a
        var y = b
        x = if (x < 0) -x else x
        y = if (y < 0) -y else y

        while (y != 0) {
            val temp = y
            y = x % y
            x = temp
        }
        return x
    }
}

fun main() {
    print("a: ")
    val a = readln().toIntOrNull()

    print("b: ")
    val b = readln().toIntOrNull()

    if (a == null || b == null) {
        println("Dữ liệu nhập vào không hợp lệ!")
        return
    }

    val ucln = UCLNBCNN(a, b)
    println("Ước chung lớn nhất của ${ucln.a} và ${ucln.b} là: ${ucln.timUCLN()}")
}

