package com.example.wsCarSalesKotling.Dtos


import com.example.wsCarSalesKotling.Models.Car
import com.example.wsCarSalesKotling.Models.Model
import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull


class CarDto(
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message= "modelo_id field is required")
    var modelo_id:Int?,

@Max(value = 2023,message = "ano must be above 2023")
@Min(value = 1900,message = "ano must be above 1900")
@NotNull(message= "ano field is required")
var ano:Int,

@NotNull(message= "combustivel field is required")
var combustivel:String,

@NotBlank(message= "num_portas field is required")
@Max(value = 5,message = "num_portas can have the maximum value of 5.")
@Min(value = 2,message = "num_portas can have the maximum value of 2.")
var num_portas:Int,

@NotBlank(message= "cor field is required")
var cor:String,


) {

    open fun toEntity(model: Model) = Car(
        modelo= model,
        ano = ano,
        num_portas=num_portas,
        cor = cor,
    )
}