package pl.com.bms.doodle;

public class DoodleResponse {
    public final String id;
    public final String adminKey;

    public DoodleResponse(String id, String adminKey) {
        this.id = id;
        this.adminKey = adminKey;
    }
}
