package com.example.se.pringbootredis.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.se.pringbootredis.entity.ChuyenBay;
import com.example.se.pringbootredis.service.ChuyenBayService;

@RestController
@RequestMapping("/api")
public class ChuyenBayController {
	@Autowired
	private ChuyenBayService chuyenBayService;
	
	private static final Logger LOG = LoggerFactory.getLogger(ChuyenBayController.class);
	@PostMapping("/save")
    public String save(@RequestBody final ChuyenBay chuyenbay) {
        LOG.info("Saving the new employee to the redis.");
        chuyenBayService.save(chuyenbay);
        return "Successfully added. Employee with id= " + chuyenbay.getMaCB();
    }
	@DeleteMapping("/delete/{id}")
    public String deleteRedis(@PathVariable("id") final String id) {
        LOG.info("deleting the new employee to the redis.");
        chuyenBayService.deleteById(id);
        return "Successfully deleted. Employee with id= " + id;
    }
	@GetMapping("/get/{id}")
    public ChuyenBay findById(@PathVariable("id") final String id) {
        LOG.info("Fetching employee with id= " + id);
        return chuyenBayService.findById(id);
    }
	
	@GetMapping("/chuyenbay") 
	public List<ChuyenBay> findAlls() {
		List<ChuyenBay> chuyenBays = chuyenBayService.findAll();
		System.out.println(chuyenBays);
		return chuyenBayService.findAll();
	}
	@GetMapping("/chuyenbayGaDen")
	public List<ChuyenBay> findAllGaDen(@RequestParam("gaDen") String gaDen) {
		List<ChuyenBay> chuyenBays = chuyenBayService.findByGaDen(gaDen);
		System.out.println(gaDen);
		return chuyenBays;
	}
	@ResponseBody
	@GetMapping("/chuyenbayDuongBay")
	public List<ChuyenBay> getChuyenBayByDuongBay(@RequestParam("dbay1") int dbay1, @RequestParam("dbay2") int dbay2){
		
		return chuyenBayService.findByDuongbay(dbay1, dbay2);
	}
	@ResponseBody
	@GetMapping("/chuyenbaySgBmt")
	public List<ChuyenBay> getCBSGBMT(@RequestParam("gaDi") String gaDi, @RequestParam("gaDen") String gaden){
		return chuyenBayService.findBySG_BMT(gaDi, gaden);
	}
	@GetMapping("/chuyenbay/save")
	public ChuyenBay saveChuyenBay(@RequestBody ChuyenBay chuyenBay) { 
//		ChuyenBay cb1 = new ChuyenBay("CB01", "SG", "BMT", 2000, "09:00:00", "11:00:00", 100000);
		return chuyenBayService.save(chuyenBay);
	}
}
