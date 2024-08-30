package com.flower.constants;

public class ProfileQLQuery {
    public static final String QUERY_TEMPLATE_FIND_BY_ID = "SELECT * FROM profile where id = ?";
    public static final String QUERY_TEMPLATE_FIND_BY_LOGIN = "SELECT * FROM profile WHERE login = ?";
    public static final String QUERY_TEMPLATE_FIND_ALL = "SELECT * FROM profile";
    public static final String QUERY_TEMPLATE_CREATE = "INSERT INTO profile (fio, login, password) VALUES (?, ?, ?)";
}
