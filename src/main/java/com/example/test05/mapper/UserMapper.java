package com.example.test05.mapper;



import com.example.test05.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    //增删改查

    //添加用户,简单的mysql添加语句，再加一个添加的方法
    @Insert("insert into user (username,password) values (#{username},#{password})")
    void adduser(String username,String password);

    //删除用户，根据用户名删除
    @Delete("delete from user where username=#{username}")
    void deluser(String username);

    //修改用户密码
    @Update("update user set password=#{password} where username=#{username}")
    void changepwd(String username,String password);

    //查询用户，并输出，所有方法返回User类型
    @Select("select * from user where username=#{username}")
    User searchuser(String username);
}
