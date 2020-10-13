package soo.md.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class BoardVo {
	String keyword; //for �˻� 
	
	private int page; // ������ ��ȣ 
	private int pageSize; //������ ������  ( ���������� �� ���� )
	
	public int getStartRow() {
		return (page-1)*pageSize;	
	}
	public int getEndRow() {
		return page*pageSize; 
	}
}
