<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>职位明细编辑--${site.name}</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <meta name="description" content="${site.description}"/>
    <meta name="keywords" content="${site.keywords}"/>
    <meta name="author" content="${site.author}"/>
    <link rel="icon" href="${site.logo}">
    <link rel="stylesheet" href="${base}/static/layui/css/layui.css" media="all" />
    <style type="text/css">
        .layui-form-item .layui-inline{ width:33.333%; float:left; margin-right:0; }
        @media(max-width:1240px){
            .layui-form-item .layui-inline{ width:100%; float:none; }
        }
        .layui-form-item .role-box {
            position: relative;
        }
        .layui-form-item .role-box .jq-role-inline {
            height: 100%;
            overflow: auto;
        }

    </style>
</head>
<body class="childrenBody">
<form class="layui-form" style="width:80%;">
    <input value="${empPosDetail.id}" name="id" type="hidden">
    <div class="layui-form-item">
        <label class="layui-form-label">职位编号</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${empPosDetail.posId}" name="posId"  placeholder="请输入职位编号">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">职位名称</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${empPosDetail.posName}" name="posName"  placeholder="请输入职位名称">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">公司编号</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${empPosDetail.posCompId}" name="posCompId"  placeholder="请输入公司编号">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">公司名称</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${empPosDetail.posCompName}" name="posCompName"  placeholder="请输入公司名称">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">备注信息</label>
        <div class="layui-input-block">
                <input type="text" class="layui-input" name="posRemark" value = "${empPosDetail.posRemark}" placeholder="请输入备注信息">


        </div>
    </div>
    <div class="layui-form-item" hidden>
        <label class="layui-form-label"></label>
        <div class="layui-input-block">
                <input type="hidden" class="layui-input" name="posReamark2" id="posReamark2" value = "${empPosDetail.posReamark2}" >
                <div class="layui-upload-drag" id="posReamark2">
                  <i class="layui-icon"></i>
                  <p>点击上传，或将文件拖拽到此处</p>
                </div>

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">类型</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${empPosDetail.posType}" name="posType"  placeholder="请输入类型">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">人数</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${empPosDetail.posReqNum}" name="posReqNum"  placeholder="请输入人数">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label"></label>
        <div class="layui-input-block">
                <input type="text" class="layui-input" name="posPrice" value = "${empPosDetail.posPrice}" placeholder="请输入职位薪水">


        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">联系人名称</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${empPosDetail.posContactPer}" name="posContactPer"  placeholder="请输入联系人名称">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">联系人电话</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${empPosDetail.posContactPho}" name="posContactPho"  placeholder="请输入联系人电话">

        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="addEmpPosDetail">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>
<script type="text/javascript" src="${base}/static/layui/layui.js"></script>
<script>
    layui.use(['form','jquery','layer'],function(){
        var form      = layui.form,
                $     = layui.jquery,
                layer = layui.layer;


        form.on("submit(addEmpPosDetail)",function(data){
            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            //给角色赋值
            $.post("${base}/admin/empPosDetail/edit",data.field,function(res){
                layer.close(loadIndex);
                if(res.success){
                    parent.layer.msg("职位明细编辑成功！",{time:1000},function(){
                        parent.layer.close(parent.editIndex);
                        //刷新父页面
                        parent.location.reload();
                    });
                }else{
                    layer.msg(res.message);
                }
            });
            return false;
        });

    });
</script>
</body>
</html>