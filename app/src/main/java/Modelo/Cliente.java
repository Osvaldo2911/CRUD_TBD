package Modelo;

public class Cliente {
    String clientNo;
    String fName;
    String lName;
    String telNo;
    String prefType;
    String maxRent;

    public Cliente(String clientNo, String fName, String lName, String telNo, String prefType, String maxRent) {
        this.clientNo = clientNo;
        this.fName = fName;
        this.lName = lName;
        this.telNo = telNo;
        this.prefType = prefType;
        this.maxRent = maxRent;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getPrefType() {
        return prefType;
    }

    public void setPrefType(String prefType) {
        this.prefType = prefType;
    }

    public String getMaxRent() {
        return maxRent;
    }

    public void setMaxRent(String maxRent) {
        this.maxRent = maxRent;
    }
}
