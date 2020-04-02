package fr.gwenrspl;

import java.util.List;

public class MowersHandler {
    private Lawn lawn;
    private List<Mower> mowers;

    public MowersHandler(Lawn lawn, List<Mower> mowers) {
        this.lawn = lawn;
        this.mowers = mowers;
    }

    public Lawn getLawn() {
        return this.lawn;
    }

    public void setLawn(Lawn lawn) {
        this.lawn = lawn;
    }

    public List<Mower> getMowers() {
        return this.mowers;
    }

    public void setMowers(List<Mower> mowers) {
        this.mowers = mowers;
    }
}
