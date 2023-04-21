package com.example.controller;

import com.example.pojo.Emp;
import com.example.pojo.PageBean;
import com.example.pojo.Result;
import com.example.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;
    @GetMapping
    public Result page(@RequestParam (defaultValue = "1") Integer page,
                       @RequestParam (defaultValue = "10")Integer pageSize,
                       String name,
                       Short gender,
                      @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate end){
        log.info("查询了 {}:{},{},{},{},{}",page,pageSize,name,gender,begin,end);
        PageBean pageBean=empService.page(page,pageSize,name,gender,begin,end);

        return Result.success(pageBean);
    }

    @DeleteMapping("/{ids}")
    public Result del(@PathVariable List<Integer> ids){
        empService.del(ids);
        return Result.success();
    }
    @PostMapping
    public Result add(@RequestBody Emp emp){
        log.info("新增了:{}",emp);
        empService.add(emp);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("要更改员工id :{}的信息",id);
        Emp emp=empService.getById(id);
        return Result.success(emp);
    }
    @PutMapping
    public Result update(@RequestBody Emp emp){
        empService.update(emp);
        return Result.success();
    }
}
