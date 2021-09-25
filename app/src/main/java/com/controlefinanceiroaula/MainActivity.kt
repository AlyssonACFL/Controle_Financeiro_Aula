package com.controlefinanceiroaula

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Our code here
        var cost_of_service: EditText = findViewById(R.id.cost_of_service)

        var value_result: TextView = findViewById(R.id.result_view)

        var calculate_button: Button = findViewById(R.id.calculate_button)
        calculate_button.setOnClickListener {

            if ( TextUtils.isEmpty(cost_of_service.text) ){

                cost_of_service.setError("Informe o Valor")

            }else {

                var result = calculeValue(cost_of_service.text.toString().toDouble())
                value_result.text = result.toString()

                value_result.visibility = View.VISIBLE

            }
        }
    }

    // This method calculate value service
    fun calculeValue( value_base: Double ): Double {

        val option: RadioGroup = findViewById(R.id.tip_options)
        val selectOption = option.checkedRadioButtonId

        if ( selectOption == R.id.option_twenty_percent )
            return (value_base * 20.0) / 100 + value_base
        else if ( selectOption.equals(R.id.option_ten_percent) )
            return (value_base * 10.0) / 100 + value_base
        else
            return (value_base * 5.0) / 100 + value_base

        return value_base
    }

}