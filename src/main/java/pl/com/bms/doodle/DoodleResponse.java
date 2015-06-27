package pl.com.bms.doodle;

class DoodleResponse {
    final String id;
    final String adminKey;

    DoodleResponse(String id, String adminKey) {
        this.id = id;
        this.adminKey = adminKey;
    }
}
