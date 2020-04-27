package fr.umlv.arthur;

public class Shield extends Equipement {
    final private int _protection;
    final private String _name;

    public Shield(String n, int p){
        if(p<0){
            throw new IllegalArgumentException("value must be positive");
        }
        _protection= p;
        if (n.length() == 0) {
            throw new IllegalArgumentException("name must contain at least 1 carac");
        }
        _name = n;
    }



    public final int protection() {
        return _protection;
    }

    @Override
    public String toString() {
        return  _name;
    }
}

