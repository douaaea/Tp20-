package com.example.carservice.service;

import com.example.carservice.model.Car;
import com.example.carservice.model.Client;
import com.example.carservice.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    @Autowired
    private RestTemplate restTemplate;

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car getCarById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    public List<Car> getCarsByClientId(Long clientId) {
        return carRepository.findByClientId(clientId);
    }

    public Client getClientDetails(Long clientId) {
        String url = "http://client-service/clients/" + clientId;
        return restTemplate.getForObject(url, Client.class);
    }

    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
}
