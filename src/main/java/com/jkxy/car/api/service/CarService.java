package com.jkxy.car.api.service;

import com.jkxy.car.api.pojo.Car;
import com.jkxy.car.api.pojo.CarInfo;
import com.jkxy.car.api.utils.JSONResult;

import java.util.List;


public interface CarService {

    List<Car> findAll();

    Car findById(int id);

    List<Car> findByCarName(String carName);

    void deleteById(int id);

    void updateById(Car car);

    void insertCar(Car car);

    JSONResult purchaseCar(Car car);

    List<Car> fuzzyQueryByCarName(CarInfo carInfo);
}
