package com.enderio.endergy.common.item;

import com.enderio.api.capability.IMultiCapabilityItem;
import com.enderio.api.capability.MultiCapabilityProvider;
import com.enderio.api.capacitor.CapacitorModifier;
import com.enderio.api.capacitor.ICapacitorData;
import com.enderio.base.common.init.EIOCapabilities;
import com.enderio.base.common.item.capacitors.FixedCapacitorItem;
import com.enderio.core.common.util.TooltipUtil;
import com.enderio.endergy.common.lang.EndergyCommonComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("deprecation")
public class TotemicCapacitorItem extends FixedCapacitorItem {

    private static final Map<Integer, ICapacitorData> DATA_CACHE = new HashMap<>();

    public TotemicCapacitorItem(Properties properties) {
        super(buildData(0), properties.durability(512));
    }

    @Nullable
    @Override
    public MultiCapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt, MultiCapabilityProvider provider) {
        provider.add(EIOCapabilities.CAPACITOR, LazyOptional.of(() -> {
            int effLevel = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.BLOCK_EFFICIENCY, stack);
            return DATA_CACHE.computeIfAbsent(effLevel, TotemicCapacitorItem::buildData);
        }));
        return provider;
    }

    private static ICapacitorData buildData(int efficiencyLevel) {
        float base = 3.5f + efficiencyLevel * 0.5f;
        return new ICapacitorData() {
            @Override
            public float getBase() { return base; }

            @Override
            public float getModifier(CapacitorModifier modifier) { return base; }

            @Override
            public Map<CapacitorModifier, Float> getAllModifiers() { return Map.of(); }
        };
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack,
            net.minecraft.world.item.enchantment.Enchantment enchantment) {
        if (enchantment == Enchantments.BLOCK_EFFICIENCY) {
            return true;
        }
        return super.canApplyAtEnchantingTable(stack, enchantment);
    }

    @Override
    public int getEnchantmentValue() {
        return 10;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level,
            List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, level, tooltipComponents, tooltipFlag);
        tooltipComponents.add(TooltipUtil.style(EndergyCommonComponents.TOTEMIC_CAPACITOR_TOOLTIP));
    }
}