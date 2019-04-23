package com.wqy.controller;

import com.wqy.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("accountController")
@RequestMapping("/account")
public class AcccountController {

    @Autowired
    private IAccountService accountService;

    @RequestMapping("/findAll")
    public String findAll(){
        accountService.findAll();
        System.out.println("控制层查询所有");
        return "list";
    }

}
