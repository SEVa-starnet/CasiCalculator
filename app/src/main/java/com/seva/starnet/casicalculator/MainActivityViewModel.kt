package com.seva.starnet.casicalculator

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
        buttonModel?.let {
            if (it.buttonId.value < 19) {
                // first sector clicked
                localListShot!![41].clicks++
            } else if (it.buttonId.value < 37) {
                // second sector clicked
                localListShot!![42].clicks++
            }
            return@let
        }

        updatePercents(
            listOf(
                localListShot!![41],
                localListShot!![42]
            )
        )
    }

    private fun proceedFirstSecondThirdRow(buttonModel: ButtonModel?) {
        buttonModel?.let {
            when (buttonModel.buttonId.value) {
                3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36 -> {
                    // first row clicked
                    localListShot!![47].clicks++
                }

                2, 5, 8, 11, 14, 17, 20, 23, 26, 29, 32, 35 -> {
                    // second row clicked
                    localListShot!![48].clicks++
                }

                1, 4, 7, 10, 13, 16, 19, 22, 25, 28, 31, 34 -> {
                    // third row clicked
                    localListShot!![49].clicks++
                }
            }
            return@let
        }

        updatePercents(
            listOf(
                localListShot!![47],
                localListShot!![48],
                localListShot!![49]
            )
        )
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