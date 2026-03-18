package com.enderio.endergy.common.conduit;

import com.enderio.api.conduit.ColoredRedstoneProvider;
import com.enderio.api.conduit.ConduitGraph;
import com.enderio.api.conduit.ConduitNode;
import com.enderio.api.conduit.ConduitType;
import com.enderio.api.conduit.ticker.CapabilityAwareConduitTicker;
import com.enderio.conduits.common.conduit.type.energy.EnergyConduitData;
import com.enderio.conduits.common.tag.ConduitTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.energy.IEnergyStorage;

import java.util.List;
import java.util.function.Consumer;

public class EndergyEnergyConduitTicker extends CapabilityAwareConduitTicker<EnergyConduitData, IEnergyStorage> {

    
    public static final int CRUDE       = 20;
    public static final int IRON        = 80;
    public static final int GOLD        = 160;
    public static final int COPPER      = 10_240;
    public static final int CRYSTALLINE = 81_920;
    public static final int MELODIC     = 327_680;
    public static final int STELLAR     = 2_000_000_000;

    private final int transferRate;

    public EndergyEnergyConduitTicker(int transferRate) {
        this.transferRate = transferRate;
    }

    public int getTransferRate() {
        return transferRate;
    }

    @Override
    public void tickGraph(
            ServerLevel level,
            ConduitType<EnergyConduitData> type,
            List<ConduitNode<EnergyConduitData>> loadedNodes,
            ConduitGraph<EnergyConduitData> graph,
            ColoredRedstoneProvider coloredRedstoneProvider) {

        
        for (ConduitNode<EnergyConduitData> node : loadedNodes) {
            EnergyConduitData data = node.getConduitData();
            if (data.getCapacity() < transferRate) {
                data.setCapacity(transferRate);
            }
        }

        super.tickGraph(level, type, loadedNodes, graph, coloredRedstoneProvider);
    }

    @Override
    protected void tickCapabilityGraph(
            ServerLevel level,
            ConduitType<EnergyConduitData> type,
            List<CapabilityConnection> inserts,
            List<CapabilityConnection> extracts,
            ConduitGraph<EnergyConduitData> graph,
            ColoredRedstoneProvider coloredRedstoneProvider) {

        int totalExtractors = Math.max(1, extracts.size());
        int ratePerExtractor = Math.max(1, transferRate / totalExtractors);

        for (CapabilityConnection extract : extracts) {
            IEnergyStorage extractHandler = extract.capability;
            EnergyConduitData.EnergySidedData sidedExtractData =
                    extract.data.castTo(EnergyConduitData.class).compute(extract.direction);

            extractEnergyLimited(
                    extractHandler,
                    inserts.stream().map(con -> con.capability).toList(),
                    sidedExtractData.rotatingIndex,
                    i -> sidedExtractData.rotatingIndex = i,
                    ratePerExtractor
            );
        }
    }

    private void extractEnergyLimited(
            IEnergyStorage extractHandler,
            List<IEnergyStorage> inserts,
            int startingIndex,
            Consumer<Integer> rotationIndexSetter,
            int maxTransfer) {

        int availableForExtraction = Math.min(
                extractHandler.extractEnergy(maxTransfer, true),
                maxTransfer
        );

        if (availableForExtraction <= 0) return;

        if (inserts.isEmpty()) return;

        if (startingIndex >= inserts.size()) {
            startingIndex = 0;
            rotationIndexSetter.accept(0);
        }

        for (int j = startingIndex; j < startingIndex + inserts.size(); j++) {
            int insertIndex = j % inserts.size();
            IEnergyStorage insert = inserts.get(insertIndex);
            int inserted = insert.receiveEnergy(availableForExtraction, false);
            extractHandler.extractEnergy(inserted, false);
            if (inserted == availableForExtraction) {
                rotationIndexSetter.accept(insertIndex + 1);
                return;
            }
            availableForExtraction -= inserted;
        }
    }

    @Override
    public int getTickRate() {
        return 1;
    }

    @Override
    protected Capability<IEnergyStorage> getCapability() {
        return ForgeCapabilities.ENERGY;
    }

    @Override
    public boolean canConnectTo(Level level, BlockPos conduitPos, Direction direction) {
        return super.canConnectTo(level, conduitPos, direction)
                && !level.getBlockState(conduitPos.relative(direction)).is(ConduitTags.Blocks.ENERGY_CABLE);
    }
}