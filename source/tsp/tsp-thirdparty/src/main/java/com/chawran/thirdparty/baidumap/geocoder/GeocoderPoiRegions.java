package com.chawran.thirdparty.baidumap.geocoder;

public class GeocoderPoiRegions {

	// 命中区域面与坐标位置关系
	private String direction_desc;

	// 命中区域面名称
	private String name;

	// 命中区域面类型
	private String tag;

	public String getDirection_desc() {
		return direction_desc;
	}

	public void setDirection_desc(String direction_desc) {
		this.direction_desc = direction_desc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

}
