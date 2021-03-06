package com.evertec.everteplacetopay.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.evertec.everteplacetopay.vo.json.input.Additional
import com.evertec.everteplacetopay.vo.json.input.AmountInput
import com.evertec.everteplacetopay.vo.json.input.Conversion
import com.evertec.everteplacetopay.vo.json.input.Status
import com.evertec.everteplacetopay.vo.json.output.Amount
import com.google.gson.annotations.SerializedName
import java.util.*
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue


/**
 * Respuesta recibida al consulta la api  @POST("gateway/process")
 */

@Parcelize
data class Transaction(
    val status: @RawValue Status,
    val internalReference: Int,
    val reference: String,
    val paymentMethod: String,
    val franchise: String,
    val franchiseName: String,
    val issuerName: String,
    val amountInput: @RawValue AmountInput,
    val conversion: @RawValue Conversion,
    val authorization: Int,
    val receipt: Int,
    val type: String,
    val refunded: Boolean,
    val lastDigits: Int,
    val provider: String,
    val discount: String,
    val processorFields: List<String>,
    val additional: @RawValue Additional
) : Parcelable


/**
 * Respuesta recibida al consulta la api  @POST("gateway/query")
 */
@Parcelize
data class InfoTransaction(

    val status: @RawValue Status,
    val internalReference: Int,
    val reference: String,
    val paymentMethod: String,
    val franchise: String,
    val franchiseName: String,
    val issuerName: String,
    val amount: @RawValue Amount,
    // val conversion: Conversion,
    val authorization: Int,
    val receipt: Int,
    val type: String,
    val refunded: Boolean,
    val lastDigits: Int,
    val provider: String,
    val discount: String,
    // val processorFields: List<String>,
    // val additional: Additional
) : Parcelable


/**
 * Entidad para guardar en room la informacion que se le va mostrar al usuario de sus transacciones
 */
@Entity
data class TransactionEntity(
    @PrimaryKey()
    @ColumnInfo(name = "id")
    val internalReference: Int,
    @ColumnInfo(name = "reference")
    val reference: String,
    @ColumnInfo(name = "card_number")
    val cardNumber: String = "",
    @ColumnInfo(name = "state")
    val state: String = "",
    @ColumnInfo(name = "value")
    val value: Double,
)