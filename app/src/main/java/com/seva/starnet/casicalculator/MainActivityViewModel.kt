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
    private var localListShot: MutableList<ButtonModel>? = null

    fun newClick(buttonModel: ButtonModel) {
        localListShot = mutableListOf()
        for (button in buttonModels) {
            localListShot!!.add(button.copy())
        }
        proceedPercents(buttonModel)
        for (i in 0 until localListShot!!.size) {
            updateButton(i, localListShot!![i].clicks, localListShot!![i].percent)
        }
    }

    private fun updateButton(id: Int, clicks: Int, percent: Double) {
        uIState[id] = uIState[id].copy(
            clicks = clicks,
            percent = percent
        )
        buttonModels[id].clicks = clicks
        buttonModels[id].percent = percent
    }

    private fun proceedPercents(buttonModel: ButtonModel?) {
        proceedFirsSecondSector(buttonModel)
        proceedFirstSecondThirdRow(buttonModel)
        proceedFirstSecondThirdSector(buttonModel)
        proceedBlackRed(buttonModel)
        proceedOddEven(buttonModel)
        proceedNumbers(buttonModel)
    }

    private fun proceedFirsSecondSector(buttonModel: ButtonModel?) {
        Log.d("===", "proceedFirsSecondSector() called with: buttonModel = $buttonModel")
        buttonModel?.let {
            if (it.buttonId.value < 19) {
                // first sector clicked
                localListShot!![41].clicks++
            } else {
                // second sector clicked
                localListShot!![42].clicks++
            }
        }

        updatePercents(
            listOf(
                localListShot!![41],
                localListShot!![42]
            )
        )
    }

    private fun proceedFirstSecondThirdRow(buttonModel: ButtonModel?) {

    }

    private fun proceedFirstSecondThirdSector(buttonModel: ButtonModel?) {

    }

    private fun proceedBlackRed(buttonModel: ButtonModel?) {

    }

    private fun proceedOddEven(buttonModel: ButtonModel?) {

    }

    private fun proceedNumbers(buttonModel: ButtonModel?) {

    }

    private fun updatePercents(buttons: List<ButtonModel>) {
        var fullAmountOfClicks = 0
        for (button in buttons) {
            fullAmountOfClicks += button.clicks
        }

        val fullAmountOfSkips = ((buttons.size - 1) * (fullAmountOfClicks + 1)) + 1
        val skipPercent: Double = 100.0 / fullAmountOfSkips

        for (button in buttons) {
            val skipAmount = fullAmountOfClicks - button.clicks + 1
            val percent = skipAmount * skipPercent
            button.percent = percent
        }
    }

    private fun loadButtons(): MutableList<ButtonModel> {
        val buttons = getButtonsUseCase.getButtons()
        localListShot = mutableListOf()
        for (button in buttons) {
            localListShot!!.add(button.copy())
        }
        proceedPercents(null)
        return localListShot!!
    }
}