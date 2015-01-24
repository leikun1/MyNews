package com.wtu.jbs.dao;

import java.util.List;

import com.wtu.jbs.vo.userDTO;

public interface userDAOImp {
      public  abstract List<userDTO> findAll();
      public  abstract userDTO findById(int id);
      public  abstract void add(userDTO user);
      public abstract  void update(userDTO user);
      public abstract void delete(int id);
      
}
