package com.wqy.controller;

import com.wqy.domain.Account;
import com.wqy.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller("accountController")
@RequestMapping("/account")
public class AcccountController {

    @Autowired
    private IAccountService accountService;

    @RequestMapping("/findAll")
    public String findAll(){
        List<Account> accounts=accountService.findAll();
        System.out.println("控制层查询所有");
        for(Account account:accounts){
            System.out.println(account);
        }

        return "list";
    }

    @RequestMapping("/save")
    public void save(Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("控制层保存账户");
        response.sendRedirect(request.getContextPath()+"/account/findAll");
        accountService.saveAccount(account);
    }

}
