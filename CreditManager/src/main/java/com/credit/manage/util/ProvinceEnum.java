package com.credit.manage.util;

import java.util.ArrayList;
import java.util.List;

public enum ProvinceEnum implements RealizeEnum<String> {
	
	BEIJING("010", "北京市"),
	
	SHANGHAI("021", "上海市"),
	
	TIANJING("022", "天津市"),
	
	CHONGQING("023", "重庆市"),
	
	XIANGGAN("852", "香港"),
	
	AOMEN("853", "澳门"),
	
	HEBEI("0310", "河北省"),
	
	ZHEJIAN("0570", "浙江省"),
	
	LIAOLIN("024", "辽宁省"),
	
	HUBEI("027", "湖北省"),
	
	JIANGSU("025", "江苏省"),
	
	NEIMENGU("0470", "内蒙古"),
	
	JIANGXI("0790", "江西省"),
	
	SHANXI("0350", "山西省"),
	
	GANSHU("0930", "甘肃省"),
	
	SHANGDONG("0530", "山东省"),
	
	HEILONGJIANG("0450", "黑龙江"),
	
	FUJIAN("0591", "福建省"),
	
	GUANGDONG("020", "广东省"),
	
	SICHUANG("028", "四川省"),
	
	HUNAN("0730", "湖南省"),
	
	HENAN("0370", "河南省"),
	
	YUNNAN("0870", "云南省"),
	
	ANHUI("0550", "安徽省"),
	
	LINGXIA("0951", "宁夏"),
	
	JILING("0431", "吉林省"),
	
	GUANGXI("0770", "广西省"),
	
	GUIZHOU("0851", "贵州省"),
	
	SHANGXI("029", "陕西省"),
	
	QINHAI("0971", "青海省"),
	
	HAINAN("0890", "海南省"),
	
	XIZHANG("0891", "西藏")
	
	;
	private String name;
	
	private String value;
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	private ProvinceEnum(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static List<String> takeAllValues(){
		ProvinceEnum[] eh = ProvinceEnum.values();
		List<String> result = new ArrayList<String>();
		for (ProvinceEnum p : eh) {
			result.add(p.getValue());
		}
		return result;
	}

}
