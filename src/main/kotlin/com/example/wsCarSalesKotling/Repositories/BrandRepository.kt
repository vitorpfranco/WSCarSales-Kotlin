package com.example.wsCarSalesKotling.Repositories
import com.example.wsCarSalesKotling.Models.Brand
import org.springframework.data.jpa.repository.JpaRepository

interface BrandRepository:JpaRepository<Brand,Int> {
}