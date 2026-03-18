package com.enderio.endergy.common.capacitor;

import com.enderio.api.capacitor.CapacitorModifier;
import com.enderio.api.capacitor.ICapacitorData;
import com.enderio.endergy.common.EnderIOEndergy;
import net.minecraft.nbt.FloatTag;
import net.minecraft.nbt.Tag;
import net.minecraftforge.common.util.INBTSerializable;

import java.util.Map;

public enum EndergyCapacitorData implements ICapacitorData, INBTSerializable<Tag> {
    GRAINY(1.0f),
    VIVID(3.0f),
    CRYSTALLINE(3.5f),
    MELODIC(4.0f),
    STELLAR(5.0f);

    private final float base;

    EndergyCapacitorData(float base) {
        this.base = base;
    }

    @Override
    public float getBase() {
        return base;
    }

    @Override
    public float getModifier(CapacitorModifier modifier) {
        return getBase();
    }

    @Override
    public Map<CapacitorModifier, Float> getAllModifiers() {
        return Map.of();
    }

    @Override
    public Tag serializeNBT() {
        return FloatTag.valueOf(base);
    }

    @Override
    public void deserializeNBT(Tag nbt) {
        EnderIOEndergy.LOGGER.warn("Tried to deserialize NBT for an Endergy capacitor datum.");
    }
}