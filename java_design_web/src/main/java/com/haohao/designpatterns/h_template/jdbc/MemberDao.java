package com.haohao.designpatterns.h_template.jdbc;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

public class MemberDao extends MyJdbcTemplate {

    public MemberDao(DataSource dataSource) {
        super(dataSource);
    }

    public List<?> selectAll() {
        String sql = "select * from t_member";
        return super.executeQuery(sql, new RowMapper<Member>(){

            @Override
            public Member mapRow(ResultSet rs, Integer rowNum) throws Exception {
                // 字段过多可以使用 原型模式;
                Member member = new Member();
                member.setUsername(rs.getString("username"));
                member.setPassword(rs.getString("password"));
                member.setNickName(rs.getString("nickname"));
                member.setAge(rs.getInt("age"));
                member.setAddr(rs.getString("addr"));
                return member;
            }
        }, null);
    }
}
