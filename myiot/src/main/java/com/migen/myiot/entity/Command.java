package com.migen.myiot.entity;

/**
 * 指令
 */
public class Command {

    private int cid;

    private String code;

    private String comment;

    private Byte slaveId;

    private Byte functionCode;

    private short start;

    private byte[] dataSegment;

    private String  dt;

    public int geCid()
    {
        return cid;
    }

    public void setCid(int cid)
    {
        this.cid = cid;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }


    public String getComment()
    {
        return comment;
    }

    public void setComment(String comment)
    {
        this.comment = comment;
    }

    public Byte getSlaveId()
    {
        return slaveId;
    }

    public void setSlaveId(Byte slaveId)
    {
        this.slaveId = slaveId;
    }

    public Byte getFunctionCode()
    {
        return functionCode;
    }

    public void setFunctionCode(Byte functionCode)
    {
        this.functionCode = functionCode;
    }

    public short getStart()
    {
        return start;
    }

    public void setStart(short start)
    {
        this.start = start;
    }

    public  byte[] getDataSegment()
    {
        return dataSegment;
    }

    public void setDataSegment( byte[] dataSegment)
    {
        this.dataSegment = dataSegment;
    }


    public String getDt()
    {
        return dt;
    }

    public void setDt(String dt)
    {
        this.dt = dt;
    }

}
