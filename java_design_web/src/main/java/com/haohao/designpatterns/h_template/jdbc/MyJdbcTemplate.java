package com.haohao.designpatterns.h_template.jdbc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MyJdbcTemplate {

    private DataSource dataSource;

    public MyJdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<?> executeQuery(String sql, RowMapper<?> rowMapper, Object[] values) {
        try {
            // 1 获取连接;
            Connection conn = getConnection();

            // 2 创建语句集;
            PreparedStatement psmt = createPrepareStatement(conn, sql);

            // 3 执行语句;
            ResultSet result = executeQuery(psmt, values);

            // 4 处理结果集;
            List<?> resultList = parseResultSet(result, rowMapper);

            // 5 关闭结果集;
            closeResultSet(result);

            // 6 关闭语句集;
            closeStatement(psmt);

            // 7 关闭连接;
            closeConnection(conn);

            // 返回结果;
            return resultList;
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private void closeConnection(Connection conn) throws SQLException {
        conn.close();
    }

    private void closeStatement(PreparedStatement psmt) throws SQLException {
        psmt.close();
    }

    private void closeResultSet(ResultSet result) throws SQLException {
        result.close();
    }

    private List<?> parseResultSet(ResultSet result, RowMapper<?> rowMapper) throws Exception {
        List<Object> resultList = new ArrayList<Object>();
        int rowNum = 1;
        while (result.next()) {
            resultList.add(rowMapper.mapRow(result, rowNum ++));
        }
        return resultList;
    }

    private ResultSet executeQuery(PreparedStatement psmt, Object[] values) throws SQLException {
        for (int i = 0; i < values.length; i++) {
            psmt.setObject(i, values[i]);
        }
        return psmt.executeQuery();
    }

    private PreparedStatement createPrepareStatement(Connection conn, String sql) throws SQLException {
        return conn.prepareStatement(sql);
    }

    private Connection getConnection() throws SQLException {
        return this.dataSource.getConnection();
    }
}
