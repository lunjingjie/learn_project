package com.learn.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "device", schema = "strutssshlearn")
public class DeviceModel implements Serializable{
    private int id;
    private String deviceId;
    private String deviceName;
    private String model;
    private String deviceUnit;
    private String mn;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "device_id")
    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    @Basic
    @Column(name = "device_name")
    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    @Basic
    @Column(name = "model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Basic
    @Column(name = "device_unit")
    public String getDeviceUnit() {
        return deviceUnit;
    }

    public void setDeviceUnit(String deviceUnit) {
        this.deviceUnit = deviceUnit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DeviceModel that = (DeviceModel) o;

        if (id != that.id) {
            return false;
        }
        if (deviceId != null ? !deviceId.equals(that.deviceId) : that.deviceId != null) {
            return false;
        }
        if (deviceName != null ? !deviceName.equals(that.deviceName) : that.deviceName != null) {
            return false;
        }
        if (model != null ? !model.equals(that.model) : that.model != null) {
            return false;
        }
        if (deviceUnit != null ? !deviceUnit.equals(that.deviceUnit) : that.deviceUnit != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (deviceId != null ? deviceId.hashCode() : 0);
        result = 31 * result + (deviceName != null ? deviceName.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (deviceUnit != null ? deviceUnit.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "mn")
    public String getMn() {
        return mn;
    }

    public void setMn(String mn) {
        this.mn = mn;
    }
}
