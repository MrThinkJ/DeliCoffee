/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import daoconfig.DrinkDatabaseConfig;
import entity.Account;
import entity.Drink;
import repository.DrinkRepository;

/**
 *
 * @author ACER
 */
public class DrinkService implements DrinkRepository{

    @Override
    public int getMaxId() {
        int maxId = 1;
        for (Drink drink : drinkList)
            if (drink.getId()>=maxId)
                maxId = drink.getId();
        return maxId;
    }

    @Override
    public void addDrink(int price, String name){
        Drink drink = new Drink();
        drink.setId(getMaxId()+1);
        drink.setPrice(price);
        drink.setName(name);
        drinkList.add(drink);
        DrinkDatabaseConfig.changeDrinkDatabase(drinkList);
    }
    @Override
    public void updateDrink(int id, int price, String name){
        drinkList.get(id-1).setName(name);
        drinkList.get(id-1).setPrice(price);
        DrinkDatabaseConfig.changeDrinkDatabase(drinkList);
    }
    @Override
    public void deleteDrink(int id){
        drinkList.remove(id-1);
        for (int i=id-1;i<drinkList.size();i++){
            drinkList.get(i).setId(drinkList.get(i).getId()-1);
        }
        DrinkDatabaseConfig.changeDrinkDatabase(drinkList);
    }
    @Override
    public void getAllDrink(){
        for (Drink drink : drinkList)
            System.out.println(drink.toString());
    }
    
}
