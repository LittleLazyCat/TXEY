package cn.lby.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lby.dao.MarketActivityReportWeekMapper;
import cn.lby.entity.MarketActivityReportWeek;
import cn.lby.service.MarketReportServiceI;

@Service("marketReportService")
public class MarketReportServiceImpl implements MarketReportServiceI {

	@Autowired
	private MarketActivityReportWeekMapper marketActivityReportWeekMapper; 
	
	@Override
	public MarketActivityReportWeek getReportById(String Id) {
		return marketActivityReportWeekMapper.selectByPrimaryKey(Id);
	}

	@Override
	public List<MarketActivityReportWeek> getAllReports() {
		List<MarketActivityReportWeek> reports = marketActivityReportWeekMapper.selectByExample(null);
		return reports;
	}
	
}
