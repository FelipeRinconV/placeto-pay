package com.evertec.everteplacetopay.vo.json.processTransaction.input

data class Taxe(
    val amount: Double,
    val base: Int,
    val kind: String
)