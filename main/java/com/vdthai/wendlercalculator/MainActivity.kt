package com.vdthai.wendlercalculator

import android.content.Context
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var mPresenter: Presenter = Presenter(this)

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                weekHeading.setText(R.string.title_week1)
                set1_weight_text.setText(R.string.week1_weight_set1)
                set2_weight_text.setText(R.string.week1_weight_set2)
                set3_weight_text.setText(R.string.week1_weight_set3)
                calculateButton.setOnClickListener {
                    if(enterWeightText.text.toString() != ""){
                        var trainingWeight = enterWeightText.text.toString().replace(mPresenter.getUnit(), "")
                        calculateWeightsText(trainingWeight.toDouble(), 1)
                    }
                }
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                weekHeading.setText(R.string.title_week2)
                set1_weight_text.setText(R.string.week2_weight_set1)
                set2_weight_text.setText(R.string.week2_weight_set2)
                set3_weight_text.setText(R.string.week2_weight_set3)
                calculateButton.setOnClickListener {
                    if(enterWeightText.text.toString() != ""){
                        var trainingWeight = enterWeightText.text.toString().replace(mPresenter.getUnit(), "")
                        calculateWeightsText(trainingWeight.toDouble(), 2)
                    }
                }
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                weekHeading.setText(R.string.title_week3)
                set1_weight_text.setText(R.string.week3_weight_set1)
                set2_weight_text.setText(R.string.week3_weight_set2)
                set3_weight_text.setText(R.string.week3_weight_set3)
                calculateButton.setOnClickListener {
                    if(enterWeightText.text.toString() != ""){
                        var trainingWeight = enterWeightText.text.toString().replace(mPresenter.getUnit(), "")
                        calculateWeightsText(trainingWeight.toDouble(), 3)
                    }
                }
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        navigation.selectedItemId = R.id.navigation_home

        enterWeightButton.setOnClickListener {
            enterWeightText.requestFocus()
            enterWeightText.isFocusableInTouchMode = true
            enterWeightText.text.clear()
            val mInputManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            mInputManager.showSoftInput(enterWeightText, InputMethodManager.SHOW_FORCED)
        }

        unitButton.setOnClickListener {
            if(unitButton.text.toString() == "Unit: Kilograms") {
                unitButton.setText(R.string.text_unit_pounds)
            } else {
                unitButton.setText(R.string.text_unit_kilograms)
            }
            mPresenter.changeUnit()
        }
    }

    private fun calculateWeightsText(trainingMax: Double, week: Int) {
        when (week){
            1 -> updateWeekOneText(mPresenter.calculateWeekOne(trainingMax))
            2 -> updateWeekTwoText(mPresenter.calculateWeekTwo(trainingMax))
            3 -> updateWeekThreeText(mPresenter.calculateWeekThree(trainingMax))
            else -> updateWeekOneText(doubleArrayOf(0.0, 0.0, 0.0))
        }

        if(!enterWeightText.text.toString().contains(mPresenter.getUnit())){
            val unitText = enterWeightText.text.toString() + mPresenter.getUnit()
            enterWeightText.setText(unitText)
        }
    }

    private fun updateWeekOneText(trainingWeights: DoubleArray) {
        val week1_weight_text = resources.getString(R.string.week1_weight_set1) + "   " + trainingWeights[0].toString() + mPresenter.getUnit()
        val week2_weight_text = resources.getString(R.string.week1_weight_set2) + "   " + trainingWeights[1].toString() + mPresenter.getUnit()
        val week3_weight_text = resources.getString(R.string.week1_weight_set3) + "   " + trainingWeights[2].toString() + mPresenter.getUnit()
        set1_weight_text.text = ""
        set1_weight_text.text = week1_weight_text
        set2_weight_text.text = ""
        set2_weight_text.text = week2_weight_text
        set3_weight_text.text = ""
        set3_weight_text.text = week3_weight_text
    }

    private fun updateWeekTwoText(trainingWeights: DoubleArray) {
        val week1_weight_text = resources.getString(R.string.week2_weight_set1) + "   " + trainingWeights[0].toString() + mPresenter.getUnit()
        val week2_weight_text = resources.getString(R.string.week2_weight_set2) + "   " + trainingWeights[1].toString() + mPresenter.getUnit()
        val week3_weight_text = resources.getString(R.string.week2_weight_set3) + "   " + trainingWeights[2].toString() + mPresenter.getUnit()
        set1_weight_text.text = ""
        set1_weight_text.text = week1_weight_text
        set2_weight_text.text = ""
        set2_weight_text.text = week2_weight_text
        set3_weight_text.text = ""
        set3_weight_text.text = week3_weight_text
    }

    private fun updateWeekThreeText(trainingWeights: DoubleArray) {
        val week1_weight_text = resources.getString(R.string.week3_weight_set1) + "   " + trainingWeights[0].toString() + mPresenter.getUnit()
        val week2_weight_text = resources.getString(R.string.week3_weight_set2) + "   " + trainingWeights[1].toString() + mPresenter.getUnit()
        val week3_weight_text = resources.getString(R.string.week3_weight_set3) + "   " + trainingWeights[2].toString() + mPresenter.getUnit()
        set1_weight_text.text = ""
        set1_weight_text.text = week1_weight_text
        set2_weight_text.text = ""
        set2_weight_text.text = week2_weight_text
        set3_weight_text.text = ""
        set3_weight_text.text = week3_weight_text
    }

}
