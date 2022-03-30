package com.library.ui;

import com.library.exception.LibraryExceptions;
import com.library.service.BookServiceImpl;
import com.library.validations.ValidateInput;

import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Library Management System\n");
        System.out.println("Choose the Any one Operation:");
        System.out.println("PRESS 1: For Issue a Book");
        System.out.println("PRESS 2: For Return a Book");
        System.out.println("PRESS 3: For Check Stock");

        boolean isInputValid = false;

        while (!isInputValid){
            try {
                System.out.print("Please Enter any Number: ");
                int operation = sc.nextInt();
                if (!ValidateInput.isOperationValid(operation))
                    throw new Exception();
                isInputValid = true;

                if(operation ==1){
                    issueBook();
                }else if(operation == 2){
                   // returnBook();
                }else {
                    //checkStock();
                }

            }catch (Exception ex){
                System.out.println("Please Enter valid input.\nPress 1, 2 or 3");

            }
        }
    }

    static void issueBook(){

        Scanner sc = new Scanner(System.in);
        System.out.print("Please Enter Book Id: ");
        int bookId = sc.nextInt();
        System.out.print("Please Enter Student Id: ");
        int studentId = sc.nextInt();

        BookServiceImpl bService = new BookServiceImpl();

        //System.out.println("Student fine: "+bService.checkFine(studentId));

        try {
            int stuFine = bService.checkFine(studentId);
            if (stuFine > 500){
                throw new LibraryExceptions("Fine cannot be more than 500");
            }

            int noOfBookIssued = bService.checkNoOfBookIssued(studentId);
            if (noOfBookIssued == 3){
                throw new LibraryExceptions("Already 3 books are issued, return a book to get a new book ");
            }
            bService.issueBook(bookId, studentId);
            noOfBookIssued = bService.checkNoOfBookIssued(studentId);
            System.out.println("BOOK ISSUED");
            System.out.println("Total Books Issued: "+ noOfBookIssued);



        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }
    static void returnBook(int bookId, int studentId){

    }
    static void checkStock(String bName, String bEdition){

    }
}
