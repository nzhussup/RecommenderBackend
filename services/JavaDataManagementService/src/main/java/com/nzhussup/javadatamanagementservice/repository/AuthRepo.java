package com.nzhussup.javadatamanagementservice.repository;


import com.nzhussup.javadatamanagementservice.entity.UserEntity;
import com.nzhussup.javadatamanagementservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AuthRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Optional<UserEntity> authFindByEmail(String email) {
        String sqlFindByEmail = "SELECT * FROM auth WHERE email = ?";

        try {
            UserEntity user = jdbcTemplate.queryForObject(sqlFindByEmail, new Object[]{email}, (rs, rowNum) -> {
                return new UserEntity(
                        rs.getLong("id"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("role")
                );
            });
            return Optional.of(user);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    public UserEntity register(UserEntity user) {
        String sql = "INSERT INTO auth (email, password, role) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, user.getEmail(), user.getPassword(), user.getRole());
        Optional<UserEntity> userOptional = authFindByEmail(user.getEmail());
        if (userOptional.isPresent()) {
            return userOptional.get();
        }
        return null;
    }

    public List<UserEntity> findAll(){

        String sqlFindAll = "SELECT * FROM auth";

        return jdbcTemplate.query(sqlFindAll, (rs, rowNum) -> {
            return new UserEntity(
                    rs.getLong("id"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getString("role")
            );
        });

    }

    public void deleteByEmail(String email) {
        String sqlDelete = "DELETE FROM auth WHERE email = ?";
        jdbcTemplate.update(sqlDelete, email);
    }
}
