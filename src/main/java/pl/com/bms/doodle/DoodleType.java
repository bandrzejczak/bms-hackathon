package pl.com.bms.doodle;

enum DoodleType {
    TEXT("text", "TEXT"),
    DATES("dates", "DATE");

    final String mode;
    final String type;

    DoodleType(String mode, String type) {
        this.mode = mode;
        this.type = type;
    }
}
