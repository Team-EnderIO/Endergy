package com.enderio.endergy.common.conduit;

import com.enderio.api.conduit.ConduitMenuData;
import com.enderio.api.conduit.ConduitNode;
import com.enderio.api.misc.RedstoneControl;
import com.enderio.conduits.common.conduit.type.SimpleConduitType;
import com.enderio.conduits.common.conduit.type.energy.EnergyConduitData;
import com.enderio.conduits.common.conduit.type.energy.EnergyConduitType;
import com.enderio.conduits.common.tag.ConduitTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.IEnergyStorage;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.function.Consumer;

public class EndergyEnergyConduitType extends SimpleConduitType<EnergyConduitData> {

    private static final ConduitMenuData MENU_DATA = new ConduitMenuData.Simple(false, false, false, false, false, true);

    private static final EnergyConduitType DELEGATE = new EnergyConduitType();

    private final String langKey;
    private final int transferRate;

    public EndergyEnergyConduitType(String langKey, int transferRate) {
        super(new EndergyEnergyConduitTicker(transferRate), EnergyConduitData::new, MENU_DATA);
        this.langKey = langKey;
        this.transferRate = transferRate;
    }

    @Override
    public ConduitConnectionData getDefaultConnection(Level level, BlockPos pos, Direction direction) {
        BlockEntity blockEntity = level.getBlockEntity(pos.relative(direction));
        if (blockEntity != null) {
            LazyOptional<IEnergyStorage> capability = blockEntity.getCapability(ForgeCapabilities.ENERGY, direction.getOpposite());
            if (capability.isPresent()) {
                IEnergyStorage storage = capability.orElseThrow(() -> new RuntimeException("present capability was not found"));
                if (!storage.canReceive() && !storage.canExtract()) {
                    return new ConduitConnectionData(false, true, RedstoneControl.ALWAYS_ACTIVE);
                }
                return new ConduitConnectionData(storage.canReceive(), storage.canExtract(), RedstoneControl.ALWAYS_ACTIVE);
            }
        }
        return super.getDefaultConnection(level, pos, direction);
    }

    @Override
    public <K> Optional<LazyOptional<K>> proxyCapability(Capability<K> cap, EnergyConduitData extendedConduitData, Level level, BlockPos pos, @Nullable Direction direction, @Nullable ConduitNode.IOState state) {
        return DELEGATE.proxyCapability(cap, extendedConduitData, level, pos, direction, state);
    }

    @Override
    public void addToTooltip(Level level, Consumer<Component> tooltip, TooltipFlag flag) {
        tooltip.accept(Component.translatable(langKey));
        tooltip.accept(Component.translatable("tooltip.enderio_endergy.transfer_rate",
                formatRate(transferRate)));
    }

    private String formatRate(int rate) {
        if (rate == Integer.MAX_VALUE) {
            return "Unlimited";
        }
        return String.format("%,d FE/t", rate);
    }

    public int getTransferRate() {
        return transferRate;
    }
}