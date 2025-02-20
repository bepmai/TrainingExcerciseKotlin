import kotlin.math.PI

open class Shape(var color: String) {
    open fun shapePerimeter(): Double {
        return 0.0
    }

    open fun shapeArea(): Double {
        return 0.0
    }

    open fun shapeInfo(): String {
        return "Màu sắc: $color, Diện tích: ${shapeArea()}, Chu vi: ${shapePerimeter()}"
    }
}

open class Rectangle(color: String, var length: Double, var width: Double) : Shape(color) {
    override fun shapePerimeter(): Double {
        return 2 * (length + width)
    }

    override fun shapeArea(): Double {
        return length * width
    }

    override fun shapeInfo(): String {
        return "Hình chữ nhật - Màu sắc: $color, Chiều dài: $length, Chiều rộng: $width, Diện tích: ${shapeArea()}, Chu vi: ${shapePerimeter()}"
    }
}

class CircleShape(color: String, var radius: Double) : Shape(color) {
    override fun shapePerimeter(): Double {
        return 2 * PI * radius
    }

    override fun shapeArea(): Double {
        return PI * radius * radius
    }

    override fun shapeInfo(): String {
        return "Hình tròn - Màu sắc: $color, Bán kính: $radius, Diện tích: ${shapeArea()}, Chu vi: ${shapePerimeter()}"
    }
}

class Square(color: String, var side: Double) : Rectangle(color, side, side) {
    override fun shapeInfo(): String {
        return "Hình vuông - Màu sắc: $color, Cạnh: $side, Diện tích: ${shapeArea()}, Chu vi: ${shapePerimeter()}"
    }
}
fun main() {
    val shapes = mutableListOf<Shape>()

    print("Nhập số lượng hình: ")
    val n = readln().toInt()

    for (i in 1..n) {
        print("Nhập màu sắc của hình $i: ")
        val color = readln()
        print("Chọn loại hình (1 - Chữ nhật, 2 - Tròn, 3 - Vuông): ")
        when (readln().toInt()) {
            1 -> {
                print("Nhập chiều dài: ")
                val length = readln().toDouble()
                print("Nhập chiều rộng: ")
                val width = readln().toDouble()
                shapes.add(Rectangle(color, length, width))
            }
            2 -> {
                print("Nhập bán kính: ")
                val radius = readln().toDouble()
                shapes.add(CircleShape(color, radius))
            }
            3 -> {
                print("Nhập cạnh: ")
                val side = readln().toDouble()
                shapes.add(Square(color, side))
            }
        }
    }

    println("\nThông tin các hình:")
    for ((index, shape) in shapes.withIndex()) {
        println("Hình ${index + 1}: ${shape.shapeInfo()}")
    }
}
