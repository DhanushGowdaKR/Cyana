package dev.dhanushgowda.cyana.presentation.components

import androidx.compose.animation.core.AnimationVector2D
import androidx.compose.animation.core.TwoWayConverter
import androidx.compose.animation.core.animateValueAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import dev.dhanushgowda.cyana.presentation.theme.CyanaTheme

@Composable
fun DrumPadButton(
    modifier: Modifier = Modifier,
    padName: String,
    onClick: () -> Unit
) {
    val density = LocalDensity.current
    var isPressed by remember {
        mutableStateOf(false)
    }
    val dpOffset by animateValueAsState(
        targetValue = if (isPressed) {
            DpOffset(0.dp, 0.dp)
        } else {
            DpOffset(6.dp, 6.dp)
        },
        typeConverter = TwoWayConverter<DpOffset, AnimationVector2D>(
            convertToVector = {
                AnimationVector2D(it.x.value, it.y.value)
            },
            convertFromVector = {
                DpOffset(it.v1.dp, it.v2.dp)
            }
        ),
        animationSpec = tween(
            durationMillis = 80
        ),
        label = ""
    )
    Box(
        modifier = modifier
            .fillMaxSize()
            .clickable(onClick = onClick)
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                        isPressed = true
                        tryAwaitRelease()
                        isPressed = false
                    },
                )
            }
            .graphicsLayer {
                translationX = with(density) {-dpOffset.x.toPx()}
                translationY = with(density) {-dpOffset.y.toPx()}
            }
            .dropShadow(
                shape = RoundedCornerShape(16.dp),
                shadow = Shadow(
                    radius = 0.dp,
                    color = Color(0xFFBC321A),
                    spread = 0.dp,
                    offset = dpOffset
                )
            )
            .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(16.dp))
            .background(color = CyanaTheme.colorScheme.drumPad, shape = RoundedCornerShape(16.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = padName,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview
@Composable
private fun DrumPadButtonPreview() {
    CyanaTheme {
        DrumPadButton(
            modifier = Modifier,
            padName = "KICK",
            onClick = {}
        )
    }
}