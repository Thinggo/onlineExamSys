<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<script type="text/javascript">
    $(function () {
        //getButton("course");
    	ui_course_init_list();
    });
	var baseUrl = "courseServlet.do";
    function ui_course_init_list(){
        $("#ui_course_dg").datagrid({       //初始化datagrid
            url: baseUrl+"?action=list",
            striped: true, rownumbers: true, pagination: true, pageSize: 20,
            idField: 'id',
            sortName: 'id',
            sortOrder: 'desc',
            pageList: [20, 40, 60, 80, 100],
            frozenColumns: [[
                { field: 'ck', checkbox: true },
                {
                    width: 100,
                    title: '名称',
                    field: 'name',
                    sortable: true,
                    formatter: function (value, row, index) {
                        return value.length > 10 ? '<span title="' + value + '">' + value + '</span>' : value;
                    }
                }
            ]],
            columns: [[

                { field: 'code', title: '编码', sortable: true, width: 100 },
                { field: 'deptId', title: '部门', sortable: true, width: 200},
                {
                    field: 'remark', title: '课程说明', width: 200,
                    formatter: function (value, row, index) {
                        return value.length > 50 ? '<span title="' + value + '">' + value + '</span>' : value;
                    }
                }, 
          		{ field: 'teacherId', title: '教师', sortable: true, width: 130 }
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
            }
            ]
        });
        //回车搜索
        $("#ui_course_search").find('input').on('keyup', function (event) {
            if (event.keyCode == '13') {
                ui_course_searchdata();
            }
        });
    }
    //添加
    function ui_course_add() {
        $("<div/>").dialog({
            id: "ui_course_add_dialog",
            href: "courseEdit.jsp",
            title: "新增课程",
            iconCls:"icon-add",
            height: 250,
            width: 460,
            modal: true,
            buttons: [{
                id: "ui_course_add_btn",
                text: '添 加',
                iconCls: "icon-add",
                handler: function () {
                    $("#ui_course_editform").form("submit", {
                        url: baseUrl,
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
                                $("#ui_course_dg").datagrid("reload");
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
        var row = $("#ui_course_tg").treegrid("getSelected");
        if (!row) {
            $.show_warning("提示", "请先选择要修改的课程");
            return;
        }
        $("<div/>").dialog({
            id: "ui_course_edit_dialog",
            href: "admin/courseEdit.html",
            title: "修改区域",
            iconCls: "icon-edit",
            height: 250,
            width: 460,
            modal: true,
            buttons: [{
                id: "ui_course_edit_btn",
                text: '修 改',
                iconCls: "icon-edit",
                handler: function () {
                    $("#ui_course_editform").form("submit", {
                        url: "courseServlet.do",
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
                                $("#ui_course_tg").treegrid("reload");
                            } else {
                                $('#ui_course_edit_btn').linkbutton('enable');    //恢复按钮
                                $.show_warning("提示", dataJson.msg);
                            }
                        }
                    });
                }
            }],
            onLoad: function () {
                $("#ui_course_name_edit").textbox("setValue", row.text);
                $("#ui_course_code_edit").textbox("setValue", row.code);
                $("#ui_course_scode_edit").textbox("setValue", row.scode);
                $('#ui_course_sort_edit').numberspinner('setValue', row.sort);
                if (row.pcode)
                    $('#ui_course_pcode_edit').combotree('setValue', row.pcode);
            },
            onClose: function () {
                $("#ui_course_edit_dialog").dialog('destroy');  //销毁dialog对象
            }
        });
    }
    //删除区域
    function ui_course_delete() {
        var row = $("#ui_course_tg").datagrid("getSelected");
        if (rows.length < 1) {
            $.show_warning("提示", "请先勾选要删除的Bug");
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
                    url: baseUrl,
                    data: para,
                    type: "POST",
                    dataType: "json",
                    success: function (data) {
                        if (data.success) {
                            $.show_warning("提示", "删除成功！");
                            $("#ui_bug_dg").datagrid("reload").datagrid('clearSelections').datagrid('clearChecked');
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