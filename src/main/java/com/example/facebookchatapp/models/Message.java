package com.example.facebookchatapp.models;

public class Message
{
    private String text;

    private String seq;

    private String mid;

    public String getText ()
    {
        return text;
    }

    public void setText (String text)
    {
        this.text = text;
    }

    public String getSeq ()
    {
        return seq;
    }

    public void setSeq (String seq)
    {
        this.seq = seq;
    }

    public String getMid ()
    {
        return mid;
    }

    public void setMid (String mid)
    {
        this.mid = mid;
    }

    @Override
    public String toString()
    {
        return "[text = "+text+", seq = "+seq+", mid = "+mid+"]";
    }
}
