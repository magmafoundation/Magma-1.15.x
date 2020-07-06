package org.magmafoundation.magma.api;

import java.util.Objects;

/**
 * Magma
 *
 * @author Hexeption admin@hexeption.co.uk
 */
public class MagmaVersion {

    public static final MagmaVersion v1_15 = new MagmaVersion("1.15.2", 1152);

    private final String name;
    private final int num;

    public MagmaVersion(String name, int num) {
        this.name = name;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "MagmaVersion{" +
                "name='" + name + '\'' +
                ", num=" + num +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MagmaVersion that = (MagmaVersion) o;
        return num == that.num &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, num);
    }

    private static MagmaVersion version;

    public static void setVersion(MagmaVersion version) {
        if (MagmaVersion.version != null) throw new IllegalStateException("Version is already set!");
        if (version == null) throw new IllegalArgumentException("Version cannot be null!");
        MagmaVersion.version = version;
    }

    public static boolean atLeast(MagmaVersion v) {
        return v.num <= version.num;
    }

    public static boolean lesserThan(MagmaVersion v) {
        return v.num > version.num;
    }
}
