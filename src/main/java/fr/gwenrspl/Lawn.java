package fr.gwenrspl;

import java.util.Objects;

public class Lawn {
    private final int width;
    private final int height;

    public Lawn(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
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
        return this.width == lawn.width &&
                this.height == lawn.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.width, this.height);
    }

    @Override
    public String toString() {
        return "Lawn{" +
                "width=" + this.width +
                ", height=" + this.height +
                '}';
    }
}
