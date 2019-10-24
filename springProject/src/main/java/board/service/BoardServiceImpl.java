package board.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDAO boardDAO;

	@Override
	public void boardWrite(Map<String, String> map) {
		boardDAO.boardWrite(map);
	}

	@Override
	public List<BoardDTO> boardList(int endNum, int startNum) {
		return boardDAO.boardList(endNum, startNum);
	}

	@Override
	public List<BoardDTO> getBoardList(Map<String, Integer> map) {
		return boardDAO.getBoardList(map);
	}

	@Override
	public int getTotalA() {
		return boardDAO.getTotalA();
	}

	@Override
	public BoardDTO getBoard(int seq) {
		return boardDAO.getBoard(seq);
	}
}












