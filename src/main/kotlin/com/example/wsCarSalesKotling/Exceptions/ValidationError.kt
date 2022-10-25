package com.example.wsCarSalesKotling.Exceptions

class ValidationError(
    timestamp: Long,
    status: Int,
    error: String,
    message: String,
    path: String,
    var errors:List<FieldMessage>? = emptyList()

):StandardError(timestamp,status,error,message,path){
}

fun ValidationError.add(fieldName:String, message: String?){
    errors = errors?.plus(FieldMessage(fieldName, message))
}
