package com.library.dao;

import com.library.exception.LibraryExceptions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class BookServiceDao {

   public int checkFine(int studentId) throws Exception{
        Connection con = CreatConnection.getConnection();

        String query =  "select Stu_fine from Student where Stu_Id = ?";

        PreparedStatement prepSt = con.prepareStatement(query);
        prepSt.setInt(1,studentId);

        ResultSet rs = prepSt.executeQuery();

        if(rs.next())
            return rs.getInt(1);
        else throw new Exception("Student Id not found in DataBase");
    }

    public int checkNoOfBooksIssued(int studentId) throws Exception{
        Connection con = CreatConnection.getConnection();
        String query = "select Book_Issued from student where Stu_Id = ?";
        PreparedStatement prepSt = con.prepareStatement(query);
        prepSt.setInt(1,studentId);

        ResultSet rs = prepSt.executeQuery();

        if(rs.next())
            return rs.getInt("Book_Issued");
        else
            throw new Exception("Student Id not found for fetching no of books issued");

    }

    public boolean updateNoOfBooks(int studentId) throws Exception{

        Connection con = CreatConnection.getConnection();
        String query = "update student set Book_Issued = Book_Issued + 1 where Stu_Id = ?";
        PreparedStatement prepSt = con.prepareStatement(query);
        prepSt.setInt(1,studentId);

        prepSt.executeUpdate();

        return true;


    }

    public Map<String, String> getBookDetailsById(int bookId) throws Exception{

       Map<String , String> bookDetails = new HashMap<>();
        Connection con = CreatConnection.getConnection();
        String query = "select  BookName, BookAuthor, BookEdition from book where BookId = ?";
        PreparedStatement prepSt = con.prepareStatement(query);
        prepSt.setInt(1,bookId);

        ResultSet rs = prepSt.executeQuery();
        if(rs.next()){
            bookDetails.put("Book Name: ", rs.getString("BookName"));
            bookDetails.put("Book Author: ", rs.getString("BookAuthor"));
            bookDetails.put("Book Edition: ", rs.getString("BookEdition"));
            return bookDetails;
        }else
            throw new LibraryExceptions("Book Details not found in Book Table");

    }
}
