package com.sinosoft.demo.dao;

import com.sinosoft.demo.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserDao {

    /**
     * 查询所有用户数据
     * @return 用户数据列表
     */
    @Select(" select * from UserInfo ")
    List<UserInfo> getUsers();

    @Update("UPDATE userinfo set password = #{psw}  where userId = #{userId} ")
    void updatePsw(@Param(value="userId")String userId, @Param(value="psw")String psw);


}
