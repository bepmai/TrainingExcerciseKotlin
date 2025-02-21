package bai2

import kotlin.math.PI
import kotlin.math.pow

import bai2.model.Point
import bai2.model.Circle
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
