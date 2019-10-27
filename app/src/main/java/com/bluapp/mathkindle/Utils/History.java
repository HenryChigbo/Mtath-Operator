package com.bluapp.mathkindle.Utils;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "history")
public class History {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "attemptname")
    private String attemptname;

    @ColumnInfo(name = "totalquestion")
    private String totalquestion;

    @ColumnInfo(name = "correctquestion")
    private String correctquestion;

    @ColumnInfo(name = "wrongquestion")
    private String wrongquestion;

    @ColumnInfo(name = "attempteddate")
    private String attempteddate;

    @ColumnInfo(name = "arithmeticoperator")
    private String arithmeticoperator;

    @ColumnInfo(name = "skippedquestion")
    private String skippedquestion;

    public History(String attemptname, String totalquestion, String correctquestion, String wrongquestion, String attempteddate, String arithmeticoperator, String skippedquestion) {
        this.attemptname = attemptname;
        this.totalquestion = totalquestion;
        this.correctquestion = correctquestion;
        this.wrongquestion = wrongquestion;
        this.attempteddate = attempteddate;
        this.arithmeticoperator = arithmeticoperator;
        this.skippedquestion = skippedquestion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setAttemptname(String attemptname) {
        this.attemptname = attemptname;
    }

    public String getAttemptname() {
        return attemptname;
    }

    public void setTotalquestion(String totalquestion) {
        this.totalquestion = totalquestion;
    }

    public String getTotalquestion() {
        return totalquestion;
    }

    public void setCorrectquestion(String correctquestion) {
        this.correctquestion = correctquestion;
    }

    public String getCorrectquestion() {
        return correctquestion;
    }

    public void setWrongquestion(String wrongquestion) {
        this.wrongquestion = wrongquestion;
    }

    public String getWrongquestion() {
        return wrongquestion;
    }

    public void setAttempteddate(String attempteddate) {
        this.attempteddate = attempteddate;
    }

    public String getAttempteddate() {
        return attempteddate;
    }

    public void setArithmeticoperator(String arithmeticoperator) {
        this.arithmeticoperator = arithmeticoperator;
    }

    public String getArithmeticoperator() {
        return arithmeticoperator;
    }

    public void setSkippedquestion(String skippedquestion) {
        this.skippedquestion = skippedquestion;
    }

    public String getSkippedquestion() {
        return skippedquestion;
    }
}
