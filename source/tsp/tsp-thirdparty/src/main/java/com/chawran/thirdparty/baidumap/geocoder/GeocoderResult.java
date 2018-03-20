package com.chawran.thirdparty.baidumap.geocoder;

public class GeocoderResult {

	// 经纬度坐标
	private GeocoderLocation location;

	// 结构化地址信息
	private String formatted_address;

	// 所在商圈信息，如 "人民大学,中关村,苏州街"
	private String business;

	// 详细地址
	private GeocoderAddress addressComponent;

	// 周边poi数组
	private GeocoderPois[] pois;

	// 周边road数组
	private GeocoderRoads[] roads;

	// 当前位置结合POI的语义化结果描述
	private String sematic_description;

	// 命中区域面
	private GeocoderPoiRegions[] poiRegions;

	// 城市id
	private String cityCode;

	public GeocoderLocation getLocation() {
		return location;
	}

	public void setLocation(GeocoderLocation location) {
		this.location = location;
	}

	public String getFormatted_address() {
		return formatted_address;
	}

	public void setFormatted_address(String formatted_address) {
		this.formatted_address = formatted_address;
	}

	public String getBusiness() {
		return business;
	}

	public void setBusiness(String business) {
		this.business = business;
	}

	public GeocoderAddress getAddressComponent() {
		return addressComponent;
	}

	public void setAddressComponent(GeocoderAddress addressComponent) {
		this.addressComponent = addressComponent;
	}

	public GeocoderPois[] getPois() {
		return pois;
	}

	public void setPois(GeocoderPois[] pois) {
		this.pois = pois;
	}

	public GeocoderRoads[] getRoads() {
		return roads;
	}

	public void setRoads(GeocoderRoads[] roads) {
		this.roads = roads;
	}

	public String getSematic_description() {
		return sematic_description;
	}

	public void setSematic_description(String sematic_description) {
		this.sematic_description = sematic_description;
	}

	public GeocoderPoiRegions[] getPoiRegions() {
		return poiRegions;
	}

	public void setPoiRegions(GeocoderPoiRegions[] poiRegions) {
		this.poiRegions = poiRegions;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

}
