/** 
* 在iframe中调用，在父窗口中出提示框(herf方式不用调父窗口)
*/
$.extend({
    show_warning: function (strTitle, strMsg) {
        $.messager.show({
            title: strTitle,
            width: 300,
            height: 100,
            msg: strMsg,
            closable: true,
            showType: 'slide',
            style: {
                right: '',
                top: document.body.scrollTop + document.documentElement.scrollTop,
                bottom: ''
            }
        });
    }
});

/** 
* 弹框
*/
$.extend({
    show_alert: function (strTitle, strMsg) {
        $.messager.alert(strTitle, strMsg);
    }
});

/**
* @author 孙宇
* 
* @requires jQuery,EasyUI
* 
* 扩展validatebox，添加验证两次密码功能
*/
$.extend($.fn.textbox.defaults.rules, {
    eqPwd: {
        validator: function (value, param) {
            return value == $(param[0]).val();
        },
        message: '密码不一致！'
    }
});

/**
* @author 风骑士
* 
* @requires jQuery,EasyUI
* 
* 初始化datagrid toolbar
*/
getToolBar = function (data) {
    if (data.toolbar != undefined && data.toolbar != '') {
        var toolbar = [];
        $.each(data.toolbar, function (index, row) {
            var handler = row.handler;
            row.handler = function () { eval(handler); };
            toolbar.push(row);
        });
        return toolbar;
    } else {
        return [];
    }
}

getButton = function (menucode) {
    $.ajax({     //请求当前用户可以操作的按钮
        url: "ashx/rm_button.ashx?menucode=" + menucode + "&pagename=" + "ui_" + menucode,
        type: "post",
        data: { "action": "getbutton" },
        dataType: "json",
        timeout: 5000,
        success: function (data) {
            if (data.success) {
                var toolbar = getToolBar(data);      //common.js
                if (data.browser) {     //判断是否有浏览权限                    
                    var func = eval("ui_" + menucode + "_init_list");
                    func(toolbar);
                }
                else {
                    $.show_warning("提示", "无权限，请联系管理员！");
                }
            } else {
                $.show_warning("错误", data.msg);
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            if (textStatus == "timeout") {
                $.show_warning("提示", "请求超时，请刷新当前页重试！");
            }
            else {
                $.show_warning("错误", textStatus + "：" + errorThrown);
            }
        }
    });
    //回车搜索
    $("#ui_loginlog_search").find('input').on('keyup', function (event) {
        if (event.keyCode == '13') {
            ui_loginlog_searchdata();
        }
    })
}

/**
* @author 孙宇
*
* 接收一个以逗号分割的字符串，返回List，list里每一项都是一个字符串（做编辑功能的时候 传入id 然后自动勾选combo系列组件）
*
* @returns list
*/
stringToList = function (value) {
    if (value != undefined && value != '') {
        var values = [];
        var t = value.split(',');
        for (var i = 0; i < t.length; i++) {
            values.push('' + t[i]); /* 避免将ID当成数字 */
        }
        return values;
    } else {
        return [];
    }
};