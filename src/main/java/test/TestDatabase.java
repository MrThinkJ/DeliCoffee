/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import config.Connect;
import dao.DAO;
public class TestDatabase extends DAO{
    public static void main(String[] args) {
        try{
            conn = Connect.openConnect();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
