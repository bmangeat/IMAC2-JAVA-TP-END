package fr.umlv.arthur;

public class Shield extends Equipement {
    final private int _protection;
    final private String _name;

    /**
     * Constructor of Shield
     * @param n Name of the shield
     * @param p Protection provided from the shield
     */
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

    public final int protection() { return _protection; }
    public final String name() { return _name; }

    @Override
    public String toString() {
        return  _name;
    }
}

