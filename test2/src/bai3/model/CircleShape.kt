package bai3.model

import kotlin.math.PI

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
