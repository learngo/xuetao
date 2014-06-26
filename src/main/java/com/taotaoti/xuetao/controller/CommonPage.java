package com.taotaoti.xuetao.controller;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

public class CommonPage {

	/**
	 * 分页
	 * @author liulxiang
	 */
	/*
	 * 分页要素：
	 * 1、首页			first
	 * 2、最后一页			last
	 * 3、页总数			 pageCount
	 * 4、总共显示的数据条数	 rowCount
	 * 5、每页显示的数据条数	 pageRowCount
	 * 6、当前页			 curPage	
	 * 7、得到的数据		 data
	 */
	
	/**
	 * 1、首页 first
	 */
	private int first;
	
	/**
	 * 2、最后一页	 last
	 */
	private int last;
	
	/**
	 * 3、页总数 pageCount
	 */
	private int pageCount;
	
	/**
	 * 4、总共显示的数据条数	rowCount
	 */
	private int rowCount;
	
	/**
	 * 5、每页显示的数据条数	pageRowCount
	 */
	private int pageRowCount;
	
	/**
	 * 6、当前页	curPage	
	 */
	private int curPage;
	/**
	 * 7、 显示多页面数
	 */
	private int pageShowSum;
	/***
	 * 
	 * @param curPage 当前页面
	 * @param pageRowCount 每页多少调
	 * @param rowCount 总共多少页
	 * @param pageShowSum 显示多少页
	 */
	public CommonPage(int curPage, int pageRowCount,int rowCount,int pageShowSum) {
		this.curPage = curPage;
		this.pageRowCount = pageRowCount;
		this.rowCount = rowCount;
		this.pageCount = (int)Math.ceil((double)this.rowCount / (double)this.pageRowCount);
		this.pageShowSum=pageShowSum;
	}
	/**
	 * 首页取得
	 * @return
	 */
	public int getFirst() {
		return this.first = 1;
	}
	
	/**
	 * 最后一页取得
	 * @return
	 */
	public int getLast() {
		return this.last = this.pageCount;
	}
	
	/**
	 * 上一页
	 * @return
	 */
	public int previous() {
		return (this.curPage > 1) ? this.curPage - 1 : 1;
	}
	
	/**
	 * 下一页
	 * @return
	 */
	public int next() {
		return (this.curPage < this.pageCount) ? this.curPage + 1 : this.pageCount;
	}
	
	/**
	 * 判断是否是首页
	 * @return
	 */
	public boolean isFirst() {
		return (this.curPage == 1) ? true : false;
	}
	
	/**
	 * 判断是否是最后一页
	 * @return
	 */
	public boolean isLast() {
		return (this.curPage == this.pageCount) ? true : false;
	}
	
	
	
	/**
	 * 客户端显示的工具条
	 */
	public String getToolBar(String url) {
        if(url.indexOf("?") == -1) {
        	url = url+"?";
        } else {
        	url =url +"&";
        }
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append("<ul class='pagination'>");
        
        String tempUrl=url+"pageSize="+pageRowCount+"&curPage="+getFirst();
        stringBuffer.append("<li ><a href='"+tempUrl+"'>首页</a></li>");
        tempUrl=url+"pageSize="+pageRowCount+"&curPage="+curPage;
        
        if(curPage-1<=0){
        	tempUrl=url+"pageSize="+pageRowCount+"&curPage="+getFirst();
        	stringBuffer.append("<li class='disabled'><a href='"+tempUrl+"'>&laquo;</a></li>");
        }else{
        	tempUrl=url+"pageSize="+pageRowCount+"&curPage="+(curPage-1);
        	stringBuffer.append("<li><a href='"+tempUrl+"'>&laquo;</a></li>");
        }
        int i=0;
        int count=1;
        while(true){
        	int tempPage=(curPage-this.pageShowSum/2)+i;
        	if(tempPage>0){
        		i++;
	        	if(tempPage==curPage){
	        		tempUrl=url+"pageSize="+pageRowCount+"&curPage="+curPage;
	        		stringBuffer.append("<li class='active'><a href='"+tempUrl+"'>"+curPage+"</a></li>");
	        	    count++;
	        	}else if(tempPage>getLast()){
	             	count++;
	             	break;
	        	}else if(count>pageShowSum){
	             	break;
	        	}else{
	        		tempUrl=url+"pageSize="+pageRowCount+"&curPage="+tempPage;
	             	stringBuffer.append("<li><a href='"+tempUrl+"'>"+tempPage+"</a></li>");
	             	count++;
	        	}
        	}else{
        		i++;
        	}
        }
       
    	 
    	 
    	 
    	 
    	 if(curPage+1>getLast()) {
         	tempUrl=url+"pageSize="+pageRowCount+"&curPage="+getLast();
         	stringBuffer.append("<li class='disabled'><a href='"+tempUrl+"'>&raquo;</a></li>");
         }else{
         	tempUrl=url+"pageSize="+pageRowCount+"&curPage="+(curPage+1);
         	stringBuffer.append("<li ><a href='"+tempUrl+"'>&raquo;</a></li>");
         }
        tempUrl=url+"pageSize="+pageRowCount+"&curPage="+getLast();
        stringBuffer.append("<li ><a href='"+tempUrl+"'>末页</a></li>");
        stringBuffer.append("</ul>");
        return stringBuffer.toString();
	}
}