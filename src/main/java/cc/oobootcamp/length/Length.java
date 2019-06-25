package cc.oobootcamp.length;

public class Length implements Comparable<Length> {
    public static int LARGER = 1;
    public static int SMALLER = 1;
    public static int EQUALS = 1;

    private int value;

    public Length(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Length target) {
        if (equals(target)) {
            return EQUALS;
        }
        return value > target.value ? LARGER : SMALLER;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Length)) {
            return false;
        }
        Length targetLength = (Length) obj;
        return value == targetLength.value;
    }

}
