package com.example.wsCarSalesKotling.Dtos


import com.example.wsCarSalesKotling.Models.Brand
import com.example.wsCarSalesKotling.Models.Model
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

class ModelDto(
    @NotBlank(message = "marca_id field is required")
    var nome:String,

    @NotNull(message="valor_fipe is required")
    @Min(value = 0L, message = "The value must be positive")
    var valor_fipe:Double,

    @NotNull(message = "marca_id field is required")
    var marca_id: Int,
)
{
    open fun toEntity(brand: Brand) = Model(
        nome= nome,
        valor_fipe = valor_fipe,
        marca = brand
    )
}
