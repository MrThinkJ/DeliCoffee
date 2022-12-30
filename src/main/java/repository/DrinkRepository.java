/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.List;
import entity.Drink;
import daoconfig.Config;

/**
 *
 * @author ACER
 */
public interface DrinkRepository {
    List<Drink> drinkList = Config.dataSource();
    public void addDrink(Drink drink);
    
    public void updateDrink(int id, int price, String name);
    
    public void deleteDrink(int id);
    
    public void getAllDrink();
}