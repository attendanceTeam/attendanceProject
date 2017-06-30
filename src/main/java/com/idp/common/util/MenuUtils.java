package com.idp.common.util;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.idp.web.system.entity.SysMenu;

public class MenuUtils {

	
	public static String getMenu(List<SysMenu> menuList,List<String> userMenus){
		
		StringBuilder sb = new StringBuilder();
		
		if(menuList != null && menuList.size() > 0){
			
			for(SysMenu menu : menuList){
				
				if(userMenus.contains(menu.getId())){
					int childNum = menu.getChildren().size();
					
					if(childNum > 0){
						sb.append("<li>\n")
						.append("<a ");
						sb.append("ng-click='systemMangerShow($event)'");
					}else{
						sb.append("<li ui-sref=\""+menu.getMenuUrl()+"\">\n")
						.append("<a ");
					}
					sb.append(">\n");
					sb.append("<i class=\""+menu.getMenuIcon()+"\"></i>\n")
					.append("<span class=\"title\">"+menu.getMenuName()+"</span>\n");
					if(childNum > 0){
						sb.append("<span class=\"arrow\"></span>\n");
					}
					sb.append("</a>\n");
					if(childNum > 0){
						sb.append(getChildren(menu.getChildren(),userMenus));
					}
					sb.append("</li>\n");
				}
			}
		}
		
		return sb.toString();
	}
	
	public static String getChildren(List<SysMenu> menuList,List<String> userMenus){
		StringBuilder sb = new StringBuilder();
		
		sb.append("<ul class=\"sub-menu\">\n");
		
		for(SysMenu menu : menuList){
			
			if(userMenus.contains(menu.getId())){
				int childNum = menu.getChildren().size();
				
				sb.append("<li ui-sref=\""+menu.getMenuUrl()+"\">\n")
				.append("<a>\n");
				sb.append("<i class=\""+menu.getMenuIcon()+"\"></i>\n")
				.append("<span class=\"title\">"+menu.getMenuName()+"</span>\n");
				if(childNum > 0){
					sb.append("<span class=\"arrow\"></span>\n");
				}
				sb.append("</a>\n");
				if(childNum > 0){
					sb.append(getChildren(menu.getChildren(),userMenus));
				}
				sb.append("</li>\n");
			}
		}
		
		sb.append("</ul>");
		
		return sb.toString();
	}
}
