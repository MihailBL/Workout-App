package com.example.workoutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.marginTop
import com.example.workoutapp.databinding.ActivityBmiactivityBinding
import com.google.android.material.snackbar.Snackbar
import java.math.BigDecimal
import java.math.RoundingMode

class BMIActivity : AppCompatActivity() {

    /** COMPANION OBJECT: Singleton object static to its class*/
    companion object{
        private const val METRIC_UNITS_VIEW = "METRIC_UNIT_VIEW"
        private const val US_UNITS_VIEW = "US_UNITS_VIEW"
    }

    // Create binding for main layout
    private var binding: ActivityBmiactivityBinding? = null

    // Property to hold a value to make selected metric view visible
    private var currentVisibleView = METRIC_UNITS_VIEW

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set the binding
        this.binding = ActivityBmiactivityBinding.inflate(layoutInflater)
        setContentView(this.binding?.root)

        // Set the toolbar as action bar
        setSupportActionBar(this.binding?.toolbarBMIActivity)
        if (supportActionBar != null){
            this.supportActionBar?.title = "BMI CALCULATOR"
            this.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        this.binding?.toolbarBMIActivity?.setNavigationOnClickListener{
            onBackPressed()
        }

        // button get BMI results
        this.binding?.btnDisplayBMIResults?.setOnClickListener { view ->
            calculateBMI(view)
        }

        // Set The Metric System as Default at the beginning
        makeVisibleMetricUnitsView()

        // If radio group buttons state is changed
        this.binding?.rgUnitsConversionTab?.setOnCheckedChangeListener { _, checkedRadioButtonID: Int ->
            if (checkedRadioButtonID == R.id.rb_metricUnits)
                makeVisibleMetricUnitsView()
            else
                makeVisibleUSUnitsView()
        }
    }

    /** Check if the edit text fields are empty for metric units */
    private fun checkUserInputForMetricUnits(): Boolean{
        var isValid = true

        if (this.binding?.etUserWeightInput?.text?.isEmpty() == true)
            isValid = false
        else if (this.binding?.etUserHeightInput?.text?.isEmpty() == true)
            isValid = false

        return isValid
    }

    /** check if edit text fields are empty for us units */
    private fun checkUserInputForUSUnits(): Boolean{
        var isValid = true

        if (this.binding?.etUserWeightInputUSUnitsPOUNDS?.text?.isEmpty() == true)
            isValid = false
        else if (this.binding?.etUserHeightInputUSUnitsFEET?.text?.isEmpty() == true)
            isValid = false
        else if (this.binding?.etUserHeightInputUSUnitsINCHES?.text?.isEmpty() == true)
            isValid = false

        return isValid
    }

    /** Method to calculate results for Metric or US Units */
    private fun calculateBMI(view: View){
        if (this.currentVisibleView == METRIC_UNITS_VIEW){
            if (checkUserInputForMetricUnits()){
                // BMI Formula: weight(kg)/[height(m)]^2
                val userWeight = this.binding?.etUserWeightInput?.text?.toString()?.toFloat()
                val userHeight = this.binding?.etUserHeightInput?.text?.toString()?.toFloat()?.div(100)

                val bmiResult = userWeight?.div((userHeight!! * userHeight))
                displayBMIResults(bmiResult!!)
            }else{
                val snackBar = Snackbar.make(view, "Please Fill The Fields", Snackbar.LENGTH_LONG)
                snackBar.animationMode = Snackbar.ANIMATION_MODE_SLIDE
                snackBar.show()
            }
        }
        else{   // Else the user is in US Units
            if (checkUserInputForUSUnits()){
                val userWeightUSUnits = this.binding?.etUserWeightInputUSUnitsPOUNDS?.text?.toString()?.toFloat()
                val userHeightUSUnitsFEET = this.binding?.etUserHeightInputUSUnitsFEET?.text?.toString()?.toFloat()
                val userHeightUSUnitsINCHES = this.binding?.etUserHeightInputUSUnitsINCHES?.text?.toString()?.toFloat()

                val heightValue = userHeightUSUnitsFEET?.plus(userHeightUSUnitsINCHES!!)?.times(12)
                // TODO: BMI CALCULATION FOR US UNITS DON'T SHOW SAME RESULTS, WRONG IN CALCULATIONS HERE
                val bmiResult = 703 * (userWeightUSUnits?.div((heightValue?.times(heightValue)!!))!!)
                displayBMIResults(bmiResult)
            }
            else{
                val snackBar = Snackbar.make(view, "Please Fill The Fields", Snackbar.LENGTH_LONG)
                snackBar.animationMode = Snackbar.ANIMATION_MODE_SLIDE
                snackBar.show()
            }
        }
    }

