/*
 * Magma Server
 * Copyright (C) 2019-2020.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package org.magmafoundation.magma.util;

import java.util.Enumeration;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class MagmaLazyLogManager extends LogManager {

    private volatile LogManager delegate;

    @Override
    public boolean addLogger(Logger logger) {
        tryGet();
        if (delegate != null) {
            return delegate.addLogger(logger);
        }
        return super.addLogger(logger);
    }

    @Override
    public Logger getLogger(String name) {
        tryGet();
        if (delegate != null) {
            return delegate.getLogger(name);
        }
        return super.getLogger(name);
    }

    @Override
    public Enumeration<String> getLoggerNames() {
        tryGet();
        if (delegate != null) {
            return delegate.getLoggerNames();
        }
        return super.getLoggerNames();
    }

    private void tryGet() {
        if (delegate != null) {
            return;
        }
        try {
            Class<?> name = Class.forName("org.apache.logging.log4j.jul.LogManager");
            delegate = (LogManager) name.newInstance();
        } catch (Exception ignored) {
        }
    }
}
