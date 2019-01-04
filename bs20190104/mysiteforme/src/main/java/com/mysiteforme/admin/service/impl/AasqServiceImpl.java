package com.mysiteforme.admin.service.impl;

import com.mysiteforme.admin.entity.Aasq;
import com.mysiteforme.admin.dao.AasqDao;
import com.mysiteforme.admin.service.AasqService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * qs 服务实现类
 * </p>
 *
 * @author wangl
 * @since 2018-12-22
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AasqServiceImpl extends ServiceImpl<AasqDao, Aasq> implements AasqService {

}
