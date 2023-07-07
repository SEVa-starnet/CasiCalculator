package com.seva.starnet.casicalculator

import android.util.Log
import androidx.compose.runtime.toMutableStateList
import com.seva.starnet.casicalculator.common.base.BaseViewModel
import com.seva.starnet.casicalculator.domain.GetButtonsUseCase
import com.seva.starnet.casicalculator.model.ButtonId
import com.seva.starnet.casicalculator.model.ButtonModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainActivityViewModel : BaseViewModel() {

    private val getButtonsUseCase = GetButtonsUseCase()

    private var buttonModels = loadButtons()
    var uIState = buttonModels.toMutableStateList()

    fun newClick(buttonModel: ButtonModel) {
        uIState[getId(buttonModel = buttonModel)] = uIState[getId(buttonModel = buttonModel)].copy(clicks = uIState[getId(buttonModel)].clicks +1)
        buttonModels[getId(buttonModel = buttonModel)].clicks++
        proceedPercents()
    }

    private fun getId(buttonModel: ButtonModel): Int {
        return buttonModels.indexOf(buttonModel)
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