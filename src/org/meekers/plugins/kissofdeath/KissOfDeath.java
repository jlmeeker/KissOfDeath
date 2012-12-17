/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meekers.plugins.kissofdeath;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author jaredm
 */
public class KissOfDeath extends JavaPlugin {

    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new KissOfDeathListener(), this);
    }
}
