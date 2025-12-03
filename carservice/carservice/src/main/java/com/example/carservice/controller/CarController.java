package com.example.carservice.controller;

import com.example.carservice.model.Car;
import com.example.carservice.model.Client;
import com.example.carservice.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable Long id) {
        return carService.getCarById(id);
    }

    @GetMapping("/client/{clientId}")
    public List<Car> getCarsByClientId(@PathVariable Long clientId) {
        return carService.getCarsByClientId(clientId);
    }

    @GetMapping("/client-details/{clientId}")
    public Client getClientDetails(@PathVariable Long clientId) {
        return carService.getClientDetails(clientId);
    }

    @PostMapping
    public Car createCar(@RequestBody Car car) {
        return carService.saveCar(car);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
    }
}
