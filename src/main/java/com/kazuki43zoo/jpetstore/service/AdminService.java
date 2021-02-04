package com.kazuki43zoo.jpetstore.service;

import com.kazuki43zoo.jpetstore.domain.Account;
import com.kazuki43zoo.jpetstore.domain.Product;
import com.kazuki43zoo.jpetstore.mapper.AdminMapper;
import com.kazuki43zoo.jpetstore.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Service
public class AdminService {

    private final AdminMapper adminMapper;
    private final ProductMapper productMapper;

    public int getAccountCount() {
        return adminMapper.getAccountCount();
    }

    public List<Account> getAccountList(String keywords) {
        return Stream.of(Optional.ofNullable(keywords).orElse("").split("\\s+"))
                .distinct()
                .flatMap(x -> adminMapper.getAccountList(x).stream())
                .distinct()
                .collect(Collectors.toList());
    }

    public int getProductCount() { return productMapper.getProductCount(); }


    public List<Product> searchProductList(String keywords) {
        return Stream.of(Optional.ofNullable(keywords).orElse("").split("\\s+"))
                .distinct()
                .flatMap(x -> productMapper.searchProductList(x).stream())
                .distinct()
                .collect(Collectors.toList());
    }
}
