package com.vstu.msgproj.webui.utils;
public class SplitValueBuilder
{
    private String split = "|";
    private StringBuilder sb = new StringBuilder();

    public SplitValueBuilder() {}

    public SplitValueBuilder(String split)
    {
        this.split = split;
    }

    public SplitValueBuilder add(String value)
    {
        this.sb.append(value).append(this.split);
        return this;
    }

    public SplitValueBuilder add(int value)
    {
        this.sb.append(String.valueOf(value)).append(this.split);
        return this;
    }

    public SplitValueBuilder add(long value)
    {
        this.sb.append(String.valueOf(value)).append(this.split);
        return this;
    }

    public SplitValueBuilder add(Object value)
    {
        this.sb.append(String.valueOf(value)).append(this.split);
        return this;
    }

    public String buildWithLast()
    {
        return this.sb.toString();
    }

    public String build()
    {
        int index = this.sb.lastIndexOf(this.split);
        if ((index + this.split.length() == this.sb.length()) && (index >= 0)) {
            return this.sb.substring(0, index);
        }
        return this.sb.toString();
    }

    public void clear(){
        this.sb = new StringBuilder();
    }

    public String toString()
    {
        return build();
    }

    public static void main(String[] args)
    {
        SplitValueBuilder svb = new SplitValueBuilder(";");

        System.out.println(svb.build());
    }
}
