package com.controlefinanceiroaula

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var cost_of_service: EditText = findViewById(R.id.cost_of_service)
        var calculate_button: Button = findViewById(R.id.calculate_button)

        calculate_button.setOnClickListener {

            var cost_value : Double
            var adittional_percentage: Double = DefinePercentage()

            if(Validate_Fields()) {

                cost_value = cost_of_service.getText().toString().toDouble()

                cost_value = CalculeValueByComplexity(
                    cost_value,
                    adittional_percentage
                )

                ShowResult(RoundValuebySwitch(cost_value))
            }else{
                Clear_Result()
            }

        }

    }

    fun RoundValuebySwitch(value:Double):Double{
        var round_switch :Switch = findViewById(R.id.round_value)
        if (round_switch.isChecked()){
            return (value+1)-(value%1)
        }else{
            return value
        }
    }

    fun ShowResult(result: Double){

        var value_result: TextView = findViewById(R.id.result_view)
        var service_name: TextView = findViewById(R.id.name_of_service)

        value_result.setText("Serviço: " + service_name.getText() + "\nR$ " + result)

        value_result.visibility = View.VISIBLE

        Clear_Fields()

    }

    fun CalculeValueByComplexity( base_value: Double, adittional_percentage: Double): Double {
        var final_value: Double

        final_value = (base_value*(100+adittional_percentage))/100.0

        return final_value
    }

    fun DefinePercentage ():Double{

        var option_twenty_percent :RadioButton = findViewById(R.id.option_twenty_percent)
        var option_ten_percent :RadioButton = findViewById(R.id.option_ten_percent)
        var option_five_percent :RadioButton = findViewById(R.id.option_five_percent)

        if (option_twenty_percent.isChecked ){
            return 20.0
        }else if (option_ten_percent.isChecked ){
            return 10.0
        }else if (option_five_percent.isChecked ){
            return 5.0
        }
        return 0.0
    }

    fun Validate_Fields (): Boolean{
        var cost_of_service: EditText = findViewById(R.id.cost_of_service)
        var service_name: TextView = findViewById(R.id.name_of_service)
        var return_value: Boolean = true

        if(TextUtils.isEmpty(cost_of_service.text)){
            cost_of_service.setError("Informe o Valor")
            return_value=false
        }
        if(TextUtils.isEmpty(service_name.text)){
            service_name.setError("Informe o Valor")
            return_value=false
        }

        return return_value

    }

    fun Clear_Fields(){
        var cost_of_service: EditText = findViewById(R.id.cost_of_service)
        var service_name: TextView = findViewById(R.id.name_of_service)
        cost_of_service.setText("")
        service_name.setText("")
    }

    fun Clear_Result(){
        var value_result: TextView = findViewById(R.id.result_view)
        value_result.setText("Resultado")
        value_result.visibility = View.GONE
    }
}