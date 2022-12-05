package com.example.se.pringbootredis.service;

import java.util.ArrayList;
import java.util.List;

import com.example.se.pringbootredis.entity.ChuyenBay;

public interface ChuyenBayService {
	public ArrayList<ChuyenBay> findAll();
	public ChuyenBay findById(String theId);
	public ArrayList<ChuyenBay> findByGaDen(String gaDen);
	public ChuyenBay save(ChuyenBay chuyenBay);
	public Long deleteById(String maCB);
	public List<ChuyenBay> findByDuongbay(int dbay1, int dbay2);
	public List<ChuyenBay> findBySG_BMT(String gadi, String daden);
	public int countChuyenBay(String gadi);
}
