package dev.dhanushgowda.cyana.presentation.screens.drumMachineScreen

import androidx.compose.foundation.layout.ExperimentalGridApi
import androidx.compose.foundation.layout.Grid
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.dhanushgowda.cyana.jni.DrumMachine
import dev.dhanushgowda.cyana.model.DrumPad
import dev.dhanushgowda.cyana.presentation.components.DrumPadButton

@OptIn(ExperimentalGridApi::class)
@Composable
fun DrumMachineScreen(
    drumPads: List<DrumPad>,
    drumMachine: DrumMachine
) {
    Grid(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        config = {
            column(1.fr)
            column(1.fr)
            column(1.fr)
            column(1.fr)
            row(1.fr)
            row(1.fr)
            gap(32.dp)
        }
    ) {
        drumPads.forEach {
            DrumPadButton(
                padName = it.padName,
                onClick = {
                    drumMachine.playPad(it.id)
                }
            )
        }
    }
}