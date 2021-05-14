package com.assemble.map;
import com.assemble.entity.UserDO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {

    @SelectProvider(type = UserSqlFactory.class, method = "findByQuerySql")
    List<UserDO> findByQuery();

    @InsertProvider(type = UserSqlFactory.class, method = "insertSql")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    boolean insert(@Param("userDO") UserDO userDO);

    @UpdateProvider(type = UserSqlFactory.class, method = "updateSql")
    int update(@Param("userDO")UserDO userDO);

    @Select("SELECT id, num,name, mobile, old FROM  USER WHERE  id =#{id}")
    UserDO findById(@Param("id") long id);
}
