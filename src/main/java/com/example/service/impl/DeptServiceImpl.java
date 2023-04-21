package com.example.service.impl;

import com.example.anno.Log;
import com.example.mapper.DeptLogMapper;
import com.example.mapper.DeptMapper;
import com.example.mapper.EmpMapper;
import com.example.pojo.Dept;
import com.example.pojo.DeptLog;
import com.example.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {


    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private DeptLogMapper deptLogMapper;
    @Autowired
    private EmpMapper empMapper;
    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    @Log
    @Transactional//spring事务管理
    @Override
    public void del(Integer id) {

        try {
            deptMapper.delById(id);
            empMapper.delByDeptId(id);
        } finally {
            DeptLog deptLog=new DeptLog();
            deptLog.setCreateTime(LocalDateTime.now());
            deptLog.setDescription("执行了解散部门的操作，删除了"+id+"号部门");
            deptLogMapper.insert(deptLog);
        }

    }

    @Log
    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }

    @Log
    @Override
    public void updateById(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.updateById(dept);
    }

    @Override
    public Dept getById(Integer id) {
        Dept dept = deptMapper.selectById(id);
        return dept;
    }


}
