package com.seva.starnet.casicalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.seva.starnet.casicalculator.data.DataSource
import com.seva.starnet.casicalculator.model.ButtonColor
import com.seva.starnet.casicalculator.model.ButtonId
import com.seva.starnet.casicalculator.model.ButtonModel
import com.seva.starnet.casicalculator.ui.theme.CasiCalculatorTheme

class MainActivity : ComponentActivity() {

    private var viewModel: MainActivityViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CasiCalculatorTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CasiCalulatorApp()
                }
            }
        }
    }

    @Preview(device = Devices.AUTOMOTIVE_1024p, showSystemUi = true)
    @Composable
    fun MainGridPreview() {
        MainGrid(DataSource().getButtons())
    }

    @Composable
    fun CasiCalulatorApp(
        viewModel: MainActivityViewModel = viewModel()
    ) {
        this.viewModel = viewModel
        val uIState = remember { this.viewModel!!.uIState }
        Column {
            MainGrid(buttons = uIState)
        }
    }

    @Composable
    fun MainGrid(buttons: List<ButtonModel>) {
        Row {
            Column(
                modifier = Modifier
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                MainNumber(
                    buttonModel = buttons[36],
                    Modifier
                        .height(80.dp)
                ) // 0
                MainNumber(
                    buttonModel = buttons[37],
                    Modifier
                        .height(80.dp)
                ) // 00

            }
            Column(
                modifier = Modifier
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                Row(
                    modifier = Modifier,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    MainNumber(
                        buttonModel = buttons[41],
                        Modifier
                            .width(350.dp)
                            .clickable(enabled = false) {}
                    ) // 1 to 18
                    MainNumber(
                        buttonModel = buttons[42],
                        Modifier
                            .width(350.dp)
                            .clickable(enabled = false) {}
                    ) // 19 to 36
                }
                Row() { // first row
                    MainNumber(buttonModel = buttons[2])
                    MainNumber(buttonModel = buttons[5])
                    MainNumber(buttonModel = buttons[8])
                    MainNumber(buttonModel = buttons[11])
                    MainNumber(buttonModel = buttons[14])
                    MainNumber(buttonModel = buttons[17])
                    MainNumber(buttonModel = buttons[20])
                    MainNumber(buttonModel = buttons[23])
                    MainNumber(buttonModel = buttons[26])
                    MainNumber(buttonModel = buttons[29])
                    MainNumber(buttonModel = buttons[32])
                    MainNumber(buttonModel = buttons[35])
                }
                Row() { // second row
                    MainNumber(buttonModel = buttons[1])
                    MainNumber(buttonModel = buttons[4])
                    MainNumber(buttonModel = buttons[7])
                    MainNumber(buttonModel = buttons[10])
                    MainNumber(buttonModel = buttons[13])
                    MainNumber(buttonModel = buttons[16])
                    MainNumber(buttonModel = buttons[19])
                    MainNumber(buttonModel = buttons[22])
                    MainNumber(buttonModel = buttons[25])
                    MainNumber(buttonModel = buttons[28])
                    MainNumber(buttonModel = buttons[31])
                    MainNumber(buttonModel = buttons[34])
                }
                Row() { // third row
                    MainNumber(buttonModel = buttons[0])
                    MainNumber(buttonModel = buttons[3])
                    MainNumber(buttonModel = buttons[6])
                    MainNumber(buttonModel = buttons[9])
                    MainNumber(buttonModel = buttons[12])
                    MainNumber(buttonModel = buttons[15])
                    MainNumber(buttonModel = buttons[18])
                    MainNumber(buttonModel = buttons[21])
                    MainNumber(buttonModel = buttons[24])
                    MainNumber(buttonModel = buttons[27])
                    MainNumber(buttonModel = buttons[30])
                    MainNumber(buttonModel = buttons[33])
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                MainNumber(
                    buttonModel = buttons[47],
                    Modifier
                        .width(80.dp)
                        .padding(start = 5.dp)
                        .clickable(enabled = false) {}
                ) // first row
                MainNumber(
                    buttonModel = buttons[48],
                    Modifier
                        .width(80.dp)
                        .padding(start = 5.dp)
                        .clickable(enabled = false) {}
                ) // second row
                MainNumber(
                    buttonModel = buttons[49],
                    Modifier
                        .width(80.dp)
                        .padding(start = 5.dp)
                        .clickable(enabled = false) {}
                ) //third row
            }
        }
    }


    @Preview
    @Composable
    fun MainNumberPreview() {
        MainNumber(
            buttonModel = ButtonModel(buttonId = ButtonId.BUTTON_2, color = ButtonColor.RED),
            modifier = Modifier
        )
    }

    @Composable
    fun MainNumber(buttonModel: ButtonModel, modifier: Modifier = Modifier) {
        var backgroundColor = Color.White
        var textColor = Color.Black
        if (buttonModel.color == ButtonColor.BLACK) {
            backgroundColor = Color.Black
            textColor = Color.White
        }
        if (buttonModel.color == ButtonColor.RED) {
            backgroundColor = Color.Red
        }
        Button(
            colors = ButtonDefaults.buttonColors(backgroundColor),
            onClick = { viewModel?.newClick(buttonModel) },
            shape = RoundedCornerShape(2),
            modifier = modifier
                .border(
                    width = 2.dp,
                    color = textColor,
                    shape = RoundedCornerShape(5.dp)
                ),
            contentPadding = PaddingValues(0.dp)
        ) {
            Column(
                modifier = modifier
                    .padding(0.dp)
            ) {
                Text(
                    text = buttonModel.buttonId.uiName,
                    color = textColor
                )
                Spacer(
                    modifier = Modifier.height(Dp("5".toFloat()))
                )
                Text(
                    text = buttonModel.clicks.toString(),
                    color = textColor
                )
            }
        }
    }
}
