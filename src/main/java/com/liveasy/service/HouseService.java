package com.liveasy.service;

import com.liveasy.model.House;
import com.liveasy.model.User;

public interface HouseService {
	
	public House findHouseByAddress(String address);
	public House findHouseByUser(User user);
	public void saveHouse(House house);
	public void deleteHouse(House house);
	
}
