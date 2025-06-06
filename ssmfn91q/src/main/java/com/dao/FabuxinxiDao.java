package com.dao;

import com.entity.FabuxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.FabuxinxiVO;
import com.entity.view.FabuxinxiView;


/**
 * 发布信息
 * 
 * @author 
 * @email 
 * @date 2021-03-30 14:48:06
 */
public interface FabuxinxiDao extends BaseMapper<FabuxinxiEntity> {
	
	List<FabuxinxiVO> selectListVO(@Param("ew") Wrapper<FabuxinxiEntity> wrapper);
	
	FabuxinxiVO selectVO(@Param("ew") Wrapper<FabuxinxiEntity> wrapper);
	
	List<FabuxinxiView> selectListView(@Param("ew") Wrapper<FabuxinxiEntity> wrapper);

	List<FabuxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<FabuxinxiEntity> wrapper);
	
	FabuxinxiView selectView(@Param("ew") Wrapper<FabuxinxiEntity> wrapper);
	
}
