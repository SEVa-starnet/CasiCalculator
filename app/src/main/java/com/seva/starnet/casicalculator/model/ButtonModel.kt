package com.seva.starnet.casicalculator.model

data class ButtonModel(
    val buttonId: ButtonId,
    var clicks: Int = 0,
    var percent: Double = 0.0,
    val color: ButtonColor = ButtonColor.TRANSPARENT
)