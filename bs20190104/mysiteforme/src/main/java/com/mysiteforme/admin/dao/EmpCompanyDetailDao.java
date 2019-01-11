package com.mysiteforme.admin.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.mysiteforme.admin.entity.emp.EmpCompanyDetail;

import java.util.List;

/**
 * <p>
 * 企业明细 Mapper 接口
 * </p>
 *
 * @author root
 * @since 2019-01-05
 */
public interface EmpCompanyDetailDao extends BaseMapper<EmpCompanyDetail> {

    List<EmpCompanyDetail> selectById();
}
