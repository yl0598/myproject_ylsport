package cn.ly.core.service.product.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.common.page.Pagination;
import cn.ly.core.bean.product.Brand;
import cn.ly.core.dao.product.BrandDao;
import cn.ly.core.service.product.BrandService;

@Service
@Transactional
public class BrandServiceImpl implements BrandService {

	@Resource
	private BrandDao brandDao;
	
	
	@Override
	@Transactional(readOnly=true)
	public Pagination getBrandListWithPage(Brand brand) {
	  //1:起始页  startRow =(pageNo -1)*pageSize;
	  //2.每页数 
	//	3.总页数	
Pagination pagination = new Pagination(brand.getPageNo(),brand.getpageSize(),brandDao.getBrandCount(brand));
  pagination.setList(brandDao.getBrandListWithPage(brand));

		return pagination;
	}


	@Override
	public void addBrand(Brand brand) {
		brandDao.addBrand(brand);
		
	}


	@Override
	public void deleteBrandByKey(Integer id) {
		brandDao.deleteBrandByKey(id);
		
	}


	@Override
	public void deleteBrandByKeys(Integer[] ids) {
		brandDao.deleteBrandByKeys(ids);
		
	}


	@Override
	public void updateBrand(Brand brand) {
		brandDao.updateBrand(brand);
		
	}

}
