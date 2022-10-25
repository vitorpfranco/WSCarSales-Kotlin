package com.example.wsCarSalesKotling.Models

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
class Brand (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Int?=0,

    @Column(nullable = false, unique = true)
    var nome_marca: String,

    @JsonIgnore
    @OneToMany( cascade = [CascadeType.ALL], mappedBy="marca")
    val models:List<Model>? = emptyList()
    )
