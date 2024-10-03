package com.nzhussup.javadatamanagementservice.repository;

import com.nzhussup.javadatamanagementservice.model.Item;
import com.nzhussup.javadatamanagementservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<User> findAll(){

        String sqlFindAll = "SELECT * FROM users";

        return jdbcTemplate.query(sqlFindAll, (rs, rowNum) -> {
            return new User(
                    rs.getInt("userid"),
                    rs.getString("firstname"),
                    rs.getString("lastname"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getString("username")
            );
        });

    }

    public void add(User user) {
        String sqlAdd = "INSERT INTO users (firstname, lastname, email, password, username) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sqlAdd, user.getFirstname(),  user.getLastname(), user.getEmail(), user.getPassword(), user.getUsername());
    }

    public void deleteById(int id) {
        String sqlDelete = "DELETE FROM users WHERE userid = ?";
        jdbcTemplate.update(sqlDelete, id);
    }

    public void update(User user) {
        String sqlUpdate = "UPDATE users SET firstname=?, lastname=?, email=?, password=?, username=? WHERE userid = ?";
        jdbcTemplate.update(sqlUpdate, user.getFirstname(), user.getLastname(), user.getEmail(), user.getPassword(), user.getUsername(), user.getUserid());
    }

    public User findById(int id) {
        String sqlFindById = "SELECT * FROM users WHERE userid = ?";

        return jdbcTemplate.queryForObject(sqlFindById, new Object[]{id}, (rs, rowNum) -> {
            return new User(
                    rs.getInt("userid"),
                    rs.getString("firstname"),
                    rs.getString("lastname"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getString("username")
            );
        });
    }

    public User findLastEntry() {
        String sqlFindLast = "SELECT * FROM users ORDER BY userid DESC LIMIT 1"; // PostgreSQL syntax
        return jdbcTemplate.queryForObject(sqlFindLast, (rs, rowNum) -> {
            return new User(
                    rs.getInt("userid"),
                    rs.getString("firstname"),
                    rs.getString("lastname"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getString("username")
            );
        });
    }

}
