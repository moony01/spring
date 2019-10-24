package board.service;

import java.util.List;
import java.util.Map;

import board.bean.BoardDTO;

public interface BoardService {

	public void boardWrite(Map<String, String> map);

	public List<BoardDTO> boardList(int endNum, int startNum);

	public List<BoardDTO> getBoardList(Map<String, Integer> map);

	public int getTotalA();

	public BoardDTO getBoard(int seq);

}
