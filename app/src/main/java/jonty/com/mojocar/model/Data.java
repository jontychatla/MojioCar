package jonty.com.mojocar.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;

/**
 * Created by bharatkc on 1/3/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Data implements Serializable {

    @JsonProperty("Type")
    private String type;
    @JsonProperty("MojioId")
    private String mojioId;
    @JsonProperty("VehicleId")
    private String vehicleId;
    @JsonProperty("StartTime")
    private String startTime;
    @JsonProperty("LastUpdatedTime")
    private String lastUpdatedTime;
    @JsonProperty("EndTime")
    private String endTime;
    @JsonProperty("MaxSpeed")
    private Long maxSpeed;
    @JsonProperty("MaxAcceleration")
    private Long maxAcceleration;
    @JsonProperty("MaxDeceleration")
    private Long maxDeceleration;
    @JsonProperty("MaxRPM")
    private Integer maxRPM;
    @JsonProperty("FuelLevel")
    private Long fuelLevel;
    @JsonProperty("FuelEfficiency")
    private Long fuelEfficiency;
    @JsonProperty("Distance")
    private Long distance;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMojioId() {
        return mojioId;
    }

    public void setMojioId(String mojioId) {
        this.mojioId = mojioId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(String lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Long getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Long maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Long getMaxAcceleration() {
        return maxAcceleration;
    }

    public void setMaxAcceleration(Long maxAcceleration) {
        this.maxAcceleration = maxAcceleration;
    }

    public Long getMaxDeceleration() {
        return maxDeceleration;
    }

    public void setMaxDeceleration(Long maxDeceleration) {
        this.maxDeceleration = maxDeceleration;
    }

    public Integer getMaxRPM() {
        return maxRPM;
    }

    public void setMaxRPM(Integer maxRPM) {
        this.maxRPM = maxRPM;
    }

    public Long getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(Long fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public Long getFuelEfficiency() {
        return fuelEfficiency;
    }

    public void setFuelEfficiency(Long fuelEfficiency) {
        this.fuelEfficiency = fuelEfficiency;
    }

    public Long getDistance() {
        return distance;
    }

    public void setDistance(Long distance) {
        this.distance = distance;
    }
}

