package com.seva.starnet.casicalculator.data

import com.seva.starnet.casicalculator.model.ButtonColor
import com.seva.starnet.casicalculator.model.ButtonId.BUTTON_0
import com.seva.starnet.casicalculator.model.ButtonId.BUTTON_00
import com.seva.starnet.casicalculator.model.ButtonId.BUTTON_1
import com.seva.starnet.casicalculator.model.ButtonId.BUTTON_10
import com.seva.starnet.casicalculator.model.ButtonId.BUTTON_11
import com.seva.starnet.casicalculator.model.ButtonId.BUTTON_12
import com.seva.starnet.casicalculator.model.ButtonId.BUTTON_13
import com.seva.starnet.casicalculator.model.ButtonId.BUTTON_13_24
import com.seva.starnet.casicalculator.model.ButtonId.BUTTON_14
import com.seva.starnet.casicalculator.model.ButtonId.BUTTON_15
import com.seva.starnet.casicalculator.model.ButtonId.BUTTON_16
import com.seva.starnet.casicalculator.model.ButtonId.BUTTON_17
import com.seva.starnet.casicalculator.model.ButtonId.BUTTON_18
import com.seva.starnet.casicalculator.model.ButtonId.BUTTON_19
import com.seva.starnet.casicalculator.model.ButtonId.BUTTON_19_36
import com.seva.starnet.casicalculator.model.ButtonId.BUTTON_1_12
import com.seva.starnet.casicalculator.model.ButtonId.BUTTON_1_18
import com.seva.starnet.casicalculator.model.ButtonId.BUTTON_2
import com.seva.starnet.casicalculator.model.ButtonId.BUTTON_20
import com.seva.starnet.casicalculator.model.ButtonId.BUTTON_21
import com.seva.starnet.casicalculator.model.ButtonId.BUTTON_22
import com.seva.starnet.casicalculator.model.ButtonId.BUTTON_23
import com.seva.starnet.casicalculator.model.ButtonId.BUTTON_24
import com.seva.starnet.casicalculator.model.ButtonId.BUTTON_25
import com.seva.starnet.casicalculator.model.ButtonId.BUTTON_25_36
import com.seva.starnet.casicalculator.model.ButtonId.BUTTON_26
import com.seva.starnet.casicalculator.model.ButtonId.BUTTON_27
import com.seva.starnet.casicalculator.model.ButtonId.BUTTON_28
import com.seva.starnet.casicalculator.model.ButtonId.BUTTON_29
import com.seva.starnet.casicalculator.model.ButtonId.BUTTON_3
import com.seva.starnet.casicalculator.model.ButtonId.BUTTON_30
import com.seva.starnet.casicalculator.model.ButtonId.BUTTON_31
import com.seva.starnet.casicalculator.model.ButtonId.BUTTON_32
import com.seva.starnet.casicalculator.model.ButtonId.BUTTON_33
import com.seva.starnet.casicalculator.model.ButtonId.BUTTON_34
import com.seva.starnet.casicalculator.model.ButtonId.BUTTON_35
import com.seva.starnet.casicalculator.model.ButtonId.BUTTON_36
import com.seva.starnet.casicalculator.model.ButtonId.BUTTON_4
import com.seva.starnet.casicalculator.model.ButtonId.BUTTON_5
import com.seva.starnet.casicalculator.model.ButtonId.BUTTON_6
import com.seva.starnet.casicalculator.model.ButtonId.BUTTON_7
import com.seva.starnet.casicalculator.model.ButtonId.BUTTON_8
import com.seva.starnet.casicalculator.model.ButtonId.BUTTON_9
import com.seva.starnet.casicalculator.model.ButtonId.BUTTON_BLACK
import com.seva.starnet.casicalculator.model.ButtonId.BUTTON_EVEN
import com.seva.starnet.casicalculator.model.ButtonId.BUTTON_FIRST_ROW
import com.seva.starnet.casicalculator.model.ButtonId.BUTTON_ODD
import com.seva.starnet.casicalculator.model.ButtonId.BUTTON_RED
import com.seva.starnet.casicalculator.model.ButtonId.BUTTON_SECOND_ROW
import com.seva.starnet.casicalculator.model.ButtonId.BUTTON_THIRD_ROW
import com.seva.starnet.casicalculator.model.ButtonModel

