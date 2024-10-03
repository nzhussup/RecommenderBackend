package com.nzhussup.javadatamanagementservice.repository;

import com.nzhussup.javadatamanagementservice.service.ItemService;
import com.nzhussup.javadatamanagementservice.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Item> findAll(){

        String sqlFindAll = "SELECT * FROM items";

        return jdbcTemplate.query(sqlFindAll, (rs, rowNum) -> {
            return new Item(
                    rs.getInt("itemid"),
                    rs.getInt("userid"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getDouble("score")
            );
        });

    }
}
