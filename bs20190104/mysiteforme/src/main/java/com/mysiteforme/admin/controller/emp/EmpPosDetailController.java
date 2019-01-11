package com.mysiteforme.admin.controller.emp;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.mysiteforme.admin.annotation.SysLog;
import com.mysiteforme.admin.entity.emp.EmpPosDetail;
import com.mysiteforme.admin.service.emp.EmpPosDetailService;
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
import java.util.Map;

/**
 * <p>
 * 职位明细  前端控制器
 * </p>
 *
 * @author root
 * @since 2019-01-05
 */
@Controller
@RequestMapping("/admin/empPosDetail")
public class EmpPosDetailController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmpPosDetailController.class);

    @Autowired
    private EmpPosDetailService empPosDetailService;

    @GetMapping("list")
    @SysLog("跳转职位明细列表")
    public String list(){
        return "/admin/empPosDetail/list";
    }

    @PostMapping("list")
    @ResponseBody
    @SysLog("请求职位明细列表数据")
    public LayerData<EmpPosDetail> list(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                        @RequestParam(value = "limit",defaultValue = "10")Integer limit,
                                        ServletRequest request){
        Map map = WebUtils.getParametersStartingWith(request, "s_");
        LayerData<EmpPosDetail> layerData = new LayerData<>();
        EntityWrapper<EmpPosDetail> wrapper = new EntityWrapper<>();
        wrapper.eq("del_flag",false);
        if(!map.isEmpty()){
            String posId = (String) map.get("posId");
            if(StringUtils.isNotBlank(posId)) {
                wrapper.like("pos_id",posId);
            }else{
                map.remove("posId");
            }

            String posName = (String) map.get("posName");
            if(StringUtils.isNotBlank(posName)) {
                wrapper.like("pos_name",posName);
            }else{
                map.remove("posName");
            }

            String posCompId = (String) map.get("posCompId");
            if(StringUtils.isNotBlank(posCompId)) {
                wrapper.like("pos_comp_id",posCompId);
            }else{
                map.remove("posCompId");
            }

            String posCompName = (String) map.get("posCompName");
            if(StringUtils.isNotBlank(posCompName)) {
                wrapper.like("pos_comp_name",posCompName);
            }else{
                map.remove("posCompName");
            }

            String posType = (String) map.get("posType");
            if(StringUtils.isNotBlank(posType)) {
                wrapper.like("pos_type",posType);
            }else{
                map.remove("posType");
            }

        }
        Page<EmpPosDetail> pageData = empPosDetailService.selectPage(new Page<>(page,limit),wrapper);
        layerData.setData(pageData.getRecords());
        layerData.setCount(pageData.getTotal());
        return layerData;
    }

    @GetMapping("add")
    @SysLog("跳转新增职位明细页面")
    public String add(){
        return "/admin/empPosDetail/add";
    }

    @PostMapping("add")
    @SysLog("保存新增职位明细数据")
    @ResponseBody
    public RestResponse add(EmpPosDetail empPosDetail){
        empPosDetailService.insert(empPosDetail);
        return RestResponse.success();
    }

    @GetMapping("edit")
    @SysLog("跳转编辑职位明细页面")
    public String edit(Long id,Model model){
        EmpPosDetail empPosDetail = empPosDetailService.selectById(id);
        model.addAttribute("empPosDetail",empPosDetail);
        return "/admin/empPosDetail/edit";
    }

    @PostMapping("edit")
    @ResponseBody
    @SysLog("保存编辑职位明细数据")
    public RestResponse edit(EmpPosDetail empPosDetail){
        if(null == empPosDetail.getId() || 0 == empPosDetail.getId()){
            return RestResponse.failure("ID不能为空");
        }
        empPosDetailService.updateById(empPosDetail);
        return RestResponse.success();
    }

    @PostMapping("delete")
    @ResponseBody
    @SysLog("删除职位明细数据")
    public RestResponse delete(@RequestParam(value = "id",required = false)Long id){
        if(null == id || 0 == id){
            return RestResponse.failure("ID不能为空");
        }
        EmpPosDetail empPosDetail = empPosDetailService.selectById(id);
        empPosDetail.setDelFlag(true);
        empPosDetailService.updateById(empPosDetail);
        return RestResponse.success();
    }

}