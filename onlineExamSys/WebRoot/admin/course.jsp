<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<script type="text/javascript">
	var modurl = "courseServlet.do";
    $(function () {
        //getButton("course");        
    	ui_course_init_list();
    });
	
    function ui_course_init_list(){
    	
        $("#ui_course_dg").datagrid({       //初始化datagrid
            url: modurl+"?action=search",
            striped: true, rownumbers: true, pagination: true, pageSize: 20,
            idField: 'id',
            sortName: 'id',
            sortOrder: 'desc',
            pageList: [20, 40, 60, 80, 100],
            frozenColumns: [[
                { field: 'ck', checkbox: true }
                
            ]],
            columns: [[
				{ field: 'name', title: '名称', sortable: true,width: 200 },
                { field: 'code', title: '编码', sortable: true, width: 100 },
                { field: 'deptName', title: '部门', sortable: true, width: 200},
                {
                    field: 'remark', title: '课程说明', width: 200,
                    formatter: function (value, row, index) {                    	
                        return value && value.length > 50 ? '<span title="' + value + '">' + value + '</span>' : value;
                    }
                }, 
          		{ field: 'teacherName', title: '教师', sortable: true, width: 130 },
          		{
                    field: 'courseStatus', title: '课程状态', width: 200,
                    formatter: function (value, row, index) {                     	
                    	if(value==1) return "审核通过";
                    	else if(value==2) return "考试";
                    	else if(value==3) return "练习";
                    	else return "未审核";
                    	
                    }
                }
            ]],
            //toolbar: toolbar.length == 0 ? null : toolbar
            toolbar: [{
                text: '添加',
                iconCls: 'icon-add',
                handler: function () { ui_course_add(); }
            }, {
                text: '修改',
                iconCls: 'icon-edit',
                handler: function () { ui_course_edit(); }
            }, {
                text: '删除',
                iconCls: 'icon-remove',
                handler: function () { ui_course_delete(); }
            }, {
                text: '审核',
                iconCls: 'icon-remove',
                handler: function () { ui_course_audit(); }
            }
            ]
        });       
    }
    //添加
    function ui_course_add() {
        $("<div/>").dialog({
            id: "ui_course_add_dialog",
            href: "courseEdit.jsp",
            title: "新增课程",
            iconCls:"icon-add",
            height: 400,
            width: 460,
            modal: true,
            buttons: [{
                id: "ui_course_add_btn",
                text: '添 加',
                iconCls: "icon-add",
                handler: function () {
                    $("#ui_course_editform").form("submit", {
                        url: modurl,
                        onSubmit: function (param) {
                            $('#ui_course_add_btn').linkbutton('disable');    //点击就禁用按钮，防止连击
                            param.action = 'add';
                            if ($(this).form('validate'))
                                return true;
                            else {
                                $('#ui_course_add_btn').linkbutton('enable');   //恢复按钮
                                return false;
                            }
                        },
                        success: function (data) {                        
                            var dataJson = eval('(' + data + ')');    //转成json格式
                            if (dataJson.success) {
                                $("#ui_course_add_dialog").dialog('destroy'); //销毁dialog对象
                                $.show_warning("提示", "添加成功！");
                                $("#ui_course_dg").datagrid("reload").datagrid('clearSelections').datagrid('clearChecked');
                            } else {
                                $('#ui_course_add_btn').linkbutton('enable');   //恢复按钮
                                $.show_warning("提示", dataJson.msg);
                            }
                        }
                    });
                }
            }],
            onLoad: function () {
                $("#ui_name_edit").focus();
            },
            onClose: function () {
                $("#ui_course_add_dialog").dialog('destroy');  //销毁dialog对象
            }
        });
    }
    //修改课程
    function ui_course_edit() {
    	var rows = $("#ui_course_dg").datagrid("getChecked");
        if (rows.length != 1) {
            $.show_warning("提示", "请先选择一门课程进行修改！");
            $("#ui_course_dg").datagrid('clearSelections').datagrid('clearChecked');
            return;
        }
        var row = rows[0];
        if(row['courseStatus'] >= 2){
        	$.show_warning("提示", "课程已经审核通过，不能再修改！");
        	return;
        }
        $("<div/>").dialog({
            id: "ui_course_edit_dialog",
            href: "courseEdit.jsp",
            title: "修改课程",
            iconCls: "icon-edit",
            height:400,
            width: 460,
            modal: true,
            buttons: [{
                id: "ui_course_edit_btn",
                text: '修 改',
                iconCls: "icon-edit",
                handler: function () {
                    $("#ui_course_editform").form("submit", {
                        url: modurl,
                        onSubmit: function (param) {
                            $('#ui_course_edit_btn').linkbutton('disable');   //点击就禁用按钮，防止连击
                            param.action = 'edit';
                            if ($(this).form('validate'))
                                return true;
                            else {
                                $('#ui_course_edit_btn').linkbutton('enable');   //恢复按钮
                                return false;
                            }
                        },
                        success: function (data) {
                            var dataJson = eval('(' + data + ')');    //转成json格式
                            if (dataJson.success) {
                                $("#ui_course_edit_dialog").dialog('destroy');  //销毁dialog对象
                                $.show_warning("提示", "修改成功！");
                                $("#ui_course_dg").datagrid("reload").datagrid('clearSelections').datagrid('clearChecked');
                            } else {
                                $('#ui_course_edit_btn').linkbutton('enable');    //恢复按钮
                                $.show_warning("提示", dataJson.msg);
                            }
                        }
                    });
                }
            }],
            onLoad: function () {
            	$("#ui_course_editform").form("load",row);
            },
            onClose: function () {
                $("#ui_course_edit_dialog").dialog('destroy');  //销毁dialog对象
            }
        });
    }
    function ui_course_audit(){
    	var rows = $("#ui_course_dg").datagrid("getChecked");
        if (rows.length < 1) {
            $.show_warning("提示", "请勾选要审核的课程");
            return;
        }
        $.messager.confirm('提示', '确定要审核通过勾选的这' + rows.length + '门课程吗？', function (r) {
            if (r) {
                para = {};
                para.action = "audit";
                para.timespan = new Date().getTime();

                var ids = [];
                $.each(rows, function (i, row) {
                    ids.push(row.id);
                });
                para.ids = ids.join(",");
                $.ajax({
                    url: modurl,
                    data: para,
                    type: "POST",
                    dataType: "json",
                    success: function (data) {
                        if (data.success) {
                            $.show_warning("提示", "审核成功！");
                            $("#ui_course_dg").datagrid("reload").datagrid('clearSelections').datagrid('clearChecked');
                        } else {
                            $.show_warning("提示", data.msg);
                        }
                    }
                });
            }
        });
    }
    //删除区域
    function ui_course_delete() {
        var rows = $("#ui_course_dg").datagrid("getChecked");
        if (rows.length < 1) {
            $.show_warning("提示", "请先勾选要删除的课程");
            return;
        }
        $.messager.confirm('提示', '确定删除勾选的这' + rows.length + '门课程吗？', function (r) {
            if (r) {
                para = {};
                para.action = "delete";
                para.timespan = new Date().getTime();

                var ids = [];
                $.each(rows, function (i, row) {
                    ids.push(row.id);
                });
                para.ids = ids.join(",");
                $.ajax({
                    url: modurl,
                    data: para,
                    type: "POST",
                    dataType: "json",
                    success: function (data) {
                        if (data.success) {
                            $.show_warning("提示", "删除成功！");
                            $("#ui_course_dg").datagrid("reload").datagrid('clearSelections').datagrid('clearChecked');
                        } else {
                            $.show_warning("提示", data.msg);
                        }
                    }
                });
            }
        });
    }
    
</script>
<div id="ui_layout" class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'center',border:false">
        <table id="ui_course_dg" data-options="fit:true,border:false">
        </table>
    </div>
</div>