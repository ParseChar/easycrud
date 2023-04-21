package com.example.mapper;

import com.example.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {
    @Select("select  * from dept")
    List<Dept> list();


    @Delete("delete from dept where id=#{id}")
    void delById(Integer id);


//    @Insert("insert into dept(name,create_time,update_time) values (#{name},#{createTime},#{updateTime}}})")
    @Insert("insert into dept(name,create_time,update_time) values (#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);

    @Update("update dept set name=#{name},update_time=#{updateTime} where id=#{id}")
    void updateById(Dept dept);


    @Select("select * from dept where id=#{id}")
    Dept selectById(Integer id);
}
