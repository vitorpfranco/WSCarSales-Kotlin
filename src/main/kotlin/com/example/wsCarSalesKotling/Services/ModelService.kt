package com.example.wsCarSalesKotling.Services

import com.example.wsCarSalesKotling.Dtos.ModelDto
import com.example.wsCarSalesKotling.Exceptions.ResourceNotFoundException
import com.example.wsCarSalesKotling.Models.Model
import com.example.wsCarSalesKotling.Repositories.ModelRepository
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.Optional
import java.util.function.Supplier


@Service
class ModelService {

    @Autowired
    lateinit var brandService: BrandService;

    @Autowired
    lateinit var modelRepository: ModelRepository


    fun saveModel(model: Model): Model {
        return modelRepository.save(model)
    }

    fun setBrand(modelDto: ModelDto): Model {
        var brand = brandService.getBrandById(modelDto.marca_id)
       var model= modelDto.toEntity(brand)
        return model
    }

    fun getModels(): List<Model> {
        return modelRepository.findAll()
    }

    fun getModelById(id: Int): Model {
        val model:Optional<Model> = modelRepository.findById(id)
        return model.orElseThrow(Supplier<RuntimeException> { ResourceNotFoundException("Model not found for ID: $id")})
    }

    fun deleteModel(id: Int) {
        modelRepository.deleteById(id)
    }

    fun updateModel(id: Int, model: Model): Model {
        val oldModel: Model = getModelById(id)
        BeanUtils.copyProperties(model, oldModel)
        return saveModel(oldModel)
    }
}