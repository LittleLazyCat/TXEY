package cn.lby.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lby.dao.RewardRecordMapper;
import cn.lby.dao.SalesRankingQaMapper;
import cn.lby.dao.SalesRankingTypeMapper;
import cn.lby.dao.SalesRecordMapper;
import cn.lby.entity.SalesRankingQa;
import cn.lby.entity.SalesRankingQaExample;
import cn.lby.entity.SalesRankingType;
import cn.lby.entity.SalesRankingTypeExample;
import cn.lby.reportUtil.ReportDateUtil;
import cn.lby.service.SalesRankingReportService;
import cn.lby.vo.SalesRankingVO;

@Service("salesRankingReportService")
public class SalesRankingReportServiceImpl implements SalesRankingReportService {

	@Autowired
	SalesRecordMapper salesRecordMapper;

	@Autowired
	RewardRecordMapper rewardRecordMapper;
	
	@Autowired
	SalesRankingQaMapper salesRankingQaMapper;

	@Autowired
	SalesRankingTypeMapper salesRankingTypeMapper;
	
	@Override
	public SalesRankingVO getSalesRanking(String vehicleModelId,String dealerId) {
		// 先销售记录表sales_record中查出销量排行
		HashMap<String, String> parameterMap = new HashMap<String, String>();
		parameterMap.put("vehicleModelId", vehicleModelId);
		parameterMap.put("dealerId", dealerId);
		List<HashMap<String,Object>> salesVolumeRanking = salesRecordMapper.getSalesVolumeRanking(parameterMap);
//		List<HashMap<String,Object>> salesVolumeRanking = salesRecordMapper.getSalesVolumeRanking(vehicleModelId,dealerId);

		// 由reward_record表查出各个销售顾问的满意度排行,同时将结果集转移到一个map中保存以方便遍历
		List<HashMap<String,Object>> satisfactionDegreeRanking = rewardRecordMapper.getSatisfactionDegree(vehicleModelId);
		Map<String, Integer> satisfactionMap = new LinkedHashMap<String, Integer>();
		for (HashMap<String,Object> map : satisfactionDegreeRanking) {
			satisfactionMap.put(map.get("consultantId").toString(),Integer.parseInt(map.get("satisfactionDegree").toString()));
		}

		// 整合销量与满意度排行数据
		SalesRankingVO salesRankingVO = new SalesRankingVO();
		List<SalesRankingVO.SalesConsultantInfo> salesRankingList = new ArrayList<SalesRankingVO.SalesConsultantInfo>();
		for (int i = 0; i < salesVolumeRanking.size(); i++) {
			// 销售冠军信息注入
			if (i == 0) {
				String salesChampion = salesVolumeRanking.get(i).get("consultantName").toString();
				salesRankingVO.setSalesChampion(salesChampion);
				
				Integer volume = Integer.parseInt(salesVolumeRanking.get(i).get("salesVolume").toString());
				salesRankingVO.setSalesVolume(volume);

				// 查找销售冠军的满意度分值
				String championId = salesVolumeRanking.get(i).get("consultantId").toString();
				salesRankingVO.setSatisfactionDegree(satisfactionMap.get(championId));
			}

			// 销售排行信息注入
			SalesRankingVO.SalesConsultantInfo salesConsultantInfo = salesRankingVO.new SalesConsultantInfo();  // 实例化列表
			salesConsultantInfo.setConsultantName(salesVolumeRanking.get(i).get("consultantName").toString());
			salesConsultantInfo.setSalesVolume(Integer.parseInt(salesVolumeRanking.get(i).get("salesVolume").toString()));
			String consultantId = salesVolumeRanking.get(i).get("consultantId").toString();
			salesConsultantInfo.setSatisfactionDegree(satisfactionMap.get(consultantId));

			salesRankingList.add(salesConsultantInfo);
		}
		
		salesRankingVO.setSalesConsultantList(salesRankingList);
		return salesRankingVO;
	}

