package com.haohao.designpatterns.h_template.jdbc;

import java.sql.ResultSet;

public interface RowMapper<T> {
    T mapRow(ResultSet rs, Integer rowNum) throws Exception;
}