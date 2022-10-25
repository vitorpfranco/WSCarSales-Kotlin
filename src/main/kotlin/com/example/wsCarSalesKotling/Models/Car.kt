package com.example.wsCarSalesKotling.Models

import com.example.wsCarSalesKotling.Enums.FuelType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
class Car(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Int?=0,

@Column(nullable = false)
var timestamp_cadastro:Long?= System.currentTimeMillis(),

@ManyToOne
@JoinColumn(name = "modelo_id", referencedColumnName = "id")
var  modelo:Model,

@Column(nullable = false)
var ano:Int,

@Enumerated(EnumType.STRING)
@Column(nullable = false)
var combustivel:FuelType?=null,

@Column(nullable = false)
var  num_portas:Int,

@Column(nullable = false)
var cor:String
)