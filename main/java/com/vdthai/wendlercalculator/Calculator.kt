package com.vdthai.wendlercalculator

/**
 * Created by vdthai on 2017-08-24.
 */

enum class Unit {
    KILOGRAMS, POUNDS
}

enum class Result {
    ROUNDED, UNROUNDED
}

class Calculator {
    private var mUnit: Unit = Unit.KILOGRAMS
    private var mResult: Result = Result.ROUNDED

    fun calculateWeekOne(weight: Double): DoubleArray{
        if(mResult == Result.ROUNDED){
            return calculateWeekOneRounded(weight)
        }
        return calculateWeekOneNotRounded(weight)
    }

    fun calculateWeekTwo(weight: Double): DoubleArray{
        if(mResult == Result.ROUNDED){
            return calculateWeekTwoRounded(weight)
        }
        return calculateWeekTwoNotRounded(weight)
    }

    fun calculateWeekThree(weight: Double): DoubleArray{
        if(mResult == Result.ROUNDED){
            return calculateWeekThreeRounded(weight)
        }
        return calculateWeekThreeNotRounded(weight)
    }

    private fun calculateWeekOneRounded(weight: Double): DoubleArray{
        val firstSet = roundValue(weight * 0.65)
        val secondSet = roundValue(weight * 0.75)
        val finalSet = roundValue(weight * 0.85)
        return doubleArrayOf(firstSet, secondSet, finalSet)
    }

    private fun calculateWeekTwoRounded(weight: Double): DoubleArray{
        val firstSet = roundValue(weight * 0.70)
        val secondSet = roundValue(weight * 0.80)
        val finalSet = roundValue(weight * 0.90)
        return doubleArrayOf(firstSet, secondSet, finalSet)
    }

    private fun calculateWeekThreeRounded(weight: Double): DoubleArray{
        val firstSet = roundValue(weight * 0.75)
        val secondSet = roundValue(weight * 0.85)
        val finalSet = roundValue(weight * 0.95)
        return doubleArrayOf(firstSet, secondSet, finalSet)
    }

    private fun calculateWeekOneNotRounded(weight: Double): DoubleArray{
        val firstSet = weight * 0.65
        val secondSet = weight * 0.75
        val finalSet = weight * 0.85
        return doubleArrayOf(firstSet, secondSet, finalSet)
    }

    private fun calculateWeekTwoNotRounded(weight: Double): DoubleArray{
        val firstSet = weight * 0.70
        val secondSet = weight * 0.80
        val finalSet = weight * 0.90
        return doubleArrayOf(firstSet, secondSet, finalSet)
    }

    private fun calculateWeekThreeNotRounded(weight: Double): DoubleArray{
        val firstSet = weight * 0.75
        val secondSet = weight * 0.85
        val finalSet = weight * 0.95
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
        if(mUnit == Unit.KILOGRAMS) {
            mUnit = Unit.POUNDS
        } else {
            mUnit = Unit.KILOGRAMS
        }
    }

    fun updateResult(){
        if(mResult == Result.ROUNDED){
            mResult = Result.UNROUNDED
        } else {
            mResult = Result.ROUNDED
        }
    }

    fun getUnit(): String {
        if ( mUnit == Unit.KILOGRAMS ) {
            return " kg"
        }
        return " lbs"
    }
}