package com.seva.starnet.casicalculator.domain

import com.seva.starnet.casicalculator.data.DataSource
import com.seva.starnet.casicalculator.model.ButtonModel

class GetButtonsUseCase {

    private val dataSource: DataSource = DataSource()

    fun getButtons(): MutableList<ButtonModel> {
        return dataSource.getButtons()
    }
}