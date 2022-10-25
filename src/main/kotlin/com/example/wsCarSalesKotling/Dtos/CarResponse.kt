package com.example.wsCarSalesKotling.Dtos

import com.example.wsCarSalesKotling.Models.Car

class CarResponse(

    var id:Int?,
    var cor:String,
    var valor_fipe:Double,
    var ano:Int,
    var marca_id:Int?,
    var marca_nome:String,
    var nome_modelo:String,
    var timestamp_cadastro:Long?,
    var num_portas:Int,
    var combustivel:String
    ) {
    companion object{
        fun convert(car: Car)= CarResponse(
            id = car.id,
            marca_id = car.modelo.marca.id,
            marca_nome = car.modelo.marca.nome_marca,
            nome_modelo = car.modelo.nome,
            ano = car.ano,
            combustivel = car.combustivel!!.fuelType,
            num_portas = car.num_portas,
            valor_fipe = car.modelo.valor_fipe,
            cor = car.cor,
            timestamp_cadastro = car.timestamp_cadastro,
        )
}}
