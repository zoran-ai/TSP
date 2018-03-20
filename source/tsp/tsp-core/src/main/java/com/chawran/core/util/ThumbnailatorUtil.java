package com.chawran.core.util;

import java.io.File;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.Thumbnails.Builder;

@SuppressWarnings("all")
public class ThumbnailatorUtil {

	/**
	 * 压缩图片
	 * @param fromFile 来源文件
	 * @param toFile 目标文件
	 * @param width 宽度[单位:像素]
	 * @param height 高度[单位:像素]
	 * @param scale 比例
	 * @param quality 图片质量
	 */
	public static void zoomImage(String fromFile, String toFile, Integer width, Integer height,
			Double scale, Double quality) throws Exception {
		Builder<File> file = Thumbnails.of(fromFile);

		if (width != null && height != null) {
			file.size(width, height);
		}

		if (scale != null) {
			file.scale(scale);
		}

		if (quality != null) {
			file.outputQuality(scale);
		}

		file.toFile(toFile);
	}
	
	/**
	 * 按照指定大小缩放图片
	 * 图片大小压缩，遵循原图高宽比例
	 * @param fromFile 来源文件
	 * @param toFile 目标文件
	 * @param width 宽度[单位:像素]
	 * @param height 高度[单位:像素]
	 */
	public static void zoomImageBySize(String fromFile, String toFile, int width, int height)
			throws Exception {
		Thumbnails.of(fromFile).size(width, height).toFile(toFile);
	}
	
	/**
	 * 按照指定比例缩放图片
	 * 图片大小压缩，图片像素按照比例折算
	 * @param fromFile 来源文件
	 * @param toFile 目标文件
	 * @param scale 比例
	 */
	public static void zoomImageByScale(String fromFile, String toFile, double scale)
			throws Exception {
		Thumbnails.of(fromFile).scale(scale).toFile(toFile);
	}
	
	/**
	 * 按照图片质量缩放图片
	 * 图片大小压缩，图片像素 不变
	 * @param fromFile 来源文件
	 * @param toFile 目标文件
	 * @param quality 图片质量
	 */
	public static void zoomImageByQuality(String fromFile, String toFile, double quality)
			throws Exception {
		Thumbnails.of(fromFile).outputQuality(quality).toFile(toFile);
	}
	
	public static void main(String[] args) throws Exception {
		String fromFile = "C:\\tsp\\imgs\\original\\1.jpg";
		String toFile = "C:\\tsp\\imgs\\compress\\1.jpg";
		
//		zoomImageBySize(fromFile, toFile, 300, 400);
		
//		zoomImageByScale(fromFile, toFile, 0.5);
		
//		zoomImageByQuality(fromFile, toFile, 0.1);
	}
	
}
