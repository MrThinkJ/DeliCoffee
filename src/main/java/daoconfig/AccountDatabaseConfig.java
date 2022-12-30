package daoconfig;

import entity.Account;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountDatabaseConfig {
        public static List<Account> dataSource(){
            List<Account> accountList = new ArrayList<>();
            try{
                Scanner sc = new Scanner(new File("AccountDatabase.txt"));
                while(sc.hasNextLine()){
                    String data = sc.nextLine();
                    String []splitAccount = data.split(" ");
                    Account account = new Account();
                    account.setId(Integer.parseInt(splitAccount[0]));
                    account.setUsername(splitAccount[1]);
                    account.setPassword(splitAccount[2]);
                    account.setRole(splitAccount[3]);
                    accountList.add(account);
                }
            }
            catch(FileNotFoundException e){
                e.printStackTrace();
            }
            return accountList;
        }

        public static void changeAccountDatabase(List<Account> accountList){
            try{
                PrintStream ps = new PrintStream(new File("AccountDatabase.txt"));
                for (Account account:accountList){
                    ps.print(account.getId()+" ");
                    ps.print(account.getUsername()+" ");
                    ps.print(account.getPassword()+" ");
                    ps.println(account.getRole());
                }
            } catch(FileNotFoundException e){
                e.printStackTrace();
            }
        }
}
