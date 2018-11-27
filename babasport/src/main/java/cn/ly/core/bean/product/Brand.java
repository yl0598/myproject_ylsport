package cn.ly.core.bean.product;

import cn.ly.common.web.Constants;

public class Brand {

/**
 * 品牌
 * 	
 */
	private Integer id;
    private String name;
    private String description;
    private String imgUrl;
    private Integer sort;
    private Integer isDisplay;
    
    //获取全路径
    public String getAllImgUrl() {
    	return Constants.IMAGE_URL + imgUrl;
    };
    
    //页号
    private Integer pageNo = 1;
    
    //开始行
    private Integer startRow;
    //每页数
    private Integer pageSize =10;
    
    
    
    
	public Integer getStartRow() {
		return startRow;
	}
	public void setStartRow(Integer startRow) {
		
		this.startRow = startRow;
	}
	public Integer getpageSize() {
		return pageSize;
	}
	public void setpageSize(Integer pageSize) {
		
		this.startRow=(pageNo -1)*pageSize;
		this.pageSize = pageSize;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.startRow=(pageNo-1)*pageSize;
		this.pageNo = pageNo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public Integer getIsDisplay() {
		return isDisplay;
	}
	public void setIsDisplay(Integer isDisplay) {
		this.isDisplay = isDisplay;
	}
	@Override
	public String toString() {
		return "Brand [id=" + id + ", name=" + name + ", description=" + description + ", imgUrl=" + imgUrl + ", sort="
				+ sort + ", isDisplay=" + isDisplay + "]";
	}
    
    
}
