package service.impl;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import dao.face.RestaurantDao;
import dao.impl.RestaurantDaoImpl;
import dto.SeoulGrade;
import review.dto.Seoul;
import service.face.RestaurantService;

public class RestaurantServiceImpl implements RestaurantService {
	RestaurantDao restaurantDao = new RestaurantDaoImpl();
	@Override
	public List<Seoul> getTopRest() {
		return restaurantDao.selectByTopRest(JDBCTemplate.getConnection());
	}
	@Override
	public List<SeoulGrade> getTopRest(HttpServletRequest req) {
		
		List<SeoulGrade> list = restaurantDao.selectTopRestByTitle(JDBCTemplate.getConnection(), req);
		
		// avg순서로 정렬
		Collections.sort(list,Collections.reverseOrder());
		
		return list;
	}
	@Override
	public List<SeoulGrade> getThemeList(String theme) {
		// TODO Auto-generated method stub
		return restaurantDao.selectThemeByBiz(JDBCTemplate.getConnection(),theme);
	}

}