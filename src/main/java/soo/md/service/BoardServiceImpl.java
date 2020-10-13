package soo.md.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import soo.md.domain.Board;
import soo.md.domain.BoardListResult;
import soo.md.domain.BoardVo;
import soo.md.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardMapper boardMapper; 
	
	@Override
	public BoardListResult getBoardListResult(int page, int pageSize) {
		long totalCount = boardMapper.selectCount();
		BoardVo boardVo = new BoardVo(null, page, pageSize);
		List<Board> list = boardMapper.selectPerPage(boardVo);
		return new BoardListResult(page, pageSize, totalCount, list);
	}

	@Override
	public Board getBoard(long seq) {
		return boardMapper.selectBySeq(seq);
	}

	@Override
	public BoardListResult getBoardListResultByKeyword(String keyword, int page, int pageSize) {
		long totalCount = boardMapper.selectCount();
		BoardVo boardVo = new BoardVo(keyword, page, pageSize);
		List<Board> list = boardMapper.selectByWriter(boardVo);
		return new BoardListResult(page, pageSize, totalCount, list);
	}

	@Override
	public void write(Board board) {
		boardMapper.insert(board);
	}

	@Override
	public void edit(Board board) {
		boardMapper.update(board);
	}

	@Override
	public void remove(long seq) {
		boardMapper.delete(seq);
	}

}
