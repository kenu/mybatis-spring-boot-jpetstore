package com.kazuki43zoo.jpetstore.mapper;

import com.kazuki43zoo.jpetstore.domain.Account;
import java.util.List;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@CacheNamespace
public interface AdminMapper {
    int getAccountCount();

    List<Account> getAccountList();
    List<Account> searchAccountList(String keyword);
}
