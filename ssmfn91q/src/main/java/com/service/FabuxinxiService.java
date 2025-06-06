package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.FabuxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.FabuxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.FabuxinxiView;


/**
 * 发布信息
 *
 * @author 
 * @email 
 * @date 2021-03-30 14:48:06
 */
public interface FabuxinxiService extends IService<FabuxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FabuxinxiVO> selectListVO(Wrapper<FabuxinxiEntity> wrapper);
   	
   	FabuxinxiVO selectVO(@Param("ew") Wrapper<FabuxinxiEntity> wrapper);
   	
   	List<FabuxinxiView> selectListView(Wrapper<FabuxinxiEntity> wrapper);
   	
   	FabuxinxiView selectView(@Param("ew") Wrapper<FabuxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FabuxinxiEntity> wrapper);
   	
}

