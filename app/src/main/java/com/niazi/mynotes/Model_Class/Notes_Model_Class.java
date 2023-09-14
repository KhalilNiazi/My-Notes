package com.niazi.mynotes.Model_Class;

public class Notes_Model_Class {

    String id,time, notesname,notes;

    public Notes_Model_Class(String time,String id, String notesname, String notes) {
        this.time = time;
        this.id = id;
        this.notesname = notesname;
        this.notes = notes;
    }

    public String getId() {
        return id;
    }

    public String getTime() {
        return time;
    }

    public String getNotesname() {
        return notesname;
    }

    public String getNotes() {
        return notes;
    }
}
