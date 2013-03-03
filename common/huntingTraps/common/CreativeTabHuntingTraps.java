package huntingTraps.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public final class CreativeTabHuntingTraps extends CreativeTabs
{
        public CreativeTabHuntingTraps(String par2Str)
        {
                super(par2Str);
        }
        
        //sets the image for the creative tab
        @Override
        public ItemStack getIconItemStack() {
            return new ItemStack(Item.eyeOfEnder);
        }
   
        //sets the title/name for the creative tab
        public String getTranslatedTabLabel()
        {
         return "Hunting Traps";
        }
}