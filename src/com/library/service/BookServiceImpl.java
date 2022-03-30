package com.library.service;

import com.library.dao.BookServiceDao;
import com.library.exception.LibraryExceptions;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BookServiceImpl implements BookService{

    @Override
    public int checkFine(int studentId) {

        BookServiceDao  bookDao = new BookServiceDao();
        try {
            return bookDao.checkFine(studentId);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return -1;
        }


    }

    @Override
    public int checkNoOfBookIssued(int StudentId) {
        BookServiceDao  bookDao = new BookServiceDao();
        try {
            return bookDao.checkNoOfBooksIssued(StudentId);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return -1;
        }



    }

    @Override
    public boolean issueBook(int bookId, int studentId) {

        BookServiceImpl bService = new BookServiceImpl();
        //bService.updateNoOfBooks(studentId);

        bService.updateStock(bookId);
        //bService.getBookDetails(bookId);


        return false;
    }

    @Override
    public boolean updateNoOfBooks(int studentId) {

        BookServiceDao  bookDao = new BookServiceDao();
        try {
            return bookDao.updateNoOfBooks(studentId);
        }catch (Exception ex){
            //throw new LibraryExceptions("Unable to update number of Books");
            System.out.println("Unable to update number of Books");
            return false;
        }



    }

    @Override
    public boolean updateStock(int bookId) {

        BookServiceImpl bookService = new BookServiceImpl();
        Map<String , String> bookDetails = bookService.getBookDetails(bookId);

        return false;
    }

    private Map<String, String> getBookDetails(int bookId) {

        BookServiceDao bookDao = new BookServiceDao();
        try {
            Map<String, String> bookDetails = bookDao.getBookDetailsById(bookId);

            for (Map.Entry<String, String> entry: bookDetails.entrySet()) {
                System.out.println(entry.getKey() + " "+ entry.getValue());
            }
            return bookDetails;
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return new HashMap<>();
        }

    }
}
