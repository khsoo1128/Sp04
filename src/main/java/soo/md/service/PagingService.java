package soo.md.service;

import java.util.List;

import soo.md.domain.Paging;
import soo.md.domain.PagingVo;

public interface PagingService {
	List<Paging> selectPerPageS(PagingVo pagingVo);
	long selectCountS();
	Paging selectBySeqS(long seq);
	
	void insertS(Paging paging);
	void deleteS(long seq);
	void deleteAllS();
}
