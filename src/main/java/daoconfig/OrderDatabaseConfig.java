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
import entity.Bill;

/**
 *
 * @author ACER
 */
public class OrderDatabaseConfig {

    public static List<Bill> dataSource() {
        List<Bill> billList = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File("OrderDatabase.txt"));
            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                String[] splitData = data.split(" ");
                Bill bill = new Bill();
                bill.setID(Integer.parseInt(splitData[0]));
                bill.setDrinkPrice(Integer.parseInt(splitData[1]));
                bill.setDrinkQuantity(Integer.parseInt(splitData[2]));
                String drinkName = "";
                for (int i = 4; i < splitData.length; i++) {
                    drinkName += splitData[i] + " ";
                }
                bill.setDrinkName(drinkName);
                billList.add(bill);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return billList;
    }

    public static void changeBillDatabase(List<Bill> billList) {
        try {
            PrintStream ps = new PrintStream(new File("OrderDatabase.txt"));
            for (Bill bill : billList) {
                ps.print(bill.getID() + " ");
                ps.print(bill.getDrinkPrice() + " ");
                ps.print(bill.getDrinkQuantity() + " ");
                ps.print(bill.getTotalPrice() + " ");
                ps.println(bill.getDrinkName());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
