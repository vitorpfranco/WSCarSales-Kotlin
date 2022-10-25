package com.example.wsCarSalesKotling.Repositories

import com.example.wsCarSalesKotling.Models.Model
import org.springframework.data.jpa.repository.JpaRepository

interface  ModelRepository: JpaRepository<Model, Int> {
}