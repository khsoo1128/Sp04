package soo.md.service;

import soo.md.domain.Board;
import soo.md.domain.BoardListResult;

public interface BoardService {
	BoardListResult getBoardListResult(int page, int pageSize);
	Board getBoard(long seq);
	BoardListResult getBoardListResultByKeyword(String keyword, int page, int pageSize);
	
	void write(Board board);
	void edit(Board board);
	void remove(long seq);
}
