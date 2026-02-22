package com.learn.payment.models

import com.fasterxml.jackson.annotation.*

@kotlinx.serialization.Serializable
data class PaymentResponse @JsonCreator constructor(
    @JsonProperty("id") val id: String,
    @JsonProperty("status") val status: String,
    @JsonProperty("amount") val amount: Long,
    @JsonProperty("currency") val currency: String
)