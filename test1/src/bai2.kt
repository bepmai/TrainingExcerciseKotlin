/*Viết chương trình cho phép nhập vào 3 số thực
Chương trình này sẽ kiểm tra 3 số này có phải là 3 cạnh của một tam giác hay không.	*/
fun main(){
    println("Nhập vào 3 số thực:")
    print("a: ")
    val a = readln()?.toDoubleOrNull()

    print("b: ")
    val b = readln()?.toDoubleOrNull()

    print("c: ")
    val c = readln()?.toDoubleOrNull()

    if (a == null || b == null || c == null) {
        println("Dữ liệu nhập vào không hợp lệ!")
        return
    }

    if (a <= 0 || b <= 0 || c <= 0) {
        println("Các cạnh của tam giác phải là số dương!")
        return
    }

    if (a + b > c && a + c > b && b + c > a) {
        println("Ba số vừa nhập có thể là các cạnh của một tam giác.")
    } else {
        println("Ba số vừa nhập không thể là các cạnh của một tam giác.")
    }
}