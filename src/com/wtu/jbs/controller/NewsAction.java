package com.wtu.jbs.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.Action;
import com.wtu.jbs.dao.newsDAO;
import com.wtu.jbs.vo.newsDTO;

public class NewsAction implements Action {
   private newsDTO  dto;
   private newsDAO dao= new newsDAO();
   private List<newsDTO> news=new ArrayList<newsDTO>();
   private int[] ids;
   private int pageno;
   private int TotalPage;

   public String list()
   {
	    TotalPage=dao.getTotalPage();
	    if(pageno<1) pageno=1;
		if(pageno>=TotalPage)pageno=TotalPage;
	   news=dao.findPageAll(pageno);
		//news=dao.findAll();
	   return this.SUCCESS;
   }
   
   public String toAdd()
   {
	   return this.SUCCESS;
   }
   
   public String doAdd()
   {
	   dao.add(dto);
	   return "list";
   }
   
   public String toUpdate()
   {
	   dto=dao.findById(dto.getNewsId());
	   return this.SUCCESS;
   }
	
   public String doUpdate()
   {
	   dao.update(dto);
	   return "list";
   }
	
   public String delete()
   {
	   if(ids!=null)
	   {
		   for(int i=0;i<ids.length;i++)
		   {
			   dao.delete(ids[i]);
		   }
	   } 
	   return "list";
   }

   
   
   

   
   //sturts交换的数据
	
	public newsDTO getDto() {
	return dto;
}



public void setDto(newsDTO dto) {
	this.dto = dto;
}


public newsDAO getDao() {
	return dao;
}



public void setDao(newsDAO dao) {
	this.dao = dao;
}



public List<newsDTO> getNews() {
	return news;
}


public void setNews(List<newsDTO> news) {
	this.news = news;
}

public int[] getIds() {
	return ids;
}


public void setIds(int[] ids) {
	this.ids = ids;
}

public int getPageno() {
	return pageno;
}

public void setPageno(int pageno) {
	this.pageno = pageno;
}



	public int getTotalPage() {
	return TotalPage;
}

public void setTotalPage(int totalPage) {
	TotalPage = totalPage;
}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
