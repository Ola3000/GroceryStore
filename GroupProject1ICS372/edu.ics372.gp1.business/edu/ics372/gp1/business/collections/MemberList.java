package edu.ics372.gp1.business.collections;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import edu.ics372.gp1.business.entities.Member;

public class MemberList implements Iterable<Member>, Serializable {
	private static final long serialVersionUID = 1L;
	private List<Member> members = new LinkedList<Member>();
	private static MemberList memberList;

	private MemberList() {

	}

	public static MemberList getInstance() {
		if (memberList == null) {
			memberList = new MemberList();
		}
		return memberList;
	}
	
	// testing method
	public void addMember(Member member) {
		members.add(member);
	}
	
	// Business Process 2
	public boolean removeMember(String id) {
		for (Iterator<Member> iterator = members.iterator(); iterator.hasNext();) {
			Member member = iterator.next();
			if (member.getId().equals(id)) {
				members.remove(member);
				return true;
			}
		}
		return false;
	}
	
	// Business Process 3
	public void retrieveMember(String name) {
		for (Iterator<Member> iterator = members.iterator(); iterator.hasNext();) {
			Member member = iterator.next();
			if (member.getName().equals(name)) {
				System.out.println("Member [Address: " + member.getAddress() + ", Fee Paid: " + member.getFee() + ", Id: " + member.getId() + "]");
			}
		}
	}
	
	// Business Process 10
	public void listMembers() {
		for (Iterator<Member> iterator = members.iterator(); iterator.hasNext();) {
			Member member = iterator.next();
			System.out.println("Member [Name: " + member.getName() + ", Id: " + member.getId() + ", Address: " + member.getAddress() + "]");
		}
	}
	
	@Override
	public Iterator<Member> iterator() {
		return members.iterator();
	}

}