    /** Method to Display BMI Results */
    private fun displayBMIResults(bmiResults: Float){
        var bmiLabel = ""
        var bmiDescription = ""

        if (bmiResults.compareTo(15f) <= 0){
            bmiLabel = "Very severely underweight"
            bmiDescription = "You are very severely underweight! This can results in weak blood, low immune system" +
                    ", and will negatively affect the overall health! Eat more and healthy food!"
        }
        else if (bmiResults.compareTo(15f) > 0 && bmiResults.compareTo(16f) <= 0){
            bmiLabel = "severely underweight"
            bmiDescription = "Being severely underweight can cause you low immune system and lack of energy!" +
                    " Exercising will be of no contribution to your muscle and can cause damage to the body!" +
                    " Eat more healthy food!"
        }
        else if (bmiResults.compareTo(16f) > 0 && bmiResults.compareTo(18.5f) <= 0){
            bmiLabel = "Underweight"
            bmiDescription = "You are underweight! Eat more to get to normal Levels. Exercising while" +
                    " underweight will have less positive results!"
        }
        else if (bmiResults.compareTo(18.5f) > 0 && bmiResults.compareTo(25f) <= 0){
            bmiLabel = "Normal"
            bmiDescription = "Congratulations! You are in good shape! Normal level is the healthiest." +
                    " Exercising will build up stamina, muscles, strength, etc..."
        }
        else if (bmiResults.compareTo(25f) > 0 && bmiResults.compareTo(30f) <= 0){
            bmiLabel = "Overweight"
            bmiDescription = "You are overweight! You need to exercise more or make habit of it." +
                    "Losing weight and building up muscles should less difficult in no time!"
        }
        else if (bmiResults.compareTo(30f) > 0 && bmiResults.compareTo(35f) <= 0){
            bmiLabel = "Heavily overweight"
            bmiDescription = "You are heavily overweight! Exercising would be difficult, because " +
                    "of the weight stamina would be hard to maintain. Exercise without quitting " +
                    "and you can get back to normal levels! Eating a healthy food is a must!"
        }
        else if (bmiResults.compareTo(35f) > 0 && bmiResults.compareTo(40f) <= 0){
            bmiLabel = "Obese Level"
            bmiDescription = "Obese Level! Critical condition for the very health and organic tissues!" +
                    " Eating less and starting diet with healthy food is a must! Exercising would be " +
                    "extremely difficult, but every little progress by day is one milestone achieved!"
        }

        val bmiValueConverted = BigDecimal(bmiResults.toDouble()).setScale(2, RoundingMode.HALF_EVEN).toString()
        this.binding?.llBMIResultView?.visibility = View.VISIBLE
        this.binding?.tvUserBMIValue?.text = bmiValueConverted
        this.binding?.tvUserBMIType?.text = bmiLabel
        this.binding?.tvUserBMIDescription?.text = bmiDescription

    }

    /** Set up views for the Metric Units */
    private fun makeVisibleMetricUnitsView(){
        this.currentVisibleView = METRIC_UNITS_VIEW
        this.binding?.tilUserWeight?.visibility = View.VISIBLE
        this.binding?.tilUserHeight?.visibility = View.VISIBLE
        this.binding?.tilUserWeightUSUnitsPOUNDS?.visibility = View.GONE
        this.binding?.tilUserHeightUSUnitsFEET?.visibility = View.GONE
        this.binding?.tilUserHeightUSUnitsINCHES?.visibility = View.GONE

        // Clear the edit text fields
        this.binding?.etUserWeightInput?.text?.clear()
        this.binding?.etUserHeightInput?.text?.clear()

        // Make BMI gone
        this.binding?.llBMIResultView?.visibility = View.INVISIBLE
    }

    /** Method to set up view for Us Units */
    private fun makeVisibleUSUnitsView(){
        this.currentVisibleView = US_UNITS_VIEW
        this.binding?.tilUserWeight?.visibility = View.GONE
        this.binding?.tilUserHeight?.visibility = View.GONE
        this.binding?.tilUserWeightUSUnitsPOUNDS?.visibility = View.VISIBLE
        this.binding?.tilUserHeightUSUnitsFEET?.visibility = View.VISIBLE
        this.binding?.tilUserHeightUSUnitsINCHES?.visibility = View.VISIBLE

        // Clear the edit text fields
        this.binding?.etUserWeightInputUSUnitsPOUNDS?.text?.clear()
        this.binding?.etUserHeightInputUSUnitsFEET?.text?.clear()
        this.binding?.etUserHeightInputUSUnitsINCHES?.text?.clear()

        // Make BMI gone
        this.binding?.llBMIResultView?.visibility = View.INVISIBLE
    }

    override fun onDestroy() {
        super.onDestroy()

        this.binding = null
    }
}