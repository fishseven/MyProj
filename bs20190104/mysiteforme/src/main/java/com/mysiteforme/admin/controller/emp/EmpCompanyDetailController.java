package com.mysiteforme.admin.controller.emp;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.mysiteforme.admin.annotation.SysLog;
import com.mysiteforme.admin.entity.emp.EmpCompanyDetail;
import com.mysiteforme.admin.service.emp.EmpCompanyDetailService;
import com.mysiteforme.admin.util.LayerData;
import com.mysiteforme.admin.util.RestResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;

import javax.servlet.ServletRequest;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 企业明细  前端控制器
 * </p>
 *
 * @author root
 * @since 2019-01-05
 */
@Controller
@RequestMapping("/admin/empCompanyDetail")
public class EmpCompanyDetailController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmpCompanyDetailController.class);

    @Autowired
    private EmpCompanyDetailService empCompanyDetailService;

    @GetMapping("list")
    @SysLog("跳转企业明细列表")
    public String list(){
        return "/admin/empCompanyDetail/list";
    }

    @PostMapping("list")
    @ResponseBody
    @SysLog("请求企业明细列表数据")
    public LayerData<EmpCompanyDetail> list(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                            @RequestParam(value = "limit",defaultValue = "10")Integer limit,
                                            ServletRequest request){
        Map map = WebUtils.getParametersStartingWith(request, "s_");
        LayerData<EmpCompanyDetail> layerData = new LayerData<>();
        EntityWrapper<EmpCompanyDetail> wrapper = new EntityWrapper<>();
        wrapper.eq("del_flag",false);
        if(!map.isEmpty()){
            String companyName = (String) map.get("companyName");
            if(StringUtils.isNotBlank(companyName)) {
                wrapper.like("company_name",companyName);
            }else{
                map.remove("companyName");
            }

            String companyType = (String) map.get("companyType");
            if(StringUtils.isNotBlank(companyType)) {
                wrapper.like("company_type",companyType);
            }else{
                map.remove("companyType");
            }

        }
        Page<EmpCompanyDetail> pageData = empCompanyDetailService.selectPage(new Page<>(page,limit),wrapper);
        layerData.setData(pageData.getRecords());
        layerData.setCount(pageData.getTotal());
        return layerData;
    }

    @GetMapping("add")
    @SysLog("跳转新增企业明细页面")
    public String add(){
        return "/admin/empCompanyDetail/add";
    }

    @PostMapping("add")
    @SysLog("保存新增企业明细数据")
    @ResponseBody
    public RestResponse add(EmpCompanyDetail empCompanyDetail){
        empCompanyDetailService.insert(empCompanyDetail);
        return RestResponse.success();
    }

    @GetMapping("edit")
    @SysLog("跳转编辑企业明细页面")
    public String edit(Long id,Model model){
        EmpCompanyDetail empCompanyDetail = empCompanyDetailService.selectById(id);
        model.addAttribute("empCompanyDetail",empCompanyDetail);
        return "/admin/empCompanyDetail/edit";
    }

    @PostMapping("edit")
    @ResponseBody
    @SysLog("保存编辑企业明细数据")
    public RestResponse edit(EmpCompanyDetail empCompanyDetail){
        if(null == empCompanyDetail.getId() || 0 == empCompanyDetail.getId()){
            return RestResponse.failure("ID不能为空");
        }
        empCompanyDetailService.updateById(empCompanyDetail);
        return RestResponse.success();
    }

    @PostMapping("delete")
    @ResponseBody
    @SysLog("删除企业明细数据")
    public RestResponse delete(@RequestParam(value = "id",required = false)Long id){
        if(null == id || 0 == id){
            return RestResponse.failure("ID不能为空");
        }
        EmpCompanyDetail empCompanyDetail = empCompanyDetailService.selectById(id);
        empCompanyDetail.setDelFlag(true);
        empCompanyDetailService.updateById(empCompanyDetail);
        return RestResponse.success();
    }


    @PostMapping("selectById")
    @ResponseBody
    public List<EmpCompanyDetail> selectById(){
        return empCompanyDetailService.selectById();
    }
}