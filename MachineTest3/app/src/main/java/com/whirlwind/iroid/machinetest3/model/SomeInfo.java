package com.whirlwind.iroid.machinetest3.model;

/**
 * Created by Muhammed on 02/08/17.
 */

public class SomeInfo {

    private Result[] result;

    private String status;

    public Result[] getResult() {
        return result;
    }

    public void setResult(Result[] result) {
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ClassPojo [result = " + result + ", status = " + status + "]";
    }
}
