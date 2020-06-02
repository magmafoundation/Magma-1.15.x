package org.magmafoundation.magma;

/**
 * Magma
 *
 * @author Hexeption admin@hexeption.co.uk
 * @since 02/06/2020 - 12:04 pm
 */
public class Magma {

    private static final String NAME = "Magma";
    private static final String VERSION = (Magma.class.getPackage().getImplementationVersion() != null) ? Magma.class.getPackage().getImplementationVersion() : "dev-env";
    private static final String BUKKIT_VERSION = "v1_15_R1";
    private static final String NMS_PREFIX = "net/minecraft/server/";
    private static final String LIBRARY_VERSION = "1";
    private static Magma INSTANCE = new Magma();

    public Magma() {
        INSTANCE = this;

        if (System.getProperty("log4j.configurationFile") == null) {
            System.setProperty("log4j.configurationFile", "log4j2_magma.xml");
        }
    }

    public static Magma getInstance() {
        return INSTANCE;
    }

    public static String getName() {
        return NAME;
    }

    public static String getVersion() {
        return VERSION;
    }

    public static String getBukkitVersion() {
        return BUKKIT_VERSION;
    }

    public static String getNmsPrefix() {
        return NMS_PREFIX;
    }

    public static String getLibraryVersion() {
        return LIBRARY_VERSION;
    }

}
