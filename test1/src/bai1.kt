/* Viết chương trình mà khi chạy, màn hình console sẽ cho phép ta nhập vào một số nguyên, in ra màn hình “Đây là số nguyên dương”
Nếu số vừa nhập vào là một số lớn hơn hoặc bằng 0, ngược lại in ra “Đây là số nguyên âm”.*/
fun main(){
    print("Nhập số: ")
    val input = readln();
    val num= input.toIntOrNull()

    if (num == null) {
        println("Dữ liệu nhập vào không hợp lệ!")
        return
    }

    if(num >=0)
        println("Đây là số nguyên dương")
    else
        println("Đây là số nguyên âm")
}