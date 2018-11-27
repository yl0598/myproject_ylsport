package cn.ly.core.dao.product;



import java.util.List;

import cn.ly.core.bean.product.Brand;

public interface BrandDao {

	public List<Brand> getBrandListWithPage(Brand brand);
	
	//总记录数getBrandListWithPage
	public int getBrandCount(Brand brand);
	
	//添加品牌
	public void addBrand(Brand brand);
	
	//删除品牌
	public void deleteBrandByKey(Integer id);
	
	//批量删除品牌
    public void deleteBrandByKeys(Integer[] ids);
    
    //修改
    public void updateBrand(Brand brand);
}
