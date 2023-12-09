package SplitWise.constant;

public enum SplitType {
    EQUAL("EQUAL"),
    EXACT("EXACT"),
    PERCENT("PERCENT"),
    SHARE("SHARE");

    String value;

    SplitType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
