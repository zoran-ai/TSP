package com.chawran.core.mybatis.generator.util;

import java.util.ArrayList;
import java.util.List;

import com.chawran.core.mybatis.generator.service.MyBatisService;

@SuppressWarnings("all")
public class MyBatisUtil {

	public static void main(String[] args) throws Exception {
		String projectPath = System.getProperty("user.dir").replaceAll("core", "common");
		String sourcePath = projectPath + "\\src\\main\\java\\";
		String tableSchema = "tspdb";
		
		List<String> tableList = new ArrayList<String>();
		
//		tableList.add("sys_parameter_type");
//		tableList.add("sys_parameter_define");
//		tableList.add("sys_parameter_config");
//		tableList.add("sys_data_dict_type");
//		tableList.add("sys_data_dict_type_attribute");
//		tableList.add("sys_data_dict_item");
//		tableList.add("sys_data_dict_item_attribute");
//		tableList.add("sys_data_struct_define");
//		tableList.add("sys_data_struct_attribute");
//		tableList.add("sys_data_struct_node");
//		tableList.add("sys_data_struct_node_attribute");
//		tableList.add("sys_lov_define");
//		tableList.add("sys_lov_column");
//		tableList.add("sys_function");
//		tableList.add("sys_operation");
//		tableList.add("sys_flex_field_define");
//		tableList.add("sys_flex_field_column");
//		tableList.add("sys_role");
//		tableList.add("sys_role_resource");
//		tableList.add("sys_user");
//		tableList.add("sys_user_role");
//		tableList.add("sys_log");
//		tableList.add("sys_search_define");
//		tableList.add("sys_search_column");
//		tableList.add("oe_operating_entity");
//		tableList.add("oe_wechat_public");
//		tableList.add("oe_account");
//		tableList.add("oe_account_detail");
//		tableList.add("mbr_member_service");
//		tableList.add("mbr_member_auth");
//		tableList.add("mbr_member");
//		tableList.add("tnt_tenant");
//		tableList.add("tnt_authentication");
//		tableList.add("tnt_account");
//		tableList.add("tnt_account_detail");
//		tableList.add("tnt_action");
//		tableList.add("tnt_location");
//		tableList.add("ts_service");
//		tableList.add("ts_service_image");
//		tableList.add("ts_service_label");
//		tableList.add("ts_service_scope");
//		tableList.add("om_order");
		
		tableList.add("msg_css_chat");
		tableList.add("msg_tenant_chat");

		MyBatisService service = new MyBatisService();
		
		for (String tableName : tableList) {
			if (tableName != null && !"".equals(tableName)) {
				service.generator(sourcePath, tableSchema, tableName);
			}
		}
	}

}
