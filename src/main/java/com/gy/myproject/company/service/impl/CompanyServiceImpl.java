package com.gy.myproject.company.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.gy.myproject.company.dao.CompanyMapper;
import com.gy.myproject.company.model.Company;
import com.gy.myproject.company.service.CompanyService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @Author: GY
 * @Date: 2018/8/30 14:16
 */
@Service(value = "companyService")
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper,Company> implements CompanyService {
    @Autowired
    private CompanyMapper companyMapping;


}
