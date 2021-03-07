package com.evertec.everteplacetopay.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey
    val userId: Long,
    val name: String,
    val age: Int
)

