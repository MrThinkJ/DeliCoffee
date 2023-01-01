/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import daoconfig.AccountDatabaseConfig;
import daoconfig.OrderDatabaseConfig;
import entity.Bill;
import java.util.List;
import repository.OrderRepository;

/**
 *
 * @author ACER
 */
public class OrderService implements OrderRepository{
    @Override
    public void addBill(String drinkName, int drinkPrice, int drinkQuantity) {
        Bill bill = new Bill();
        bill.setID(getMaxId()+1);
        bill.setDrinkName(drinkName);
        bill.setDrinkPrice(drinkPrice);
        bill.setDrinkQuantity(drinkQuantity);
        billList.add(bill);
        OrderDatabaseConfig.changeBillDatabase(billList);
    }

    @Override
    public List<Bill> getBillList() {
        return billList;
    }

    @Override
    public void remove(int id) {
        billList.remove(id - 1);
        for (int i = id - 1; i < billList.size(); i++) {
            billList.get(i).setID(billList.get(i).getID() - 1);
        }
        OrderDatabaseConfig.changeBillDatabase(billList);
    }

    @Override
    public int getMaxId() {
        int maxId = 0;
        for (Bill bill : billList)
            if (bill.getID()>=maxId)
                maxId = bill.getID();
        return maxId;
    }
}
