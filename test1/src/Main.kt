fun main() {
    // Prints a message to request input
//    print("Enter any word: ")
//    val yourWord = readln()
//    print("You entered the word: ")
//    println(yourWord)

//    Functions
    //    val mathOps = MathOperations()
    //    mathOps.greet("Kotlin Learner")
    //    val result = mathOps.sum(5, 10)
    //    println("Kết quả của mathOps.sum: $result")

//    Variables
    //    val từ khóa để khai báo các biến chỉ được gán giá trị một lần.
    //    Đây là các biến cục bộ chỉ đọc, không thể thay đổi và không thể gán lại giá trị khác sau khi khởi tạo
    //    val x: Int = 5 // 5
    //  var từ khóa để khai báo các biến có thể được gán lại. Đây là các biến có thể thay đổi và bạn có thể thay đổi giá trị của chúng sau khi khởi tạo
    //    var y: Int = 5
    //    y += 1 // 6
    // khởi tạo x tại thời điểm khai báo; k yêu cầu kiểu
    //    val x = 5 // 5
    // khai báo biến c mà không cần khởi tạo; bắt buộc phải có kiểu
    //    val c:Int
    //    c = 4 // 4

//    Class
    //    val rectangle = Rectangle(3.0, 4.0)
    //    println("The perimeter is ${rectangle.perimeter}")

//    String
    //    ${} được dùng để chèn biểu thức hoặc biến vào chuỗi.
    //    .replace("is", "was") thay thế "is" bằng "was" trong s1.
    //    val s1 = "Kotlin is fun"
    //    val a = "awesome"
    //
    //    val s2 = "${s1.replace("is", "was")}, but now is $a"
    //
    //    println(s2)

// Ép kiểu narrowing: Double -> Int (sử dụng toInt())
//    val x: Double = 9.7
//    val y: Int = x.toInt() // mất phần thập phân
//    println("Giá trị của y (Double -> Int): $y")

// Các toán tử
    //    val a = 2
    //    val y = 1
    //    val sum = a + y
    //    val diff = a - y
    //    val product = a * y
    //    val isConditionTrue = (a < y) && (y > 5)
    //    println("Tổng: $sum, Hiệu: $diff, Tích: $product, Điều kiện: $isConditionTrue")
}
// --- Lớp MathOperations ---
// Chứa phương thức có tham số, không trả về và có trả về kết quả
class MathOperations {
    // Phương thức có tham số, không trả về (Unit)
    fun greet(name: String) {
        println("Chào $name")
    }

    //Hàm có kiểu trả về rõ ràng
    fun sum01(a: Int, b: Int): Int {
        return a + b
    }
    // tự suy diễn kiểu trả về
    fun sum(a: Int, b: Int) = a + b
}

// class
open class Shape // Lớp cha

// Kế thừa
class Rectangle(val height: Double, val length: Double): Shape() {
    val perimeter = (height + length) * 2
}
/* You entered the word: Happiness
     Tạo đối tượng từ lớp Person và gọi phương thức introduce()
    val person1 = Person("Nguyễn Văn A", 25)
    person1.introduce()

    // --- Các kiểu dữ liệu ---
    val number: Int = 10
    val pi: Double = 3.14
    val letter: Char = 'A'
    val isKotlinFun: Boolean = true
    val message: String = "Hello Kotlin"

    println("number: $number, pi: $pi, letter: $letter, isKotlinFun: $isKotlinFun, message: $message")

    // --- Khai báo biến (var) và hằng số (val) ---
    var mutableAge: Int = 30
    println("Mutable Age: $mutableAge")
    mutableAge = 35
    println("Mutable Age after update: $mutableAge")

    val constantPI: Double = 3.1416  // Hằng số, không thay đổi giá trị
    println("Constant PI: $constantPI")

    // --- Ép kiểu dữ liệu ---
    // Ép kiểu widening: Int -> Double (sử dụng toDouble())
    val a: Int = 10
    val b: Double = a.toDouble()  // chuyển từ Int sang Double
    println("Giá trị của b (Int -> Double): $b")

    // Ép kiểu narrowing: Double -> Int (sử dụng toInt())
    val x: Double = 9.7
    val y: Int = x.toInt() // mất phần thập phân
    println("Giá trị của y (Double -> Int): $y")

    // --- Các toán tử ---
    val sum = a + y             // Toán tử số học +
    val diff = a - y            // Toán tử số học -
    val product = a * y         // Toán tử số học *
    val isConditionTrue = (a < y) && (y > 5)  // Toán tử quan hệ và logic
    println("Tổng: $sum, Hiệu: $diff, Tích: $product, Điều kiện: $isConditionTrue")

    // --- Gọi phương thức trong lớp MathOperations ---
    val mathOps = MathOperations()
    mathOps.greet("Kotlin Learner")
    val result = mathOps.sum(5, 10)
    println("Kết quả của mathOps.sum: $result")

    // --- Sử dụng lớp Car với constructor ---
    val myCar = Car("Toyota")
    myCar.showBrand()
}

// --- Khai báo class Person ---
// Class, thuộc tính và phương thức
class Person(var name: String, var age: Int) {
    // Phương thức không trả về kết quả (Unit có thể bỏ qua)
    fun introduce() {
        println("Tôi là $name, $age tuổi.")
    }
}

// --- Lớp MathOperations ---
// Chứa phương thức có tham số, không trả về và có trả về kết quả
class MathOperations {
    // Phương thức có tham số, không trả về (Unit)
    fun greet(name: String) {
        println("Chào $name")
    }

    // Phương thức có trả về kết quả (số nguyên)
    fun sum(a: Int, b: Int): Int {
        return a + b
    }
}

// --- Lớp Car ---
// Khai báo class và hàm khởi tạo (constructor)
class Car(var brand: String) {
    fun showBrand() {
        println("Hãng xe: $brand")
    } */
