package soo.md.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChartVo {
	private String item;
	private int number;
	//private String color;
	
	@Override
	public String toString() { //Tip!!
		return "Vo4GoogleChart item: " + item + ", number: " + number;
	}
}
