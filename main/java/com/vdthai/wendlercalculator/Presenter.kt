package com.vdthai.wendlercalculator

/**
 * Created by vdthai on 2017-08-24.
 */

class Presenter constructor(mainActivity: MainActivity) {
    private var mCalculator: Calculator = Calculator()

    fun calculateWeekOne(trainingMax: Double): DoubleArray {
        return mCalculator.calculateWeekOne(trainingMax)
    }

    fun changeUnit() {
        mCalculator.updateUnit()
    }

    fun getUnit(): String{
        return mCalculator.getUnit()
    }

    private fun returnWeights(weightList: IntArray): IntArray {
        return weightList
    }
}