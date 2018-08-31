package models;

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
        return "ClassPojo [entry = "+entry+", object = "+object+"]";
    }
}
