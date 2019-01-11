package com.mysiteforme.admin.service.impl.emp;


import com.mysiteforme.admin.dao.EmpCompanyDetailDao;
import com.mysiteforme.admin.entity.emp.EmpCompanyDetail;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.mysiteforme.admin.service.emp.EmpCompanyDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 企业明细 服务实现类
 * </p>
 *
 * @author root
 * @since 2019-01-05
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class EmpCompanyDetailServiceImpl extends ServiceImpl<EmpCompanyDetailDao, EmpCompanyDetail> implements EmpCompanyDetailService {
    @Autowired
    EmpCompanyDetailService empCompanyDetailService;
    @Override
    public List<EmpCompanyDetail> selectById() {
        return empCompanyDetailService.selectById();
    }
}
