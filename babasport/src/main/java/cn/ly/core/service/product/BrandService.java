package cn.ly.core.service.product;

import cn.itcast.common.page.Pagination;
import cn.ly.core.bean.product.Brand;

public interface BrandService {
	public Pagination getBrandListWithPage(Brand brand);

	// 添加品牌
	public void addBrand(Brand brand);

	// 删除品牌
	public void deleteBrandByKey(Integer id);

	// 批量删除品牌
	public void deleteBrandByKeys(Integer[] ids);

	// 修改
	public void updateBrand(Brand brand);
}
