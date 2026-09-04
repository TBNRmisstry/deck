/* Decompiler 64ms, total 188ms, lines 139 */
package me.deck.decksmp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"},
   d2 = {"Lme/deck/decksmp/HopAbility;", "Lorg/bukkit/event/Listener;", "plugin", "Lorg/bukkit/plugin/java/JavaPlugin;", "<init>", "(Lorg/bukkit/plugin/java/JavaPlugin;)V", "doubleJumped", "", "Lorg/bukkit/entity/Player;", "playerCooldowns", "", "", "cooldownNotified", "noFallDamage", "performHop", "", "player", "decksmp"}
)
public final class HopAbility implements Listener {
   @NotNull
   private final JavaPlugin plugin;
   @NotNull
   private final Set<Player> doubleJumped;
   @NotNull
   private final Map<Player, Integer> playerCooldowns;
   @NotNull
   private final Set<Player> cooldownNotified;
   @NotNull
   private final Set<Player> noFallDamage;

   public HopAbility(@NotNull JavaPlugin plugin) {
      Intrinsics.checkNotNullParameter(plugin, "plugin");
      super();
      this.plugin = plugin;
      this.doubleJumped = (Set)(new LinkedHashSet());
      this.playerCooldowns = (Map)(new LinkedHashMap());
      this.cooldownNotified = (Set)(new LinkedHashSet());
      this.noFallDamage = (Set)(new LinkedHashSet());
      Bukkit.getPluginManager().registerEvents((Listener)this, (Plugin)this.plugin);
      (new BukkitRunnable() {
         public void run() {
            List toRemove = (List)(new ArrayList());
            Iterator var2 = HopAbility.this.playerCooldowns.entrySet().iterator();

            while(var2.hasNext()) {
               Entry var3 = (Entry)var2.next();
               Player player = (Player)var3.getKey();
               int cd = ((Number)var3.getValue()).intValue();
               if (cd <= 1) {
                  toRemove.add(player);
                  if (!HopAbility.this.cooldownNotified.contains(player)) {
                     player.sendMessage("§aHop ability is off cooldown!");
                     HopAbility.this.cooldownNotified.add(player);
                  }
               } else {
                  HopAbility.this.playerCooldowns.put(player, cd - 1);
               }
            }

            Iterable $this$forEach$iv = (Iterable)toRemove;
            HopAbility var10 = HopAbility.this;
            int $i$f$forEach = false;
            Iterator var12 = $this$forEach$iv.iterator();

            while(var12.hasNext()) {
               Object element$iv = var12.next();
               Player it = (Player)element$iv;
               int var8 = false;
               var10.playerCooldowns.remove(it);
               var10.cooldownNotified.remove(it);
            }

         }
      }).runTaskTimer((Plugin)this.plugin, 20L, 20L);
   }

   public final void performHop(@NotNull final Player player) {
      Intrinsics.checkNotNullParameter(player, "player");
      Integer var10000 = (Integer)this.playerCooldowns.get(player);
      if ((var10000 != null ? var10000 : 0) <= 0) {
         if (player.isOnGround()) {
            this.doubleJumped.remove(player);
         } else if (!this.doubleJumped.contains(player)) {
            player.getWorld().playSound(player.getLocation(), Sound.ENTITY_PHANTOM_FLAP, 1.0F, 1.0F);
            Vector var3 = player.getLocation().getDirection().multiply(0.6D).setY(1.5D);
            Intrinsics.checkNotNullExpressionValue(var3, "setY(...)");
            Vector jumpVelocity = var3;
            player.setVelocity(jumpVelocity);
            this.doubleJumped.add(player);
            this.playerCooldowns.put(player, 30);
            this.cooldownNotified.remove(player);
            this.noFallDamage.add(player);
            (new BukkitRunnable() {
               public void run() {
                  if (!player.isOnline()) {
                     this.cancel();
                  } else {
                     if (player.isOnGround()) {
                        HopAbility.this.noFallDamage.remove(player);
                        this.cancel();
                     } else {
                        player.setFallDistance(0.0F);
                     }

                  }
               }
            }).runTaskTimer((Plugin)this.plugin, 0L, 1L);
            (new BukkitRunnable() {
               public void run() {
                  if (player.isOnline() && !player.isOnGround()) {
                     Location var10000 = player.getLocation().clone().add(0.0D, 0.1D, 0.0D);
                     Intrinsics.checkNotNullExpressionValue(var10000, "add(...)");
                     Location base = var10000;
                     player.getWorld().spawnParticle(Particle.CLOUD, base, 3, 0.2D, 0.0D, 0.2D, 0.01D);
                     player.getWorld().spawnParticle(Particle.END_ROD, base, 1, 0.05D, 0.05D, 0.05D, 0.0D);
                  } else {
                     this.cancel();
                     HopAbility.this.doubleJumped.remove(player);
                  }
               }
            }).runTaskTimer((Plugin)this.plugin, 0L, 2L);
         }
      }
   }
}
