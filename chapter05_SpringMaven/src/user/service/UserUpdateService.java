package user.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

@Service
public class UserUpdateService implements UserService {
	@Autowired
	private UserDAO userDAO;

	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		System.out.print("���� �� ���̵� �Է� : ");
		String id = scan.next();
		
		UserDTO userDTO = userDAO.getUser(id);
		
		if(userDTO==null) {
			System.out.println("ã���� �ϴ� ���̵� �����ϴ�");
			return;
		}
		
		System.out.println(userDTO.getName()+"\t"+userDTO.getId()+"\t"+userDTO.getPwd());
		
		System.out.println();
		System.out.print("������ �̸� �Է� : ");
		String name = scan.next();
		System.out.print("������ ��й�ȣ �Է� : ");
		String pwd = scan.next();
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("name", name);
		map.put("id", id);
		map.put("pwd", pwd);
		
		userDAO.userModify(map);
		
		System.out.println("�����͸� �����Ͽ����ϴ�");
	}

}













