package com.example.wsCarSalesKotling.Models

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
class Model(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Int?=0,

@Column(nullable = false)
    var nome:String,

@Column(nullable = false)
 var valor_fipe:Double,

@ManyToOne
@JoinColumn(name = "marca_id", referencedColumnName = "id")
var marca:Brand,
)
