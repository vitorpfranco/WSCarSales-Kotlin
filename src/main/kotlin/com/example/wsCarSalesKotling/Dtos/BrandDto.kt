package com.example.wsCarSalesKotling.Dtos

import com.example.wsCarSalesKotling.Models.Brand
import javax.validation.constraints.NotBlank

class BrandDto(
    @NotBlank(message = "nome_marca field is required")
    var nome_marca:String
)

fun BrandDto.toEntity() = Brand(
    nome_marca = nome_marca
)