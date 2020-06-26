package org.spigotmc;

import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;
import org.bukkit.plugin.Plugin;
import co.aikar.timings.Timing;
import co.aikar.timings.Timings;
import co.aikar.timings.TimingsManager;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;

/**
 * This is here for legacy purposes incase any plugin used it.
 *
 * If you use this, migrate ASAP as this will be removed in the future!
 *
 * @deprecated
 * @see co.aikar.timings.Timings#of
 */
@Deprecated
public final class CustomTimingsHandler {
    private final Timing handler;
    private static Boolean sunReflectAvailable;
    private static Method getCallerClass;

    public CustomTimingsHandler(@NotNull String name) {
        if (sunReflectAvailable == null) {
            String javaVer = System.getProperty("java.version");
            String[] elements = javaVer.split("\\.");
        }

        int major = Integer.parseInt(elements.length >= 2 ? elements[1] : javaVer);
        if (major <= 8) {
            sunReflectAvailable = true;
        }
    }
        try

    {
        Class<?> reflection = Class.forName("sun.reflect.Reflection");
        getCallerClass = reflection.getMethod("getCallerClass", int.class);
    } catch(ClassNotFoundException |
    NoSuchMethodException ignored)

    {
    } else

    {
        sunReflectAvailable = false;
    }

    Class calling = null;
         if(sunReflectAvailable)

    {
        try {
            calling = (Class) getCallerClass.invoke(null, 2);
        } catch (IllegalAccessException | InvocationTargetException ignored) {
        }
    }

    Timing timing;

    Plugin plugin = null;
     try

    {
        plugin = TimingsManager.getPluginByClassloader(calling);
    } catch(
    Exception ignored)

    {
    }
     new

    AuthorNagException("Deprecated use of CustomTimingsHandler. Please Switch to Timings.of ASAP").

    printStackTrace();
     if(plugin !=null)

    {
        timing = Timings.of(plugin, "(Deprecated API) " + name);
    } else {
        try {
            final Method ofSafe = TimingsManager.class.getDeclaredMethod("getHandler", String.class, String.class, Timing.class);
            ofSafe.setAccessible(true);
            timing = (Timing) ofSafe.invoke(null, "Minecraft", "(Deprecated API) " + name, null);
        } catch (Exception e) {
            e.printStackTrace();
            Bukkit.getLogger().log(Level.SEVERE, "This handler could not be registered");
            timing = Timings.NULL_HANDLER;
        }
        handler = timing;
    }

}
    public void startTiming() { handler.startTiming(); }
    public void stopTiming() { handler.stopTiming(); }
}
