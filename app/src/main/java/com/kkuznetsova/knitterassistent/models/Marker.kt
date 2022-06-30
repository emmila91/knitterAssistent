package com.kkuznetsova.knitterassistent.models

class Marker(
    var comment: String,
    var rowNumber: Int,
) {
    fun convertToString() = "$comment $rowNumber"
}
