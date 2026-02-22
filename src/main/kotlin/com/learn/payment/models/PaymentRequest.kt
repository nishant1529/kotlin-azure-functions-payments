package com.learn.payment.models

import com.fasterxml.jackson.annotation.*

@kotlinx.serialization.Serializable
data class PaymentRequest @JsonCreator constructor( 
    @JsonProperty("amount") val amount: Long, 
    @JsonProperty("currency") val currency: String, 
    @JsonProperty("description") val description: String 
)