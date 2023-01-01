/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import daoconfig.OrderDatabaseConfig;
import entity.Bill;
import java.util.List;

public interface OrderRepository {
    List<Bill> billList = OrderDatabaseConfig.dataSource();
    List<Bill> getBillList ();
    void addBill(String drinkName, int drinkPrice, int drinkQuantity);
    void remove(int id);
    int getMaxId();
}
