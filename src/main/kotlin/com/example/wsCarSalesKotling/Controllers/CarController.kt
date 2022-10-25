package com.example.wsCarSalesKotling.Controllers

import com.example.wsCarSalesKotling.Dtos.CarDto
import com.example.wsCarSalesKotling.Dtos.CarResponse
import com.example.wsCarSalesKotling.Enums.FueltoEnum
import com.example.wsCarSalesKotling.Models.Car
import com.example.wsCarSalesKotling.Services.CarService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.Instant
import java.util.stream.Collectors
import javax.validation.Valid


@CrossOrigin(origins = ["*"], maxAge = 3600)
@RestController
@RequestMapping("cars")
class CarController {
    @Autowired
    lateinit var carService: CarService

    @PostMapping
    fun saveCar(@RequestBody @Valid carDto: CarDto): ResponseEntity<Car> {
        val car = carService.setModel(carDto);
        car.timestamp_cadastro = Instant.now().getEpochSecond();
        car.combustivel = FueltoEnum(carDto.combustivel);
        return ResponseEntity.status(HttpStatus.CREATED).body(carService.saveCar(car))
    }

    @GetMapping
    fun getCars(): ResponseEntity<List<CarResponse>> {
        val carList:List<Car> = carService.getCars()
        val CarResponseList: List<CarResponse> = carList.stream().map { obj: Car ->
            CarResponse.convert(obj)
        }.collect(Collectors.toList())
        return ResponseEntity.status(HttpStatus.OK).body(CarResponseList)
    }

    @GetMapping("/{id}")
    fun getCarById(@PathVariable id: Int): ResponseEntity<CarResponse> {
        return ResponseEntity.status(HttpStatus.OK).body(CarResponse.convert(carService.getCarById(id)))
    }

    @DeleteMapping("/{id}")
    fun deleteCar(@PathVariable id: Int): ResponseEntity<String?>? {
        val car = carService.getCarById(id)
        carService.deleteCar(id)
        return ResponseEntity.status(HttpStatus.OK).body("Car deleted")
    }

    @PutMapping("/{id}")
    fun updateCar(@PathVariable id: Int, @RequestBody @Valid carDto: CarDto): ResponseEntity<Car> {
        val car = carService.setModel(carDto)
        car.combustivel = FueltoEnum(carDto.combustivel);
        return ResponseEntity.status(HttpStatus.OK).body(carService.updateCar(id, car))
    }
}