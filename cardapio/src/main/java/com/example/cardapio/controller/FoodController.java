package com.example.cardapio.controller;

import com.example.cardapio.model.Food;
import com.example.cardapio.model.FoodRequestDTO;
import com.example.cardapio.model.FoodResponseDTO;
import com.example.cardapio.repository.FoodRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food")
public class FoodController {

    private final FoodRepository repository;

    public FoodController(FoodRepository repository){
        this.repository = repository;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data){
        //Transforma DTO em entidade -> para que a request colete os dados a serem salvos
        Food foodData = new Food(data);
        repository.save(foodData);
        return;

    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<FoodResponseDTO> getAll(){
        //Transforma entidade em DTO
        List<FoodResponseDTO> foodList = repository.findAll().stream().map(FoodResponseDTO::new).toList();
        return foodList;
    }
}
