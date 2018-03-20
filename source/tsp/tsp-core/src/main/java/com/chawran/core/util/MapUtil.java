package com.chawran.core.util;

/**
 * 地图工具类
 */
public class MapUtil {

	// 地球平均半径[单位:KM]
    private static final double EARTH_RADIUS = 6378.137;
	
    /**
     * 把经纬度转换为度
     */
    private static double rad(double d){
        return d * Math.PI / 180.0;
    }
    
    /**
     * 获取两个地点之间的距离
     * @param longitude1 位置1经度
     * @param lat1 位置1纬度
     * @param longitude2 位置2经度
     * @param lat2 位置2纬度
     */
	public static double getDistance(double longitude1, double latitude1, double longitude2, double latitude2) {
		double a, b, d, sa2, sb2;
		latitude1 = rad(latitude1);
		latitude2 = rad(latitude2);
		a = latitude1 - latitude2;
		b = rad(longitude1 - longitude2);

		sa2 = Math.sin(a / 2.0);
		sb2 = Math.sin(b / 2.0);
		d = 2 * EARTH_RADIUS
				* Math.asin(Math.sqrt(sa2 * sa2 + Math.cos(latitude1) * Math.cos(latitude2) * sb2 * sb2));
		return d;
	}
    
	public static void main(String[] args) {
		// 重庆中路583丙附近:蓝山湾三期西门[120.413116,36.184676]
		// 香港中路11号 :青岛市政府[120.389013,36.073168]
		System.out.println(getDistance(120.413116, 36.184676, 120.389013, 36.073168));
	}

}
