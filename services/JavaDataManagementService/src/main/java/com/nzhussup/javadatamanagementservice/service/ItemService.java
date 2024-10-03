package com.nzhussup.javadatamanagementservice.service;

import com.nzhussup.javadatamanagementservice.model.Item;
import com.nzhussup.javadatamanagementservice.repository.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepo itemRepo;

    public List<Item> findAll() {
        return itemRepo.findAll();
    }
}
