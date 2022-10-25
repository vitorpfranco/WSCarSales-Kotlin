package com.example.wsCarSalesKotling.Services

import com.example.wsCarSalesKotling.Dtos.CarDto
import com.example.wsCarSalesKotling.Enums.FuelType
import com.example.wsCarSalesKotling.Exceptions.ResourceNotFoundException
import com.example.wsCarSalesKotling.Models.Car
import com.example.wsCarSalesKotling.Models.Model
import com.example.wsCarSalesKotling.Repositories.CarRepository
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class CarService {
    @Autowired
    lateinit var carRepository: CarRepository

    @Autowired
    lateinit var modelService: ModelService

    fun setModel(carDto: CarDto): Car {
        val model: Model = modelService.getModelById(carDto.modelo_id!!)
        var car:Car = carDto.toEntity(model)
        return car
    }

    fun saveCar(car: Car): Car {
        return carRepository.save(car)
    }

    fun getCars(): List<Car> {
        return carRepository.findAll()
    }

    fun getCarById(id: Int): Car {
        val car: Optional<Car> = carRepository.findById(id)
        return car.orElseThrow { ResourceNotFoundException("Car not found for ID: $id") }
    }

    fun deleteCar(id: Int) {
        carRepository.deleteById(id)
    }

    fun updateCar(id: Int, car: Car): Car {
        val oldCar = getCarById(id)
        BeanUtils.copyProperties(car, oldCar)
        return saveCar(oldCar)
    }
}