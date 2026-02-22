package com.learn.payment.services

import com.learn.payment.models.PaymentRequest
import com.learn.payment.models.PaymentResponse
import com.learn.payment.repository.PaymentRepository

class PaymentService(
    private val repository: PaymentRepository = PaymentRepository()
) {

    fun createPayment(request: PaymentRequest): PaymentResponse {
        val payment = PaymentResponse(
            id = "pay_${System.currentTimeMillis()}",
            status = "PENDING",
            amount = request.amount,
            currency = request.currency
        )
        return repository.save(payment)
    }

    fun getPayment(id: String): PaymentResponse? {
        return repository.findById(id)
    }
}
