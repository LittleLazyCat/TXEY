package cn.lby.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.lby.constant.BaseConstant;
import cn.lby.dao.AppointmentsReportWeekMapper;
import cn.lby.dao.ClosingVehicleWeekMapper;
import cn.lby.dao.MarketActivityReportWeekAdvertisementMapper;
import cn.lby.dao.MarketActivityReportWeekClosingIntentionMapper;
import cn.lby.dao.MarketActivityReportWeekClosingVehicleMapper;
import cn.lby.dao.MarketActivityReportWeekIntentionMapper;
import cn.lby.dao.MarketActivityReportWeekMapper;
import cn.lby.dao.TestDriveWeekMapper;
import cn.lby.entity.AppointmentsReportWeek;
import cn.lby.entity.AppointmentsReportWeekExample;
import cn.lby.entity.ClosingVehicleWeek;
import cn.lby.entity.ClosingVehicleWeekExample;
import cn.lby.entity.MarketActivityReportWeek;
import cn.lby.entity.MarketActivityReportWeekAdvertisement;
import cn.lby.entity.MarketActivityReportWeekAdvertisementExample;
import cn.lby.entity.MarketActivityReportWeekClosingIntention;
import cn.lby.entity.MarketActivityReportWeekClosingIntentionExample;
import cn.lby.entity.MarketActivityReportWeekClosingVehicle;
import cn.lby.entity.MarketActivityReportWeekClosingVehicleExample;
import cn.lby.entity.MarketActivityReportWeekExample;
import cn.lby.entity.MarketActivityReportWeekIntention;
import cn.lby.entity.MarketActivityReportWeekIntentionExample;
import cn.lby.entity.TestDriveWeek;
import cn.lby.entity.TestDriveWeekExample;
import cn.lby.service.MarketActivityWeekReportService;
import cn.lby.vo.AccurateAdvertisementVO;
import cn.lby.vo.ClosingNumWeekVO;
import cn.lby.vo.ClosingNumWeekVO.NumVehicleModel;
import cn.lby.vo.ClosingNumWeekVO.TransactionRatioDemo;
import cn.lby.vo.IntentionCustomerCountsVO;
import cn.lby.vo.IntentionCustomerCountsVO.CustomersVehicleModel;
import cn.lby.vo.MarketActivityWeekListVO;
import cn.lby.vo.TestDriveWeekVO;

