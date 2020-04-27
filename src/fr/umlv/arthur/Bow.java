package fr.umlv.arthur;

public class Bow extends Equipement {
    final private int _damage;
    final private int _protection;
    final private String _name;

    public Bow(String n, int d, int p){
        if(d < 0){
            throw new IllegalArgumentException("value must be positive");
        }
        if(p < 0){
            throw new IllegalArgumentException("value must be positive");
        }
        _damage = d;
        _protection = p;

        if (n.length() == 0) {
            throw new IllegalArgumentException("name must contain at least 1 carac");
        }
        _name = n;
    }


    public final int protection() {
        return _protection;
    }
    public final int damage() {
        return _damage;
    }

    @Override
    public String toString() {
        return  _name;
    }
}
