<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script type="text/javascript">
	var question = "";
	var options=[];
	var answer = [];
	var explain = "";
	var modurl="questionServlet.do";
	$(function() {
		ui_question_init_list();
	});
	
	
	function ui_question_init_list(){
    	
        $("#ui_question_dg").datagrid({       //初始化datagrid
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
				{
                    field: 'title', title: '试题题干', width: 400,
                    formatter: function (value, row, index) {                    	
                        return value && value.length > 50 ? '<span title="' + value + '">' + value + '</span>' : value;
                    }
                }, 
                { field: 'typeid', title: '试题内型', sortable: true,width: 80 },
                { field: 'difficulty', title: '难度系数', sortable: true, width: 80 },
                { field: 'courseId', title: '所属课程', sortable: true, width: 120},                
          		{ field: 'courseunitId', title: '课程单元', sortable: true, width: 120 }          		
            ]],
            //toolbar: toolbar.length == 0 ? null : toolbar
            toolbar: [{
                text: '添加',
                iconCls: 'icon-add',
                handler: function () { ui_question_add(); }
            }, {
                text: '修改',
                iconCls: 'icon-edit',
                handler: function () { ui_question_edit(); }
            }, {
                text: '删除',
                iconCls: 'icon-remove',
                handler: function () { ui_question_delete(); }
            }, {
                text: '审核',
                iconCls: 'icon-remove',
                handler: function () { ui_question_audit(); }
            }
            ]
        });       
    }
	
	
	
    function ui_question_init_editor(){
		$('#ui_question_course').combobox( {
			url : 'courseServlet.do?action=list',
			method : 'get',
			valueField : 'id',
			textField : 'name',
			panelHeight : 'auto',
			editable : false,
			icons : [ {
				iconCls : 'icon-tip'
			} ],
			formatter : function(row) {
				var s = '<span style="font-weight:bold">' + row.name
						+ '</span><br/>';
				return s;
			},
			onSelect : function(row) {
				alert(row.id);
			}
		});
		$('#ui_question_course_unit').combobox( {
			url : 'courseServlet.do?action=listUnit',
			method : 'get',
			valueField : 'id',
			textField : 'name',
			panelHeight : 'auto',
			editable : false,
			icons : [ {
				iconCls : 'icon-tip'
			} ],
			formatter : function(row) {
				var s = '<span style="font-weight:bold">' + row.name
						+ '</span><br/>';
				return s;
			},
			onSelect : function(row) {
				alert(row.id);
			}
		});
		$('#ui_question_questionType').combobox({
			url : 'questionServlet.do?action=questionType',
			method : 'get',
			valueField : 'id',
			textField : 'text',
			panelHeight : 'auto',
			editable : false,
			icons : [ {
				iconCls : 'icon-tip'
			} ],
			formatter : function(row) {
				var s = '<span style="font-weight:bold">' + row.text
						+ '</span><br/>';
				return s;
			},
			onSelect : function(row) {
				ui_question_option_init(row.id);				
			}
		});	
	}
    
    function ui_question_add(){
		ui_question_editor("添加试题");
		
	}

	
	/*
	* 打开编辑器进行操作
	* title:编辑器标题
	* op:操作类型  0-输入题干，-1-解析,1-n:选项
	*/
    function ui_question_editor(title,op) {
        $("<div/>").dialog({   
        	id: "ui_question_editor_dialog",
        	href:'editor.html',
            title: title,
            iconCls:"icon-add",
            height: 560,
            width: 820,
            modal: true,
            buttons: [{
                id: "ui_question_editor_save_btn",
                text: '保存试题',
                iconCls: "icon-save",
                handler: function () {           
                	var content = UE.getEditor('ui_exam_editor').getContent();                	
                	saveCurrent2();
                	
                	var question = $('#hiddenQuestion').val();
                	if(question.length==0 || $("<div>"+question+"</div>").text().length==0){
                		 $.show_alert("提示", "题干不能为空！");
                		return;
                	}
                	
                	var explain = $('#hiddenExplain').val();                	                
                	var len = $('[name=hiddenOption]').length;
                	var options = [];
                	var answer = [];
                	var optype = $('#ui_question_questionType').combobox("getValue");
                	if(optype==1 || optype==2 || optype==3){
                		var str="A";
            			var code = str.charCodeAt();            			
	                	for(var i=1;i<=len;i++){
	                		var n = String.fromCharCode(code+i-1); 
	                		var opt = $('#hiddenOption'+i).val();
	                		if(opt.length==0 || $("<div>"+opt+"</div>").text().length==0){
		                   		 $.show_alert("提示", "选项"+ n +"不能为空！");
		                   		return;
		                   	}
	                		options.push(opt);
	                	}
	                	
	                	$('[name=ui_question_answer]:checked').each(function(){
	                		var v= $(this).attr('value');
	                		answer.push(v);
	                	});
	                	
	                	if(answer.length==0){
	                		 $.show_alert("提示", "答案不能为空！");
		                 	 return;
	                	}
	                	
                	}
                	if(optype>=5){
                		var ans = $('#hiddenAnswer').val();
                		answer.push(ans);
                	}
                	$("#ui_question_editor_dialog").dialog('destroy');
                	UE.getEditor('ui_exam_editor').destroy(); 
                }
            },{
                id: "ui_question_editor_view_btn",
                text: '预览试题',
                iconCls: "icon-search",
                handler: function () {         
                	saveCurrent();
                	var question = $('#hiddenQuestion').val();                	
                	$('#view_question_content').html("<span style='float:left;color:blue'>题干：</span><div>"+question+"</div>");
                	
                	var explain = $('#hiddenExplain').val();
                	$('#view_question_explain').html("<span style='float:left;color:pink'>答案解析：</span><div>"+explain+"</div>");
                	
                	var len = $('[name=hiddenOption]').length;
                	var options = "";
                	for(var i=1;i<=len;i++){  
                		var str="A";
            			var code = str.charCodeAt();
            			var n = String.fromCharCode(code+i-1);                		
                		var opt = $('#hiddenOption'+i).val();
                		options += "<div style='padding-top:5px'><span style='float:left;color:green'>"+n+". </span>"+opt + "</div>";                		
                	}
                	$('#view_question_option').html(options);
                	var answer = [];
                	$('[name=ui_question_answer]:checked').each(function(){
                		var v= $(this).attr('value');
                		answer.push(v);
                	});
                	$('#view_question_answer').html("<span style='float:left;color:red'>参考答案：</span><div>"+answer.join(',')+"</div>");
                	uParse('#question_view_div', { rootPath: 'ueditor/'});
                	$('#question_view_div').dialog({
                		title: '试题预览',
                        iconCls:"icon-search",
                        height: 400,
                        width: 600,
                        modal: true
                	});
                	
                }
            }],
            onLoad: function () {            
            	ui_question_init_editor();
            	var ue = UE.getEditor('ui_exam_editor');              	
            	$('#btn_question_question').linkbutton({iconCls:"icon-edit"});    
            	$('#ui_question_questionType').combobox('setValue',1);
            	ue.addListener("ready", function () {                    
                    ue.setContent("ok");
          		});
            	
            },
            onClose: function () {
            	$("#ui_question_editor_dialog").dialog('destroy');
            	UE.getEditor('ui_exam_editor').destroy();                   	
            }
        });
    }
</script>
<div id="ui_layout" class="easyui-layout"
	data-options="fit:true,border:false">
	<div data-options="region:'center',border:false">
		<table id="ui_question_dg" data-options="fit:true,border:false">
        </table>
	</div>
	<div id="question_view_div" style="padding:20px">
		<div id="view_question_content" style="padding-top:10px;clear:both"></div>
		<div id="view_question_option" style="padding-top:10px;clear:both"></div>
		<div id="view_question_answer" style="padding-top:10px;clear:both"></div>
		<div id="view_question_explain" style="padding-top:10px;clear:both"></div>
	</div>
</div>