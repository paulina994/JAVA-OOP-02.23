package robotService.entities.supplements;

public class MetalArmor extends BaseSupplement{

    public static final int HARDNESS_METAL_ARMOR = 5;
    public static final int PRICE_METAL_ARMOR = 15;


    public MetalArmor() {
        super(HARDNESS_METAL_ARMOR, PRICE_METAL_ARMOR);
    }

    @Override
    public int getHardness() {
        return HARDNESS_METAL_ARMOR;
    }

    @Override
    public double getPrice() {
        return PRICE_METAL_ARMOR;
    }
}
