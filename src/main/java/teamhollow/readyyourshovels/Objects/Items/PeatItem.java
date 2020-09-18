package teamhollow.readyyourshovels.Objects.Items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class PeatItem extends Item {

    public PeatItem(Properties properties) {
        super(properties);
    }

    @Override
    public int getBurnTime(ItemStack itemStack) {
        return 800;
    }
}
