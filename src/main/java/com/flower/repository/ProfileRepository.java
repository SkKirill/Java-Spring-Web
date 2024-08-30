package com.flower.repository;

import com.flower.entity.Profile;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.flower.constants.ProfileQLQuery.*;

@Repository
public class ProfileRepository {
    private final JdbcTemplate jdbcTemplate;

    public ProfileRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Profile create(Profile profile) {
        jdbcTemplate.update(QUERY_TEMPLATE_CREATE,
                profile.getFio(),
                profile.getLogin(),
                profile.getPassword()
        );
        return getByLogin(profile.getLogin());
    }

    public List<Profile> getAllProfile() {
        try {
            return jdbcTemplate.queryForStream(QUERY_TEMPLATE_FIND_ALL,
                    getProfileRowMapper()
            ).toList();
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    public Profile getById(Long id) {
        try {
            return jdbcTemplate.queryForObject(QUERY_TEMPLATE_FIND_BY_ID,
                    getProfileRowMapper(),
                    id
            );
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    public Profile getByLogin(String login) {
        try {
            return jdbcTemplate.queryForObject(QUERY_TEMPLATE_FIND_BY_LOGIN,
                    getProfileRowMapper(),
                    login
            );
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    private RowMapper<Profile> getProfileRowMapper() {
        return (rs, rowNum) -> new Profile(
                rs.getLong("id"),
                rs.getString("fio"),
                rs.getString("login"),
                rs.getString("password")
        );
    }
}
