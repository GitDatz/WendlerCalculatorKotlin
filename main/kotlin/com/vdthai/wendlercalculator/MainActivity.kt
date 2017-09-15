package com.vdthai.wendlercalculator

import android.content.Context
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var mTextMessage: TextView? = null
    private var mTextWeek1: TextView? = null
    private var mTextWeek2: TextView? = null
    private var mTextWeek3: TextView? = null
    private var mPresenter: Presenter = Presenter(this)

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                mTextMessage!!.setText(R.string.title_week1)
                mTextWeek1!!.setText(R.string.week1_weight_set1)
                mTextWeek2!!.setText(R.string.week1_weight_set2)
                mTextWeek3!!.setText(R.string.week1_weight_set3)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                mTextMessage!!.setText(R.string.title_week2)
                mTextWeek1!!.setText(R.string.week2_weight_set1)
                mTextWeek2!!.setText(R.string.week2_weight_set2)
                mTextWeek3!!.setText(R.string.week2_weight_set3)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                mTextMessage!!.setText(R.string.title_week3)
                mTextWeek1!!.setText(R.string.week3_weight_set1)
                mTextWeek2!!.setText(R.string.week3_weight_set2)
                mTextWeek3!!.setText(R.string.week3_weight_set3)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mTextMessage = findViewById(R.id.message) as TextView
        mTextWeek1 = findViewById(R.id.set1_weight) as TextView
        mTextWeek2 = findViewById(R.id.set2_weight) as TextView
        mTextWeek3 = findViewById(R.id.set3_weight) as TextView

        val mEnterWeighText = findViewById(R.id.enterWeightText) as EditText

        val navigation = findViewById(R.id.navigation) as BottomNavigationView
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        val mEnterWeightButton = findViewById(R.id.enterWeightButton) as Button
        mEnterWeightButton.setOnClickListener {
            mEnterWeighText.requestFocus()
            mEnterWeighText.isFocusableInTouchMode = true
            val mInputManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            mInputManager.showSoftInput(mEnterWeighText, InputMethodManager.SHOW_FORCED)
        }

        val mUnitButton = findViewById(R.id.unitButton) as Button
        mUnitButton.setOnClickListener {
            if( mUnitButton.text.toString().equals("Unit: Kilograms") ) {
                mUnitButton.setText(R.string.text_unit_pounds)
            } else {
                mUnitButton.setText(R.string.text_unit_kilograms)
            }
            mPresenter.changeUnit()
        }
    }

}
