package com.example.idealweight

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.INVISIBLE
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var radioGroup: RadioGroup? = null
    lateinit var radioButton: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvInfo.visibility = View.INVISIBLE
        radioGroup = findViewById(R.id.rgGender)


        btCalculateWeight.setOnClickListener {
            val selectedGender: Int = radioGroup!!.checkedRadioButtonId
            radioButton = findViewById(selectedGender)

            tvInfo.visibility = View.VISIBLE

            var weight: Double = etInputWeight.text.toString().toDouble()
            var height: Double = etInputHeight.text.toString().toDouble()
            var gender: String = radioButton.text.toString()
            var weightCoefficient: Double

            Log.i("msg", "weight is ${weight}, height is ${height}, gender is ${gender}")

            if (gender == "Male") {
                weightCoefficient = 0.1
            } else {
                weightCoefficient = 0.15
            }

            var idealWeight: Double = (height - 100) - ((height - 100) * weightCoefficient)

            if (weight == idealWeight) {
                tvResult.text = "${idealWeight} / IDEAL"
            } else {
                tvResult.text = "${idealWeight} / NOT IDEAL"
            }


        }
    }
}