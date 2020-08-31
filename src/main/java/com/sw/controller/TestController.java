package com.sw.controller;

import com.sw.service.DictService;
import com.sw.service.HisXxlyService;
import com.sw.util.POIXlsx;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.POIXMLDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/test")
public class TestController {
	private HisXxlyService hisXxlyService;
	private DictService dictService;
	private static final Logger logger = LogManager.getLogger(TestController.class);

	@Autowired
	public TestController(HisXxlyService hisXxlyService,DictService dictService) {
		this.hisXxlyService = hisXxlyService;
		this.dictService = dictService;
	}

	@RequestMapping(value="insertHis",method = RequestMethod.GET)
	@ResponseBody
	public void insertHis() {
		//插入字典表一级
		/*try {
			HashSet<String> hs = POIXlsx.readywlx1();
			for (String s:hs) {
				boolean result = dictService.insertDict(s,"","1");
				System.out.println(result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		//插入字典表二级
		/*try {
			HashMap<String,HashSet<String>> map =POIXlsx.readywlx2();
			//HashSet<String> set = (HashSet<String>) map.keySet();

			for (String key : map.keySet()) {
				String id = dictService.getIdByName(key);
				for (String ss:map.get(key)) {

					boolean result = dictService.insertDict(ss,id,"2");
					System.out.println(result);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}*/
		//插入历史数据

		boolean result =false;
		try {
			List<List<String>> list = POIXlsx.readExcel1();
			System.out.println(list.toString());
			for (List<String> ls:list) {
				result = hisXxlyService.insertXxlyHis(ls.get(0).trim(),ls.get(1).trim(),ls.get(2).trim(),ls.get(3).trim(),ls.get(4).trim(),ls.get(5).trim(),ls.get(6).trim());
			}
			logger.info(result);
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
