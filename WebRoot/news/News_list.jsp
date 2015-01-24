<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="/struts-tags" prefix="s" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新闻列表</title>

</head>
<script type="text/javascript" language="javascript" src="../js/CheckBox.js">
</script>
<script language="javascript" type="text/javascript">
function goAdd()
{
window.location.href="News_toAdd";
}
</script>

<body>
<form name="form1" id="form1" action="News_delete" method="post">
尊敬的用户:<s:property value="#session.username" />
</br>
<a href="User_doQuit">退出登录</a>
<table width="836" border="0">
  <tr>
    <td width="149"><div align="center">
      <input name="checkbox" type="checkbox" id="checkbox" value="checkbox" onchange="checkAll()"/>
    全选</div></td>
    <td width="154"><div align="center">新闻ID</div></td>
    <td width="123"><div align="center">新闻标题</div></td>
    <td width="123"><div align="center">新闻内容</div></td>
    <td width="180"><div align="center">新闻时间</div></td>
    <td width="81"><div align="center">操作</div></td>
  </tr>
  <s:iterator value="news">
  <tr>
    <td><div align="center">
      <input name="ids" type="checkbox" id="ids" value="<s:property value='newsId'/>" />
    </div></td>
    <td><div align="center"><s:property value="newsId" /></div></td>
    <td><div align="center"><s:property value="newsTitle" /></div></td>
    <td><div align="center"><s:property value="newsContent" /></div></td>
    <td><div align="center"><s:property value="newsTime" /></div></td>
    <td><div align="center"><a href="News_toUpdate?dto.newsId=<s:property value='newsId'/>">更新</a></div></td>
  </tr>
   </s:iterator>
  <tr>
    <td colspan="6"><div align="center">
      <a href="News_list?pageno=1">首页</a>
	  <s:if test="pageno>1">
	  <a href="News_list?pageno=<s:property value='pageno-1' />">上一页</a>
	  </s:if>
	  <s:else>
	   <a href="News_list?pageno=1">上一页</a>
	  </s:else>
	  <s:if test="pageno<(<s:property value='TotalPage' />)">
	  <a href="News_list?pageno=<s:property value='pageno+1' />">下一页</a>
	  </s:if>
	  <s:else>
	   <a href="News_list?pageno=<s:property value='TotalPage' />">下一页</a>
	  </s:else>
	  <a href="News_list?pageno=<s:property value='TotalPage' />">尾页</a>
      <input name="submit" type="submit" id="submit" value="批量删除" />　
      　　　　　　　　　　  
        <input name="add_Button" type="button" id="add_Button" value="添加" onclick="goAdd()" />
    </div></td>
    </tr>
</table>

</form>
</body>
</html>
