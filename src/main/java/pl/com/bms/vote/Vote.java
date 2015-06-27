package pl.com.bms.vote;

/**
 * Created by marcin.konarski on 2015-06-27.
 */
public enum Vote {
    HATE(-1),
    LIKE(1);

    private int value;
    Vote(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
