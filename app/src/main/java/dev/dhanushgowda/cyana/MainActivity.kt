package dev.dhanushgowda.cyana

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import dev.dhanushgowda.cyana.jni.DrumMachine
import dev.dhanushgowda.cyana.model.drumPads
import dev.dhanushgowda.cyana.presentation.screens.drumMachineScreen.DrumMachineScreen
import dev.dhanushgowda.cyana.presentation.theme.CyanaTheme

class MainActivity : ComponentActivity() {
    val drumMachine = DrumMachine()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CyanaTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize(),
                    containerColor = CyanaTheme.colorScheme.background
                ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Cyana - Drum Machine",
                            fontSize = 32.sp
                        )
                        DrumMachineScreen(drumPads, drumMachine = drumMachine)
                    }
                }
            }
        }
    }
}
