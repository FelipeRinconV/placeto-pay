package com.evertec.everteplacetopay.data.model

import com.evertec.everteplacetopay.vo.json.processTransaction.output.Auth
import com.evertec.everteplacetopay.vo.json.processTransaction.output.Instrument
import com.evertec.everteplacetopay.vo.json.processTransaction.output.Payer
import com.evertec.everteplacetopay.vo.json.processTransaction.output.Payment

/**
 * Representa el json para enviarle a la ruta https://dev.placetopay.com/rest/gateway/process
 */
data class ProcessTransactionOutput(
    val auth: Auth,
    val instrument: Instrument,
    val ipAddress: String,
    val locale: String,
    val payer: Payer,
    val payment: Payment,
    val userAgent: String
)