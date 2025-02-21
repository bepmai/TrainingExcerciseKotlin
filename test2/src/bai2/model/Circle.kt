package bai2.model

import kotlin.math.PI
import kotlin.math.pow

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
