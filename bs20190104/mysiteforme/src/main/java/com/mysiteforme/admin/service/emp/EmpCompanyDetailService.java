package com.mysiteforme.admin.service.emp;

import com.baomidou.mybatisplus.service.IService;
import com.mysiteforme.admin.entity.emp.EmpCompanyDetail;

import java.util.List;

/**
 * <p>
 * 企业明细 服务类
 * </p>
 *
 * @author root
 * @since 2019-01-05
 */
public interface EmpCompanyDetailService extends IService<EmpCompanyDetail> {

    List<EmpCompanyDetail> selectById();
}
