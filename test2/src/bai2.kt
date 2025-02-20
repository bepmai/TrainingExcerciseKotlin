import kotlin.math.PI
import kotlin.math.pow

open class Point(var x: Double, var y: Double) {
    override fun toString(): String {
        return "[$x, $y]"
    }
}

class Circle(x: Double, y: Double, private var radius: Double) : Point(x, y) {
    init {
        setRadius(radius)
    }

    fun setRadius(radius: Double) {
        if (radius > 0) {
            this.radius = radius
        } else {
           println("Bán kính phải lớn hơn 0 và không được để trống")
        }
    }

    fun getDiameter(): Double {
        return 2 * radius
    }

    fun getCircumference(): Double {
        return 2 * PI * radius
    }

    fun getArea(): Double {
        return PI * radius.pow(2)
    }

    override fun toString(): String {
        return "Hình tròn(Tọa độ=${super.toString()}, bán kính=$radius)"
    }
}

fun main() {
    print("Nhập số lượng hình tròn: ")
    val n = readln().toInt()

    val circles = mutableListOf<Circle>()

    for (i in 1..n) {
        println("Nhập tọa độ x, y và bán kính của hình tròn thứ $i: ")
        print("Nhập tọa độ x: ")
        val x = readln().toDouble()

        print("Nhập tọa độ y: ")
        val y = readln().toDouble()

        print("Nhập bán kính: ")
        val radius = readln().toDouble()

        circles.add(Circle(x, y, radius))
    }

    println("Thông tin các hình tròn:")
    for (circle in circles) {
        println(circle)
        println("Đường kính: %.2f".format(circle.getDiameter()))
        println("Chu vi: %.2f".format(circle.getCircumference()))
        println("Diện tích: %.2f".format(circle.getArea()))
        println("---------------------------------")
    }
}
