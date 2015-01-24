<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>更新</title>
</head>

<body>
<form id="form1" name="form1"  action="User_doUpdate" method="post">
<table width="598" height="242" border="0">
  <tr>
    <td width="182" height="64"><div align="center"></div></td>
    <td width="239"><div align="center">更改用户</div></td>
    <td width="163"><div align="center"></div></td>
  </tr>
  <tr>
    <td colspan="3"><div align="center">用户ID:
      <s:property value="dto.id"/> 
      <span id="userIDSpan"></span>&nbsp;</div></td>
    </tr>
  <tr>
    <td><div align="right">用户名:</div></td>
    <td><div align="center">
      <input name="dto.userName" type="text" id="dto.userName" value="<s:property value='dto.userName' />" />
    </div></td>
    <td><div align="center"><span id="userNameSpan"></span>&nbsp;</div></td>
  </tr>
  <tr>
    <td><div align="right">密　码:</div></td>
    <td><div align="center">
      <input name="dto.passWord" type="text" id="dto.passWord" value="<s:property value='dto.passWord' />" />
    </div></td>
    <td><div align="center"><span id="passWordSPan"></span>&nbsp;</div></td>
  </tr>
  <tr>
    <td colspan="3">
      <div align="left">　　　　　　　
          <input type="submit" name="Submit" id="Submit" value="提交" />
		  <input type="hidden"  name="dto.id" id="dto.id" value="<s:property value='dto.id'/>" />　　　　　　　　　　　　　
          <input type="reset" name="Reset" id="Reset" value="重置" />
        </div></td>
    </tr>
</table>

</form>
</body>
</html>
