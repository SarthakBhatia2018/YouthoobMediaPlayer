package sarthak.bhatia.youtubemediaplayer;

import java.text.StringCharacterIterator;

public class Exampleitems {
    private int mimage;
    private String title;
    private String mURL;

    public Exampleitems(int image,String text1,String text2)
    {
        mimage=image;
        title=text1;
        mURL=text2;
    }
    public void setImage(int image)
    {
        mimage=image;
    }
    public void setTitle(String text)
    {
        title=text;
    }
    public String getTitle()
    {
        return title;
    }
    public int getImageResource()
    {
        return mimage;
    }
    public String getURL()
    {
        return mURL;
    }
    public void setURL(String text)
    {
        mURL=text;
    }

}
