package com.example.facebookchatapp.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class FacebookRequest
{
    private Entry[] entry;

    private String object;

    public Entry[] getEntry ()
    {
        return entry;
    }

    public void setEntry (Entry[] entry)
    {
        this.entry = entry;
    }

    public String getObject ()
    {
        return object;
    }

    public void setObject (String object)
    {
        this.object = object;
    }

    @Override
    public String toString()
    {
    	Gson gson  = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
        return gson.toJson(this);
    }
}
