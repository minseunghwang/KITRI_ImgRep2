package service;

import java.util.ArrayList;

import model.MemberVO;

public interface Service {
	ArrayList idList();
	MemberVO findMember(String id);
	void registerMember(MemberVO vo);
}
