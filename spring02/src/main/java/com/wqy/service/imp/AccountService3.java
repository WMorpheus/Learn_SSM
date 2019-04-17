package com.wqy.service.imp;

import com.wqy.service.IAccountService;

import java.lang.reflect.Array;
import java.util.*;

public class AccountService3 implements IAccountService {
    private String[] array;
    private List<String> list;
    private Set<String> set;
    private Map<String,String> map;
    private Properties prop;

    public void setArray(String[] array) {
        this.array = array;
    }

    public void setList(List<String> list) {
        this.list = list;

    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setProp(Properties prop) {
        this.prop = prop;
    }



    public void saveAccount() {
        System.out.println("I have save account.");
        System.out.println(Arrays.toString(array));
        System.out.println(list);
        System.out.println(set);
        System.out.println(map);
        System.out.println(prop);
    }
}
