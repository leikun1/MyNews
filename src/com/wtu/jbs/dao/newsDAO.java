package com.wtu.jbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wtu.jbs.util.DBHelper;
import com.wtu.jbs.vo.newsDTO;
import com.wtu.jbs.vo.userDTO;

public class newsDAO implements newsDAOImp {

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	//每页显示3条数据
	int counter=3;
	int total=0;
	
	//获取总页数
	public int getTotalPage()
	{
		int TotalPage=1;
		conn=DBHelper.getConn();
		try {
			ps=conn.prepareStatement("select count(*) from news");
			rs=ps.executeQuery();
			if(rs.next())
			{
				total=rs.getInt(1);
			}
			TotalPage=(total+counter-1)/counter;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBHelper.close(rs, conn, ps);
		}
		
		return TotalPage;
	}
	
	public List<newsDTO> findPageAll(int pageno)
	{
	   
		List<newsDTO> list= new ArrayList<newsDTO>();
		conn=DBHelper.getConn();	
		try {
			ps=conn.prepareStatement("select * from news",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	        rs=ps.executeQuery();
	        int i=1;
	        if(pageno!=1)
	        {	        	
	        	rs.absolute((pageno-1)*counter);
	        }
	        while(rs.next()&&i<=counter)
	        {
	        	newsDTO dto= new newsDTO();
	        	dto.setNewsId(rs.getInt(1));
				dto.setNewsTitle(rs.getString(2));
				dto.setNewsContent(rs.getString(3));
				dto.setNewsTime(rs.getDate(4));
				list.add(dto);
				i++;
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	@Override
	public void add(newsDTO news) {
		// TODO Auto-generated method stub
		conn = DBHelper.getConn();
		String sql="insert into news(newstitle,newscontent,newstime) values(?,?,?)";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, news.getNewsTitle());
			ps.setString(2, news.getNewsContent());
			ps.setDate(3, news.getNewsTime());
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
		conn = DBHelper.getConn();
		String sql="delete  from news where newsid=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1,id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBHelper.close(rs, conn, ps);
		}
		
	}

	@Override
	public List<newsDTO> findAll() {
		// TODO Auto-generated method stub
		List<newsDTO> list= new ArrayList<newsDTO>();
		conn=DBHelper.getConn();
		String sql="select * from news";
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next())
			{
				newsDTO dto= new  newsDTO();
				dto.setNewsId(rs.getInt(1));
				dto.setNewsTitle(rs.getString(2));
				dto.setNewsContent(rs.getString(3));
				dto.setNewsTime(rs.getDate(4));
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
	public newsDTO findById(int id) {
		// TODO Auto-generated method stub
		newsDTO  dto= new newsDTO();
		conn = DBHelper.getConn();
		String sql="select * from news where newsid=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next())
			{
				dto.setNewsId(rs.getInt(1));
				dto.setNewsTitle(rs.getString(2));
				dto.setNewsContent(rs.getString(3));
				dto.setNewsTime(rs.getDate(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBHelper.close(rs, conn, ps);
		}
		return dto;
	}		

	@Override
	public void update(newsDTO news) {
		// TODO Auto-generated method stub
		conn=DBHelper.getConn();
		String sql="update news set newstitle=?,newscontent=?,newstime=? where newsid=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, news.getNewsTitle());
			ps.setString(2, news.getNewsContent());
			ps.setDate(3, news.getNewsTime());
			ps.setInt(4, news.getNewsId());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBHelper.close(rs, conn, ps);
		}
	}

}
