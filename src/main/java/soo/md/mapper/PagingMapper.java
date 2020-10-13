package soo.md.mapper;

import java.util.List;
import soo.md.domain.Paging;
import soo.md.domain.PagingVo;

public interface PagingMapper {
	List<Paging> selectPerPage(PagingVo pagingVo);
	long selectCount();
	Paging selectBySeq(long seq);
	
	void insert(Paging paging);
	void delete(long seq);
	void deleteAll();
}
