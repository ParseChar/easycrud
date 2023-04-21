package com.example.service;


import com.example.pojo.Dept;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DeptService {
    /*
    * 查询全部部门信息
    * */
    List<Dept> list();


    /**
     *
     *
     * @author H2
     * @date  15:41
     * @param id

     */
    void del(Integer id);
    /**
     *
     *
     * @author H2
     * @date  15:51
     * @param dept

     */
    void add(Dept dept);

    /** 
     * 
     *
     * @author H2
     * @date  16:26
     * @param dept 
     
     */
    void updateById(Dept dept);


    Dept getById(Integer id);
}
