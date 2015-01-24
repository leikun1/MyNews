<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录</title>
</head>

<body>
<form action="User_doLogin" method="post" name="form1" id="form1">
  <table width="463" border="0">
    <tr>
      <td width="47">&nbsp;</td>
      <td width="339"><div align="center">用户登录</div></td>
      <td width="63">&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td><div align="center">用户名:
        <input name="dto.userName" type="text" id="dto.userName" />
      </div></td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td><div align="center">密　码:
        <input name="dto.passWord" type="text" id="dto.passWord" />
      </div></td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td><div align="center">
        <input type="submit" name="Submit" id="Submit" value="提交" />
      　　　　　　　　　　  
      <input name="Reset" type="reset" id="Reset" value="重置" />
      </div></td>
      <td>&nbsp;</td>
    </tr>
  </table>

</form>
</body>
</html>
