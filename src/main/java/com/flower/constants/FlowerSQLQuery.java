package com.flower.constants;

public class FlowerSQLQuery {
    public static final String QUERY_TEMPLATE_FIND_BY_PROFILE_ID = "SELECT * FROM flower where id_profile = ?";
    public static final String QUERY_TEMPLATE_FIND_BY_ID = "SELECT * FROM flower where id = ?";
    public static final String QUERY_TEMPLATE_FIND_BY_PROFILE_ID_AND_ID = "SELECT * FROM flower where id_profile = ? and id=?";
    public static final String QUERY_TEMPLATE_UPDATE = "UPDATE flower SET name = ?, description = ? WHERE id = ?";
    public static final String QUERY_TEMPLATE_DELETE = "DELETE FROM flower WHERE id = ?";
    public static final String QUERY_TEMPLATE_CREATE = "INSERT INTO flower (name, id_profile, description) VALUES (?, ?, ?)";
}
