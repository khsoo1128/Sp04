package soo.md.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import soo.md.domain.ChartVo;

@RequestMapping("chart")
@Controller
public class ChartController {
	@RequestMapping("chart")
	public String showView() {
		return "chart/chart";
	}
	
	/*@ResponseBody
	@PostMapping("chartData")
	public List<ChartVo> charData() {
		List<ChartVo> list = new ArrayList<ChartVo>();
		String items[] = {"애플", "MS", "아마존", "구글", "페이스북", "테슬라", "넥플릭스"};
		int numbers[] = {16800, 15800, 15700, 10600, 6893, 2907, 2155};
		String colors[] = {"#FF0000", "#00FF00", "#0000FF", "#e66819", "#12e6aa", "#5912e6", "#e620dc"};
		for(int i=0; i<items.length; i++) {
			ChartVo vo = new ChartVo(items[i], numbers[i], colors[i]);
			list.add(vo);
		}
		
		return list;
	}*/
	
	@ResponseBody
	@PostMapping("chartData")
	public List<ChartVo> charData() {
		List<ChartVo> list = new ArrayList<ChartVo>();
		String items[] = {"애플", "MS", "아마존", "구글", "페이스북", "테슬라", "넥플릭스"};
		int numbers[] = {16800, 15800, 15700, 10600, 6893, 2907, 2155};
		for(int i=0; i<items.length; i++) {
			ChartVo vo = new ChartVo(items[i], numbers[i]);
			list.add(vo);
		}
		
		return list;
	}
	
	@ResponseBody
	@PostMapping("charDataRan")
	public List<ChartVo> charDataRan() {
		List<ChartVo> list = new ArrayList<ChartVo>();
		String items[] = {"애플", "MS", "아마존", "구글", "페이스북", "테슬라", "넥플릭스"};
		//int numbers[] = {16800, 15800, 15700, 10600, 6893, 2907, 2155};
		Random r = new Random();
		for(int i=0; i<items.length; i++) {
			ChartVo vo = new ChartVo(items[i], r.nextInt(100));
			list.add(vo);
		}
		
		return list;
	}
	
}
