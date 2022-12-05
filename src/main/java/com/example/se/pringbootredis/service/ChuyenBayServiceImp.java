package com.example.se.pringbootredis.service;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.example.se.pringbootredis.dao.ChuyenBayRepository;
import com.example.se.pringbootredis.entity.ChuyenBay;



@Service
public class ChuyenBayServiceImp implements ChuyenBayService{
	@Autowired
	private ChuyenBayRepository chuyenBayRepository;
	private final String CHUYENBAY_CACHE = "CHUYENBAY";
	 
    @Autowired
    RedisTemplate<String, Object> redisTemplate;
    private HashOperations<String, String, ChuyenBay> hashOperations;
 // This annotation makes sure that the method needs to be executed after
    // dependency injection is done to perform any initialization.
    @PostConstruct
    private void intializeHashOperations() {
        hashOperations = redisTemplate.opsForHash();
    }
    
	public ChuyenBayServiceImp(ChuyenBayRepository chuyenBayRepository) {
		this.chuyenBayRepository = chuyenBayRepository;
	}
	
	@Override
	public ArrayList<ChuyenBay> findAll() {
		return (ArrayList<ChuyenBay>) chuyenBayRepository.findAll();
	}

	

	@Override
	public ChuyenBay findById(String theId) {
		// TODO Auto-generated method stub
		return (ChuyenBay) hashOperations.get(CHUYENBAY_CACHE, theId);
	}

	@Override
	public ChuyenBay save(ChuyenBay chuyenBay) {
		ChuyenBay cb = chuyenBayRepository.save(chuyenBay);
		hashOperations.put(CHUYENBAY_CACHE, chuyenBay.getMaCB(), chuyenBay);
		return cb;
	}

	@Override
	public Long deleteById(String maCB) {
		 Long deleted = hashOperations.delete(CHUYENBAY_CACHE, maCB);
		return deleted;
	}

	@Override
	public ArrayList<ChuyenBay> findByGaDen(String gaDen) {
		return chuyenBayRepository.findByGaDen(gaDen);
	}

	@Override
	public List<ChuyenBay> findByDuongbay(int dbay1, int dbay2) {
		// TODO Auto-generated method stub
		return chuyenBayRepository.findByDuongbay(dbay1, dbay2);
	}

	@Override
	public List<ChuyenBay> findBySG_BMT(String gadi, String daden) {
		// TODO Auto-generated method stub
		return chuyenBayRepository.findBySG_BMT(gadi, daden);
	}

	@Override
	public int countChuyenBay(String gadi) {
		// TODO Auto-generated method stub
		 return chuyenBayRepository.countChuyenBay(gadi);
	}

}

