package fr.umlv.arthur;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Knight {
    final private ArrayList<Equipement> _equipements;
    final private String _name;
    private Heroicity _heroic;

    public Knight(String n, Sword w){
        if (n.length() == 0) {
            throw new IllegalArgumentException("name must contain at least 1 carac");
        }
        _name = Objects.requireNonNull(n);

        _equipements = new ArrayList<Equipement>();

        _equipements.add(Objects.requireNonNull(w));
        _heroic = new Heroicity(1, 1);
    }

    public Knight(String n, Equipement w1, Equipement w2){
        if (n.length() == 0) {
            throw new IllegalArgumentException("name must contain at least 1 carac");
        }
        _name = Objects.requireNonNull(n);

        _equipements = new ArrayList<Equipement>();

        if (w1 instanceof Shield && w2 instanceof Shield){
            throw new IllegalArgumentException("you can't carry only shield");
        }

        _equipements.add(Objects.requireNonNull(w1));
        _equipements.add(Objects.requireNonNull(w2));

        _heroic = new Heroicity(1, 1);

    }

    public Knight(String n, Equipement w1, Equipement w2, Equipement w3, Equipement w4){
        if (n.length() == 0) {
            throw new IllegalArgumentException("name must contain at least 1 carac");
        }
        _name = Objects.requireNonNull(n);

        _equipements = new ArrayList<Equipement>();

        if (w1 instanceof Shield && w2 instanceof Shield && w3 instanceof Shield && w4 instanceof Shield){
            throw new IllegalArgumentException("you can't carry only shield");
        }

        _equipements.add(Objects.requireNonNull(w1));
        _equipements.add(Objects.requireNonNull(w2));
        _equipements.add(Objects.requireNonNull(w3));
        _equipements.add(Objects.requireNonNull(w4));

        _heroic = new Heroicity(1, 1);


    }

    public int damage(){
        int result = 0;
        for (Equipement s: _equipements)
        {
            if (s instanceof Sword){
                result += ((Sword) s).damage();
            }
            if (s instanceof Bow){
                result += ((Bow) s).damage();
            }
        }

        if (this._heroic.isHeroic()){
            return _heroic.applyDamageHeroic(result);
        }

        return result;
    }

    public int protection(){
        int result = 0;
        for (Equipement s: _equipements){
            if(s instanceof Shield){
                result +=  ((Shield) s).protection();
            }
            if (s instanceof Bow){
                result += ((Bow) s).protection();
            }
        }
        if (this._heroic.isHeroic()){
            return _heroic.applyProtecHeroic(result);
        }
        return result;
    }

    public String name() {
        return _name;
    }

    public boolean isBetterThan(Knight otherKnight){
        if(this.damage() == otherKnight.damage() ){
            return this.protection() < otherKnight.protection();
        } else {
            return this.damage() < otherKnight.damage();
        }
    }

    public void setHeroicity(Heroicity h){
        _heroic = Objects.requireNonNull(h);
    }

    public boolean isHeroic(){
        return _heroic.isHeroic();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(_name);
        sb.append(" damage : ");
        sb.append(damage());
        sb.append(" protection : ");
        sb.append(protection());
        sb.append("\n");
        sb.append("  [");

        Iterator i = _equipements.iterator();
        while (i.hasNext()){
            sb.append(i.next());
            if(i.hasNext()){
                sb.append(", ");
            }
        }

        sb.append("]");


        return sb.toString() ;
    }
}
