package com.dollop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dollop.entity.Contact;
import com.dollop.util.DbConnection;
import com.mysql.cj.protocol.Resultset;

public class ContactInterfaceDAOImpl implements ContactInterfaceDAO {
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	Contact contact=null;

	public boolean createContact(Contact contact) {
		// TODO Auto-generated method stub
		try {
			con=DbConnection.creation();
			String q="insert into contactlist(name,email,phone) values(?,?,?)";
			pstmt=con.prepareStatement(q);
			pstmt.setString(1,contact.getName());
			pstmt.setString(2, contact.getEmail());
			pstmt.setString(3, contact.getPhone() );
			pstmt.executeUpdate();
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<Contact> viewAllContact() {
		
		try {
			ArrayList<Contact> al=new ArrayList<Contact>();
			con=DbConnection.creation();
			String q="select * from contactlist";
			pstmt=con.prepareStatement(q);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				contact=new Contact();
				contact.setId(rs.getInt(1));
				contact.setName(rs.getString(2));
				contact.setEmail(rs.getString(3));
				contact.setPhone(rs.getString(4));
				al.add(contact);
				
			}
			return al;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// TODO Auto-generated method stub
		return null;
	}

	public Contact viewContactById(Integer id) {
		// TODO Auto-generated method stub
		try {
			con=DbConnection.creation();
			String q="select * from contactlist where id='"+id+"'";
			pstmt=con.prepareStatement(q);
			rs=pstmt.executeQuery();
			rs.next();
			contact=new Contact();
			contact.setId(rs.getInt(1));
			contact.setName(rs.getString(2));
			contact.setEmail(rs.getString(3));
			contact.setPhone(rs.getString(4));
			
			return contact;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public boolean updateContact(Contact contact) {
		// TODO Auto-generated method stub
		try {
			con=DbConnection.creation();
			String q="update contactlist set name=?,email=?,phone=? where id=?";
			pstmt=con.prepareStatement(q);
			pstmt.setInt(4, contact.getId());
			pstmt.setString(1, contact.getName());
			pstmt.setString(2, contact.getEmail());
			pstmt.setString(3, contact.getPhone());
			int accfectedRow =pstmt.executeUpdate();
			if(accfectedRow>0) {
				System.out.println("Contact was update");
				return true;
			}
			else {
				System.out.println("something went wrong");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteContact(Integer id) {
		// TODO Auto-generated method stub
		try {
			con=DbConnection.creation();
			String q="delete contactlist where id='"+id+"'";
			pstmt=con.prepareStatement(q);
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

}
