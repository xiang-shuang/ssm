<%--
  Created by IntelliJ IDEA.
  User: Hello world
  Date: 2020/6/30
  Time: 22:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员的管理页面</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/themes/icon.css">

    <%--下面三个js文件必须是按顺序进行，不能搞乱顺序--%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN.js"></script>

    <script type="text/javascript">
        $(function () {
            /*jquery easyui的代码在这里写*/
            $('#tt').tree({
                onClick : function(node) {
                    /*单击导航栏中的管理员列表结点*/
                    if(node.id == "adminlistall"){
                        /*单击管理员列表时把中间区域的标题设置为管理管理*/
                        $(".layout-panel-center .panel-title").text("管理员信息列表");
                        //动态加js文件
                        if(typeof(initadmin) !="function"){
                            $.getScript("../js/admin.js",function(){
                                initadmin();
                            })
                        }else{
                            initadmin();
                        }
                    }

                    /*单击导航栏中的单位信息列表结点*/
                    if (node.id == "departmentlist") {
                        /*单击单位列表时把中间区域的标题设置为单位信息列表*/
                        $(".layout-panel-center .panel-title").text("单位信息列表");
                        if(typeof(initdepartment) !="function"){
                            $.getScript("../js/department.js",function(){
                                initdepartment();
                            })
                        }else{
                            initdepartment();
                        }
                    }

                    /*单击导航栏中的专业信息列表结点*/
                    if (node.id == "majorlist") {
                        /*单击专业列表时把中间区域的标题设置为管理管理*/
                        $(".layout-panel-center .panel-title").text("专业信息列表");
                        if(typeof(initmajor) !="function"){
                            $.getScript("../js/major.js",function(){
                                initmajor();
                            })
                        }else{
                            initmajor();
                        }
                    }

                    /*单击导航栏中的班级信息列表结点*/
                    if (node.id == "classselist") {
                        /*单击班级列表时把中间区域的标题设置为班级信息列表*/
                        $(".layout-panel-center .panel-title").text("班级信息列表");
                        //动态加js文件
                        if(typeof(initclassse) !="function"){
                            $.getScript("../js/classse.js",function(){
                                initclassse();
                            })
                        }else{
                            initclassse();
                        }
                    }

                    /*单击导航栏中的教师信息列表结点*/
                    if (node.id == "teacherlist") {
                        /*单击教师信息列表时把中间区域的标题设置为信息列表*/
                        $(".layout-panel-center .panel-title").text("教师信息列表");
                        //动态加js文件
                        if(typeof(initteacher) !="function"){
                            $.getScript("../js/teacher.js",function(){
                                initteacher();
                            })
                        }else{
                            initteacher();
                        }
                    }

                    /*单击导航栏中的层次信息列表结点*/
                    if (node.id == "levelslist") {
                        /*单击教材层次列表列表时把中间区域的标题设置为教材层次列表*/
                        $(".layout-panel-center .panel-title").text("教材层次列表");
                        //动态加js文件
                        if(typeof(initlevels) !="function"){
                            $.getScript("../js/levels.js",function(){
                                initlevels();
                            })
                        }else{
                            initlevels();
                        }
                    }

                    /*单击导航栏中的类别信息列表结点*/
                    if (node.id == "categorylist") {
                        /*单击教材类别信息列表时把中间区域的标题设置为教材类别信息列表*/
                        $(".layout-panel-center .panel-title").text("教材类别信息列表");
                        //动态加js文件
                        if(typeof(initcategory) !="function"){
                            $.getScript("../js/category.js",function(){
                                initcategory();
                            })
                        }else{
                            initcategory();
                        }
                    }

                    /*单击导航栏中的出版社信息列表结点*/
                    if (node.id == "publisherlist") {
                        /*单击出版社信息列表时把中间区域的标题设置为出版社信息列表*/
                        $(".layout-panel-center .panel-title").text("出版社信息列表");
                        //动态加js文件
                        if(typeof(initpublisher) !="function"){
                            $.getScript("../js/publisher.js",function(){
                                initpublisher();
                            })
                        }else{
                            initpublisher();
                        }
                    }

                    /*单击导航栏中的课程信息列表结点*/
                    if (node.id == "courselist") {
                        /*单击课程信息列表时把中间区域的标题设置为课程信息列表*/
                        $(".layout-panel-center .panel-title").text("课程信息列表");
                        
                    }

                    

                    /*单击导航栏中的教材征订信息列表结点*/
                    if (node.id == "jclist") {
                        /*单击教材征订信息列表时把中间区域的标题设置为教材征订信息列表*/
                        $(".layout-panel-center .panel-title").text("教材征订信息列表");
                    }
                }
            });
        });
    </script>
</head>
<body class="easyui-layout" >
<%--这是北边的区域用于显示系统的主标题--%>
<div data-options="region:'north',split:true" style="mapping-left:10px; height:100px;font-size:46px;text-align: center;">基于ssm教材征订系统设计与应用</div>
<%--这是南边的区域用于显示系统的版权相关的信息--%>
<div data-options="region:'south',split:true" style="height:60px;"></div>
<!-- 布局中的东边区域去掉    <div data-options="region:'east',iconCls:'icon-reload',title:'East',split:true" style="width:100px;"></div>    -->
<%--这是西边的区域用于作为系统的侧边导航--%>
<div data-options="region:'west',title:'管理员操作导航',split:true" style="width:210px;">
    <%--下边的无序列表是构成我们的树型导航--%>
    <ul id="tt" class="easyui-tree">
        <li>
            <span>管理员管理</span>
            <ul>
                <li id="adminlistall">
                    <span>管理员信息列表</span>
                </li>
            </ul>
        </li>
        <li>
            <span style="padding: ">基本数据管理</span>
            <ul>
                <li id="departmentlist">
                    <span>单位信息列表</span>
                </li>
                <li id="majorlist">
                    <span>专业信息列表</span>
                </li>
                <li id="classselist">
                    <span>班级信息列表</span>
                </li>
                <li id="teacherlist">
                    <span>教师信息列表</span>
                </li>
                <li id="levelslist">
                    <span>教材层次信息列表</span>
                </li>
                <li id="categorylist">
                    <span>教材类别信息列表</span>
                </li>
                <li id="publisherlist">
                    <span>出版社信息列表</span>
                </li>
            </ul>
        </li>
        <li>
            <span>课程管理</span>
            <ul>
                <li id="courselist">
                    <span>课程信息列表</span>
                </li>

                <li id="jclist">
                    <span>教材征订信息列表</span>
                </li>
            </ul>
        </li>
        <li>
            <span>个人信息管理</span>
            <ul>
                <li id="adminlist">
                    <span>修改信息列表</span>
                </li>

                <li id="exitlist">
                    <span>退出系统</span>
                </li>
            </ul>
        </li>
    </ul>
</div>

<%--这是中间区域用于显示我们操作中心--%>
<div data-options="region:'center',title:'工作区域'" style="padding:5px;background:#eee;">
    <%--显示区域--%>
    <div id="tab"></div>
</div>

</body>
</html>
