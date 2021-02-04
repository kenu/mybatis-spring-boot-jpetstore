package com.kazuki43zoo.jpetstore.ui.controller;

import com.kazuki43zoo.jpetstore.domain.Account;
import com.kazuki43zoo.jpetstore.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class TestController {
    @GetMapping("/get")
    public Object get() {
        List<String> strings = Arrays.asList("Visa", "MasterCard", "American Express");
        return strings;
    }

    private final AdminService adminService;

    @GetMapping("/data")
    public Object main() {
        int count = adminService.getAccountCount();
        List<Account> accountList = adminService.getAccountList("");
        Map<String, Object> map = new HashMap<>();
        map.put("count", count);
        map.put("accountList", accountList);
        return map;
    }
}
