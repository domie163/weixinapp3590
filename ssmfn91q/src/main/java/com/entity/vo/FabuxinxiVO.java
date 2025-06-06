package com.entity.vo;

import com.entity.FabuxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * 发布信息
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2021-03-30 14:48:06
 */
public class FabuxinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 信息名称
	 */
	
	private String xinximingcheng;
		
	/**
	 * 类型
	 */
	
	private String leixing;
		
	/**
	 * 简介
	 */
	
	private String jianjie;
		
	/**
	 * 信息内容
	 */
	
	private String xinxineirong;
		
	/**
	 * 信息图片
	 */
	
	private String xinxitupian;
		
	/**
	 * 卖家账号
	 */
	
	private String maijiazhanghao;
		
	/**
	 * 卖家姓名
	 */
	
	private String maijiaxingming;
		
	/**
	 * 联系电话
	 */
	
	private String lianxidianhua;
		
	/**
	 * 卖家地址
	 */
	
	private String maijiadizhi;
		
	/**
	 * 用户id
	 */
	
	private Long userid;
				
	
	/**
	 * 设置：信息名称
	 */
	 
	public void setXinximingcheng(String xinximingcheng) {
		this.xinximingcheng = xinximingcheng;
	}
	
	/**
	 * 获取：信息名称
	 */
	public String getXinximingcheng() {
		return xinximingcheng;
	}
				
	
	/**
	 * 设置：类型
	 */
	 
	public void setLeixing(String leixing) {
		this.leixing = leixing;
	}
	
	/**
	 * 获取：类型
	 */
	public String getLeixing() {
		return leixing;
	}
				
	
	/**
	 * 设置：简介
	 */
	 
	public void setJianjie(String jianjie) {
		this.jianjie = jianjie;
	}
	
	/**
	 * 获取：简介
	 */
	public String getJianjie() {
		return jianjie;
	}
				
	
	/**
	 * 设置：信息内容
	 */
	 
	public void setXinxineirong(String xinxineirong) {
		this.xinxineirong = xinxineirong;
	}
	
	/**
	 * 获取：信息内容
	 */
	public String getXinxineirong() {
		return xinxineirong;
	}
				
	
	/**
	 * 设置：信息图片
	 */
	 
	public void setXinxitupian(String xinxitupian) {
		this.xinxitupian = xinxitupian;
	}
	
	/**
	 * 获取：信息图片
	 */
	public String getXinxitupian() {
		return xinxitupian;
	}
				
	
	/**
	 * 设置：卖家账号
	 */
	 
	public void setMaijiazhanghao(String maijiazhanghao) {
		this.maijiazhanghao = maijiazhanghao;
	}
	
	/**
	 * 获取：卖家账号
	 */
	public String getMaijiazhanghao() {
		return maijiazhanghao;
	}
				
	
	/**
	 * 设置：卖家姓名
	 */
	 
	public void setMaijiaxingming(String maijiaxingming) {
		this.maijiaxingming = maijiaxingming;
	}
	
	/**
	 * 获取：卖家姓名
	 */
	public String getMaijiaxingming() {
		return maijiaxingming;
	}
				
	
	/**
	 * 设置：联系电话
	 */
	 
	public void setLianxidianhua(String lianxidianhua) {
		this.lianxidianhua = lianxidianhua;
	}
	
	/**
	 * 获取：联系电话
	 */
	public String getLianxidianhua() {
		return lianxidianhua;
	}
				
	
	/**
	 * 设置：卖家地址
	 */
	 
	public void setMaijiadizhi(String maijiadizhi) {
		this.maijiadizhi = maijiadizhi;
	}
	
	/**
	 * 获取：卖家地址
	 */
	public String getMaijiadizhi() {
		return maijiadizhi;
	}
				
	
	/**
	 * 设置：用户id
	 */
	 
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	
	/**
	 * 获取：用户id
	 */
	public Long getUserid() {
		return userid;
	}
			
}
