package bai3.model

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
