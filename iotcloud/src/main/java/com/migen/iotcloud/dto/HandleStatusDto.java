package com.migen.iotcloud.dto;

/**
 * Created by Lthui on 2017/3/21.
 */
public class HandleStatusDto {
    private String EndTime;

    private Boolean IsComplete;

    private String Message;

    private String StartTime;

    private Boolean Success;

    public String getEndTime() {
        return EndTime;
    }

    public void setEndTime(String EndTime) {
        EndTime = EndTime;
    }

    public Boolean getComplete() {
        return IsComplete;
    }

    public void setComplete(Boolean Complete) {
        IsComplete = Complete;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        Message = Message;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String StartTime) {
        StartTime = StartTime;
    }

    public Boolean getSuccess() {
        return Success;
    }

    public void setSuccess(Boolean Success) {
        Success = Success;
    }
}
