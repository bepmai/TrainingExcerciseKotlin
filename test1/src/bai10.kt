/*Viết một chương trình kiểm tra số nguyên tố
Đầu vào nhập vào một số nguyên bất kì (Lưu ý là số nguyên)
Kiểm tra số đó có là số nguyên tố không, nếu có in ra " số .. là số nguyên tố" nếu ko thì in ra: "số .. ko là số nguyên tố"	*/

import kotlin.math.sqrt

fun checkPrime(n: Int): Boolean {
    if (n < 2) return false
    for (i in 2..sqrt(n.toDouble()).toInt()) {
        if (n % i == 0) return false
    }
    return true
}

fun main() {
    print("Nhập vào một số nguyên: ")
    val n = readln().toIntOrNull()
    if (n == null) {
        println("Vui lòng nhập một số nguyên hợp lệ.")
    } else {
        if (checkPrime(n)) {
            println("Số $n là số nguyên tố.")
        } else {
            println("Số $n không là số nguyên tố.")
        }
    }
}