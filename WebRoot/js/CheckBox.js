// JavaScript Document
function checkAll()
{

var ids=document.getElementsByName("ids");
if(document.getElementById("checkbox").checked)
{
	 for(var  i=0;i<ids.length;i++)
	 {
       ids[i].checked=true;
     }
}else
{
    for(var  i=0;i<ids.length;i++)
	{
       ids[i].checked=false;
    }
}

}