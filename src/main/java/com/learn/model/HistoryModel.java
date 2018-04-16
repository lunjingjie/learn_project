package com.learn.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "history", schema = "strutssshlearn")
public class HistoryModel {
    private int id;
    private Timestamp datatime;
    private String dataType;
    private String dataValue;
    private String deviceName;
    private DeviceModel deviceByDeviceId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "datatime")
    public Timestamp getDatatime() {
        return datatime;
    }

    public void setDatatime(Timestamp datatime) {
        this.datatime = datatime;
    }

    @Basic
    @Column(name = "data_type")
    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    @Basic
    @Column(name = "data_value")
    public String getDataValue() {
        return dataValue;
    }

    public void setDataValue(String dataValue) {
        this.dataValue = dataValue;
    }

    @Basic
    @Column(name = "device_name")
    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        HistoryModel that = (HistoryModel) o;

        if (id != that.id) {
            return false;
        }
        if (datatime != null ? !datatime.equals(that.datatime) : that.datatime != null) {
            return false;
        }
        if (dataType != null ? !dataType.equals(that.dataType) : that.dataType != null) {
            return false;
        }
        if (dataValue != null ? !dataValue.equals(that.dataValue) : that.dataValue != null) {
            return false;
        }
        if (deviceName != null ? !deviceName.equals(that.deviceName) : that.deviceName != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (datatime != null ? datatime.hashCode() : 0);
        result = 31 * result + (dataType != null ? dataType.hashCode() : 0);
        result = 31 * result + (dataValue != null ? dataValue.hashCode() : 0);
        result = 31 * result + (deviceName != null ? deviceName.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "device_id", referencedColumnName = "device_id")
    public DeviceModel getDeviceByDeviceId() {
        return deviceByDeviceId;
    }

    public void setDeviceByDeviceId(DeviceModel deviceByDeviceId) {
        this.deviceByDeviceId = deviceByDeviceId;
    }
}
