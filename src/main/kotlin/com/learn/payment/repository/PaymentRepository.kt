package com.learn.payment.repository

import com.learn.payment.models.PaymentResponse
import java.util.concurrent.ConcurrentHashMap

class PaymentRepository {

    private val payments = ConcurrentHashMap<String, PaymentResponse>()

    fun save(payment: PaymentResponse): PaymentResponse {
        payments.put(payment.id, payment)  
        return payment
    }

    fun findById(id: String): PaymentResponse? {
        return payments[id]
    }
}
