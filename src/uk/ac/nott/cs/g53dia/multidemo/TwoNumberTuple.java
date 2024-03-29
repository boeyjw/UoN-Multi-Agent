package uk.ac.nott.cs.g53dia.multidemo;

/**
 * Represent a 2-tuple of (int x, int y)
 */
public class TwoNumberTuple implements NumberTuple, Cloneable {
    protected int x;
    protected int y;

    TwoNumberTuple() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    TwoNumberTuple(int x, int y) {
        this.x = x;
        this.y = y;
    }


    @Override
    public int getValue(int valuePosition) {
        if(valuePosition == 0)
            return x;
        else if(valuePosition == 1)
            return y;
        throw new IndexOutOfBoundsException("Tuple value out of range");
    }

    @Override
    public int getMin() {
        return Math.min(x, y);
    }

    @Override
    public int getMax() {
        return Math.max(x, y);
    }

    @Override
    public NumberTuple simpleOperation(int value, NumberTuple otherNumberTuple, char operation) {
        int x = this.x;
        int y = this.y;

        switch (operation) {
            case PLUS:
                x += (otherNumberTuple == null ? value : otherNumberTuple.getValue(0));
                y += (otherNumberTuple == null ? value : otherNumberTuple.getValue(1));
                break;
            case MINUS:
                x -= (otherNumberTuple == null ? value : otherNumberTuple.getValue(0));
                y -= (otherNumberTuple == null ? value : otherNumberTuple.getValue(1));
                break;
            case MULTIPLY:
                x *= (otherNumberTuple == null ? value : otherNumberTuple.getValue(0));
                y *= (otherNumberTuple == null ? value : otherNumberTuple.getValue(1));
                break;
            case DIVIDE:
                x /= (otherNumberTuple == null ? value : otherNumberTuple.getValue(0));
                y /= (otherNumberTuple == null ? value : otherNumberTuple.getValue(1));
                break;
            default:
                throw new IllegalArgumentException("Operation out of scope");
        }

        return new TwoNumberTuple(x, y);
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof TwoNumberTuple)) {
            return false;
        }
        TwoNumberTuple n = (TwoNumberTuple) obj;
        return n.getValue(0) == this.x && n.getValue(1) == this.y;
    }

    @Override
    protected Object clone() {
        return new TwoNumberTuple(x, y);
    }
}
