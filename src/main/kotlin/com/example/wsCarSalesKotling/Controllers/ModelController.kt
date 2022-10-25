package com.example.wsCarSalesKotling.Controllers

import com.example.wsCarSalesKotling.Dtos.ModelDto
import com.example.wsCarSalesKotling.Models.Model
import com.example.wsCarSalesKotling.Services.ModelService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@CrossOrigin(origins = ["*"], maxAge = 3600)
@RestController
@RequestMapping("models")
class ModelController {
    @Autowired
    lateinit var modelService: ModelService;

    @PostMapping
    fun saveModel(@RequestBody @Valid modelDto: ModelDto): ResponseEntity<Model> {
        var model: Model = modelService.setBrand(modelDto)
        return ResponseEntity.status(HttpStatus.CREATED).body(modelService.saveModel(model))
    }

    @GetMapping
    fun getModels(): ResponseEntity<List<Model>>{
        return ResponseEntity.status(HttpStatus.OK).body(modelService.getModels())
    }

    @GetMapping("/{id}")
    fun getModelById(@PathVariable id: Int): ResponseEntity<Model> {
        return ResponseEntity.status(HttpStatus.OK).body(modelService.getModelById(id))
    }

    @DeleteMapping("/{id}")
    fun deleteModel(@PathVariable id: Int): ResponseEntity<String> {
        var model: Model = modelService.getModelById(id)
        modelService.deleteModel(id)
        return ResponseEntity.status(HttpStatus.OK).body<String>("Model deleted")
    }

    @PutMapping("/{id}")
    fun updateModel(@PathVariable id: Int, @RequestBody @Valid modelDto: ModelDto): ResponseEntity<Model> {
        var model: Model = modelService.setBrand(modelDto)
        return ResponseEntity.status(HttpStatus.OK).body(modelService.updateModel(id, model))
    }
}