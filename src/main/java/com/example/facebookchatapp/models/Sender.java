package com.example.facebookchatapp.models;

public class Sender
{
    private String id;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    @Override
    public String toString()
    {
        return "[id = "+id+"]";
    }
}