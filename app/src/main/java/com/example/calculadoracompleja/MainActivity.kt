package com.example.calculadoracompleja

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var num1: Double = 0.0
    private var num2: Double = 0.0
    private var operation: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        oneButton.setOnClickListener { numberPressed("1") }
        twoButton.setOnClickListener { numberPressed("2") }
        threeButton.setOnClickListener { numberPressed("3") }
        fourButton.setOnClickListener { numberPressed("4") }
        fiveButton.setOnClickListener { numberPressed("5") }
        sixButton.setOnClickListener { numberPressed("6") }
        sevenButton.setOnClickListener { numberPressed("7") }
        eightButton.setOnClickListener { numberPressed("8") }
        nineButton.setOnClickListener { numberPressed("9") }
        zeroButton.setOnClickListener { numberPressed("0") }

        sumButton.setOnClickListener { operationPress(SUM) }
        subtractionButton.setOnClickListener { operationPress(SUBTRACTION) }
        multiplicationButton.setOnClickListener { operationPress(MULTIPLICATION) }
        divisionButton.setOnClickListener { operationPress(DIVISION) }

        clearButton.setOnClickListener {
            num1 = 0.0
            num2 = 0.0
            resultTextView.text = "0"
            operation = NO_OPERATION
        }

        equalityButton.setOnClickListener {
            val result: Any = when (operation){
                SUM -> num1 + num2
                SUBTRACTION -> num1 - num2
                MULTIPLICATION -> num1 * num2
                DIVISION -> num1 / num2
                else -> 0
            }

            resultTextView.text = result.toString()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun numberPressed(digit: String){
        resultTextView.text = "${resultTextView.text}$digit"

        if(operation == NO_OPERATION){
            num1 = resultTextView.text.toString().toDouble()
        } else {
            num2 = resultTextView.text.toString().toDouble()
        }
    }

    private fun operationPress(operation: Int) {
        this.operation = operation

        resultTextView.text = "0"
    }

    companion object{
        const val SUM = 1
        const val SUBTRACTION = 2
        const val MULTIPLICATION = 3
        const val DIVISION = 4
        const val NO_OPERATION = 0
    }
}