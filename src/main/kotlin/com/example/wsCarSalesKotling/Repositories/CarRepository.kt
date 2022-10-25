package com.example.wsCarSalesKotling.Repositories

import com.example.wsCarSalesKotling.Models.Car
import org.springframework.data.jpa.repository.JpaRepository

interface CarRepository:JpaRepository<Car,Int> {
}