package user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

@Service
public class UserSearchService implements UserService {
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		System.out.println("1. 이름 검색");
		System.out.println("2. 아이디 검색");
		System.out.print("번호입력 : ");
		int num = scan.nextInt();
		
		String key = null;
		String value = null;
		
		if(num == 1) {
			System.out.println("검색을 원하는 이름 검색  :");
			value = scan.next();
			key = "name";
		} else if(num == 2) {
			System.out.println("검색을 원하는 아이디 입력 : ");
			value = scan.next();
			key = "id";
		}

		Map<String, String> map = new HashMap<String, String>();
		map.put("key", key);
		map.put("value", value);
		
		List<UserDTO> list = userDAO.userSearch(map);
		
		for(UserDTO userDTO : list) {
			System.out.println(userDTO.getName()+"\t"+userDTO.getId()+"\t"+userDTO.getPwd());
		}
		
	}

}
