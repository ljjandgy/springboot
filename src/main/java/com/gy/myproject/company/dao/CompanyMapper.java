package com.gy.myproject.company.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.gy.myproject.company.model.Company;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;


/**
 * @Author: GY
 * @Date: 2018/8/30 14:17
 */
@Repository
public interface CompanyMapper extends BaseMapper<Company> {

}
