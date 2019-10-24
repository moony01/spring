package member.service;

import java.util.List;
import java.util.Map;

import member.bean.MemberDTO;
import member.bean.ZipcodeDTO;

public interface MemberService {

	public MemberDTO login(String id, String pwd);

	public void write(MemberDTO memberDTO);

	public MemberDTO checkId(String id);

	public List<ZipcodeDTO> postSearch(Map<String, String> map);

}
