package com.learn.payment

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.microsoft.azure.functions.*
import com.microsoft.azure.functions.annotation.*
import java.util.*
import com.learn.payment.services.PaymentService
import com.learn.payment.models.PaymentRequest

class CreatePaymentFunction {

    private val paymentService = PaymentService()

    @FunctionName("createPayment")
    fun run(
        @HttpTrigger(
            name = "req",
            methods = [HttpMethod.POST],
            authLevel = AuthorizationLevel.ANONYMOUS,
            route = "payments"
        ) request: HttpRequestMessage<Optional<String>>,
        context: ExecutionContext
    ): HttpResponseMessage {

        val body = request.body.orElse("")

        val mapper = ObjectMapper().registerKotlinModule()
        val paymentRequest = mapper.readValue(body, PaymentRequest::class.java)

        val response = paymentService.createPayment(paymentRequest)

        return request
            .createResponseBuilder(HttpStatus.OK)
            .header("Content-Type", "application/json")
            .body(response)
            .build()
    }
}
