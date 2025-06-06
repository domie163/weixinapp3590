package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.FabuxinxiDao;
import com.entity.FabuxinxiEntity;
import com.service.FabuxinxiService;
import com.entity.vo.FabuxinxiVO;
import com.entity.view.FabuxinxiView;

@Service("fabuxinxiService")
public class FabuxinxiServiceImpl extends ServiceImpl<FabuxinxiDao, FabuxinxiEntity> implements FabuxinxiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FabuxinxiEntity> page = this.selectPage(
                new Query<FabuxinxiEntity>(params).getPage(),
                new EntityWrapper<FabuxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FabuxinxiEntity> wrapper) {
		  Page<FabuxinxiView> page =new Query<FabuxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<FabuxinxiVO> selectListVO(Wrapper<FabuxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public FabuxinxiVO selectVO(Wrapper<FabuxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<FabuxinxiView> selectListView(Wrapper<FabuxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FabuxinxiView selectView(Wrapper<FabuxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
