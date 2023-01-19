package com.example.mailspring;



public class MailSpringApplication {


    public static void main(String[] args) {

        email mail = new email("fvbt12345@gmail.com", "library", "hi");
        mail.SendEmail();
    }
}



