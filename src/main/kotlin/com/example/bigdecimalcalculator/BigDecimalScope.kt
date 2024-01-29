package com.example.bigdecimalcalculator


import java.math.BigDecimal
import java.math.RoundingMode


fun bigDecimalScope(
    scale: Int = 2,
    roundingMode: RoundingMode = RoundingMode.HALF_EVEN,
    init: BigDecimalScope.() -> Unit,
): BigDecimal {
    val scope = BigDecimalScope(scale, roundingMode)
    scope.init()
    return scope.value
}

class BigDecimalScope(
    private val scale: Int,
    private val roundingMode: RoundingMode,
) {

    var value: BigDecimal = BigDecimal.ZERO

    operator fun Number.plus(other: Number): BigDecimal =
        this.toBigDecimal().add(other.toBigDecimal())

    operator fun Number.minus(other: Number): BigDecimal =
        this.toBigDecimal().subtract(other.toBigDecimal())

    operator fun Number.times(other: Number): BigDecimal =
        this.toBigDecimal().multiply(other.toBigDecimal())

    operator fun Number.div(other: Number): BigDecimal =
        this.toBigDecimal().divide(other.toBigDecimal(), scale, roundingMode)

    operator fun Number.rem(other: Number): BigDecimal =
        this.toBigDecimal().remainder(other.toBigDecimal())

}

fun Number.toBigDecimal(): BigDecimal = BigDecimal(this.toString())