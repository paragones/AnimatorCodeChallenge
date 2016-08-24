package com.paularagones.dojocodechallenge.Models;

/**
 * Created by Mack and Aragones on 17/08/2016.
 */
public class Item {
    private String status;
    private float timeDifference;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getTimeDifference() {
        return timeDifference;
    }

    public void setTimeDifference(float timeDifference) {
        this.timeDifference = timeDifference;
    }

    @Override
    public String toString() {
        return "Item{" +
                "status='" + status + '\'' +
                ", timeDifference=" + timeDifference +
                '}';
    }
}
