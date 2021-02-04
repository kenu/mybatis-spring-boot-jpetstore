package com.kazuki43zoo.jpetstore.ui.controller;

import com.kazuki43zoo.jpetstore.domain.Account;
import com.kazuki43zoo.jpetstore.domain.Product;
import com.kazuki43zoo.jpetstore.service.AdminService;
import com.kazuki43zoo.jpetstore.ui.ProductSearchCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/admin")
@Controller
public class AdminController {

    private final AdminService adminService;
    private final ProductSearchCriteria productSearchCriteria;

    @GetMapping
    public String main(@RequestParam(defaultValue = "") String keywords, Model model) {
        productSearchCriteria.setKeywords(keywords);

        int count = adminService.getAccountCount();
        List<Account> accountList = adminService.getAccountList(productSearchCriteria.getKeywords());
        model.addAttribute("count", count);
        model.addAttribute("accountList", accountList);
        return "admin/main";
    }
    @GetMapping("/product")
    public String viewProductList(@RequestParam(defaultValue = "") String keywords, Model model) {
        productSearchCriteria.setKeywords(keywords);

        int count = adminService.getProductCount();
        List<Product> productList = adminService.getProductList(productSearchCriteria.getKeywords());
        model.addAttribute("count", count);
        model.addAttribute("productList", productList);
        return "admin/product";
    }
}
