package bai3.model

class Square(color: String, var side: Double) : Rectangle(color, side, side) {
    override fun shapeInfo(): String {
        return "Hình vuông - Màu sắc: $color, Cạnh: $side, Diện tích: ${shapeArea()}, Chu vi: ${shapePerimeter()}"
    }
}
