package robotService.entities.supplements;

public class PlasticArmor extends BaseSupplement{

    public static final int HARDNESS_PLASTIC_ARMOR = 1;
    public static final int PRICE_PLASTIC_ARMOR = 10;
    public PlasticArmor() {
        super(HARDNESS_PLASTIC_ARMOR,PRICE_PLASTIC_ARMOR);
    }

    @Override
    public int getHardness() {
        return HARDNESS_PLASTIC_ARMOR;
    }

    @Override
    public double getPrice() {
        return PRICE_PLASTIC_ARMOR;
    }
}
