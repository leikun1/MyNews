package com.wtu.jbs.controller;

import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.Severity;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.omg.CORBA.Request;

import com.opensymphony.xwork2.Action;
import com.wtu.jbs.dao.userDAO;
import com.wtu.jbs.vo.userDTO;

public class UserAction implements Action {
	private userDTO dto;
	private userDAO dao=new userDAO();
    private List<userDTO> users= new ArrayList<userDTO>();
    private int[] ids;
 
	public String toLogin()
    {
    	return this.SUCCESS;
    }
    
    public String doLogin()
    {
    	Boolean  bl= dao.findUser(dto);
    	if(bl==true)
    	{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		HttpSession hs=request.getSession();
    		hs.setAttribute("username", "Mylife");		
    		return "dologin";
    	}else
    	{
    		return "tologin";
    	}
    }
    
    public String doQuit()
    {
    	HttpServletRequest request=ServletActionContext.getRequest();
        HttpSession hs=request.getSession();
        hs.setAttribute("username", null);
    	return "tologin";
    }
    
	public String list()
    {
      users = dao.findAll();
      return this.SUCCESS;
    }
    
    public String  toAdd()
    {
    	return this.SUCCESS;
    }
    
    public String doAdd()
    {
    	dao.add(dto);
    	return "list";
    }
 
    public String delete()
    {
    	if(ids!=null)
    	{
    		for(int i=0;i<ids.length;i++)
        	{
        		System.out.println(ids[i]);
        		dao.delete(ids[i]);
        	}
    	}
    	return "list";
    }
    
    public String toUpdate()
    {
    	dto=dao.findById(dto.getId());
    	return this.SUCCESS;
    }
    
    public String doUpdate()
    {
    	dao.update(dto);
    	return "list";
    }
    
  ///获取实体对象
	public userDTO getDto() {
		return dto;
	}


	public void setDto(userDTO dto) {
		this.dto = dto;
	}


	public userDAO getDao() {
		return dao;
	}


	public void setDao(userDAO dao) {
		this.dao = dao;
	}


	public List<userDTO> getUsers() {
		return users;
	}


	public void setUsers(List<userDTO> users) {
		this.users = users;
	}
  
    public int[] getIds() {
		return ids;
	}





	public void setIds(int[] ids) {
		this.ids = ids;
	}


	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
