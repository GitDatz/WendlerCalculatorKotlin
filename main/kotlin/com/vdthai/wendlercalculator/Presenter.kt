package com.vdthai.wendlercalculator

/**
 * Created by vdthai on 2017-08-24.
 */

class Presenter constructor(mainActivity: MainActivity) {
    private var mCalculator: Calculator = Calculator()

    fun calculateWeek(week: Double){
        mCalculator.calculateWeekOne(week)
    }

    fun changeUnit() {
        mCalculator.updateUnit()
    }

    private fun returnWeights(weightList: IntArray): IntArray {
        return weightList
    }
}