package online.solution.accessLog;

public class AccessLogReader {

    private final String logEntryPattern = "^([\\d.]+) (\\S+) (\\S+) \\[([\\w:/]+\\s[+\\-]\\d{4})\\] \"(.+?)\" (\\d{3}) (\\d+) \"([^\"]+)\" \"([^\"]+)\"";
    private final int NUM_FIELDS = 9;
    private int i = 0;
    AccessLogData logData;

    public AccessLogData readLine(String line) {
        logData = new AccessLogData();
        System.out.println("i-> " + i);
        i++;
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(logEntryPattern);
        java.util.regex.Matcher matcher = p.matcher(line);
        if (!matcher.matches() || NUM_FIELDS != matcher.groupCount()) {
            System.err.println("Bad log entry (or problem with RE?):");
            System.err.println(line);
            return logData;
        }
        logData.setClientIpAddress(matcher.group(1));
        System.out.println("IP Address: " + matcher.group(1));

        logData.setRequestDateTime(matcher.group(4));
        System.out.println("Date&Time: " + matcher.group(4));

        logData.setRequestMethod(matcher.group(5));
        System.out.println("Request: " + matcher.group(5));//Method + URL +Request header

        logData.setResponseStatus(matcher.group(6));
        System.out.println("Response Status : " + matcher.group(6));

        logData.setByteSent(matcher.group(7));
        System.out.println("Bytes Sent: " + matcher.group(7));
        if (!matcher.group(8).equals("-")) {
            logData.setRefererUrl(matcher.group(8));
            System.out.println("Referer link : " + matcher.group(8));
        }
        String userAgent = matcher.group(9).trim();
        if (!userAgent.isEmpty() && userAgent.contains("(")) {
            String browser = userAgent.substring(0, userAgent.indexOf("("));
            logData.setRefererBrowser(browser);
            System.out.println("Browser : " + browser);
            
            String otherDetail = userAgent.substring(userAgent.indexOf("("));
            if (!otherDetail.isEmpty()) {
                logData.setRefererOtheDeatil(otherDetail);
                System.out.println("Referer Other detail : " + otherDetail.toString());
            }
        } else {
            logData.setRefererBrowser(userAgent);
            System.out.println("Browser : " + userAgent);
        }
        System.out.println();
        System.out.println();
        return logData;
    }
}
