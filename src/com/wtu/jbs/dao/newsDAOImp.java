package com.wtu.jbs.dao;

import java.util.List;

import com.wtu.jbs.vo.newsDTO;



public interface newsDAOImp {
	 public  abstract List<newsDTO> findAll();
     public  abstract newsDTO findById(int id);
     public  abstract void add(newsDTO news);
     public abstract  void update(newsDTO news);
     public abstract void delete(int id);
}
