package online.solution.accessLog;

public class AccessLogData extends AccessLogFields{

    public String getClientIpAddress() {
        return clientIpAddress;
    }

    public void setClientIpAddress(String clientIpAddress) {
        this.clientIpAddress = clientIpAddress;
    }

    public String getRequestDateTime() {
        return requestDateTime;
    }

    public void setRequestDateTime(String requestDateTime) {
        this.requestDateTime = requestDateTime;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getByteSent() {
        return byteSent;
    }

    public void setByteSent(String byteSent) {
        this.byteSent = byteSent;
    }

    public String getRefererUrl() {
        return refererUrl;
    }

    public void setRefererUrl(String refererUrl) {
        this.refererUrl = refererUrl;
    }

    public String getRefererBrowser() {
        return refererBrowser;
    }

    public void setRefererBrowser(String refererBrowser) {
        this.refererBrowser = refererBrowser;
    }

    public String getRefererOtheDeatil() {
        return refererOtheDeatil;
    }

    public void setRefererOtheDeatil(String refererOtheDeatil) {
        this.refererOtheDeatil = refererOtheDeatil;
    }
    /*
     public String getRequestTimeZone() {
     return requestTimeZone;
     }

     public void setRequestTimeZone(String requestTimeZone) {
     this.requestTimeZone = requestTimeZone;
     }

     public String getRequestUrl() {
     return requestUrl;
     }

     public void setRequestUrl(String requestUrl) {
     this.requestUrl = requestUrl;
     }

     public String getHostName() {
     return hostName;
     }

     public void setHostName(String hostName) {
     this.hostName = hostName;
     }
     */
}
