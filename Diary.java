/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.diaryapp;

/**
 *
 * @author tran-hang
 */
public class Diary {
    int id;
    String date, description, content;

    public Diary() {
    }

    public Diary(int id, String date, String description, String content) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.content = content;
    }

    public Diary(String date, String description, String content) {
        this.date = date;
        this.description = description;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
}
