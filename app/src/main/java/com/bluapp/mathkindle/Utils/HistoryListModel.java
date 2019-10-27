package com.bluapp.mathkindle.Utils;

public class HistoryListModel{

    private int id;
    private String attemptname;
    private String totalquestion;
    private String correctquestion;
    private String wrongquestion;
    private String attempteddate;
    private String arithmeticoperator;
    private String skippedquestion;

    public HistoryListModel(int historyId, String attemptName, String totalQuestion, String correctQuestion, String wrongQuestion, String attemptedDate, String arithmeticOperator, String skippedQuestion) {
        this.id = historyId;
        this.attemptname = attemptName;
        this.totalquestion = totalQuestion;
        this.correctquestion = correctQuestion;
        this.wrongquestion = wrongQuestion;
        this.attempteddate = attemptedDate;
        this.arithmeticoperator = arithmeticOperator;
        this.skippedquestion = skippedQuestion;
    }

    public int getId() {
        return id;
    }

    public String getAttemptname() {
        return attemptname;
    }

    public String getTotalquestion() {
        return totalquestion;
    }

    public String getCorrectquestion() {
        return correctquestion;
    }

    public String getWrongquestion() {
        return wrongquestion;
    }

    public String getAttempteddate() {
        return attempteddate;
    }

    public String getArithmeticoperator() {
        return arithmeticoperator;
    }

    public String getSkippedquestion() {
        return skippedquestion;
    }
}
