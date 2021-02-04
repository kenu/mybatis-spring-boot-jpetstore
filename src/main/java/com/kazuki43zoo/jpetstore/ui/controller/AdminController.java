package com.kazuki43zoo.jpetstore.ui.controller;

import com.kazuki43zoo.jpetstore.domain.Account;
import com.kazuki43zoo.jpetstore.domain.Product;
import com.kazuki43zoo.jpetstore.service.AdminService;
import com.kazuki43zoo.jpetstore.ui.AccountSearchCriteria;
import com.kazuki43zoo.jpetstore.ui.ProductSearchCriteria;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@RequestMapping("/admin")
@Controller
public class AdminController {

    private final AdminService adminService;
    private final AccountSearchCriteria accountSearchCriteria;
    private final ProductSearchCriteria productSearchCriteria;
Logger logger = LoggerFactory.getLogger(AdminController.class);
    @GetMapping
    public String main(Model model) {
        int count = adminService.getAccountCount();
        List<Account> accountList = adminService.getAccountList();
        model.addAttribute("accountList", accountList);
        model.addAttribute("count", count);
        return "admin/main";
    }

    @GetMapping("/username")
    public String searchAccounts(@RequestParam(defaultValue = "") String keywords, Model model) {
        accountSearchCriteria.setKeywords(keywords);
        List<Account> accountList = adminService.searchAccountList(accountSearchCriteria.getKeywords());
        model.addAttribute(accountList);
        return "admin/userName";
    }
    @GetMapping("/product")
    public String getProducts(@RequestParam(defaultValue = "") String keywords, Model model) {
        int count = adminService.getProductCount();
        List<Product> productList = adminService.getProductList();
        model.addAttribute("productList", productList);
        model.addAttribute("count", count);
        return "admin/product";
    }

    @GetMapping("/product/name")
    public String searchProducts(@RequestParam(defaultValue = "") String keywords, Model model) {
        productSearchCriteria.setKeywords(keywords);
        List<Product> productList = adminService.searchProductList(productSearchCriteria.getKeywords());
        model.addAttribute(productList);
        return "admin/productName";
    }
}
