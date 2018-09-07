package com.gy.myproject.company.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.gy.myproject.company.model.Company;
import com.gy.myproject.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.gy.myproject.common.Common.SUCCESS_INFO;

/**
 * @Author: GY
 * @Date: 2018/8/30 14:13
 */
@Controller
@RequestMapping("/company")
public class CompanyController{
    @Autowired
    private CompanyService companyService;

    /**
    * @Description: 跳转到首页
    * @Author: GY
    * @Date: 2018/9/3
    */
    @RequestMapping("/view")
    public String index(){
        return "/company/company.html";
    }

    /**
     * @Description: 跳转到新增
     * @Author: GY
     * @Date: 2018/9/3
     */
    @RequestMapping("/company_add")
    public String adviceAdd() {
        return "/company/company_add.html";
    }

    /**
     * @Description: 跳转到首页
     * @Author: GY
     * @Date: 2018/9/3
     */
    @RequestMapping("/company_update/{compid}")
    public String adviceUpdate(@PathVariable String compid, Model model) {
        Company company = companyService.selectById(compid);
        model.addAttribute("item",company);
        return  "/company/advice_edit.html";
    }

    /**
     * @Description: 获取列表
     * @Author: GY
     * @Date: 2018/9/3
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition,
                       @RequestParam(value="pageNumber", defaultValue="1")int pageNumber,
                       @RequestParam(value="pageSize", defaultValue="20") int pageSize) {
        Wrapper<Company> ew = new EntityWrapper<Company>();
        Page<Company> page = new Page<Company>(pageNumber, companyService.selectCount(ew));
        Map<String, Object> map = new HashMap<String, Object>(5);
        page.setTotal(companyService.selectCount(ew));
        List<Company> list = companyService.selectPage(page, ew).getRecords();
        map.put("data", list);
        map.put("total",page.getTotal());
        return map;
    }

    /**
     * @Description: 新增
     * @Author: GY
     * @Date: 2018/9/3
     */
    @RequestMapping("/add")
    @ResponseBody
    public Object insert(Company company){
        companyService.insert(company);
        return SUCCESS_INFO;
    }

    /**
     * @Description: 修改
     * @Author: GY
     * @Date: 2018/9/3
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Company company) {
        companyService.updateById(company);
        return SUCCESS_INFO;
    }

    /**
     * @Description: 删除
     * @Author: GY
     * @Date: 2018/9/3
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam String compid) {
        List<String> ids = Arrays.asList(compid.split(","));
        companyService.deleteBatchIds(ids);
        return SUCCESS_INFO;
    }

    /**
     * @Description: 查看详情
     * @Author: GY
     * @Date: 2018/9/3
     */
    @RequestMapping(value = "/detail/{compid}")
    @ResponseBody
    public Object detail(@PathVariable("compid") String compid) {
        return companyService.selectById(compid);
    }
}
