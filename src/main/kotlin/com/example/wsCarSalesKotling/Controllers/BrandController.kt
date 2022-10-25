package com.example.wsCarSalesKotling.Controllers

import com.example.wsCarSalesKotling.Dtos.BrandDto
import com.example.wsCarSalesKotling.Models.Brand
import com.example.wsCarSalesKotling.Services.BrandService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@CrossOrigin(origins = ["*"], maxAge = 3600)
@RestController
@RequestMapping("/brands")
class BrandController() {

@Autowired
lateinit var brandService: BrandService;

    @PostMapping
    fun saveBrand(@RequestBody brandDto: BrandDto):ResponseEntity<Brand>{
        return ResponseEntity.status(HttpStatus.CREATED).body(brandService.saveBrand(brandDto.toEntity()));
    }

    @GetMapping
    fun getBrands(): ResponseEntity<List<Brand>> {
        return ResponseEntity.status(HttpStatus.OK).body(brandService.getBrands())
    }

    @GetMapping("/{id}")
    fun getBrandById(@PathVariable id: Int): ResponseEntity<Brand> {
        val brand: Brand = brandService.getBrandById(id)
        return ResponseEntity.status(HttpStatus.OK).body(brand)
    }

    @DeleteMapping("/{id}")
    fun deleteBrand(@PathVariable id: Int): ResponseEntity<String> {
        brandService.getBrandById(id)
        brandService.deleteBrand(id)
        return ResponseEntity.status(HttpStatus.OK).body("Brand deleted")
    }

    @PutMapping("/{id}")
    fun updateBrand(@PathVariable id: Int, @RequestBody brandDto: BrandDto): ResponseEntity<Brand>{
        return ResponseEntity.status(HttpStatus.OK).body(brandService.updateBrand(id, brandDto.toEntity()))
    }
}