	@Override
	public SalesRankingVO getSalesRankingByTypeId(String rankingTypeId) {
		// 查出排行榜
		SalesRankingQaExample example = new SalesRankingQaExample();
		example.createCriteria().andRankingTypeIdEqualTo(rankingTypeId);
		example.setOrderByClause("sales_volume DESC");
		List<SalesRankingQa> qaList = salesRankingQaMapper.selectByExample(example);
		
		// 转化为前端显示结构
		SalesRankingVO salesRankingVO = new SalesRankingVO();
		List<SalesRankingVO.SalesConsultantInfo> salesRankingList = new ArrayList<SalesRankingVO.SalesConsultantInfo>();
		for (int i = 0; i < qaList.size(); i++) {
			// 销售冠军信息注入
			if (i == 0) {
				salesRankingVO.setSalesChampion(qaList.get(i).getSaleConsultantName());
				salesRankingVO.setSalesVolume(qaList.get(i).getSalesVolume());
				salesRankingVO.setSatisfactionDegree(qaList.get(i).getSatisfactionDegree());
			}

			// 销售排行信息注入
			SalesRankingVO.SalesConsultantInfo salesConsultantInfo = salesRankingVO.new SalesConsultantInfo();  // 实例化列表
			salesConsultantInfo.setConsultantName(qaList.get(i).getSaleConsultantName());
			salesConsultantInfo.setSalesVolume(qaList.get(i).getSalesVolume());
			salesConsultantInfo.setSatisfactionDegree(qaList.get(i).getSatisfactionDegree());

			salesRankingList.add(salesConsultantInfo);
		}
		
		salesRankingVO.setSalesConsultantList(salesRankingList);
		return salesRankingVO;
	}

	@Override
	public List<String> getSalesRankingList(String dealerId) {
		return salesRankingTypeMapper.selectSalesDate(dealerId);
	}

	@Override
	public List<Map<String, String>> getSalesVehicleModels(String dealerId,
			String salesDate) {
		// 查出对象列表
		SalesRankingTypeExample example = new SalesRankingTypeExample();
		example.createCriteria().andDealerIdEqualTo(dealerId).andTimeEqualTo(salesDate);
		List<SalesRankingType> typeList = salesRankingTypeMapper.selectByExample(example);
		
		// 类型转化以减少回传字段
		List<Map<String,String>> resultMapList = new ArrayList<Map<String,String>>();
		for (SalesRankingType rankingType : typeList) {
			Map<String, String> resultMap = new HashMap<String, String>();
			resultMap.put("rankingTypeId", rankingType.getId());
			resultMap.put("vehicleModelName", rankingType.getVehicleModelName());
			
			resultMapList.add(resultMap);
		}
		
		return resultMapList;
	}

	@Override
	public void startStoring(String begin, String end) {
		// 共用参数
		Map<String,String> parameterMap = new HashMap<String, String>();

		String beginDate = null;
		String endDate = null;
		
		// 如果不给出开始日期则将其赋为本月开始日期
		if (begin == null) {
			beginDate = ReportDateUtil.getMonthBegin();
		} else {
			beginDate = begin;
		}

		// 如果不给出结束日期则在获取到本月结束日期后继续加上时间约束
		if (end == null) {
			endDate =  ReportDateUtil.getMonthEnd() + " " + "23:59:59";
		} else {
			endDate = end + " " + "23:59:59";
		}
		
		parameterMap.put("beginDate", beginDate);
		parameterMap.put("endDate",endDate);

		// 1.录入各个经销商下不同车型当月月报类型
		salesRankingTypeMapper.insertTypeWithVehicleModel(parameterMap);
		
		// 2.录入各个经销商下全部车型当月月报类型
		salesRankingTypeMapper.insertType(parameterMap);
		
		// 3.录入各个经销商下不同车型当月月报
		salesRankingQaMapper.insertQaWithVehicleModel(parameterMap);

		// 4.录入各个经销商下全部车型当月月报
		salesRankingQaMapper.insertQa(parameterMap);

	}
	
	
}
