package com.geekbrains.july.warehouse.services;

import com.geekbrains.july.warehouse.entities.ProductTransaction;
import com.geekbrains.july.warehouse.entities.Unit;
import com.geekbrains.july.warehouse.entities.UserAction;
import com.geekbrains.july.warehouse.exceptions.CustomException;
import com.geekbrains.july.warehouse.repositories.UserActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserActionService {
    @Autowired
    UserActionRepository userActionRepository;

    public List<UserAction> findAll() {
        return userActionRepository.findAll();
    }

    public UserAction saveOrUpdate(UserAction userAction) {
        try {
            return userActionRepository.save(userAction);
        }catch(Exception e){
            throw new CustomException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    public List<UserAction> getProductTransactions(Long productId) {
        return userActionRepository.findAllByProductId(productId);
    }

    public List<UserAction> getAuthorTransactions(String authorName) {
        return userActionRepository.findAllByAuthorName(authorName);
    }

    public List<UserAction> getDateTransactions(Date data) {
        return userActionRepository.findAllByData(data);
    }
}
