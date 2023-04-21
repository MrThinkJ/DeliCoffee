/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import entity.Bill;
import java.util.ArrayList;
import java.util.List;

public interface OrderRepository {
    List<Bill> getBillList (int id);
    void addBill(int drinkId, int drinkQuantity);
    void remove(int id);
    void setTable(int tableId);
    void removeAll();
    void changeDataToLog(int tableId);
    void removeAll(int id);
    void removeBillHaveDrinkName(String drinkName);
}
