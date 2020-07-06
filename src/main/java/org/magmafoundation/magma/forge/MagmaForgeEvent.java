package org.magmafoundation.magma.forge;

import net.minecraftforge.common.animation.Event;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;

/**
 * Magma
 *
 * @author Hexeption admin@hexeption.co.uk
 */
public class MagmaForgeEvent extends org.bukkit.event.Event {
    private static final HandlerList handlers = new HandlerList();
    private final Event forgeEvent;

    public MagmaForgeEvent(Event forgeEvent) {
        super(!Bukkit.getServer().isPrimaryThread());
        this.forgeEvent = forgeEvent;
    }

    public Event getForgeEvent() {
        return this.forgeEvent;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
