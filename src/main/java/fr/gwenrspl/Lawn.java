package fr.gwenrspl;

import java.util.Objects;

/**
 * The class representing the lawn
 *
 * @author Gwen Rspl
 */
public class Lawn {
    /**
     * The maximum width of the lawn
     */
    private final int maxWidth;
    /**
     * The maximum height of the lawn
     */
    private final int maxHeight;
    /**
     * The minimum width of the lawn
     */
    private final int minWidth = 0;
    /**
     * The minimum height of the lawn
     */
    private final int minHeight = 0;

    public Lawn(int maxWidth, int maxHeight) {
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
    }

    public int getMaxWidth() {
        return this.maxWidth;
    }

    public int getMaxHeight() {
        return this.maxHeight;
    }

    public int getMinWidth() {
        return this.minWidth;
    }

    public int getMinHeight() {
        return this.minHeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Lawn lawn = (Lawn) o;
        return this.maxWidth == lawn.maxWidth &&
                this.maxHeight == lawn.maxHeight &&
                this.minWidth == lawn.minWidth &&
                this.minHeight == lawn.minHeight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.maxWidth, this.maxHeight, this.minWidth, this.minHeight);
    }

    @Override
    public String toString() {
        return "Lawn{" +
                "maxWidth=" + this.maxWidth +
                ", maxHeight=" + this.maxHeight +
                ", minWidth=" + this.minWidth +
                ", minHeight=" + this.minHeight +
                '}';
    }
}
