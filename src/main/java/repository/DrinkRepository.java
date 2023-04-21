/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.List;
import entity.Drink;

/**
 *
 * @author ACER
 */
public interface DrinkRepository {
    void addDrink(int price, String name);
    
    void updateDrink(int id, int price, String name);
    
    void deleteDrink(int id);
    
    List<Drink> getAllDrink();
}