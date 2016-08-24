package com.paularagones.dojocodechallenge.Models;

/**
 * Created by Mack and Aragones on 17/08/2016.
 */
public class Overall {
    private long value;
    private long total;
    private String trend;
    private String status;

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public String getTrend() {
        return trend;
    }

    public void setTrend(String trend) {
        this.trend = trend;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Overall{" +
                "value=" + value +
                ", total=" + total +
                ", trend='" + trend + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
