package com.example.se.pringbootredis.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.se.pringbootredis.entity.ChuyenBay;



@Repository
public interface ChuyenBayRepository extends JpaRepository<ChuyenBay, String>{
	@Query(value = "SELECT * FROM ChuyenBay m where m.GaDen like ?1", nativeQuery = true)
	public ArrayList<ChuyenBay> findByGaDen(String gaDen);
	
	@Query(value = "SELECT * FROM chuyenbay  WHERE DoDai > ?1 and DoDai < ?2", nativeQuery = true)
	List<ChuyenBay> findByDuongbay(int dbay1, int dbay2);

	@Query(value = "SELECT * FROM chuyenbay  WHERE GaDi = ?1 and GaDen = ?2", nativeQuery = true)
	List<ChuyenBay> findBySG_BMT(String gadi, String daden);

	@Query(value = "SELECT COUNT(*) FROM chuyenbay where GaDi = ?1", nativeQuery = true)
	int countChuyenBay(String gadi);
}
