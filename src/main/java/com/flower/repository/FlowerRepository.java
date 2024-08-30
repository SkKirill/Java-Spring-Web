package com.flower.repository;

import com.flower.dto.FlowerDTO;
import com.flower.entity.Flower;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.flower.constants.FlowerSQLQuery.*;

@Repository
public class FlowerRepository {

    private final JdbcTemplate jdbcTemplate;

    public FlowerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Flower> create(Long profileId, FlowerDTO flowerDTO) {
        jdbcTemplate.update(QUERY_TEMPLATE_CREATE,
                flowerDTO.getName(),
                profileId,
                flowerDTO.getDescription()
        );
        return getByProfileId(profileId);
    }

    public Flower getByProfileIdAndId(Long profileId, Long id) {
        try {
            return jdbcTemplate.queryForObject(QUERY_TEMPLATE_FIND_BY_PROFILE_ID_AND_ID,
                    getFlowerRowMapper(),
                    profileId,
                    id
            );
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    public List<Flower> getByProfileId(Long profileId) {
        try {
            return jdbcTemplate.queryForStream(QUERY_TEMPLATE_FIND_BY_PROFILE_ID,
                    getFlowerRowMapper(),
                    profileId
            ).toList();
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    public Flower getById(Long id) {
        try {
            return jdbcTemplate.queryForObject(QUERY_TEMPLATE_FIND_BY_ID,
                    getFlowerRowMapper(),
                    id
            );
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    public void deleteById(Long id) {
        jdbcTemplate.update(QUERY_TEMPLATE_DELETE, id);
    }

    public Flower update(Long id, FlowerDTO flowerDTO) {
        jdbcTemplate.update(QUERY_TEMPLATE_UPDATE,
                flowerDTO.getName(),
                flowerDTO.getDescription(),
                id
        );
        return getById(id);
    }

    private RowMapper<Flower> getFlowerRowMapper() {
        return (rs, rowNum) -> new Flower(
                rs.getLong("id"),
                rs.getLong("id_profile"),
                rs.getString("description"),
                rs.getString("name")
        );
    }
}
