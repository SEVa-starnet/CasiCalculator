package com.seva.starnet.casicalculator

import android.util.Log
import androidx.compose.runtime.toMutableStateList
import com.seva.starnet.casicalculator.common.base.BaseViewModel
import com.seva.starnet.casicalculator.domain.GetButtonsUseCase
import com.seva.starnet.casicalculator.model.ButtonModel

class MainActivityViewModel : BaseViewModel() {

    private val getButtonsUseCase = GetButtonsUseCase()

    private var buttonModels = loadButtons()
    var uIState = buttonModels.toMutableStateList()

    fun newClick(buttonModel: ButtonModel) {
        updateButton(buttonModels.indexOf(buttonModel) , buttonModel.clicks + 1, buttonModel.percent + 0.5)
    }

    private fun updateButton(id: Int, clicks: Int, percent: Double) {
        uIState[id] = uIState[id].copy(
            clicks = clicks,
            percent = percent
        )
        buttonModels[id].clicks = clicks
        buttonModels[id].percent = percent
        proceedPercents()
    }

    private fun proceedPercents() {
        proceedFirsSecondSector()
        proceedFirstSecondThirdRow()
        proceedFirstSecondThirdSector()
        proceedBlackRed()
        proceedOddEven()
        proceedNumbers()
    }

    private fun proceedFirsSecondSector() {

    }

    private fun proceedFirstSecondThirdRow() {

    }

    private fun proceedFirstSecondThirdSector() {

    }

    private fun proceedBlackRed() {

    }

    private fun proceedOddEven() {

    }

    private fun proceedNumbers() {

    }

    private fun updatePercents(buttons: List<ButtonModel>) {
        var fullAmountOfClicks = 0
        for (button in buttons) {
            fullAmountOfClicks += button.clicks
        }

        val fullAmountOfSkips = ((buttons.size - 1) * (fullAmountOfClicks + 1)) + 1
        val skipPercent: Double = 100.0 / fullAmountOfSkips

        for (button in buttons) {
            val skipAmount = fullAmountOfClicks - button.clicks
            val percent = skipAmount * skipPercent
            button.percent = percent
        }
    }

    private fun loadButtons(): MutableList<ButtonModel> {
        return getButtonsUseCase.getButtons()
    }
}