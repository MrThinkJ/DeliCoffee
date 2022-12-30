/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daoconfig;

import entity.Drink;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class DrinkDatabaseConfig {
    public static List<Drink> dataSource(){
        List<Drink> drinkList = new ArrayList<>();
        try{
            Scanner sc = new Scanner(new File("DrinkDatabase.txt"));
        while(sc.hasNextLine()){
            String data = sc.nextLine();
            String[] splitData = data.split(" ");
            Drink drink = new Drink();
            drink.setId(Integer.parseInt(splitData[0]));
            drink.setPrice(Integer.parseInt(splitData[1]));
            String drinkName = "";
            for (int i = 2; i<splitData.length;i++)
                drinkName += splitData[i]+" ";
            drink.setName(drinkName);
            drinkList.add(drink);
        }
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        return drinkList;
    }
    
    public static void changeDrinkDatabase(List<Drink> drinkList){
        try{
            PrintStream ps = new PrintStream(new File("DrinkDatabase.txt"));
            for (Drink drink:drinkList){
                ps.print(drink.getId()+" ");
                ps.print(drink.getPrice()+" ");
                ps.println(drink.getName());
            }
        } catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
