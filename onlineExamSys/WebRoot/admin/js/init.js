$(function () {
    initLogin();
})

function initLogin() {
    $('#treeLeft').tree({    //初始化左侧功能树（不同用户显示的树是不同的）
        method: 'GET',
        url: 'menuServlet.do?action=listSysMenu',
        lines: true,        
        onClick: function (node) {    //点击左侧的tree节点  打开右侧tabs显示内容
            if (node.url) {
                addTab(node.text, node.url, node.iconCls);
            }
        }
    });
/*
    $.ajax({
        url: "teacherServlet.do",
        type: "post",
        data: { action: "getuser" },
        dataType: "json",
        success: function (result) {
            if (result.success) {
                var user = JSON.parse(result.msg);
                $("#div_welcome").html("当前登录用户：" + user.userName);
            }
            else {
                //直接访问index页面没有cookie不会发这个ajax请求的，而是被FormsAuthentication带到了登录页面了
                //这个else是有cookie，但是cookie里的用户再次验证的时候发现数据库里的当前用户已经修改密码/设置不可用等，然后干掉了cookie
                window.location.href = "login.html";
            }
        }
    });
*/    
}

function addTab(subtitle, url, icon) {
    if (!$('#tabs').tabs('exists', subtitle)) {
        $('#tabs').tabs('add', {
            title: subtitle,
            href: url,
            iconCls: icon,
            closable: true,
            loadingMessage: '正在加载中......'
        });
    } else {
        $('#tabs').tabs('select', subtitle);
    }
}

function refreshTab() {
    var index = $('#tabs').tabs('getTabIndex', $('#tabs').tabs('getSelected'));
    if (index != -1) {
        $('#tabs').tabs('getTab', index).panel('refresh');
    }
}

function closeTab() {
    $('.tabs-inner span').each(function (i, n) {
        var t = $(n).text();
        if (t != '') {
            $('#tabs').tabs('close', t);
        }
    });
}

//查看当前用户信息
function searchMyInfo() {
    $("<div/>").dialog({
        id: "ui_myinfo_dialog",
        href: "html/ui_myinfo.html",
        title: "我的信息",
        iconCls:'icon-boss',
        height: 500,
        width: 580,
        modal: true,
        onLoad: function () {
            $.ajax({
                url: "ashx/rm_user.ashx?action=getUserInfo&t=" + new Date().getTime(),
                type: "post",
                dataType: "json",
                success: function (user) {
                    $("#ui_myinfo_username").html(user.userName);
                    $("#ui_myinfo_realname").html(user.realName);
                    $("#ui_myinfo_adddate").html(user.addDate);
                    $("#ui_myinfo_roles").html(user.roleNames.length > 12 ? "<span title=" + user.roleNames + ">" + user.roleNames.substring(0, 12) + "...</span>" : user.roleNames);
                    $("#ui_myinfo_departments").html(user.deptNames.length > 12 ? "<span title=" + user.deptNames + ">" + user.deptNames.substring(0, 12) + "...</span>" : user.deptNames);
                    //长度超过12个字符就隐藏
                }
            });

            $('#ui_myinfo_authority').tree({
                url: "ashx/rm_menu.ashx?action=getMyAuthority&timespan=" + new Date().getTime(),
                onlyLeafCheck: true,
                checkbox: true
            });
        },
        onClose: function () {
            $("#ui_myinfo_dialog").dialog('destroy');  //销毁dialog对象
        }
    });
}

//修改密码
function changePwd() {
    $("<div/>").dialog({
        id: "ui_user_changepwd_dialog",
        href: "html/ui_user_changepwd.html",
        title: "修改密码",
        iconCls:'icon-set',
        height: 240,
        width: 380,
        modal: true,
        closable: false,
        buttons: [{
            id: "ui_user_changepwd_edit",
            text: '修 改',
            iconCls:'icon-edit',
            handler: function () {
                $("#ui_user_changepwd_form").form("submit", {
                    url: "ashx/rm_user.ashx",
                    onSubmit: function (param) {
                        $('#ui_user_changepwd_edit').linkbutton('disable');  //点击就不可用，防止连击
                        param.action = 'changepwd';
                        if ($(this).form('validate'))
                            return true;
                        else {
                            $('#ui_user_changepwd_edit').linkbutton('enable');   //恢复按钮
                            return false;
                        }
                    },
                    success: function (data) {
                        $('#ui_user_changepwd_edit').linkbutton('enable');       //恢复按钮
                        var dataBack = $.parseJSON(data);                       //序列化成对象
                        if (dataBack.success) {                            
                            alert(dataBack.msg);
                            window.location.href = "login.html";
                        }
                        else {
                            $('#ui_user_changepwd_edit').linkbutton('enable');
                            $.show_warning("提示", dataBack.msg);
                        }
                    }
                });
            }
        }, {
            text: '取 消',
            iconCls: 'icon-cancel',
            handler: function () { $("#ui_user_changepwd_dialog").dialog('destroy'); }
        }],
        onLoad: function () {
            $("#ui_user_changepwd_originalpwd").focus();
        }
    });
}

//退出系统
function loginOut() {
    if (confirm("确定退出当前陆登账户？")) {
        var para = { "action": "logout" };
        $.ajax({
            url: "teacherServlet.do",
            type: "post",
            data: para,
            dataType: "json",
            success: function (result) {
                if (result.success) {
                    window.location.href = "login.html";
                }
                else {
                    $.show_warning("提示", result.msg);
                }
            }
        })
    }
}