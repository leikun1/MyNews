package com.wtu.jbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import com.wtu.jbs.util.DBHelper;
import com.wtu.jbs.vo.userDTO;

public class userDAO implements userDAOImp{
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
		
	public List<userDTO> findAll()
	{
		List<userDTO> list =new ArrayList<userDTO>();
		try {
			conn = DBHelper.getConn();
			String sql="select * from  user";
			ps =conn.prepareStatement(sql);
			rs =ps.executeQuery();
			while(rs.next())
			{
				userDTO dto= new userDTO();
				dto.setId(rs.getInt(1));
				dto.setUserName(rs.getString(2));
				dto.setPassWord(rs.getString(3));
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBHelper.close(rs, conn, ps);
		}
		return list;
	}

	@Override
	public void add(userDTO user) {
		// TODO Auto-generated method stub
		try {
			conn=DBHelper.getConn();
			String sql="insert into user(userName,passWord) values(?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassWord());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBHelper.close(rs, conn, ps);
		}
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		conn=DBHelper.getConn();
		String sql="delete from  user where id=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBHelper.close(rs, conn, ps);
		}
		
	}

	@Override
	public userDTO findById(int  id) {
		// TODO Auto-generated method stub
		userDTO  dto= new userDTO();
		conn = DBHelper.getConn();
		String sql="select * from user where id=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next())
			{
				dto.setId(rs.getInt(1));
				dto.setUserName(rs.getString(2));
				dto.setPassWord(rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBHelper.close(rs, conn, ps);
		}
		return dto;
	}
	
	public Boolean findUser(userDTO user)
	{
		Boolean bl=false;
		conn=DBHelper.getConn();
		String sql="select * from user where userName=? and passWord=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2,user.getPassWord());
			rs=ps.executeQuery();
			if(rs.next())
			{
				bl=true;
			}else
			{
				bl=false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bl;
	}

	@Override
	public void update(userDTO user) {
		// TODO Auto-generated method stub
		conn=DBHelper.getConn();
		String sql="update user set userName=?,passWord=? where id=?";
		try {
		
			ps=conn.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassWord());
			ps.setInt(3, user.getId());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBHelper.close(rs, conn, ps);
		}
		
	}
}
