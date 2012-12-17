/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meekers.plugins.kissofdeath;

import java.util.Random;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

/**
 *
 * @author jaredm
 */
class KissOfDeathListener implements Listener {

    @EventHandler
    public void onEntityHit(EntityDamageByEntityEvent event) {
        Entity receiver = event.getEntity();
        Entity attacker = event.getDamager();
        String an;
        String rn;
        String item = "???";
        Random rand = new Random();
        int damage = event.getDamage();

        if (attacker.getType() == EntityType.PLAYER) {
            Player p = (Player) attacker;
            an = p.getPlayerListName();
            item = p.getItemInHand().getType().toString();

            if (attacker.getType() == EntityType.PLAYER && receiver.getType() != EntityType.PLAYER) {
                LivingEntity li = (LivingEntity) receiver;
                int lih = li.getHealth()-damage;
                int lihM = li.getMaxHealth();

                rn = receiver.getType().toString();
                // Caculate probability of one-shot kill
                boolean oneshotkill = rand.nextInt(10) == 0;

                if (oneshotkill == true) {
                    event.setDamage(li.getHealth() + 10);
                    Location location;
                    location = p.getLocation();
                    p.getWorld().playSound(location, Sound.AMBIENCE_THUNDER, 1, 0);
                    Bukkit.broadcastMessage(an + " dealt lethal blow to " + rn + " with a(n) " + item);
                    lih = 0;
                }
                
                p.sendMessage(rn + " has " + lih + "/" + lihM + " health left");
            }
        }
    }
}
