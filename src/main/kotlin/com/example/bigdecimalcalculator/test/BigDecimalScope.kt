package com.example.bigdecimalcalculator.test

import java.math.BigDecimal
import java.math.RoundingMode

fun bigDecimalScope(
    scale: Int = 2,
    roundingMode: RoundingMode = RoundingMode.HALF_EVEN,
    init: BigDecimalScope.() -> BigDecimal,
): BigDecimal {
    val scope = BigDecimalScope(scale, roundingMode)
    return scope.init()
}

class BigDecimalScope(
    private val scale: Int,
    private val roundingMode: RoundingMode,
) {
    operator fun BigDecimal.plus(other: Number): BigDecimal =
        this.toBigDecimal().add(other.toBigDecimal())

    operator fun BigDecimal.minus(other: Number): BigDecimal =
        this.toBigDecimal().subtract(other.toBigDecimal())

    operator fun BigDecimal.times(other: Number): BigDecimal =
        this.toBigDecimal().multiply(other.toBigDecimal())

    operator fun BigDecimal.div(other: Number): BigDecimal =
        this.toBigDecimal().divide(other.toBigDecimal(), scale, roundingMode)

    operator fun BigDecimal.rem(other: Number): BigDecimal =
        this.toBigDecimal().remainder(other.toBigDecimal())
}

fun Number.toBigDecimal(): BigDecimal = BigDecimal(this.toString())