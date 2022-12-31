/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import entity.Account;

/**
 *
 * @author ACER
 */
public class SharedData {
    static Account account = new Account();

    public Account getAccount() {
        return account;
    }

    public static void setAccount(Account account) {
        SharedData.account = account;
    }
    
    
}
