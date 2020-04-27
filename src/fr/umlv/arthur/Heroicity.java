package fr.umlv.arthur;


public class Heroicity {
    private final int _damage;
    private final int _protect;

    /**
     * Contructor of Heroicity
     * @param a Coef of damage
     * @param b Coef of protection
     */
    public Heroicity(int a, int b){
        if (a < 1 && a > 3){
            throw new IllegalArgumentException("value must be between 1 and 3");
        }

        if (b < 1 && b > 3){
            throw new IllegalArgumentException("value must be between 1 and 3");
        }
        _damage = a;
        _protect = b;
    }

    /**
     * @return false if ==1
     */
    public boolean isHeroic(){
        return _damage != 1 && _protect != 1;
    }

    /**
     * @param d initial damage from hero
     * @return multiply by coef set
     */
    public int applyDamageHeroic(int d){
        return this._damage* d;
    }

    /**
     *
     * @param p initial protection from hero
     * @return multiply by coef set
     */
    public int applyProtecHeroic(int p){
        return this._protect* p;
    }
}
