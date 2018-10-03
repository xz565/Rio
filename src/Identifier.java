import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonValue;


/**
 * Represents an identifier value.
 */
public abstract class Identifier implements Comparable<Identifier> {

    private final String value;

    /**
     * @param value A non-blank String identifier value
     * @throws IllegalArgumentException if the argument is blank
     */
    protected Identifier(final String value) {

        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @Override
    public int compareTo(final Identifier other) {
        return getValue().compareTo(other.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass(), getValue());
    }

    @Override
    public boolean equals(final Object other) {
        if (other == null) {
            return false;
        }
        if (!this.getClass().equals(other.getClass())) {
            return false;
        }
        return getValue().equals(((Identifier) other).getValue());
    }

}
