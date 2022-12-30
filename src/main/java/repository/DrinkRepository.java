/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.List;
import entity.Drink;
import daoconfig.DrinkDatabaseConfig;

/**
 *
 * @author ACER
 */
public interface DrinkRepository {
    List<Drink> drinkList = DrinkDatabaseConfig.dataSource();
    int getMaxId();
    void addDrink(int price, String name);
    
    void updateDrink(int id, int price, String name);
    
    void deleteDrink(int id);
    
    void getAllDrink();
}