@Service
public class MarketActivityWeekReportServiceImpl implements
		MarketActivityWeekReportService {

	@Autowired
	MarketActivityReportWeekIntentionMapper marketActivityReportWeekIntentionMapper;
	
	@Autowired
	MarketActivityReportWeekMapper marketActivityReportWeekMapper;

	@Autowired
	AppointmentsReportWeekMapper appointmentsReportWeekMapper;

	@Autowired
	TestDriveWeekMapper testDriveWeekMapper;

	@Autowired
	MarketActivityReportWeekClosingIntentionMapper closingIntentionMapper;

	@Autowired
	MarketActivityReportWeekClosingVehicleMapper closingVehicleMapper;
	
	@Autowired
	ClosingVehicleWeekMapper closingVehicleWeekMapper; 

	@Autowired
	MarketActivityReportWeekAdvertisementMapper advertisementMapper; 

//	@Autowired
//	IntentionCustomerMapper intentionCustomerMapper;
//
//	@Autowired
//	SalesRecordMapper salesRecordMapper;
//	
//	@Autowired
//	MarketActivityMapper marketActivityMapper;
//
//	@Autowired
//	MarketActivityDealerMapper marketActivityDealerMapper;
//	
//	@Autowired
//	DealerMapper dealerMapper;
//	
//	@Autowired
//	MessageStrategy messageStrategy;
//	
//	@Autowired
//	RequestService requestService;
//	
//	@Resource
//	private MarketVehicleModelMapper marketVehicleModelMapper;
//
//	@Resource
//	private AppointmentMapper appointmentMapper;

//	final static Logger logger = Logger.getLogger(RequestServiceImpl.class);

	@Override
	public IntentionCustomerCountsVO getIntentionCustomerCounts(
			String marketActivityWeeklyReportId) {
		// 总数据模型
		IntentionCustomerCountsVO intentionCustomerCountsVO = new IntentionCustomerCountsVO();
		
		// 查出各个意向级别的客户数量
		MarketActivityReportWeekIntentionExample intentionExample = new MarketActivityReportWeekIntentionExample();
		intentionExample.createCriteria().andMarketActivityReportWeekIdEqualTo(marketActivityWeeklyReportId);
		List<MarketActivityReportWeekIntention> list = marketActivityReportWeekIntentionMapper.selectByExample(intentionExample);
		
		// 类型转化
		List<CustomersVehicleModel> currentCustomerList = new ArrayList<IntentionCustomerCountsVO.CustomersVehicleModel>();
		List<CustomersVehicleModel> firstTryCustomerList = new ArrayList<IntentionCustomerCountsVO.CustomersVehicleModel>();
		for (MarketActivityReportWeekIntention intention : list) {
			if (intention.getIsFirst() == BaseConstant.BASE_TRUE) {
				CustomersVehicleModel CustomersVehicleModel = intentionCustomerCountsVO.new CustomersVehicleModel();
				CustomersVehicleModel.setLevelOfIntention(changeIntentionType(intention.getLevelOfIntent()));
				CustomersVehicleModel.setCustomerNumber(intention.getCustomerNum());
				CustomersVehicleModel.setVehicleModel(intention.getVehicleModelName());
				currentCustomerList.add(CustomersVehicleModel);
			} else if (intention.getIsFirst() == BaseConstant.BASE_FALSE) {
				CustomersVehicleModel CustomersVehicleModel = intentionCustomerCountsVO.new CustomersVehicleModel();
				CustomersVehicleModel.setLevelOfIntention(changeIntentionType(intention.getLevelOfIntent()));
				CustomersVehicleModel.setCustomerNumber(intention.getCustomerNum());
				CustomersVehicleModel.setVehicleModel(intention.getVehicleModelName());
				firstTryCustomerList.add(CustomersVehicleModel);
			}
		}
		
		intentionCustomerCountsVO.setCurrentCustomerList(currentCustomerList);
		intentionCustomerCountsVO.setFirstTryCustomerList(firstTryCustomerList);
		
		// 查出推送数据
		MarketActivityReportWeek reportWeek = marketActivityReportWeekMapper.selectByPrimaryKey(marketActivityWeeklyReportId);
		
		// 数据录入
		intentionCustomerCountsVO.setPush_plan_num_week(reportWeek.getPushPlanNumWeek());
		intentionCustomerCountsVO.setPush_actual_num_week(reportWeek.getPushActualNumWeek());
		intentionCustomerCountsVO.setPush_plan_num(reportWeek.getPushPlanNum());
		intentionCustomerCountsVO.setPush_actual_num(reportWeek.getPushActualNum());
		
		return intentionCustomerCountsVO;
	}
	
	public String changeIntentionType(Integer intentionLevel) {
		String result = null;
		switch (intentionLevel) {
		case BaseConstant.LEVEL_OF_INTENT_H:
			result = "H";
			break;
		case BaseConstant.LEVEL_OF_INTENT_A:
			result = "A";
			break;
		case BaseConstant.LEVEL_OF_INTENT_B:
			result = "B";
			break;
		case BaseConstant.LEVEL_OF_INTENT_C:
			result = "C";
			break;
		default:
			result = "";
			break;
		}
		return result;
	}

	@Override
	@Transactional
	public TestDriveWeekVO getTestDriveWeek(String marketActivityWeeklyReportId) {
		// 这里先给一个经销商Id，后面再从cookie中拿
		String dealerId = "1baf88c0-7404-11e6-8da9-005056af50a8";
		
		// 总数据模型
		TestDriveWeekVO testDriveWeekVO = new TestDriveWeekVO();

		// 查出预约到店量和留档数量
		MarketActivityReportWeek reportWeek = marketActivityReportWeekMapper.selectByPrimaryKey(marketActivityWeeklyReportId);

		// 周报表数据录入
		testDriveWeekVO.setAppointments(reportWeek.getAppointmentIntoNumWeek());
		testDriveWeekVO.setTotalAppointments(reportWeek.getAppointmentIntoNum());
		testDriveWeekVO.setArchivesNumWeek(reportWeek.getArchivesNumWeek());
		testDriveWeekVO.setArchivesNum(reportWeek.getArchivesNum());
		
		// 从周报主表数据中拿到市场活动Id
		String marketActivityId = reportWeek.getMarketActivityId();
		
		// 查预进到店量周报(注意按创建时间排序,注意给到经销商和市场活动约束)
		AppointmentsReportWeekExample example2 = new AppointmentsReportWeekExample();
		example2.setOrderByClause("create_time");
		example2.createCriteria().andDealerIdEqualTo(dealerId).andMarketActivityIdEqualTo(marketActivityId);
		List<AppointmentsReportWeek> appointmentsWeekList = appointmentsReportWeekMapper.selectByExample(example2);

		// 预约进店量统计数据录入
		List<Integer> appointmentsList = new ArrayList<Integer>();
		for (AppointmentsReportWeek appointment : appointmentsWeekList) {
			appointmentsList.add(appointment.getNum());
		}
		testDriveWeekVO.setAppointmentsList(appointmentsList);
		
		// 查询试驾次数周报(按车型排序以提高数据转化效率,按创建时间排序为了控制第几周)
		TestDriveWeekExample example3 = new TestDriveWeekExample();
		example3.setOrderByClause("vehicle_model_name,create_time");
		example3.createCriteria().andDealerIdEqualTo(dealerId).andMarketActivityIdEqualTo(marketActivityId);
		List<TestDriveWeek> testDriveWeekList = testDriveWeekMapper.selectByExample(example3);
		
		// 试驾次数统计数据录入
		Map<String,List<Integer>> testDriveMap = new LinkedHashMap<String, List<Integer>>();
		List<Integer> testDriveList = null;
		for (TestDriveWeek testDriveWeek : testDriveWeekList) {
			String vehicleModelName = testDriveWeek.getVehicleModelName();
			if (testDriveMap.containsKey(vehicleModelName)) {
				testDriveList = testDriveMap.get(vehicleModelName);
				testDriveList.add(testDriveWeek.getNum());
//				testDriveMap.put(vehicleModelName, testDriveList);			//要不要都可以
			} else {
				testDriveList = new ArrayList<Integer>();
				testDriveList.add(testDriveWeek.getNum());
				testDriveMap.put(vehicleModelName, testDriveList);
			}
		}
		testDriveWeekVO.setTestDriveMap(testDriveMap);
		
		return testDriveWeekVO;
	}

	@Override
	public ClosingNumWeekVO getClosingWeek(String marketActivityWeeklyReportId) {
		// 这里先给一个经销商Id，后面再从cookie中拿
		String dealerId = "1baf88c0-7404-11e6-8da9-005056af50a8";

		// 总数据模型
		ClosingNumWeekVO closingNumWeekVO = new ClosingNumWeekVO();
		
		// 1.查出本周/累计成交量、留档量及预约进店量并录入(这里先做这块是为了在查主表周成交列表的时候能确定出市场活动以保证数据的正确性)
		MarketActivityReportWeek reportWeek = marketActivityReportWeekMapper.selectByPrimaryKey(marketActivityWeeklyReportId);
		
		closingNumWeekVO.setClosingNumWeek(reportWeek.getClosingNumWeek());
		closingNumWeekVO.setClosingNum(reportWeek.getClosingNum());
		closingNumWeekVO.setArchivesNumWeek(reportWeek.getArchivesNumWeek());
		closingNumWeekVO.setArchivesNum(reportWeek.getArchivesNum());
		closingNumWeekVO.setAppointments(reportWeek.getAppointmentIntoNumWeek());
		closingNumWeekVO.setAppointmentsTotalNum(reportWeek.getAppointmentIntoNum());

		// 从周报主表数据中拿到市场活动Id
		String marketActivityId = reportWeek.getMarketActivityId();

		// 2.各周成交数量统计(注意按创建时间排序以控制第几周，同时加入经销商和市场活动约束)
		MarketActivityReportWeekExample weekReportExample = new MarketActivityReportWeekExample();
		weekReportExample.setOrderByClause("create_time");
		weekReportExample.createCriteria().andIstotalEqualTo(BaseConstant.MARKET_ACTIVITY_TOTAL_FALSE).andDealerIdEqualTo(dealerId).andMarketActivityIdEqualTo(marketActivityId);
		List<MarketActivityReportWeek> reportWeekList = marketActivityReportWeekMapper.selectByExample(weekReportExample);
		
		List<Integer> closingNumWeekList = new ArrayList<Integer>();
		for (MarketActivityReportWeek report : reportWeekList) {
			closingNumWeekList.add(report.getClosingNumWeek());
		}
		closingNumWeekVO.setClosingNumWeekList(closingNumWeekList);

		// 3.查各意向级别客户的首次成交数量与客户数量并录入
		MarketActivityReportWeekClosingIntentionExample closingIntentionExample = new MarketActivityReportWeekClosingIntentionExample();
		closingIntentionExample.createCriteria().andMarketActivityReportWeekIdEqualTo(marketActivityWeeklyReportId);
		List<MarketActivityReportWeekClosingIntention> closingIntentionWeekList = closingIntentionMapper.selectByExample(closingIntentionExample);
		
		List<TransactionRatioDemo> transactionRatio = new ArrayList<ClosingNumWeekVO.TransactionRatioDemo>();
		for (MarketActivityReportWeekClosingIntention intention : closingIntentionWeekList) {
			TransactionRatioDemo transactionRatioDemo = closingNumWeekVO.new TransactionRatioDemo();
			transactionRatioDemo.setLevelOfIntention(changeIntentionType(intention.getLevelOfIntent()));
			transactionRatioDemo.setClosingNumFirst(intention.getClosingNumFrist());
			transactionRatioDemo.setNumFirst(intention.getNumFirst());
			transactionRatio.add(transactionRatioDemo);
		}
		closingNumWeekVO.setTransactionRatio(transactionRatio);

		// 4.分车型统计每周的成交数量
		MarketActivityReportWeekClosingVehicleExample closingVehicleExample = new MarketActivityReportWeekClosingVehicleExample();
		closingVehicleExample.createCriteria().andMarketActivityReportWeekIdEqualTo(marketActivityWeeklyReportId);
		List<MarketActivityReportWeekClosingVehicle> closingVehicleWeekList = closingVehicleMapper.selectByExample(closingVehicleExample);
		
		List<NumVehicleModel> closingNumWeekVehicleModel = new ArrayList<ClosingNumWeekVO.NumVehicleModel>();
		for (MarketActivityReportWeekClosingVehicle closingVehicle : closingVehicleWeekList) {
			NumVehicleModel numVehicleModel = closingNumWeekVO.new NumVehicleModel();
			numVehicleModel.setClosingNumWeek(closingVehicle.getClosingNumWeek());
			numVehicleModel.setClosingNum(closingVehicle.getClosingNum());
			numVehicleModel.setVehicleModel(closingVehicle.getVehicleModelName());
			
			// 查该车型下各个周的成交情况(单表注意加经销商和市场活动约束)
			ClosingVehicleWeekExample example = new ClosingVehicleWeekExample();
			example.createCriteria().andVehicleModelIdEqualTo(closingVehicle.getVehicleModelId());	// 这里还是用 Id 查更合适
			example.setOrderByClause("create_time");
			example.createCriteria().andDealerIdEqualTo(dealerId).andMarketActivityIdEqualTo(marketActivityId);
			List<ClosingVehicleWeek> list = closingVehicleWeekMapper.selectByExample(example);
			
			List<Integer> closingNumList = new ArrayList<Integer>();
			for (ClosingVehicleWeek unit : list) {
				closingNumList.add(unit.getNum());
			}
			numVehicleModel.setClosingNumWeekList(closingNumList);
			
			// 加入队列
			closingNumWeekVehicleModel.add(numVehicleModel);
		}
		closingNumWeekVO.setClosingNumWeekVehicleModel(closingNumWeekVehicleModel);
		
		return closingNumWeekVO;
	}

	@Override
	public AccurateAdvertisementVO getAccurateAdvertisement(String marketActivityWeeklyReportId) {
		// 总数据模型
		AccurateAdvertisementVO accurateAdvertisementVO = new AccurateAdvertisementVO();
		
		// 1.查各广告渠道相关信息
		MarketActivityReportWeekAdvertisementExample advertisementExample = new MarketActivityReportWeekAdvertisementExample();
		advertisementExample.createCriteria().andMarketActivityReportWeekIdEqualTo(marketActivityWeeklyReportId);
		List<MarketActivityReportWeekAdvertisement> adWeekReportList = advertisementMapper.selectByExample(advertisementExample);
		
		List<AccurateAdvertisementVO.AdvertisementModel> advertisements = new ArrayList<AccurateAdvertisementVO.AdvertisementModel>();
		for (MarketActivityReportWeekAdvertisement adWeekReport : adWeekReportList) {
			AccurateAdvertisementVO.AdvertisementModel advertisement = accurateAdvertisementVO.new AdvertisementModel();
			advertisement.setAccessName(adWeekReport.getChannelName());
			advertisement.setArchivesNum(adWeekReport.getArchivesNum());
			advertisement.setClickNum(adWeekReport.getClickNum());
			advertisement.setExposureTimes(adWeekReport.getShowNum());
			advertisements.add(advertisement);
		}
		accurateAdvertisementVO.setAdvertisements(advertisements);
		
		// 2.查老客户曝光、留档信息
		MarketActivityReportWeek reportWeek = marketActivityReportWeekMapper.selectByPrimaryKey(marketActivityWeeklyReportId);

		accurateAdvertisementVO.setOldCustomerArchivesNum(reportWeek.getOldCustomerArchivesNum());
		accurateAdvertisementVO.setOldCustomerShowNum(reportWeek.getOldCustomerShowNum());
		
		return accurateAdvertisementVO;
	}

	@Override
	public List<MarketActivityWeekListVO> getMarketActivityWeekReportList() {
		// 这里先给一个经销商Id，后面再从cookie中拿
		String dealerId = "1baf88c0-7404-11e6-8da9-005056af50a8";
		
		// 这里选择按创建日期一次性查出所有报表类型
		MarketActivityReportWeekExample weekReportExample = new MarketActivityReportWeekExample();
		weekReportExample.setOrderByClause("create_time DESC");
		weekReportExample.createCriteria().andIstotalEqualTo(BaseConstant.MARKET_ACTIVITY_TOTAL_FALSE).andDealerIdEqualTo(dealerId);
		List<MarketActivityReportWeek> reportWeekList = marketActivityReportWeekMapper.selectByExample(weekReportExample);
		
		// 先用一个map去接收结果
		Map<String,List<String>> weekReportMap = new HashMap<String, List<String>>();
		List<String> reportIdList = null;
		for (MarketActivityReportWeek report : reportWeekList) {
			String marketActivityName = report.getMarketActivityName();
			if (weekReportMap.containsKey(marketActivityName)) {
				reportIdList = weekReportMap.get(marketActivityName);
				reportIdList.add(report.getId());
			} else {
				reportIdList = new ArrayList<String>();
				reportIdList.add(report.getId());
				weekReportMap.put(marketActivityName, reportIdList);
			}
		}
		
		// 总模型
		List<MarketActivityWeekListVO> marketActivityWeekListVOList = new ArrayList<MarketActivityWeekListVO>();

		// 数据转移
		for (Map.Entry<String, List<String>> entry : weekReportMap.entrySet()) {
			MarketActivityWeekListVO marketActivityWeekListVO = new MarketActivityWeekListVO();
			marketActivityWeekListVO.setMarketActivityName(entry.getKey());
			marketActivityWeekListVO.setMarketActivityWeeklyReportIds(entry.getValue());
			marketActivityWeekListVOList.add(marketActivityWeekListVO);
		}
		
		return marketActivityWeekListVOList;
	}
	
	@Override
	public List<HashMap<String, String>> getMarketActivityTotalReportList() {
		// 这里先给一个经销商Id，后面再从cookie中拿
		String dealerId = "1baf88c0-7404-11e6-8da9-005056af50a8";

		// 查出所有总报
		MarketActivityReportWeekExample weekReportExample = new MarketActivityReportWeekExample();
		weekReportExample.setOrderByClause("create_time DESC");
		weekReportExample.createCriteria().andIstotalEqualTo(BaseConstant.MARKET_ACTIVITY_TOTAL_TRUE).andDealerIdEqualTo(dealerId);
		List<MarketActivityReportWeek> reports = marketActivityReportWeekMapper.selectByExample(weekReportExample);

		List<HashMap<String,String>> totalReportsList = new ArrayList<HashMap<String,String>>();
		for (MarketActivityReportWeek report : reports) {
			HashMap<String,String> map = new HashMap<String, String>();
			map.put("marketActivityName", report.getMarketActivityName());
			map.put("marketActivityReportId", report.getId());
			totalReportsList.add(map);
		}

		return totalReportsList;
	}


//	@Override
//	public void generateReportWeekData(String start, String end) {
//		// 查出所有正在进行的市场活动
//		MarketActivityExample marketActivityExample = new MarketActivityExample();
//		marketActivityExample.createCriteria().andStatusEqualTo(BaseConstant.BASE_TRUE);
//		List<MarketActivity> activitys = marketActivityMapper.selectByExample(marketActivityExample);
//		
//		for (MarketActivity marketActivity : activitys) {
//			// 查出正在进行该市场活动的经销商
//			MarketActivityDealerExample dealerExample = new MarketActivityDealerExample();
//			dealerExample.createCriteria().andMarketActivityIdEqualTo(marketActivity.getId()).andStatusEqualTo(BaseConstant.BASE_TRUE);
//			List<MarketActivityDealer> dealers = marketActivityDealerMapper.selectByExample(dealerExample);
//			
//			for (MarketActivityDealer marketActivityDealer : dealers) {
//				// 1.主单基本量赋值
//				String marketActivityWeeklyReportId = UUIDUtil.getOrigUUID();
//				MarketActivityReportWeek marketActivityReportWeek = new MarketActivityReportWeek();
//				marketActivityReportWeek.setId(marketActivityWeeklyReportId);
//				marketActivityReportWeek.setCreateTime(new Date());
//				
//				marketActivityReportWeek.setMarketActivityId(marketActivity.getId());
//				marketActivityReportWeek.setMarketActivityCode(marketActivity.getCode());
//				marketActivityReportWeek.setMarketActivityName(marketActivity.getName());
//				
//				marketActivityReportWeek.setDealerId(marketActivityDealer.getDealerId());
//				marketActivityReportWeek.setDealerCode(marketActivityDealer.getDealerCode());
//				marketActivityReportWeek.setDealerName(marketActivityDealer.getDealerName());
//
//				// 如果两个参数都不传则给到本周的开始结束日期;
//				// 如果只给到开始日期，结束日期就赋为当前日期;
//				// 如果只给到结束日期，开始日期赋为相应市场活动的开始日期。
//				Date startDate = null;
//				Date endDate = null;
//				if (start == null && end == null) {
//					startDate = ReportDateUtil.getTimesWeekmorning();
//					endDate = ReportDateUtil.getTimesWeeknight();
//				} else if (start != null && end == null){
//					startDate = DateUtil.stringToDate(start);
//					endDate = new Date();
//				} else if (start == null && end != null){
//					startDate = marketActivity.getStartDate();
//					endDate = DateUtil.stringToDate(end);
//				} else {
//					startDate = DateUtil.stringToDate(start);
//					endDate = DateUtil.stringToDateIn(end + " " + "23:59:59");	 	// 这里人为的加上当天时间末约束
//				}
//
//				marketActivityReportWeek.setWeekStartTime(startDate);
//				marketActivityReportWeek.setWeekEndTime(endDate);
//				marketActivityReportWeek.setIstotal(BaseConstant.MARKET_ACTIVITY_TOTAL_FALSE);
//				
//				// 主单数据插入
//				marketActivityReportWeekMapper.insert(marketActivityReportWeek);
//				
//				// 2.调用子表数据生成器
//				Dealer dealer = dealerMapper.selectByPrimaryKey(marketActivityDealer.getDealerId());
//
//				// 精准广告
//				requestService.generatorAdvertisementData(null, null, marketActivity, marketActivityWeeklyReportId);
//				
//				// 到店体验
//				requestService.generatorTestDriveData(startDate, endDate, marketActivity, dealer, marketActivityWeeklyReportId);
//				
//				// 意向客户
//				generateIntentionCustomerNumData(marketActivityWeeklyReportId, startDate, endDate, marketActivity, dealer);
//				
//				// 成交
//				generateClosingWeekData(marketActivityWeeklyReportId, startDate, endDate, marketActivity, dealer);
//				
//			}
//			
//		}
//	}
	
//	@Override
//	public void generateClosingWeekData(String marketActivityWeeklyReportId,Date startDate,Date endDate,MarketActivity marketActivity,Dealer dealer) {
//		// 1.本周成交量与累计成交量
//		MarketActivityReportWeek marketActivityReportWeek = new MarketActivityReportWeek();
//		marketActivityReportWeek.setId(marketActivityWeeklyReportId);
//
//		// 1.1 累计成交量
//		SalesRecordExample example = new SalesRecordExample();
//		bz.sunlight.entity.SalesRecordExample.Criteria salesRecordCriteria = example.createCriteria().andMarketActivityIdEqualTo(marketActivity.getId()).andDealerIdEqualTo(dealer.getId());
//		marketActivityReportWeek.setClosingNum((salesRecordMapper.countByExample(example)));
//
//		// 1.2 本周成交量
//		salesRecordCriteria.andCreateTimeBetween(startDate, endDate);
//		marketActivityReportWeek.setClosingNumWeek(salesRecordMapper.countByExample(example));
//
//		// 更新主单
//		marketActivityReportWeekMapper.updateByPrimaryKeySelective(marketActivityReportWeek);
//		
//		// 2.首次确度数量与相应成交数量
//		Map<String,Object> parameterMapFirst = new HashMap<String, Object>();
//		parameterMapFirst.put("dealerId", dealer.getId());
//		parameterMapFirst.put("marketActivityCode", marketActivity.getCode());
//		
//		// 2.1 首次各类确度数量(因为结果集有效字段就两个，故可将其转化为一个map)
//		List<HashMap<String,Object>> firstIntentionCustomers = intentionCustomerMapper.getFirstIntentionCustomerNum(parameterMapFirst);
//		HashMap<Object,Object> intentionNumMap = new HashMap<Object, Object>();
//		for (HashMap<String,Object> map : firstIntentionCustomers) {
//			intentionNumMap.put(map.get("Level_Of_Intent_First"), map.get("num"));
//		}
//		
//		// 2.2 首次确度成交数量
//		parameterMapFirst.put("status", 2);
//		List<HashMap<String,Object>> firstFinishedIntentionCustomers = intentionCustomerMapper.getFirstIntentionCustomerNum(parameterMapFirst);
//		
//		for (HashMap<String,Object> customer :firstFinishedIntentionCustomers) {
//			MarketActivityReportWeekClosingIntention intention = new MarketActivityReportWeekClosingIntention();
//			intention.setId(UUIDUtil.getOrigUUID());
//			intention.setMarketActivityReportWeekId(marketActivityWeeklyReportId);
//			intention.setLevelOfIntent(Integer.parseInt(customer.get("Level_Of_Intent_First").toString()));
//			intention.setClosingNumFrist(Integer.parseInt(customer.get("num").toString()));
//			intention.setNumFirst(Integer.parseInt(intentionNumMap.get(customer.get("Level_Of_Intent_First")).toString()));
//			closingIntentionMapper.insert(intention);
//		}
//		
//		// 3.分车型统计成交量
//		// 先查出当前当前经销商在该市场活动下所有的车型
//		MarketVehicleModelExample marketVehicleModelExample = new MarketVehicleModelExample();
//		marketVehicleModelExample.createCriteria().andMarketActivityIdEqualTo(marketActivity.getId());
//		List<MarketVehicleModel> marketVehicleModels = marketVehicleModelMapper.selectVehicleByMarketAndDealer(marketActivity.getId(), dealer.getId());
//		
//		for (MarketVehicleModel marketVehicleModel : marketVehicleModels) {
//			String vehicleModelId = marketVehicleModel.getVehicleModelId();
//			String vehicleModelCode = marketVehicleModel.getVehicleModelCode();
//			String vehicleModelName = marketVehicleModel.getVehicleModelName();
//
//			// 3.1 市场活动周报清单-成交-按车表录入数据
//			MarketActivityReportWeekClosingVehicle marketActivityReportWeekClosingVehicle = new MarketActivityReportWeekClosingVehicle();
//			marketActivityReportWeekClosingVehicle.setId(UUIDUtil.getOrigUUID());
//			marketActivityReportWeekClosingVehicle.setCreateTime(new Date());
//			marketActivityReportWeekClosingVehicle.setMarketActivityReportWeekId(marketActivityWeeklyReportId);
//			marketActivityReportWeekClosingVehicle.setVehicleModelId(vehicleModelId);
//			marketActivityReportWeekClosingVehicle.setVehicleModelCode(vehicleModelCode);
//			marketActivityReportWeekClosingVehicle.setVehicleModelName(vehicleModelName);
//
//			// 各车型累计成交数量统计
//			SalesRecordExample salesRecordExample = new SalesRecordExample();
//			bz.sunlight.entity.SalesRecordExample.Criteria criteria = salesRecordExample.createCriteria().andMarketActivityIdEqualTo(marketActivity.getId()).andDealerIdEqualTo(dealer.getId()).andVehicleModelIdEqualTo(vehicleModelId);
//			marketActivityReportWeekClosingVehicle.setClosingNum(salesRecordMapper.countByExample(salesRecordExample));
//
//			// 各车型本周成交数量统计
//			criteria.andBuyDateBetween(startDate, endDate);
//			Integer salesNumWeek = salesRecordMapper.countByExample(salesRecordExample);
//			marketActivityReportWeekClosingVehicle.setClosingNumWeek(salesNumWeek);
//			
//			closingVehicleMapper.insertSelective(marketActivityReportWeekClosingVehicle);
//			
//			// 3.2 成交数量-车型表录入数据
//			ClosingVehicleWeek closingVehicleWeek = new ClosingVehicleWeek();
//			closingVehicleWeek.setId(UUIDUtil.getOrigUUID());
//			closingVehicleWeek.setCreateTime(new Date());
//			closingVehicleWeek.setWeekStartTime(startDate);
//			closingVehicleWeek.setWeekEndTime(endDate);
//			closingVehicleWeek.setDealerId(dealer.getId());
//			closingVehicleWeek.setDealerCode(dealer.getCode());
//			closingVehicleWeek.setDealerName(dealer.getName());
//			closingVehicleWeek.setMarketActivityId(marketActivity.getId());
//			closingVehicleWeek.setMarketActivityCode(marketActivity.getCode());
//			closingVehicleWeek.setMarketActivityName(marketActivity.getName());
//			closingVehicleWeek.setVehicleModelId(vehicleModelId);
//			closingVehicleWeek.setVehicleModelCode(vehicleModelCode);
//			closingVehicleWeek.setVehicleModelName(vehicleModelName);
//			closingVehicleWeek.setNum(salesNumWeek);;
//			closingVehicleWeekMapper.insertSelective(closingVehicleWeek);
//		}
//
//		/* ------------------------ 下面的方式无法统计出售车型在各个结算周期内的成交数量(有可能为0) ------------------------*/
////		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
////		String start = dateFormat.format(startDate);
////		String end = dateFormat.format(endDate);
////
////		HashMap<String, String> parameterMap = new HashMap<String, String>();
////		parameterMap.put("marketActivityId", marketActivity.getId());
////		parameterMap.put("dealerId", dealer.getId());
////		parameterMap.put("start", start);
////		parameterMap.put("end", end);
////		List<HashMap<String,Object>> weekSalesVolumeVehicleList = salesRecordMapper.getWeekSalesVolumeWithVehicleModel(parameterMap);
////		
////		// 将数据结果插入相关结转表
////		for (HashMap<String,Object> map : weekSalesVolumeVehicleList) {
////			String vehicleModelId = map.get("vehicle_model_id").toString();
////			String vehicleModelCode = map.get("vehicle_model_code").toString();
////			String vehicleModelName = map.get("vehicle_model_name").toString();
////			Integer salesNumWeek = Integer.parseInt(map.get("num").toString());
////			
////			// 3.1 市场活动周报清单-成交-按车表录入数据
////			MarketActivityReportWeekClosingVehicle marketActivityReportWeekClosingVehicle = new MarketActivityReportWeekClosingVehicle();
////			marketActivityReportWeekClosingVehicle.setId(UUIDUtil.getOrigUUID());
////			marketActivityReportWeekClosingVehicle.setCreateTime(new Date());
////			marketActivityReportWeekClosingVehicle.setMarketActivityReportWeekId(marketActivityWeeklyReportId);
////			marketActivityReportWeekClosingVehicle.setClosingNumWeek(salesNumWeek);
////			marketActivityReportWeekClosingVehicle.setVehicleModelId(vehicleModelId);
////			marketActivityReportWeekClosingVehicle.setVehicleModelCode(vehicleModelCode);
////			marketActivityReportWeekClosingVehicle.setVehicleModelName(vehicleModelName);
////			
////			// 各车型累计成交数量统计
////			SalesRecordExample salesRecordExample = new SalesRecordExample();
////			salesRecordExample.createCriteria().andMarketActivityIdEqualTo(marketActivity.getId()).andDealerIdEqualTo(dealer.getId()).andVehicleModelIdEqualTo(vehicleModelId);
////			marketActivityReportWeekClosingVehicle.setClosingNum(salesRecordMapper.countByExample(salesRecordExample));
////			
////			closingVehicleMapper.insertSelective(marketActivityReportWeekClosingVehicle);
////			
////			// 3.2 成交数量-车型表录入数据
////			ClosingVehicleWeek closingVehicleWeek = new ClosingVehicleWeek();
////			closingVehicleWeek.setId(UUIDUtil.getOrigUUID());
////			closingVehicleWeek.setCreateTime(new Date());
////			closingVehicleWeek.setWeekStartTime(startDate);
////			closingVehicleWeek.setWeekEndTime(endDate);
////			closingVehicleWeek.setDealerId(dealer.getId());
////			closingVehicleWeek.setDealerCode(dealer.getCode());
////			closingVehicleWeek.setDealerName(dealer.getName());
////			closingVehicleWeek.setMarketActivityId(marketActivity.getId());
////			closingVehicleWeek.setMarketActivityCode(marketActivity.getCode());
////			closingVehicleWeek.setMarketActivityName(marketActivity.getName());
////			closingVehicleWeek.setVehicleModelId(vehicleModelId);
////			closingVehicleWeek.setVehicleModelCode(vehicleModelCode);
////			closingVehicleWeek.setVehicleModelName(vehicleModelName);
////			closingVehicleWeek.setNum(salesNumWeek);;
////			closingVehicleWeekMapper.insertSelective(closingVehicleWeek);
////		}
//		
//	}

//	@Override
//	public void generateIntentionCustomerNumData(String marketActivityWeeklyReportId,Date startDate,Date endDate,MarketActivity marketActivity,Dealer dealer) {		
//		// 当前各类数量
//		HashMap<String, String> parameterMap = new HashMap<String, String>();
//		parameterMap.put("marketActivityCode", marketActivity.getCode());
//		parameterMap.put("dealerId", dealer.getId());
//		parameterMap.put("groupByClause","level_of_intent");
//		List<HashMap<String,Object>> currentIntentionCustomers = intentionCustomerMapper.getIntentionCustomerNumWithVehicle(parameterMap);
//		for (HashMap<String,Object> customer :currentIntentionCustomers) {
//			MarketActivityReportWeekIntention intention = new MarketActivityReportWeekIntention();
//			intention.setId(UUIDUtil.getOrigUUID());
//			intention.setMarketActivityReportWeekId(marketActivityWeeklyReportId);
//			intention.setCreateTime(new Date());
//			intention.setIsFirst(BaseConstant.BASE_FALSE);
//			intention.setCustomerNum(Integer.parseInt(customer.get("num").toString()));
//			intention.setLevelOfIntent(Integer.parseInt(customer.get("level_of_intent").toString()));
//			intention.setVehicleModelId(customer.get("vehicle_model_id").toString());
//			intention.setVehicleModelCode(customer.get("vehicle_model_code").toString());
//			intention.setVehicleModelName(customer.get("vehicle_model_name").toString());
//			marketActivityReportWeekIntentionMapper.insert(intention);
//		}
//		
//		// 首次各类数量
//		HashMap<String, String> parameterMapFirst = new HashMap<String, String>();
//		parameterMapFirst.put("marketActivityCode", marketActivity.getCode());
//		parameterMapFirst.put("dealerId", dealer.getId());
//		parameterMapFirst.put("groupByClause","Level_Of_Intent_First");
//		List<HashMap<String,Object>> firstIntentionCustomers = intentionCustomerMapper.getIntentionCustomerNumWithVehicle(parameterMapFirst);
//		for (HashMap<String,Object> customer :firstIntentionCustomers) {
//			MarketActivityReportWeekIntention intention = new MarketActivityReportWeekIntention();
//			intention.setId(UUIDUtil.getOrigUUID());
//			intention.setMarketActivityReportWeekId(marketActivityWeeklyReportId);
//			intention.setCreateTime(new Date());
//			intention.setIsFirst(BaseConstant.BASE_TRUE);
//			intention.setCustomerNum(Integer.parseInt(customer.get("num").toString()));
//			intention.setLevelOfIntent(Integer.parseInt(customer.get("Level_Of_Intent_First").toString()));
//			intention.setVehicleModelId(customer.get("vehicle_model_id").toString());
//			intention.setVehicleModelCode(customer.get("vehicle_model_code").toString());
//			intention.setVehicleModelName(customer.get("vehicle_model_name").toString());
//			marketActivityReportWeekIntentionMapper.insert(intention);
//		}
//		
//		messageStrategy.generatorPushNum(startDate, endDate, marketActivityWeeklyReportId);
//	}

//	@Override
//	public void generateReportTotalData(String start, String end) {
//		// 查出所有正在进行的市场活动
//		MarketActivityExample marketActivityExample = new MarketActivityExample();
//		marketActivityExample.createCriteria().andStatusEqualTo(BaseConstant.BASE_TRUE);
//		List<MarketActivity> activitys = marketActivityMapper.selectByExample(marketActivityExample);
//		
//		for (MarketActivity marketActivity : activitys) {
//			// 查出正在进行该市场活动的经销商
//			MarketActivityDealerExample dealerExample = new MarketActivityDealerExample();
//			dealerExample.createCriteria().andMarketActivityIdEqualTo(marketActivity.getId()).andStatusEqualTo(BaseConstant.BASE_TRUE);
//			List<MarketActivityDealer> dealers = marketActivityDealerMapper.selectByExample(dealerExample);
//			
//			for (MarketActivityDealer marketActivityDealer : dealers) {
//				// 删除之前统计的相同经销商相同市场活动的结转数据(仅针对总报)
//				MarketActivityReportWeekExample marketActivityReportWeekExample = new MarketActivityReportWeekExample();
//				marketActivityReportWeekExample.createCriteria().andMarketActivityIdEqualTo(marketActivity.getId()).andDealerIdEqualTo(marketActivityDealer.getDealerId()).andIstotalEqualTo(BaseConstant.MARKET_ACTIVITY_TOTAL_TRUE);
//				List<MarketActivityReportWeek> existedReports = marketActivityReportWeekMapper.selectByExample(marketActivityReportWeekExample);
//				
//				if (existedReports.size() != 0) {
//					// 获取待删主表id
//					String marketActivityReportId = existedReports.get(0).getId(); 
//					
//					// 删除主表
//					marketActivityReportWeekMapper.deleteByPrimaryKey(marketActivityReportId);
//					
//					// 删除各个子表
//					MarketActivityReportWeekAdvertisementExample advertisementExample = new MarketActivityReportWeekAdvertisementExample();
//					advertisementExample.createCriteria().andMarketActivityReportWeekIdEqualTo(marketActivityReportId);
//					advertisementMapper.deleteByExample(advertisementExample);
//					
//					MarketActivityReportWeekIntentionExample intentionExample = new MarketActivityReportWeekIntentionExample();
//					intentionExample.createCriteria().andMarketActivityReportWeekIdEqualTo(marketActivityReportId);
//					marketActivityReportWeekIntentionMapper.deleteByExample(intentionExample);
//
//					MarketActivityReportWeekClosingIntentionExample closingIntentionExample = new MarketActivityReportWeekClosingIntentionExample();
//					closingIntentionExample.createCriteria().andMarketActivityReportWeekIdEqualTo(marketActivityReportId);
//					closingIntentionMapper.deleteByExample(closingIntentionExample);
//
//					MarketActivityReportWeekClosingVehicleExample closingVehicleExample = new MarketActivityReportWeekClosingVehicleExample();
//					closingVehicleExample.createCriteria().andMarketActivityReportWeekIdEqualTo(marketActivityReportId);
//					closingVehicleMapper.deleteByExample(closingVehicleExample);
//				}
//				
//				// 1.主单基本量赋值
//				String marketActivityWeeklyReportId = UUIDUtil.getOrigUUID();
//				MarketActivityReportWeek marketActivityReportWeek = new MarketActivityReportWeek();
//				marketActivityReportWeek.setId(marketActivityWeeklyReportId);
//				marketActivityReportWeek.setCreateTime(new Date());
//				
//				marketActivityReportWeek.setMarketActivityId(marketActivity.getId());
//				marketActivityReportWeek.setMarketActivityCode(marketActivity.getCode());
//				marketActivityReportWeek.setMarketActivityName(marketActivity.getName());
//				
//				marketActivityReportWeek.setDealerId(marketActivityDealer.getDealerId());
//				marketActivityReportWeek.setDealerCode(marketActivityDealer.getDealerCode());
//				marketActivityReportWeek.setDealerName(marketActivityDealer.getDealerName());
//
//				// 如果不给出开始日期则将其赋为相应市场活动的开始日期
//				// 如果不给出结束日期则将其赋为当前日期
//				Date startDate = null;
//				Date endDate = null;
//				if (start == null) {
//					startDate = marketActivity.getStartDate();
//				} else {
//					startDate = DateUtil.stringToDate(start);
//				}
//				if (end == null) {
//					endDate = new Date();
//				} else {
//					endDate = DateUtil.stringToDateIn(end + " " + "23:59:59");
//				}
//				
//				marketActivityReportWeek.setWeekStartTime(startDate);
//				marketActivityReportWeek.setWeekEndTime(endDate);
//				marketActivityReportWeek.setIstotal(BaseConstant.MARKET_ACTIVITY_TOTAL_TRUE);
//								
//				// 2.调用子表数据生成器及主表业务字段赋值
//				Dealer dealer = dealerMapper.selectByPrimaryKey(marketActivityDealer.getDealerId());
//				
//				// 2.2 到店体验
//				AppointmentExample appointmentExample = new AppointmentExample();
//				// 累计预约进店量
//				appointmentExample.createCriteria().andMarketActivityIdEqualTo(marketActivity.getId()).andDealerIdEqualTo(dealer.getId())
//						.andStatusEqualTo(BaseConstant.APPOINTMENT_STATUS_COMPLETE).andInfoSourceEqualTo(BaseConstant.CUSTOMER_SOURCE_TYPE_AIM);
//				marketActivityReportWeek.setAppointmentIntoNum(appointmentMapper.countByExample(appointmentExample));
//				logger.debug("累计预约进店量" + marketActivityReportWeek.getAppointmentIntoNum());
//
//				// 累计留档数量
//				appointmentExample = new AppointmentExample();
//				appointmentExample.createCriteria().andMarketActivityIdEqualTo(marketActivity.getId()).andDealerIdEqualTo(dealer.getId()).andInfoSourceEqualTo(BaseConstant.CUSTOMER_SOURCE_TYPE_AIM);
//				marketActivityReportWeek.setArchivesNum(appointmentMapper.countByExample(appointmentExample));
//				logger.debug("累计留档数量"+marketActivityReportWeek.getArchivesNum());
//				
//				// 2.4 成交
//				// 2.4.1 累计成交量
//				SalesRecordExample example = new SalesRecordExample();
//				example.createCriteria().andMarketActivityIdEqualTo(marketActivity.getId()).andDealerIdEqualTo(dealer.getId());
//				marketActivityReportWeek.setClosingNum((salesRecordMapper.countByExample(example)));
//				logger.debug("累计成交数量"+marketActivityReportWeek.getClosingNum());
//				
//				// 2.4.2 首次各类确度数量(因为结果集有效字段就两个，故可将其转化为一个map)
//				Map<String,Object> parameterMapFirst = new HashMap<String, Object>();
//				parameterMapFirst.put("dealerId", dealer.getId());
//				parameterMapFirst.put("marketActivityCode", marketActivity.getCode());
//				
//				List<HashMap<String,Object>> firstIntentionCustomers = intentionCustomerMapper.getFirstIntentionCustomerNum(parameterMapFirst);
//				HashMap<Object,Object> intentionNumMap = new HashMap<Object, Object>();
//				for (HashMap<String,Object> map : firstIntentionCustomers) {
//					intentionNumMap.put(map.get("Level_Of_Intent_First"), map.get("num"));
//				}
//				
//				// 2.4.2 首次确度成交数量
//				parameterMapFirst.put("status", 2);
//				List<HashMap<String,Object>> firstFinishedIntentionCustomers = intentionCustomerMapper.getFirstIntentionCustomerNum(parameterMapFirst);
//				
//				for (HashMap<String,Object> customer :firstFinishedIntentionCustomers) {
//					MarketActivityReportWeekClosingIntention intention = new MarketActivityReportWeekClosingIntention();
//					intention.setId(UUIDUtil.getOrigUUID());
//					intention.setMarketActivityReportWeekId(marketActivityWeeklyReportId);
//					intention.setLevelOfIntent(Integer.parseInt(customer.get("Level_Of_Intent_First").toString()));
//					intention.setClosingNumFrist(Integer.parseInt(customer.get("num").toString()));
//					intention.setNumFirst(Integer.parseInt(intentionNumMap.get(customer.get("Level_Of_Intent_First")).toString()));
//					closingIntentionMapper.insert(intention);
//				}
//
//				// 2.4.3 分车型统计成交量
//				// 先查出当前当前经销商在该市场活动下所有的车型
//				MarketVehicleModelExample marketVehicleModelExample = new MarketVehicleModelExample();
//				marketVehicleModelExample.createCriteria().andMarketActivityIdEqualTo(marketActivity.getId());
//				List<MarketVehicleModel> marketVehicleModels = marketVehicleModelMapper.selectVehicleByMarketAndDealer(marketActivity.getId(), dealer.getId());
//				
//				for (MarketVehicleModel marketVehicleModel : marketVehicleModels) {
//					String vehicleModelId = marketVehicleModel.getVehicleModelId();
//					String vehicleModelCode = marketVehicleModel.getVehicleModelCode();
//					String vehicleModelName = marketVehicleModel.getVehicleModelName();
//
//					// 2.4.3.1  市场活动周报清单-成交-按车表录入数据
//					MarketActivityReportWeekClosingVehicle marketActivityReportWeekClosingVehicle = new MarketActivityReportWeekClosingVehicle();
//					marketActivityReportWeekClosingVehicle.setId(UUIDUtil.getOrigUUID());
//					marketActivityReportWeekClosingVehicle.setCreateTime(new Date());
//					marketActivityReportWeekClosingVehicle.setMarketActivityReportWeekId(marketActivityWeeklyReportId);
//					marketActivityReportWeekClosingVehicle.setVehicleModelId(vehicleModelId);
//					marketActivityReportWeekClosingVehicle.setVehicleModelCode(vehicleModelCode);
//					marketActivityReportWeekClosingVehicle.setVehicleModelName(vehicleModelName);
//
//					// 各车型累计成交数量统计
//					SalesRecordExample salesRecordExample = new SalesRecordExample();
//					salesRecordExample.createCriteria().andMarketActivityIdEqualTo(marketActivity.getId()).andDealerIdEqualTo(dealer.getId()).andVehicleModelIdEqualTo(vehicleModelId);
//					marketActivityReportWeekClosingVehicle.setClosingNum(salesRecordMapper.countByExample(salesRecordExample));
//					
//					closingVehicleMapper.insertSelective(marketActivityReportWeekClosingVehicle);
//				}
//
////				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
////
////				HashMap<String, String> parameterMap = new HashMap<String, String>();
////				parameterMap.put("marketActivityId", marketActivity.getId());
////				parameterMap.put("dealerId", dealer.getId());
////				parameterMap.put("start", dateFormat.format(startDate));
////				parameterMap.put("end", dateFormat.format(endDate));
////				List<HashMap<String,Object>> weekSalesVolumeVehicleList = salesRecordMapper.getWeekSalesVolumeWithVehicleModel(parameterMap);
////				
////				// 将数据结果插入相关结转表
////				for (HashMap<String,Object> map : weekSalesVolumeVehicleList) {
////					String vehicleModelId = map.get("vehicle_model_id").toString();
////					String vehicleModelCode = map.get("vehicle_model_code").toString();
////					String vehicleModelName = map.get("vehicle_model_name").toString();
////					Integer salesNumWeek = Integer.parseInt(map.get("num").toString());
////					
////					// 市场活动周报清单-成交-按车表录入数据
////					MarketActivityReportWeekClosingVehicle marketActivityReportWeekClosingVehicle = new MarketActivityReportWeekClosingVehicle();
////					marketActivityReportWeekClosingVehicle.setId(UUIDUtil.getOrigUUID());
////					marketActivityReportWeekClosingVehicle.setCreateTime(new Date());
////					marketActivityReportWeekClosingVehicle.setMarketActivityReportWeekId(marketActivityWeeklyReportId);
////					marketActivityReportWeekClosingVehicle.setClosingNumWeek(salesNumWeek);
////					marketActivityReportWeekClosingVehicle.setVehicleModelId(vehicleModelId);
////					marketActivityReportWeekClosingVehicle.setVehicleModelCode(vehicleModelCode);
////					marketActivityReportWeekClosingVehicle.setVehicleModelName(vehicleModelName);
////					
////					// 各车型累计成交数量统计
////					SalesRecordExample salesRecordExample = new SalesRecordExample();
////					salesRecordExample.createCriteria().andMarketActivityIdEqualTo(marketActivity.getId()).andDealerIdEqualTo(dealer.getId()).andVehicleModelIdEqualTo(vehicleModelId);
////					marketActivityReportWeekClosingVehicle.setClosingNum(salesRecordMapper.countByExample(salesRecordExample));
////					
////					closingVehicleMapper.insertSelective(marketActivityReportWeekClosingVehicle);
////				}
//				
//				// 主单数据插入
//				marketActivityReportWeekMapper.insert(marketActivityReportWeek);
//
//				// 2.1 精准广告
//				requestService.generatorAdvertisementData(null, null, marketActivity, marketActivityWeeklyReportId);
//			
//				// 2.3 意向客户
//				generateIntentionCustomerNumData(marketActivityWeeklyReportId, startDate, endDate, marketActivity, dealer);
//
//			}
//			
//		}
//
//	}
	
}
