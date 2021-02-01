package com.buzzware.sofittask.Model;

public class ServicesModel {
    int serviceImageview;
    String propertysericeTitle;
    String vehicleserviceTitle;
    String housesericeTitle;
    String mediaserviceTitle;
    String complainsericeTitle;
    String serviceTitle;
    String workserviceTitle;
    String schedualsericeTitle;
    String ComerceserviceTitle;
    String waletsericeTitle;

    public ServicesModel(int serviceImageview, String propertysericeTitle, String vehicleserviceTitle, String housesericeTitle,
                         String mediaserviceTitle, String complainsericeTitle, String serviceTitle,
                         String workserviceTitle, String schedualsericeTitle, String comerceserviceTitle, String waletsericeTitle) {
        this.serviceImageview = serviceImageview;
        this.propertysericeTitle = propertysericeTitle;
        this.vehicleserviceTitle = vehicleserviceTitle;
        this.housesericeTitle = housesericeTitle;
        this.mediaserviceTitle = mediaserviceTitle;
        this.complainsericeTitle = complainsericeTitle;
        this.serviceTitle = serviceTitle;
        this.workserviceTitle = workserviceTitle;
        this.schedualsericeTitle = schedualsericeTitle;
        ComerceserviceTitle = comerceserviceTitle;
        this.waletsericeTitle = waletsericeTitle;
    }

    public int getServiceImageview() {
        return serviceImageview;
    }

    public void setServiceImageview(int serviceImageview) {
        this.serviceImageview = serviceImageview;
    }

    public String getPropertysericeTitle() {
        return propertysericeTitle;
    }

    public void setPropertysericeTitle(String propertysericeTitle) {
        this.propertysericeTitle = propertysericeTitle;
    }

    public String getVehicleserviceTitle() {
        return vehicleserviceTitle;
    }

    public void setVehicleserviceTitle(String vehicleserviceTitle) {
        this.vehicleserviceTitle = vehicleserviceTitle;
    }

    public String getHousesericeTitle() {
        return housesericeTitle;
    }

    public void setHousesericeTitle(String housesericeTitle) {
        this.housesericeTitle = housesericeTitle;
    }

    public String getMediaserviceTitle() {
        return mediaserviceTitle;
    }

    public void setMediaserviceTitle(String mediaserviceTitle) {
        this.mediaserviceTitle = mediaserviceTitle;
    }

    public String getComplainsericeTitle() {
        return complainsericeTitle;
    }

    public void setComplainsericeTitle(String complainsericeTitle) {
        this.complainsericeTitle = complainsericeTitle;
    }

    public String getServiceTitle() {
        return serviceTitle;
    }

    public void setServiceTitle(String serviceTitle) {
        this.serviceTitle = serviceTitle;
    }

    public String getWorkserviceTitle() {
        return workserviceTitle;
    }

    public void setWorkserviceTitle(String workserviceTitle) {
        this.workserviceTitle = workserviceTitle;
    }

    public String getSchedualsericeTitle() {
        return schedualsericeTitle;
    }

    public void setSchedualsericeTitle(String schedualsericeTitle) {
        this.schedualsericeTitle = schedualsericeTitle;
    }

    public String getComerceserviceTitle() {
        return ComerceserviceTitle;
    }

    public void setComerceserviceTitle(String comerceserviceTitle) {
        ComerceserviceTitle = comerceserviceTitle;
    }

    public String getWaletsericeTitle() {
        return waletsericeTitle;
    }

    public void setWaletsericeTitle(String waletsericeTitle) {
        this.waletsericeTitle = waletsericeTitle;
    }
}
