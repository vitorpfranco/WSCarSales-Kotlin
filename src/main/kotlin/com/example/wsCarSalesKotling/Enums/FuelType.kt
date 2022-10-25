package com.example.wsCarSalesKotling.Enums

enum class FuelType(val fuelType:String) {
    FLEX("flex"),
    GASOLINA("gasolina"),
    ALCOOL("álcool"),
    DIESEL("diesel"),
    HIBRIDO("híbrido"),
    ELETRICO("elétrico");


}

fun FueltoEnum(cod: String): FuelType {
    for (type in FuelType.values()) {
        if (cod == type.fuelType) {
            return type
        }
    }
    throw IllegalArgumentException("Invalid type for combustível, try: flex,gasolina,álcool,diesel,híbrido or elétrico")
}
