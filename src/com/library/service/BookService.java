package com.library.service;

public interface BookService {

    //to return no of books in stock, if no books available then return 0
    //int checkStock(String bookName, String bookAuthor, String bookEdition);

    //return the fine pending for the student
    int checkFine(int studentId);

    int checkNoOfBookIssued(int StudentId);

    boolean issueBook(int bookId, int studentId);

    boolean updateNoOfBooks(int studentId);

    boolean updateStock(int bookId);
}
