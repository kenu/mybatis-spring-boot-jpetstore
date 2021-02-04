package com.kazuki43zoo.jpetstore.service;

import com.kazuki43zoo.jpetstore.domain.Account;
import com.kazuki43zoo.jpetstore.domain.Product;
import com.kazuki43zoo.jpetstore.mapper.AdminMapper;
import com.kazuki43zoo.jpetstore.mapper.ProductMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AdminService {

    private final AdminMapper adminMapper;
    private final ProductMapper productMapper;
    public int getAccountCount() {
        return adminMapper.getAccountCount();
    }
    public int getProductCount() {return productMapper.getProductCount(); }

    public List<Account> getAccountList() {
        return adminMapper.getAccountList();
    }

    public List<Account> searchAccountList(String keyword) {
        return adminMapper.searchAccountList(keyword);
    }

    public List<Product> searchProductList(String keywords) {
        return productMapper.selectProductList(keywords);
    }

    public List<Product> getProductList() {
        return productMapper.getProductList();
    }
}
