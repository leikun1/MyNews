<%@ page contentType="text/html; charset=utf-8" language="java"  errorPage="" %>
<%@ taglib uri="/struts-tags" prefix="s" %>



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>显示</title>
</head>
<script language="javascript" type="text/javascript">
function goAdd()
{
window.location.href="User_toAdd";
}


function goUpdate(id)
{
window.location.href="User_toUpdate?dto.id="+id;
//User_toUpdate?dto.id=<s:property value='id'/>
}



</script>
<script type="text/javascript" language="javascript" src="../js/CheckBox.js">
</script>
<body>
<form name="form1" id="form1" method="post" action="User_delete">
用户表:</br>
<table width="582" border="0">
  <tr>
    <td width="76"><div align="center"><input type="checkbox" name="checkbox" id="checkbox" value="checkbox"  onchange="checkAll()"/>全选</div></td>
    <td width="85"><div align="center">id&nbsp;</div></td>
    <td width="116"><div align="center">用户名&nbsp;</div></td>
    <td width="145"><div align="center">密码&nbsp;</div></td>
    <td width="138"><div align="center">更新</div></td>
  </tr>
  <s:iterator  value="users">
  <tr>
   <td><div align="center"><input name="ids" type="checkbox" id="ids" value="<s:property value='id'/>"/></div></td>
    <td><div align="center"><s:property value="id"></s:property></div></td>
    <td><div align="center"><s:property value="userName"></s:property></div></td>
    <td><div align="center"><s:property value="passWord"></s:property></div></td>
    <td><div align="center">
	<!--
	<a href="User_toUpdate?dto.id=<s:property value='id'/>">更新</a>
	-->
	<input type="button" name="update_Button" id="update_Button"  value="更新"  onclick="goUpdate(<s:property value='id'/>)"/>
	</div></td>
  </tr>
  </s:iterator>
     <tr>
    <td colspan="5"><input name="submit" type="submit" id="submit" value="批量删除" />
      &nbsp;
	  
	  <input type="button" name="add_Button" id="add_Button"  value="添加"  onclick="goAdd()"/></td>
    </tr>
</table>


</form>
</body>
</html>
