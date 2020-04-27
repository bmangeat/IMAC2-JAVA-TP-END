package fr.umlv.arthur;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class Knight {
    final private ArrayList<Equipement> _equipements;
    final private String _name;
    private Heroicity _heroic;

    /**
     * Constructor of knight
     * @param n Name of the knight
     * @param w Array of equipments
     */
    public Knight(String n, Equipement ...w){
        if (n.length() == 0) {
            throw new IllegalArgumentException("name must contain at least 1 carac");
        }
        _name = Objects.requireNonNull(n);
        _equipements = new ArrayList<Equipement>();

        if (Arrays.asList(w).stream().allMatch(val -> val instanceof Shield)){
            throw new IllegalArgumentException("you can't carry only shield");
        }

        for (Equipement e: w)
            _equipements.add(Objects.requireNonNull(e));

        _heroic = new Heroicity(1, 1);
    }


    /**
     * Proceed damage depending on equipments and heroicity
     * @return Damage of the knight
     */
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

    /**
     * Proceed protection depending on equipments and heroicity
     * @return Protection of the knight
     */
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

    /**
     * Compare two knights on damage and protection if they are equal
     * @param otherKnight
     * @return Boolean
     */
    public boolean isBetterThan(Knight otherKnight){
        if(this.damage() == otherKnight.damage() ){
            return this.protection() < otherKnight.protection();
        } else {
            return this.damage() < otherKnight.damage();
        }
    }


    public void setHeroicity(Heroicity h){ _heroic = Objects.requireNonNull(h); }

    /**
     * @return Boolean if hero is heroic
     */
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
