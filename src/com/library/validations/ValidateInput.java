package com.library.validations;

public class ValidateInput {

    public static boolean isOperationValid(int op){

        return op>=1 && op<=3;
    }
}
