package com.vdthai.wendlercalculator

/**
 * Created by vdthai on 2017-08-24.
 */

enum class Unit {
    KILOGRAMS, POUNDS
}

class Calculator {
    private var mUnit: Unit = Unit.KILOGRAMS

    fun calculateWeekOne(weight: Double): DoubleArray{
        if(mUnit == Unit.KILOGRAMS){
            return calculateWeekOneRounded(weight)
        }
        return calculateWeekOneNotRounded(weight)
    }

    private fun calculateWeekOneRounded(weight: Double): DoubleArray{
        val firstSet = roundValue(weight * 0.65)
        val secondSet = roundValue(weight * 0.75)
        val finalSet = roundValue(weight * 0.85)
        return doubleArrayOf(firstSet, secondSet, finalSet)
    }

    private fun calculateWeekOneNotRounded(weight: Double): DoubleArray{
        val firstSet = weight * 0.65
        val secondSet = weight * 0.75
        val finalSet = weight * 0.85
        return doubleArrayOf(firstSet, secondSet, finalSet)
    }

    private fun roundValue(weight: Double): Double {
        val valueToRound = weight % 10
        val roundedWeight = when {
            valueToRound < 1.3 -> weight - valueToRound
            valueToRound < 3.8 -> weight + 2.5 - valueToRound
            valueToRound < 6.3 -> weight + 5.0 - valueToRound
            valueToRound < 8.8 -> weight + 7.5 - valueToRound
            else -> weight + 10 - valueToRound
        }
        return roundedWeight
    }

    fun updateUnit(){
        when ( mUnit ) {
            Unit.KILOGRAMS -> mUnit = Unit.POUNDS
            Unit.POUNDS -> mUnit = Unit.KILOGRAMS
        }
    }

    fun getUnit(): Unit {
        return mUnit
    }
}