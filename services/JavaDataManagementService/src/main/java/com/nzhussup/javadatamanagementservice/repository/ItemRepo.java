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


    public void add(Item item) {
        String sqlAdd = "INSERT INTO items (userid, title, description, score) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sqlAdd, item.getUserid(), item.getTitle(), item.getDescription(), item.getScore());
    }

    public void deleteById(int id) {
        String sqlDelete = "DELETE FROM items WHERE itemid = ?";
        jdbcTemplate.update(sqlDelete, id);
    }

    public void update(Item item) {
        String sqlUpdate = "UPDATE items SET title = ?, description = ?, score = ? WHERE itemid = ?";
        jdbcTemplate.update(sqlUpdate, item.getTitle(), item.getDescription(), item.getScore(), item.getItemid());
    }



    public Item findById(int id) {
        String sqlFindById = "SELECT * FROM items WHERE itemid = ?";

        return jdbcTemplate.queryForObject(sqlFindById, new Object[]{id}, (rs, rowNum) -> {
            return new Item(
                    rs.getInt("itemid"),
                    rs.getInt("userid"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getDouble("score")
            );
        });
    }

    public Item findLastEntry() {
        String sqlFindLast = "SELECT * FROM items ORDER BY itemid DESC LIMIT 1"; // PostgreSQL syntax
        return jdbcTemplate.queryForObject(sqlFindLast, (rs, rowNum) -> {
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
