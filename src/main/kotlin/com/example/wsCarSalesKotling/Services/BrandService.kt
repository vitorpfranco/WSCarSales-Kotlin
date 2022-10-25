package com.example.wsCarSalesKotling.Services

import com.example.wsCarSalesKotling.Exceptions.ResourceNotFoundException
import com.example.wsCarSalesKotling.Models.Brand
import com.example.wsCarSalesKotling.Repositories.BrandRepository
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.function.Supplier

@Service
class BrandService() {

    @Autowired
    lateinit var brandRepository: BrandRepository


    fun saveBrand(brand:Brand):Brand{
        return brandRepository.save(brand)
    }

    fun getBrands(): List<Brand> {
        return brandRepository.findAll()
    }

    fun getBrandById(id: Int): Brand {
        val brand = brandRepository.findById(id)
        return brand.orElseThrow(Supplier<RuntimeException> { ResourceNotFoundException("Brand not found for ID: $id")})
    }

    fun deleteBrand(id: Int) {
        brandRepository.deleteById(id)
    }

    fun updateBrand(id: Int, brand:Brand): Brand {
        val oldBrand = getBrandById(id)
        BeanUtils.copyProperties(brand, oldBrand)
        return saveBrand(oldBrand)
    }
}