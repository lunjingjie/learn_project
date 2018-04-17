package com.learn.model;

import javax.persistence.*;

@Entity
@Table(name = "enterprise", schema = "strutssshlearn")
public class EnterpriseModel {
    private int id;
    private String enterpriseCode;
    private String mn;
    private String enterpridseName;
    private DeviceModel deviceByMn;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "enterprise_code")
    public String getEnterpriseCode() {
        return enterpriseCode;
    }

    public void setEnterpriseCode(String enterpriseCode) {
        this.enterpriseCode = enterpriseCode;
    }

    @Basic
    @Column(name = "enterpridse_name")
    public String getEnterpridseName() {
        return enterpridseName;
    }

    public void setEnterpridseName(String enterpridseName) {
        this.enterpridseName = enterpridseName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        EnterpriseModel that = (EnterpriseModel) o;

        if (id != that.id) {
            return false;
        }
        if (enterpriseCode != null ? !enterpriseCode.equals(that.enterpriseCode) : that.enterpriseCode != null) {
            return false;
        }
        if (mn != null ? !mn.equals(that.mn) : that.mn != null) {
            return false;
        }
        if (enterpridseName != null ? !enterpridseName.equals(that.enterpridseName) : that.enterpridseName != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (enterpriseCode != null ? enterpriseCode.hashCode() : 0);
        result = 31 * result + (mn != null ? mn.hashCode() : 0);
        result = 31 * result + (enterpridseName != null ? enterpridseName.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "mn", referencedColumnName = "mn")
    public DeviceModel getDeviceByMn() {
        return deviceByMn;
    }

    public void setDeviceByMn(DeviceModel deviceByMn) {
        this.deviceByMn = deviceByMn;
    }
}
