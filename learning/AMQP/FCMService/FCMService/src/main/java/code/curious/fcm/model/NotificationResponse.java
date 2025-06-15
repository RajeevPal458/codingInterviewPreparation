package code.curious.fcm.model;

import lombok.Data;

@Data
public class NotificationResponse {
    private String type;
    private String status;
    private String deviceId;
    private String domain;

    public String getType() {
        return null;
    }

    public void setType(String auth) {
    }

    public String getStatus() {
        return "";
    }

    public String getDeviceId() {
        return "20000";
    }
    public String getDomain() {
        return "0";
    }
}
