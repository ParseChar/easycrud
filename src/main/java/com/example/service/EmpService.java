package com.example.service;

import com.example.pojo.Emp;
import com.example.pojo.PageBean;
import com.example.pojo.Result;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;

@Service
public interface EmpService {
    /**
     * 分页查询
     *
     * @param page
     * @param pageSize
     * @return PageBean
     * @author H2
     * @date 18:04
     */
    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    /**
     * 批量删除和单个删除
     *
     * @param ids
     * @author H2
     * @date 10:14
     */
    void del(List<Integer> ids);

    /**
     * @param emp
     * @author H2
     * @date 10:33
     */
    void add(Emp emp);

    /**
     * @param id
     * @return Emp
     * @author H2
     * @date 15:30
     */
    Emp getById(Integer id);

    void update(Emp emp);

    Emp login(Emp emp);
}