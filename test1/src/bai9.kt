/*Viết chương trình Đoán số, hệ thống sẽ tự random một số từ 0-100,người dùng sẽ nhập 1 số ngẫu nhiên từ 0-100, có tổng cộng 5 lần nhập
Mỗi lần nhập vào một số sẽ in ra thông báo là số người dùng nhập vào lớn hơn hay bé hơn số mà hệ thống chọn lúc đầu
Nếu đoán đúng sẽ in ra: bạn đã thắng
Nếu quá 5 lần sẽ in ra: bạn thua cuộc
Say đó hỏi người chơi có muốn chơi tiếp hay không, y/n, y: chơi lại từ đầu, n sẽ in ra: kết thúc chương trình*/

import kotlin.random.Random
fun getUserGuess(ordinalNum: Int): Int? {
    print("Lần đoán thứ $ordinalNum: ")
    return readln().toIntOrNull()
}

fun playGame(): Boolean {
    val randomNumber = Random.nextInt(0, 101)
    var win = false

    println("Hãy đoán số từ 0 đến 100. Bạn có 5 lần đoán!")

    for (ordinalNum in 1..5) {
        val inputOrdinalNum = getUserGuess(ordinalNum)

        if (inputOrdinalNum == null) {
            println("Dữ liệu nhập không hợp lệ, mời bạn nhập lại!")
            continue
        }

        if (inputOrdinalNum == randomNumber) {
            println("Bạn đã thắng!")
            win = true
            break
        } else if (inputOrdinalNum > randomNumber) {
            println("Số bạn nhập lớn hơn số cần đoán.")
        } else {
            println("Số bạn nhập nhỏ hơn số cần đoán.")
        }
    }

    println("Số ngẫu nhiên được tạo ra là: $randomNumber")
    if (!win) {
        println("Bạn thua cuộc!")
    }
    return win
}

fun askToPlayAgain(): Boolean {
    print("Bạn có muốn chơi tiếp không? (y/n): ")
    return readln().trim().lowercase() == "y"
}

fun main() {
    while (true) {
        playGame()
        if (!askToPlayAgain()) {
            println("Kết thúc chương trình!")
            break
        }
    }
}
