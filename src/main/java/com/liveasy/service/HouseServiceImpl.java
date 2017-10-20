package com.liveasy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liveasy.service.HouseService;
import com.liveasy.model.House;
import com.liveasy.model.User;
import com.liveasy.repository.HouseRepository;
import com.liveasy.repository.UserRepository;

@Service("houseService")
public class HouseServiceImpl implements HouseService{

	@SuppressWarnings("unused")
	@Autowired
	private UserRepository userRepository;
	@Autowired
    private HouseRepository houseRepository;
	
	@Override
	public void saveHouse(House house) {
		houseRepository.save(house);
		//house.getUser().changeHouse(0, house);
		userRepository.save(house.getUser());
	}
	
	@Override
	public House findHouseByAddress(String address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public House findHouseByUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteHouse(House house) {
		// TODO Auto-generated method stub
		
	}


}
