package com.example.currencyconverter

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextAmount = findViewById<EditText>(R.id.editTextAmount)
        val buttonConvert = findViewById<Button>(R.id.buttonConvert)
        val textViewResult = findViewById<TextView>(R.id.textViewResult)

        buttonConvert.setOnClickListener {
            val input = editTextAmount.text.toString().toDoubleOrNull()
            if (input != null) {
                val convertedAmount = convertCurrency(input)
                textViewResult.text = "Converted amount: $convertedAmount"
                if (input > 10000.0) {
                    showToast("Value over $10,000.00")
                }
            } else {
                showToast("Invalid input")
            }
        }
    }

    private fun convertCurrency(amountInUSD: Double): Double {
        // Conversion rate from USD to GBP (example rate)
        val exchangeRate = 0.74
        return amountInUSD * exchangeRate
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
