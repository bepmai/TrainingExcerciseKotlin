package bai3

import kotlin.math.PI
import bai3.model.Shape
import bai3.model.Rectangle
import  bai3.model.CircleShape
import bai3.model.Square

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