class DataSource {


    fun getButtons(): MutableList<ButtonModel> {
        return mutableListOf(
            ButtonModel(buttonId = BUTTON_1, color = ButtonColor.RED),
            ButtonModel(buttonId = BUTTON_2, color = ButtonColor.BLACK),
            ButtonModel(buttonId = BUTTON_3, color = ButtonColor.RED),
            ButtonModel(buttonId = BUTTON_4, color = ButtonColor.BLACK),
            ButtonModel(buttonId = BUTTON_5, color = ButtonColor.RED),
            ButtonModel(buttonId = BUTTON_6, color = ButtonColor.BLACK),
            ButtonModel(buttonId = BUTTON_7, color = ButtonColor.RED),
            ButtonModel(buttonId = BUTTON_8, color = ButtonColor.BLACK),
            ButtonModel(buttonId = BUTTON_9, color = ButtonColor.RED),
            ButtonModel(buttonId = BUTTON_10, color = ButtonColor.BLACK),
            ButtonModel(buttonId = BUTTON_11, color = ButtonColor.BLACK),
            ButtonModel(buttonId = BUTTON_12, color = ButtonColor.RED),
            ButtonModel(buttonId = BUTTON_13, color = ButtonColor.BLACK),
            ButtonModel(buttonId = BUTTON_14, color = ButtonColor.RED),
            ButtonModel(buttonId = BUTTON_15, color = ButtonColor.BLACK),
            ButtonModel(buttonId = BUTTON_16, color = ButtonColor.RED),
            ButtonModel(buttonId = BUTTON_17, color = ButtonColor.BLACK),
            ButtonModel(buttonId = BUTTON_18, color = ButtonColor.RED),
            ButtonModel(buttonId = BUTTON_19, color = ButtonColor.RED),
            ButtonModel(buttonId = BUTTON_20, color = ButtonColor.BLACK),
            ButtonModel(buttonId = BUTTON_21, color = ButtonColor.RED),
            ButtonModel(buttonId = BUTTON_22, color = ButtonColor.BLACK),
            ButtonModel(buttonId = BUTTON_23, color = ButtonColor.RED),
            ButtonModel(buttonId = BUTTON_24, color = ButtonColor.BLACK),
            ButtonModel(buttonId = BUTTON_25, color = ButtonColor.RED),
            ButtonModel(buttonId = BUTTON_26, color = ButtonColor.BLACK),
            ButtonModel(buttonId = BUTTON_27, color = ButtonColor.RED),
            ButtonModel(buttonId = BUTTON_28, color = ButtonColor.BLACK),
            ButtonModel(buttonId = BUTTON_29, color = ButtonColor.BLACK),
            ButtonModel(buttonId = BUTTON_30, color = ButtonColor.RED),
            ButtonModel(buttonId = BUTTON_31, color = ButtonColor.BLACK),
            ButtonModel(buttonId = BUTTON_32, color = ButtonColor.RED),
            ButtonModel(buttonId = BUTTON_33, color = ButtonColor.BLACK),
            ButtonModel(buttonId = BUTTON_34, color = ButtonColor.RED),
            ButtonModel(buttonId = BUTTON_35, color = ButtonColor.BLACK),
            ButtonModel(buttonId = BUTTON_36, color = ButtonColor.RED),
            ButtonModel(buttonId = BUTTON_0),
            ButtonModel(buttonId = BUTTON_00),
            ButtonModel(buttonId = BUTTON_1_12),
            ButtonModel(buttonId = BUTTON_13_24),
            ButtonModel(buttonId = BUTTON_25_36),
            ButtonModel(buttonId = BUTTON_1_18),
            ButtonModel(buttonId = BUTTON_19_36),
            ButtonModel(buttonId = BUTTON_EVEN),
            ButtonModel(buttonId = BUTTON_ODD),
            ButtonModel(buttonId = BUTTON_RED, color = ButtonColor.RED),
            ButtonModel(buttonId = BUTTON_BLACK, color = ButtonColor.BLACK),
            ButtonModel(buttonId = BUTTON_FIRST_ROW),
            ButtonModel(buttonId = BUTTON_SECOND_ROW),
            ButtonModel(buttonId = BUTTON_THIRD_ROW)
        )
    }
}