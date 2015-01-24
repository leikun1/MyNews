package com.wtu.jbs.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	private String notchecklist[];
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		    
		     boolean key=false;
              HttpServletRequest req=(HttpServletRequest)request;
              HttpServletResponse res=(HttpServletResponse)response;
              req.setCharacterEncoding("utf-8");
              res.setCharacterEncoding("utf-8");
              
              String uri=req.getRequestURI();
          	String fileName=uri.substring(uri.lastIndexOf("/")+1);
    		System.out.println(fileName);
    		if(fileName!=null&&notchecklist!=null)
    		{
    			for(int i=0;i<notchecklist.length;i++)
    			{
    				if(fileName.equalsIgnoreCase(notchecklist[i]))
    				{
    					key=true;
    				}
    			}
    		}
    			
    		if(key==true)
    		{
    			chain.doFilter(request, response);
    		}else
    		{
    			HttpSession session=req.getSession();
    			String username=(String) session.getAttribute("username");
    			System.out.println(" username £º   "+username);
    			if(username==null){
    			    res.sendRedirect("User_toLogin");
    				//RequestDispatcher rd=request.getRequestDispatcher("/news/User_toLogin.jsp");
    				//rd.forward(request, response);
    			}else
    		    {
    				chain.doFilter(request, response);
    		    }
    		}		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
		String list=arg0.getInitParameter("notchecklist");
		System.out.println("list:"+list);
		notchecklist=list.split(",");

	}

}
