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
        buttonModel?.let {
            when (buttonModel.buttonId.value) {
                1,2,3,4,5,6,7,8,9,10,11,12 -> {
                    // first sector clicked
                    localListShot!![38].clicks++
                }

                13,14,15,16,17,18,19,20,21,22,23,24 -> {
                    // second sector clicked
                    localListShot!![39].clicks++
                }

                25,26,27,28,29,30,31,32,33,34,35,36 -> {
                    // third sector clicked
                    localListShot!![40].clicks++
                }
            }
            return@let
        }

        updatePercents(
            listOf(
                localListShot!![38],
                localListShot!![39],
                localListShot!![40]
            )
        )
    }

    private fun proceedBlackRed(buttonModel: ButtonModel?) {
        buttonModel?.let {
            when (buttonModel.buttonId.value) {
                1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36 -> {
                    // red clicked
                    localListShot!![45].clicks++
                }

                2,4,6,8,10,11,13,15,17,20,22,24,26,28,29,31,33,35 -> {
                    // black clicked
                    localListShot!![46].clicks++
                }
            }
            return@let
        }

        updatePercents(
            listOf(
                localListShot!![45],
                localListShot!![46]
            )
        )
    }

    private fun proceedOddEven(buttonModel: ButtonModel?) {
        buttonModel?.let {
            when (buttonModel.buttonId.value) {
                2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36 -> {
                    // even clicked
                    localListShot!![43].clicks++
                }

                1,3,5,7,9,11,13,15,17,19,21,23,25,27,29,31,33,35 -> {
                    // odd clicked
                    localListShot!![44].clicks++
                }
            }
            return@let
        }

        updatePercents(
            listOf(
                localListShot!![43],
                localListShot!![44]
            )
        )
    }

    private fun proceedNumbers(buttonModel: ButtonModel?) {
        buttonModel?.let {
            localListShot!![buttonModel.buttonId.value - 1].clicks++
        }
        updatePercents(
            localListShot!!.subList(0, 38)
        )
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

    fun clearClick() {
        localListShot = loadButtons()
        for (i in 0 until localListShot!!.size) {
            updateButton(i, localListShot!![i].clicks, localListShot!![i].percent)
        }
    }
}