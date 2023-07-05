package com.jamsolution.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.jamsolution.calculatorapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnPlus.setOnClickListener {
            val num1 = getIntegerFromInput1(binding.input1)
            val num2 = getIntegerFromInput2(binding.input2)

            binding.tvResult.text = (num1 + num2).toString()

            resetInputs()
        }

        binding.btnMinus.setOnClickListener {
            val num1 = getIntegerFromInput1(binding.input1)
            val num2 = getIntegerFromInput2(binding.input2)

            binding.tvResult.text = (num1 - num2).toString()

            resetInputs()
        }

        binding.btnMultiply.setOnClickListener {
            val num1 = getIntegerFromInput1(binding.input1)
            val num2 = getIntegerFromInput2(binding.input2)

            binding.tvResult.text = (num1 * num2).toString()

            resetInputs()
        }

        binding.btnDivide.setOnClickListener {
            val num1 = getIntegerFromInput1(binding.input1)
            val num2 = getIntegerFromInput2(binding.input2)

            binding.tvResult.text = (num1 / num2).toString()

            resetInputs()
        }
    }

    private fun getIntegerFromInput1 (editText: EditText): Int {
        return binding.input1.text.toString().toInt()
    }

    private fun getIntegerFromInput2(editText: EditText): Int {
        return binding.input2.text.toString().toInt()
    }

    private fun resetInputs() {
        binding.input1.text = null
        binding.input2.text = null
        binding.input1.setSelection(0)
        binding.input1.requestFocus()
    }
}