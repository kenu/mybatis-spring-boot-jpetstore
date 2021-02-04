package com.kazuki43zoo.jpetstore.mapper;

import com.kazuki43zoo.jpetstore.domain.Account;
import com.kazuki43zoo.jpetstore.domain.Product;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
@CacheNamespace
public interface AdminMapper {
    int getAccountCount();
    int getProductCount();

    List<Account> getAccountList(String keywords);
    List<Product> getProductList(String keywords);
}
