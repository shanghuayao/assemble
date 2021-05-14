package com.assemble.map;


import com.assemble.entity.UserDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class UserSqlFactory {

    public String findByQuerySql() {
        SQL sql = new SQL();
        sql.SELECT("id,name");
        sql.FROM("USER");
        sql.LIMIT("0,10");
        return sql.toString();
    }

    public String  insertSql(@Param("userDO") UserDO userDO){
        SQL sql=new SQL();
        sql.INSERT_INTO("user");
        sql.INTO_COLUMNS(" name,  old");
        sql.INTO_VALUES(" #{userDO.name}, 1");
        return sql.toString();
    }


    public String updateSql(@Param("userDO") UserDO userDO){
        SQL sql=new SQL();
        sql.UPDATE("USER");
        sql.SET("old = 0");
        sql.WHERE("id = #{userDO.id}");
        return  sql.toString();
    }




}
