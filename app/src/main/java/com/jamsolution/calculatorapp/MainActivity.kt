package com.jamsolution.calculatorapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import com.jamsolution.calculatorapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // This method is called before the text is changed
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // This method is called when the text is being changed
                val input1Text = binding.input1.text.toString()
                val input2Text = binding.input2.text.toString()

                // Check if both input fields are not empty and contain digits
                val isInputEmpty = input1Text.isBlank() || input2Text.isBlank() ||
                        !input1Text.matches(".*\\d.*".toRegex()) || !input2Text.matches(".*\\d.*".toRegex())

                // Enable or disable the button based on the condition
                binding.btnPlus.isEnabled = !isInputEmpty
                binding.btnMinus.isEnabled = !isInputEmpty
                binding.btnMultiply.isEnabled = !isInputEmpty
                binding.btnDivide.isEnabled = !isInputEmpty
            }

            override fun afterTextChanged(s: Editable?) {
                // This method is called after the text has been changed
            }
        }

        binding.input1.addTextChangedListener(textWatcher)
        binding.input2.addTextChangedListener(textWatcher)

// Call onTextChanged explicitly to update the button state initially
        textWatcher.onTextChanged(null, 0, 0, 0)

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