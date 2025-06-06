package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.FabuxinxiEntity;
import com.entity.view.FabuxinxiView;

import com.service.FabuxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 发布信息
 * 后端接口
 * @author 
 * @email 
 * @date 2021-03-30 14:48:06
 */
@RestController
@RequestMapping("/fabuxinxi")
public class FabuxinxiController {
    @Autowired
    private FabuxinxiService fabuxinxiService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FabuxinxiEntity fabuxinxi, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("maijia")) {
			fabuxinxi.setMaijiazhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<FabuxinxiEntity> ew = new EntityWrapper<FabuxinxiEntity>();
		PageUtils page = fabuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fabuxinxi), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,FabuxinxiEntity fabuxinxi, HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("maijia")) {
			fabuxinxi.setMaijiazhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<FabuxinxiEntity> ew = new EntityWrapper<FabuxinxiEntity>();
		PageUtils page = fabuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fabuxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FabuxinxiEntity fabuxinxi){
       	EntityWrapper<FabuxinxiEntity> ew = new EntityWrapper<FabuxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( fabuxinxi, "fabuxinxi")); 
        return R.ok().put("data", fabuxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FabuxinxiEntity fabuxinxi){
        EntityWrapper< FabuxinxiEntity> ew = new EntityWrapper< FabuxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( fabuxinxi, "fabuxinxi")); 
		FabuxinxiView fabuxinxiView =  fabuxinxiService.selectView(ew);
		return R.ok("查询发布信息成功").put("data", fabuxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FabuxinxiEntity fabuxinxi = fabuxinxiService.selectById(id);
        return R.ok().put("data", fabuxinxi);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FabuxinxiEntity fabuxinxi = fabuxinxiService.selectById(id);
        return R.ok().put("data", fabuxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FabuxinxiEntity fabuxinxi, HttpServletRequest request){
    	fabuxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(fabuxinxi);

        fabuxinxiService.insert(fabuxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody FabuxinxiEntity fabuxinxi, HttpServletRequest request){
    	fabuxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(fabuxinxi);
    	fabuxinxi.setUserid((Long)request.getSession().getAttribute("userId"));

        fabuxinxiService.insert(fabuxinxi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody FabuxinxiEntity fabuxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fabuxinxi);
        fabuxinxiService.updateById(fabuxinxi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        fabuxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<FabuxinxiEntity> wrapper = new EntityWrapper<FabuxinxiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("maijia")) {
			wrapper.eq("maijiazhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = fabuxinxiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
