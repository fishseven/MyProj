package com.mysiteforme.admin.service.impl.emp;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.mysiteforme.admin.dao.EmpPosDetailDao;
import com.mysiteforme.admin.entity.emp.EmpPosDetail;
import com.mysiteforme.admin.service.emp.EmpPosDetailService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 职位明细 服务实现类
 * </p>
 *
 * @author root
 * @since 2019-01-05
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class EmpPosDetailServiceImpl extends ServiceImpl<EmpPosDetailDao, EmpPosDetail> implements EmpPosDetailService {

}
