package com.jkxy.car.api.service.Impl;

import com.jkxy.car.api.dao.CarDao;
import com.jkxy.car.api.pojo.Car;
import com.jkxy.car.api.pojo.CarInfo;
import com.jkxy.car.api.service.CarService;
import com.jkxy.car.api.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("carService")
public class CarServiceImpl implements CarService {
    @Autowired
    private CarDao carDao;

    @Override
    public List<Car> findAll() {
        return carDao.findAll();
    }

    @Override
    public Car findById(int id) {
        return carDao.findById(id);
    }

    @Override
    public List<Car> findByCarName(String carName) {
        return carDao.findByCarName(carName);
    }

    @Override
    public void deleteById(int id) {
        carDao.deleteById(id);
    }

    @Override
    public void updateById(Car car) {
        carDao.updateById(car);
    }

    @Override
    public void insertCar(Car car) {
        carDao.insertCar(car);
    }

    @Override
    public JSONResult purchaseCar(Car car) {
        int count = carDao.findQuantity(car);
        if(car.getCarQuantity()<=count)
        {
            carDao.purchaseCar(car);
            return JSONResult.ok();
        }else {
            return JSONResult.errorMsg("购买数量大于库存，请重新输入购买数量或联系售后");
        }
    }
    @Override
    public List<Car> fuzzyQueryByCarName(CarInfo carInfo) {
        //当入参pageNum和pageSize其中一个为0或null时，默认设置pageNum=1，pageSize=5
        if((carInfo.getPageNum() == null || carInfo.getPageNum() ==0) || (carInfo.getPageSize() == null || carInfo.getPageSize() ==0)){
            carInfo.setPageNum(1L);
            carInfo.setPageSize(5L);
        }
        carInfo.setPageNum((carInfo.getPageNum()-1)*carInfo.getPageSize());
        List<Car> cars = carDao.query(carInfo);
        return cars;
    }


}
