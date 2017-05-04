package com.credit.manage.util;

import java.util.ArrayList;
import java.util.List;

public enum CitiesEnum implements RealizeEnum<String> {
	
	BEIJING("北京市", "北京市"),
	SHANGHAI("上海市", "上海市"),
	TIANJIN("天津市", "天津市"),
	CHONGQING("重庆市", "重庆市"),
	HONGKONG("香港", "香港"),
	//XIANGGANG("香港", "香港"),
	AOMEN("澳门", "澳门"),
	//MACAO("澳门", "澳门"),
	HANDAN("邯郸市", "河北省"),
	SHIJIAZHUANG("石家庄", "河北省"),
	BAODING("保定市", "河北省"),
	ZHANGJIAKOU("张家口", "河北省"),
	CHENGDE("承德市", "河北省"),
	TANGSHAN("唐山市", "河北省"),
	LANGFANG("廊坊市", "河北省"),
	CANGZHOU("沧州市", "河北省"),
	HENGSHUI("衡水市", "河北省"),
	XINTAI("邢台市", "河北省"),
	QINGHUANGDAO("秦皇岛", "河北省"),
	QUZHOU("衢州市", "浙江省"),
	HANGZHOU("杭州市", "浙江省"),
	HUZHOU("湖州市", "浙江省"),
	JIAXING("嘉兴市", "浙江省"),
	NINGBO("宁波市", "浙江省"),
	SHAOXING("绍兴市", "浙江省"),
	TAIZHOU("台州市", "浙江省"),
	WENZHOU("温州市", "浙江省"),
	LISHUI("丽水市", "浙江省"),
	JINHUA("金华市", "浙江省"),
	ZHOUSHAN("舟山市", "浙江省"),
	SHENYANG("沈阳市", "辽宁省"),
	TIELING("铁岭市", "辽宁省"),
	DALIAN("大连市", "辽宁省"),
	ANSHAN("鞍山市", "辽宁省"),
	FUSHUN("抚顺市", "辽宁省"),
	BENXI("本溪市", "辽宁省"),
	DANDONG("丹东市", "辽宁省"),
	JINZHOU("锦州市", "辽宁省"),
	YINGKOU("营口市", "辽宁省"),
	FUXIN("阜新市", "辽宁省"),
	LIAOYANG("辽阳市", "辽宁省"),
	ZHAOYANG("朝阳市", "辽宁省"),
	PANJIN("盘锦市", "辽宁省"),
	HULUDAO("葫芦岛", "辽宁省"),
	WUHAN("武汉市", "湖北省"),
	XIANGCHENG("襄城市", "湖北省"),
	EZHOU("鄂州市", "湖北省"),
	XIAOGAN("孝感市", "湖北省"),
	HUANGZHOU("黄州市", "湖北省"),
	HUANGSHI("黄石市", "湖北省"),
	XIANNING("咸宁市", "湖北省"),
	JINGSHA("荆沙市", "湖北省"),
	YICHANG("宜昌市", "湖北省"),
	ENSHI("恩施市", "湖北省"),
	SHIYAN("十堰市", "湖北省"),
	SUIZHAO("随枣市", "湖北省"),
	JINGMEN("荆门市", "湖北省"),
	JIANGHAN("江汉市", "湖北省"),
	NANJING("南京市", "江苏省"),
	WUXI("无锡市", "江苏省"),
	ZHANJIANG("镇江市", "江苏省"),
	SHUZHOU("苏州市", "江苏省"),
	NANTONG("南通市", "江苏省"),
	YANGZHOU("扬州市", "江苏省"),
	YANCHENG("盐城市", "江苏省"),
	XUZHOU("徐州市", "江苏省"),
	HUAIYING("淮阴市", "江苏省"),
	HUAIAN("淮安市", "江苏省"),
	LIANYUNGANG("连云港", "江苏省"),
	CHANGZHOU("常州市", "江苏省"),
	TAIZHOU1("泰州市", "江苏省"),
	HAILAER("海拉尔", "内蒙古"),
	HUHEHAOTE("呼和浩特", "内蒙古"),
	BAOTOU("包头市", "内蒙古"),
	WUHAI("乌海市", "内蒙古"),
	JINING("集宁市", "内蒙古"),
	TONGLIAO("通辽市", "内蒙古"),
	CHIFENG("赤峰市", "内蒙古"),
	DONGSHENG("东胜市", "内蒙古"),
	LINHE("临河市", "内蒙古"),
	XILINHAOTE("锡林浩特", "内蒙古"),
	WULANHAOTE("乌兰浩特", "内蒙古"),
	ALASHANZHOUQI("阿拉善左旗", "内蒙古"),
	XINYU("新余市", "江西省"),
	NANCHANG("南昌市", "江西省"),
	JIUJIANG("九江市", "江西省"),
	SHANGRAO("上饶市", "江西省"),
	LINCHUAN("临川市", "江西省"),
	YICHUN("宜春市", "江西省"),
	JIAN("吉安市", "江西省"),
	GANZHOU("赣州市", "江西省"),
	JINGDEZHNE("景德镇", "江西省"),
	PINGXIANG("萍乡市", "江西省"),
	YINGTAN("鹰潭市", "江西省"),
	XINZHOU("忻州市", "山西省"),
	TAIYUAN("太原市", "山西省"),
	DATONG("大同市", "山西省"),
	YANGQUAN("阳泉市", "山西省"),
	YUCI("榆次市", "山西省"),
	CHANGZHI("长治市", "山西省"),
	JINCHENG("晋城市", "山西省"),
	LINFEN("临汾市", "山西省"),
	LISHI("离石市", "山西省"),
	YUNCHENG("运城市", "山西省"),
	LINXIA("临夏市", "甘肃省"),
	LANZHOU("兰州市", "甘肃省"),
	DINGXI("定西市", "甘肃省"),
	PINGLIANG("平凉市", "甘肃省"),
	XIFENG("西峰市", "甘肃省"),
	WUWEI("武威市", "甘肃省"),
	ZHANGYE("张掖市", "甘肃省"),
	JIUQUAN("酒泉市", "甘肃省"),
	TIANSHUI("天水市", "甘肃省"),
	GANNAN("甘南州", "甘肃省"),
	BAIYIN("白银市", "甘肃省"),
	HEZE("菏泽市", "山东省"),
	JINAN("济南市", "山东省"),
	QINGDAO("青岛市", "山东省"),
	ZIBO("淄博市", "山东省"),
	DEZHOU("德州市", "山东省"),
	YANTAI("烟台市", "山东省"),
	HUAIFANG("淮坊市", "山东省"),
	JINING1("济宁市", "山东省"),
	TAIAN("泰安市", "山东省"),
	LINXI("临沂市", "山东省"),
	ACHENG("阿城市", "黑龙江"),
	HAERBIN("哈尔滨", "黑龙江"),
	QIQIHAER("齐齐哈尔", "黑龙江"),
	MUDANJIANG("牡丹江", "黑龙江"),
	JIAMUSI("佳木斯", "黑龙江"),
	SHUIHUA("绥化市", "黑龙江"),
	HEHE("黑河市", "黑龙江"),
	JIAGEDAQI("加格达奇", "黑龙江"),
	YICHUN1("伊春市", "黑龙江"),
	DAQING("大庆市", "黑龙江"),
	FUZHOU("福州市", "福建省"),
	XIAMEN("厦门市", "福建省"),
	NINGDE("宁德市", "福建省"),
	BUTIAN("莆田市", "福建省"),
	QUANZHOU("泉州市", "福建省"),
	JINJIANG("晋江市", "福建省"),
	ZHANGZHOU("漳州市", "福建省"),
	LONGYAN("龙岩市", "福建省"),
	SANMING("三明市", "福建省"),
	NANPING("南平市", "福建省"),
	GUANGZHOU("广州市", "广东省"),
	SHAOGUAN("韶关市", "广东省"),
	HUIZHOU("惠州市", "广东省"),
	MEIZHOU("梅州市", "广东省"),
	SHANTOU("汕头市", "广东省"),
	SHENZHEN("深圳市", "广东省"),
	ZHUHAI("珠海市", "广东省"),
	FOSHAN("佛山市", "广东省"),
	ZHAOQING("肇庆市", "广东省"),
	ZHANJIANG1("湛江市", "广东省"),
	ZHONGSHAN("中山市", "广东省"),
	HEYUAN("河源市", "广东省"),
	QINGYUAN("清远市", "广东省"),
	SHUNDE("顺德市", "广东省"),
	YUNFU("云浮市", "广东省"),
	CHAOZHOU("潮州市", "广东省"),
	DONGGUAN("东莞市", "广东省"),
	SHANWEI("汕尾市", "广东省"),
	CHAOYANG("潮阳市", "广东省"),
	YANGJIANG("阳江市", "广东省"),
	JIEXI("揭西市", "广东省"),
	CHENGDU("成都市", "四川省"),
	FULING("涪陵市", "重庆市"),
	PANZHIHUA("攀枝花", "四川省"),
	ZIGONG("自贡市", "四川省"),
	YONGCHUAN("永川市", "重庆市"),
	MIANYANG("绵阳市", "四川省"),
	NANCHONG("南充市", "四川省"),
	DAXIAN("达县市", "四川省"),
	WANXIAN("万县市", "重庆市"),
	SUINING("遂宁市", "四川省"),
	GUANGAN("广安市", "四川省"),
	BAZHONG("巴中市", "四川省"),
	LUZHOU("泸州市", "四川省"),
	YIBING("宜宾市", "四川省"),
	NEIJIANG("内江市", "四川省"),
	LESHAN("乐山市", "四川省"),
	XICHANG("西昌市", "四川省"),
	YAAN("雅安市", "四川省"),
	KANGDING("康定市", "四川省"),
	MAERKANG("马尔康", "四川省"),
	DEYANG("德阳市", "四川省"),
	GUANGYUAN("广元市", "四川省"),
	YUEYANG("岳阳市", "湖南省"),
	CHANGSHA("长沙市", "湖南省"),
	XIANGTAN("湘潭市", "湖南省"),
	ZHUZHOU("株州市", "湖南省"),
	HENGYANG("衡阳市", "湖南省"),
	CHENZHOU("郴州市", "湖南省"),
	CHANGDE("常德市", "湖南省"),
	YIYANG("益阳市", "湖南省"),
	LOUDI("娄底市", "湖南省"),
	ZHAOYANG1("邵阳市", "湖南省"),
	JISHOU("吉首市", "湖南省"),
	ZHANGJIAJIE("张家界", "湖南省"),
	HUAHUA("怀化市", "湖南省"),
	YONGZHOU("永州市", "湖南省"),
	SHANGQIU("商丘市", "河南省"),
	ZHENGZHOU("郑州市", "河南省"),
	ANYANG("安阳市", "河南省"),
	XINXIANG("新乡市", "河南省"),
	XUCHANG("许昌市", "河南省"),
	PINGDINGSHAN("平顶山", "河南省"),
	XINYANG("信阳市", "河南省"),
	NANYANG("南阳市", "河南省"),
	KAIFENG("开封市", "河南省"),
	LUOYANG("洛阳市", "河南省"),
	JIAOZHOU("焦作市", "河南省"),
	HEBI("鹤壁市", "河南省"),
	PUYANG("濮阳市", "河南省"),
	ZHOUKOU("周口市", "河南省"),
	LUOHE("漯河市", "河南省"),
	ZHUMA("驻马店", "河南省"),
	SANMENXIA("三门峡", "河南省"),
	ZHAOTONG("昭通市", "云南省"),
	KUNMING("昆明市", "云南省"),
	DALI("大理市", "云南省"),
	GEJIU("个旧市", "云南省"),
	QUJING("曲靖市", "云南省"),
	BAOSHAN("保山市", "云南省"),
	WENSHAN("文山市", "云南省"),
	YUXI("玉溪市", "云南省"),
	CHUXIONG("楚雄市", "云南省"),
	SIMAO("思茅市", "云南省"),
	JINGHONG("景洪市", "云南省"),
	LUXI("潞西市", "云南省"),
	DONGCHUAN("东川市", "云南省"),
	LINCAN("临沧市", "云南省"),
	LIUKU("六库市", "云南省"),
	ZHONGDIAN("中甸市", "云南省"),
	LIJIANG("丽江市", "云南省"),
	CHUZHOU("滁州市", "安徽省"),
	HEFEI("合肥市", "安徽省"),
	BENGBU("蚌埠市", "安徽省"),
	WUFU("芜湖市", "安徽省"),
	HUAINAN("淮南市", "安徽省"),
	MAANSHAN("马鞍山", "安徽省"),
	ANQING("安庆市", "安徽省"),
	SUZHOU("宿州市", "安徽省"),
	FUYANG("阜阳市", "安徽省"),
	HUANGSHAN("黄山市", "安徽省"),
	HUAIBEI("淮北市", "安徽省"),
	TONGLING("铜陵市", "安徽省"),
	XUANCHENG("宣城市", "安徽省"),
	LUAN("六安市", "安徽省"),
	CHAOHU("巢湖市", "安徽省"),
	GUICHI("贵池市", "安徽省"),
	YINCHUAN("银川市", "宁夏"),
	SHIZUISHAN("石嘴山", "宁夏"),
	WUZHONG("吴忠市", "宁夏"),
	GUYUAN("固原市", "宁夏"),
	CHANGCHUN("长春市", "吉林省"),
	JILIN("吉林市", "吉林省"),
	YANJI("延吉市", "吉林省"),
	SIPING("四平市", "吉林省"),
	TONGHUA("通化市", "吉林省"),
	BAICHENG("白城市", "吉林省"),
	LIAOYUAN("辽源市", "吉林省"),
	SONGYUAN("松原市", "吉林省"),
	HUNJIANG("浑江市", "吉林省"),
	HUNCHUN("珲春市", "吉林省"),
	FANGCHENGGANG("防城港", "广西省"),
	NANNING("南宁市", "广西省"),
	LIUZHOU("柳州市", "广西省"),
	GUILIN("桂林市", "广西省"),
	WUZHOU("梧州市", "广西省"),
	YULIN("玉林市", "广西省"),
	BAISE("百色市", "广西省"),
	QINGZHOU("钦州市", "广西省"),
	HECHI("河池市", "广西省"),
	BEIHAI("北海市", "广西省"),
	GUIYANG("贵阳市", "贵州省"),
	ZUNYI("遵义市", "贵州省"),
	ANSHUN("安顺市", "贵州省"),
	DUYUN("都匀市", "贵州省"),
	KAILI("凯里市", "贵州省"),
	TONGREN("铜仁市", "贵州省"),
	BIJIE("毕节市", "贵州省"),
	LIUPANSHUI("六盘水", "贵州省"),
	XINGYI("兴义市", "贵州省"),
	XIAN("西安市", "陕西省"),
	XIANYANG("咸阳市", "陕西省"),
	YANAN("延安市", "陕西省"),
	YULIN1("榆林市", "陕西省"),
	WEINAN("渭南市", "陕西省"),
	SHANLUO("商洛市", "陕西省"),
	ANKANG("安康市", "陕西省"),
	HANZHONG("汉中市", "陕西省"),
	BAOJI("宝鸡市", "陕西省"),
	TONGCHUAN("铜川市", "陕西省"),
	XINING("西宁市", "青海省"),
	HAIDONG("海东市", "青海省"),
	TONGREN1("同仁市", "青海省"),
	GONGHE("共和市", "青海省"),
	MAQIN("玛沁市", "青海省"),
	YUSHU("玉树市", "青海省"),
	DELINHA("德令哈", "青海省"),
	ZHANZHOU("儋州市", "海南省"),
	HAIKOU("海口市", "海南省"),
	SANYA("三亚市", "海南省"),
	LASA("拉萨市", "西藏"),
	RIKEZE("日喀则", "西藏"),
	SHANNAN("山南市", "西藏");

	
	private String name;
	
