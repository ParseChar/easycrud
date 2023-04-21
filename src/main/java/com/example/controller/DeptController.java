package com.example.controller;

import com.example.pojo.Dept;
import com.example.pojo.Result;
import com.example.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {


    @Autowired
    private DeptService deptService;

    @GetMapping
    public Result list(){
        List<Dept>deptList=deptService.list();
        return Result.success(deptList);
    }

    @DeleteMapping("/{id}")
    public Result del(@PathVariable Integer id){
        log.info("根据id删除",id);
        deptService.del(id);
        return Result.success();
    }
    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("新增部门：{}",dept);
        deptService.add(dept);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("要更改id为{} 部门信息",id);
        Dept dept=deptService.getById(id);
        return Result.success(dept);
    }
    @PutMapping
    public Result updateById(@RequestBody Dept dept){
        log.info("更改部门:{}",dept);
        deptService.updateById(dept);
        return  Result.success();
    }

   /* //更新部门
    @PutMapping
    public Result update(@RequestBody Dept dept){
        deptService.update(dept);
        return Result.success();
    }*/
}
