//Nhập vào tháng và năm, sau đó tính ra số ngày của tháng thuộc năm đã nhập.
fun main(){
    println("Nhập vào tháng và năm:")
    print("Nhập tháng: ")
    val m = readln().toIntOrNull()
    print("Nhập năm: ")
    val y = readln().toIntOrNull()

    if (m == null || y == null) {
        println("Dữ liệu nhập vào không hợp lệ!")
        return
    }

    if (m<12){
        println("Tháng phải nằm trong khoảng từ 1 đến 12!")
        return
    }
    val daysInMonth = when(m) {
        1, 3, 5, 7, 8, 10, 12 -> 31
        4, 6, 9, 11 -> 30
        2 -> {
            if ((y % 4 == 0 && y % 100 != 0) || (y % 400 == 0))
                29
            else
                28
        }
        else -> {
            println("Tháng không hợp lệ!")
            return
        }
    }

    println("Tháng $m năm $y có $daysInMonth ngày.")
}