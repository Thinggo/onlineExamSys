<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div style="padding: 15px; overflow: hidden">
    <form id="ui_course_editform" method="post">
        <table class="tableForm" style="width: 100%">
            <tr>
                <th style="width:30%">课程名称：
                </th>
                <td>
                    <input type="hidden"  name="id" id="ui_course_id" />
                    <input type="text" name="name" id="ui_course_name" class="easyui-textbox"
                        data-options="required:true" autocomplete="off" />
                </td>
            </tr>
            <tr>
                <th style="width:30%">编码：
                </th>
                <td>
                    <input type="text" name="code" id="ui_course_code" class="easyui-textbox" data-options="required:true"
                        autocomplete="off" />
                </td>
            </tr>  
            
            <tr>
                <th style="width:30%">状态：
                </th>
                <td>
                    <input type="text" name="courseStatus" id="ui_course_courseStatus" class="easyui-textbox"  autocomplete="off" />
                </td>
            </tr> 
            <tr>
                <th style="width:30%">课程负责人：
                </th>
                <td>
                    <input type="text" name="teacherid" id="ui_course_teacherid" class="easyui-textbox"  data-options="required:true" autocomplete="off" />
                </td>
            </tr>     
            <tr>
                <th style="width:30%">所属部门：
                </th>
                <td>
                    <input type="text" name="departmentid" id="ui_course_departmentid" class="easyui-textbox" autocomplete="off" />
                </td>
            </tr>        
            <tr>
                <th style="width:30%">描述：
                </th>
                <td>
                    <textarea rows="3" cols="30" name="remark" id="ui_course_remark"></textarea>
                </td>
            </tr>
        </table>
    </form>
</div>