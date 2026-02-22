package com.learn.payment

import com.microsoft.azure.functions.*
import com.microsoft.azure.functions.annotation.*
import com.learn.payment.services.PaymentService

class GetPaymentFunction {

    private val paymentService = PaymentService()

    @FunctionName("getPayment")
    fun run(
        @HttpTrigger(
            name = "req",
            methods = [HttpMethod.GET],
            authLevel = AuthorizationLevel.ANONYMOUS,
            route = "payments/{id}"
        ) request: HttpRequestMessage<String?>,
        @BindingName("id") id: String,
        context: ExecutionContext
    ): HttpResponseMessage {

        val payment = paymentService.getPayment(id)

        return if (payment == null) {
            request
                .createResponseBuilder(HttpStatus.NOT_FOUND)
                .header("Content-Type", "application/json")
                .body("""{"error": "Payment not found"}""")
                .build()
        } else {
            request
                .createResponseBuilder(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(payment)
                .build()
        }
    }
}
