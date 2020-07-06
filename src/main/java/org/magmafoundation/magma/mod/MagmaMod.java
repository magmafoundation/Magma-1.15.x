package org.magmafoundation.magma.mod;

import net.minecraftforge.fml.CrashReportExtender;
import net.minecraftforge.fml.ExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.network.FMLNetworkConstants;
import org.apache.commons.lang3.tuple.Pair;
import org.bukkit.craftbukkit.v1_15_R1.CraftCrashReport;

import static net.minecraftforge.common.loot.LootModifierManager.LOGGER;

/**
 * Magma
 *
 * @author Hexeption admin@hexeption.co.uk
 */
@Mod("magma")
public class MagmaMod {

    public MagmaMod() {
        LOGGER.info("mod-load");
        CrashReportExtender.registerCrashCallable("Magma", () -> new CraftCrashReport().call().toString());
        ModLoadingContext.get().registerExtensionPoint(ExtensionPoint.DISPLAYTEST, () -> Pair.of(() -> FMLNetworkConstants.IGNORESERVERONLY, (a, b) -> true));
    }
}