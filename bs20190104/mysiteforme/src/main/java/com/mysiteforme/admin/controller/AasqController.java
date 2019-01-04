package com.mysiteforme.admin.controller;

import com.xiaoleilu.hutool.date.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.mysiteforme.admin.entity.Aasq;
import com.mysiteforme.admin.service.AasqService;
import com.baomidou.mybatisplus.plugins.Page;
import com.mysiteforme.admin.util.LayerData;
import com.mysiteforme.admin.util.RestResponse;
import com.mysiteforme.admin.annotation.SysLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;

import javax.servlet.ServletRequest;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * qs  前端控制器
 * </p>
 *
 * @author wangl
 * @since 2018-12-22
 */
@Controller
@RequestMapping("/admin/aasq")
public class AasqController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AasqController.class);

    @Autowired
    private AasqService aasqService;

    @GetMapping("list")
    @SysLog("跳转qs列表")
    public String list(){
        return "/admin/aasq/list";
    }

    @PostMapping("list")
    @ResponseBody
    @SysLog("请求qs列表数据")
    public LayerData<Aasq> list(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                      @RequestParam(value = "limit",defaultValue = "10")Integer limit,
                                      ServletRequest request){
        Map map = WebUtils.getParametersStartingWith(request, "s_");
        LayerData<Aasq> layerData = new LayerData<>();
        EntityWrapper<Aasq> wrapper = new EntityWrapper<>();
        wrapper.eq("del_flag",false);
        if(!map.isEmpty()){
            String qqq = (String) map.get("qqq");
            if(StringUtils.isNotBlank(qqq)) {
                wrapper.like("qqq",qqq);
            }else{
                map.remove("qqq");
            }

        }
        Page<Aasq> pageData = aasqService.selectPage(new Page<>(page,limit),wrapper);
        layerData.setData(pageData.getRecords());
        layerData.setCount(pageData.getTotal());
        return layerData;
    }

    @GetMapping("add")
    @SysLog("跳转新增qs页面")
    public String add(){
        return "/admin/aasq/add";
    }

    @PostMapping("add")
    @SysLog("保存新增qs数据")
    @ResponseBody
    public RestResponse add(Aasq aasq){
        aasqService.insert(aasq);
        return RestResponse.success();
    }

    @GetMapping("edit")
    @SysLog("跳转编辑qs页面")
    public String edit(Long id,Model model){
        Aasq aasq = aasqService.selectById(id);
        model.addAttribute("aasq",aasq);
        return "/admin/aasq/edit";
    }

    @PostMapping("edit")
    @ResponseBody
    @SysLog("保存编辑qs数据")
    public RestResponse edit(Aasq aasq){
        if(null == aasq.getId() || 0 == aasq.getId()){
            return RestResponse.failure("ID不能为空");
        }
        aasqService.updateById(aasq);
        return RestResponse.success();
    }

    @PostMapping("delete")
    @ResponseBody
    @SysLog("删除qs数据")
    public RestResponse delete(@RequestParam(value = "id",required = false)Long id){
        if(null == id || 0 == id){
            return RestResponse.failure("ID不能为空");
        }
        Aasq aasq = aasqService.selectById(id);
        aasq.setDelFlag(true);
        aasqService.updateById(aasq);
        return RestResponse.success();
    }

}