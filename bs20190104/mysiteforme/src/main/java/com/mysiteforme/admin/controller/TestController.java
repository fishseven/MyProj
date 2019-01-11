package com.mysiteforme.admin.controller;


import com.mysiteforme.admin.entity.emp.EmpCompanyDetail;
import com.mysiteforme.admin.service.emp.EmpCompanyDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping(value = "/test",method ={ RequestMethod.GET, RequestMethod.POST })
public class TestController {
    @Autowired
    private EmpCompanyDetailService empCompanyDetailService;

    @PostMapping("/selectById.do")
    @ResponseBody
    public List<EmpCompanyDetail> selectById(){
        return empCompanyDetailService.selectById();
    }
}
