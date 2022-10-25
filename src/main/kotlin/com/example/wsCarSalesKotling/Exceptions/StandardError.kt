package com.example.wsCarSalesKotling.Exceptions

open class StandardError(
    var timestamp: Long,

    var status: Int,

    var error: String,

    var message: String,

    var path: String,
)