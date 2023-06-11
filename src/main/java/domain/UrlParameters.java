package domain;

import java.net.URLEncoder;

public enum UrlParameters {
    BASE_URL("http://openapi.seoul.go.kr:8088"),
    API_KEY("4668414e5568747734355a596d6b6e"),
    FORMAT("json"),
    SERVICE("TbPublicWifiInfo");

    private final String value;

    UrlParameters(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
