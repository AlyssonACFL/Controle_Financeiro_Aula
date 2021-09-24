package com.controlefinanceiroaula

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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

            var result = calculeValue( cost_of_service.text.toString().toDouble() )
            value_result.text = result.toString()

        }
    }

    // This method calculate value service
    fun calculeValue( value_base: Double ): Double {
        return value_base
    }

}