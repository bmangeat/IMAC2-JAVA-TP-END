package fr.umlv.arthur;

import java.util.Objects;

public class Bow extends Equipement {
    final private int _damage;
    final private int _protection;
    final private String _name;

    /**
     * Constructor of bow
     * @param n Name of the bow
     * @param d Damage of the bow
     * @param p Protection of the bow
     */
    public Bow(String n, int d, int p){
        if(d < 0 || p < 0){ throw new IllegalArgumentException("value must be positive"); }
        _damage = d;
        _protection = p;

        if (n.length() == 0) { throw new IllegalArgumentException("name must contain at least 1 carac"); }
        _name = n;
    }


    public final int protection() { return _protection; }
    public final int damage() { return _damage; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bow bow = (Bow) o;
        return Objects.equals(_name, bow._name);
    }

    @Override
    public String toString() {
        return  _name;
    }
}
