package com.john.coroutinemaster.usecases.coroutines.usecase11

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.john.coroutinemaster.base.BaseActivity
import com.john.coroutinemaster.base.useCase11Description
import com.john.coroutinemaster.databinding.ActivityCooperativecancellationBinding
import com.john.coroutinemaster.utils.*
import com.john.coroutinemaster.R
class CooperativeCancellationActivity : BaseActivity() {

    override fun getToolbarTitle() = useCase11Description

    private val binding by lazy { ActivityCooperativecancellationBinding.inflate(layoutInflater) }
    private val viewModel: CooperativeCancellationViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel.uiState().observe(this, Observer { uiState ->
            if (uiState != null) {
                render(uiState)
            }
        })
        binding.btnCalculate.setOnClickListener {
            val factorialOf = binding.editTextFactorialOf.text.toString().toIntOrNull()
            if (factorialOf != null) {
                viewModel.performCalculation(factorialOf)
            }
        }
        binding.btnCancel.setOnClickListener {
            viewModel.cancelCalculation()
        }
    }

    private fun render(uiState: UiState) {
        when (uiState) {
            is UiState.Loading -> {
                onLoad()
            }
            is UiState.Success -> {
                onSuccess(uiState)
            }
            is UiState.Error -> {
                onError(uiState)
            }
        }
    }

    private fun onLoad() = with(binding) {
        progressBar.setVisible()
        textViewResult.text = ""
        textViewCalculationDuration.text = ""
        textViewStringConversionDuration.text = ""
        btnCalculate.isEnabled = false
        btnCancel.isEnabled = true
        textViewResult.hideKeyboard()
    }

    private fun onSuccess(uiState: UiState.Success) = with(binding) {
        textViewCalculationDuration.text =
            getString(R.string.duration_calculation, uiState.computationDuration)

        textViewStringConversionDuration.text =
            getString(R.string.duration_stringconversion, uiState.stringConversionDuration)

        binding.progressBar.setGone()
        btnCalculate.isEnabled = true
        btnCancel.isEnabled = false

        textViewResult.text = if (uiState.result.length <= 150) {
            uiState.result
        } else {
            "${uiState.result.substring(0, 147)}..."
        }
    }

    private fun onError(uiState: UiState.Error) = with(binding) {
        progressBar.setGone()
        btnCalculate.isEnabled = true
        btnCancel.isEnabled = false
        toast(uiState.message)
    }
}