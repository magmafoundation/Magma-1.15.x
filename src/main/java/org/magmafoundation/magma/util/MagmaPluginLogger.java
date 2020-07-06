package org.magmafoundation.magma.util;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginLogger;

import java.util.logging.LogManager;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/**
 * Magma
 *
 * @author Hexeption admin@hexeption.co.uk
 */
public class MagmaPluginLogger extends PluginLogger {

    private final Logger logger;

    public MagmaPluginLogger(Plugin context) {
        super(context);
        String prefix = context.getDescription().getPrefix();
        logger = LogManager.getLogManager().getLogger(prefix == null ? context.getName() : prefix);
    }

    @Override
    public void log(LogRecord logRecord) {
        logger.log(logRecord);
    }
}

