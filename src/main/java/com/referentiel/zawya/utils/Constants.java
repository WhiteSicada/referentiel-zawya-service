package com.referentiel.zawya.utils;

public class Constants {

    public final static class BaseResponseErrorMessages {
        public static final String ZAWIYA = "Zawiya";
        public static final String FAKIR = "Fakir";
        public static final String ALREADY_EXISTS = "already exists !";
        public static final String NOT_FOUND = "not found !";
        public static final String WAS_NOT_DELETED = "was not deleted !";

        public static String getZawiyaNotFound(){
            return ZAWIYA + " " + NOT_FOUND;
        }

        public static String getFakirNotFound(){
            return FAKIR + " " + NOT_FOUND;
        }

        public static String getZawiyaAlreadyExists(){
            return ZAWIYA + " " + ALREADY_EXISTS;
        }

        public static String getFakirAlreadyExists(){
            return FAKIR + " " + ALREADY_EXISTS;
        }

        public static String getZawiyaWasNotDeleted(){
            return ZAWIYA + " " + WAS_NOT_DELETED;
        }

        public static String getFakirWasNotDeleted(){
            return FAKIR + " " + WAS_NOT_DELETED;
        }
    }
}
