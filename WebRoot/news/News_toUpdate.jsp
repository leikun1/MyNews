<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新闻更新</title>
</head>

<body>
<form action="News_doAdd" method="post" name="form1" id="form1">
<table width="625" border="0">
  <tr>
    <td width="152"><div align="center"></div></td>
    <td width="418"><div align="center">添加新闻</div></td>
    <td width="41"><div align="center"></div></td>
  </tr>
  <tr>
    <td><div align="center"></div></td>
    <td><div align="center">新闻ID:</div></td>
    <td><div align="center"></div></td>
  </tr>
  <tr>
    <td><div align="center"></div></td>
    <td><div align="center">新闻标题:
      <input name="dto.newsTitle" type="text" id="dto.newsTitle" />
    </div></td>
    <td><div align="center"></div></td>
  </tr>
  <tr>
    <td height="23"><div align="center"></div></td>
    <td><div align="center">新闻内容:
      <textarea name="dto.newsContent" id="dto.newsContent"></textarea>
    </div></td><td><div align="center"></div></td>
  </tr>
  <tr>
    <td><div align="center"></div></td>
    <td><div align="center">新闻时间:
      <input name="dto.newsTime" type="text" id="dto.newsTime" />
    </div></td>
    <td><div align="center"></div></td>
  </tr>
  <tr>
    <td><div align="center"></div></td>
    <td><div align="center">
      <input type="submit" name="Submit" value="添加" />
    　　　　　　　　　　  
    <input name="Reset" type="reset" id="Reset" value="重置" />
    </div></td>
    <td><div align="center"></div></td>
  </tr>
  
</table>

</form>
</body>
</html>
