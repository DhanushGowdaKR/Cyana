package dev.dhanushgowda.cyana.model

data class DrumPad(
    val id: Int,
    val padName: String
)

val drumPads = listOf(
    DrumPad(1, "KICK"),
    DrumPad(2, "SNARE"),
    DrumPad(3, "C HIGH-HAT"),
    DrumPad(4, "O HIGH-HAT"),
    DrumPad(5, "CLAP"),
    DrumPad(6, "LOW TOM"),
    DrumPad(7, "HIGH TOM"),
    DrumPad(8, "CRASH")
)
