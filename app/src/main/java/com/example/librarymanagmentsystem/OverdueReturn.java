package com.example.librarymanagmentsystem;

public class OverdueReturn {
    private String serialNoBook;
    private String nameOfBook;
    private String membershipId;
    private String dateOfIssue;
    private String dateOfReturn;
    private double fine;

    public OverdueReturn(){

    }
    public OverdueReturn(String serialNoBook, String nameOfBook, String membershipId, String dateOfIssue, String dateOfReturn, double fine) {
        this.serialNoBook = serialNoBook;
        this.nameOfBook = nameOfBook;
        this.membershipId = membershipId;
        this.dateOfIssue = dateOfIssue;
        this.dateOfReturn = dateOfReturn;
        this.fine = fine;
    }

    public String getSerialNoBook() {
        return serialNoBook;
    }

    public void setSerialNoBook(String serialNoBook) {
        this.serialNoBook = serialNoBook;
    }

    public String getNameOfBook() {
        return nameOfBook;
    }

    public void setNameOfBook(String nameOfBook) {
        this.nameOfBook = nameOfBook;
    }

    public String getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(String membershipId) {
        this.membershipId = membershipId;
    }

    public String getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(String dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public String getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(String dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }
}
