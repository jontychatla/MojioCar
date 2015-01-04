package jonty.com.mojocar.model;

import java.io.Serializable;

/**
 * Created by bharatkc on 1/3/15.
 */
public class Statistics implements Serializable {

    private int accident;
    private int fenceEntered;
    private int excessiveSpeed;


    public int getAccident() {
        return accident;
    }

    public void setAccident(int accident) {
        this.accident = accident;
    }

    public int getFenceEntered() {
        return fenceEntered;
    }

    public void setFenceEntered(int fenceEntered) {
        this.fenceEntered = fenceEntered;
    }

    public int getExcessiveSpeed() {
        return excessiveSpeed;
    }

    public void setExcessiveSpeed(int excessiveSpeed) {
        this.excessiveSpeed = excessiveSpeed;
    }
}
