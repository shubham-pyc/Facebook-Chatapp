package com.example.facebookchatapp.models;


public class FacebookResponse
{
private Message message;

private String messaging_type;

private Recipient recipient;

public Message getMessage ()
{
return message;
}

public void setMessage (Message object)
{
this.message = object;
}

public String getMessaging_type ()
{
return messaging_type;
}

public void setMessaging_type (String messaging_type)
{
this.messaging_type = messaging_type;
}

public Recipient getRecipient ()
{
return recipient;
}

public void setRecipient (Recipient recipient)
{
this.recipient = recipient;
}

@Override
public String toString()
{
return "ClassPojo [message = "+message+", messaging_type = "+messaging_type+", recipient = "+recipient+"]";
}
}
