package com.example.repository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    public static Pageable DEFAULT_PAGE_REQUEST = new PageRequest(0, 10);
        
    //TODO 名前でパターンマッチする機能を作成する
    //User findByName(Long id);
}
