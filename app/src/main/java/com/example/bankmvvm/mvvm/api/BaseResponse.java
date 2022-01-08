package com.example.bankmvvm.mvvm.api;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public  class BaseResponse <R extends BaseResponse> {



    @SerializedName("Message")
    @Expose
    private String message;

    @SerializedName("Success")
    @Expose
    private Boolean success;

    @SerializedName("HasPermission")
    @Expose
    private Boolean hasPermission;
    @SerializedName("TotalCount")
    @Expose
    private Integer totalCount;





    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }



    public Boolean getHasPermission() {
        return hasPermission;
    }

    public void setHasPermission(Boolean hasPermission) {
        this.hasPermission = hasPermission;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }
}
