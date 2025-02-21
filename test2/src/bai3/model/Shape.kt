package bai3.model

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
