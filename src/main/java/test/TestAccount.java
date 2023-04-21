package test;

import entity.Account;
import service.AccountService;

public class TestAccount {
    public static void main(String[] args) {
        AccountService accountService = new AccountService();
//        Account account = accountService.findByUsernameAndPassword("binthinhle", "123");
//        if(account == null)
//            System.out.println("khong thay user nay");
//        else
//            System.out.println(account.getRole());
        Account account = new Account();
//        accountService.addAccount("staff", "staff", "staff");
    }
}
