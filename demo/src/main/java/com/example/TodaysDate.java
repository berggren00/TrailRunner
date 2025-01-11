package com.example;
import java.time.LocalDate;


public class TodaysDate {
    private LocalDate date;
    
    public TodaysDate(){
        this.date=LocalDate.now();
    }

    public TodaysDate(LocalDate date) {
        this.date=date;
    }

    public LocalDate getDate(){
        return date;
    }
    
    public void setDate(LocalDate date){
        this.date=date;
    }
    
    public String DatetoString () {
            return date.toString();
        }
}