	private String value;

	private CitiesEnum(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public static List<String> getCity() {
		List<String> list = new ArrayList<String>();
		CitiesEnum[] cities = CitiesEnum.values();
		for(CitiesEnum city : cities) {
			//System.out.println("----"+city.getName());
			list.add(city.getName());
		}
		
		return list;
	}
	
	public static List<String> getProvince(){
		List<String> list = new ArrayList<String>();
		CitiesEnum[] provinces = CitiesEnum.values();
		for (CitiesEnum p : provinces) {
			if(!list.contains(p.getValue())) {
				//System.out.println("----"+p.getValue());
				list.add(p.getValue());
			}					
		}
		
		return list;
	}
	
	public static List<String> getCityByProvince(String province){
		if (province == null) {
			return null;
		}
		List<String> list = new ArrayList<String>();
		CitiesEnum[] provinces = CitiesEnum.values();
		for (CitiesEnum p : provinces) {
			if (p.getValue().equals(province)) {
				list.add(p.getName());
			}		
		}		
		return list;
	}
	
	public static void main(String[] args) {
		List<String> cities = CitiesEnum.getCity();
		List<String> provinces = CitiesEnum.getProvince();
		List<String> cityByProvince = CitiesEnum.getCityByProvince("广东省");
		for(String city : cities) {
			System.out.println("--"+city);
		}
		for(String city : provinces) {
			System.out.println(city);
		}
		for(String city : cityByProvince) {
			System.out.println(city);
		}	
		
//		System.out.println(SHANGHAI.getName() + "," + SHANGHAI.getValue());
	}
	

}
