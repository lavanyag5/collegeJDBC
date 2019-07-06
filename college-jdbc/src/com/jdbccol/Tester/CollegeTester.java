package com.jdbccol.Tester;

import com.jdbccol.DAO.CollegeDAO;

public class CollegeTester {
	
	public static void main(String[] args) {
		CollegeDAO dao=new CollegeDAO();
//		dao.saveCollege();
//		dao.updateCollege(1,"AMBEDKAR");
		dao.readCollege();
		dao.deleteCollege(1);
		
	}

}
