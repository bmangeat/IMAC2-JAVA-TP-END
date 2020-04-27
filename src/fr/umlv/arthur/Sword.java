package fr.umlv.arthur;

import java.util.Objects;

public class Sword extends Equipement {
    final private int _damage;
    final private String _name;

    /**
     * Constructor of sword
     * @param n Name of the sword
     * @param d Damage of the sword
     */
    public Sword(String n, int d){
        if(d < 0){
            throw new IllegalArgumentException("value must be positive");
        }
        _damage = d;
        if (n.length() == 0) {
            throw new IllegalArgumentException("name must contain at least 1 carac");
        }
        _name = Objects.requireNonNull(n);

    }

    public final int damage() { return _damage; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sword sword = (Sword) o;
        return Objects.equals(_name, sword._name);
    }

    @Override
    public String toString() {
        return  _name;
    }
}
