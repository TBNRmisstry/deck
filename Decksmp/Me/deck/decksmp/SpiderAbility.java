/* Decompiler 100ms, total 228ms, lines 166 */
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
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"},
   d2 = {"Lme/deck/decksmp/SpiderAbility;", "Lorg/bukkit/event/Listener;", "plugin", "Lorg/bukkit/plugin/java/JavaPlugin;", "<init>", "(Lorg/bukkit/plugin/java/JavaPlugin;)V", "radius", "", "playerCooldowns", "", "Lorg/bukkit/entity/Player;", "cooldownNotified", "", "activateSpiderEffect", "", "player", "decksmp"}
)
public final class SpiderAbility implements Listener {
   @NotNull
   private final JavaPlugin plugin;
   private final int radius;
   @NotNull
   private final Map<Player, Integer> playerCooldowns;
   @NotNull
   private final Set<Player> cooldownNotified;

   public SpiderAbility(@NotNull JavaPlugin plugin) {
      Intrinsics.checkNotNullParameter(plugin, "plugin");
      super();
      this.plugin = plugin;
      this.radius = 5;
      this.playerCooldowns = (Map)(new LinkedHashMap());
      this.cooldownNotified = (Set)(new LinkedHashSet());
      this.plugin.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)this.plugin);
      (new BukkitRunnable() {
         public void run() {
            List toRemove = (List)(new ArrayList());
            Iterator var2 = SpiderAbility.this.playerCooldowns.entrySet().iterator();

            while(var2.hasNext()) {
               Entry var3 = (Entry)var2.next();
               Player player = (Player)var3.getKey();
               int cd = ((Number)var3.getValue()).intValue();
               if (cd <= 1) {
                  toRemove.add(player);
                  if (!SpiderAbility.this.cooldownNotified.contains(player)) {
                     player.sendMessage("§aSpider ability is off cooldown!");
                     SpiderAbility.this.cooldownNotified.add(player);
                  }
               } else {
                  SpiderAbility.this.playerCooldowns.put(player, cd - 1);
               }
            }

            Iterable $this$forEach$iv = (Iterable)toRemove;
            SpiderAbility var10 = SpiderAbility.this;
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

   public final void activateSpiderEffect(@NotNull Player player) {
      Intrinsics.checkNotNullParameter(player, "player");
      Integer var10000 = (Integer)this.playerCooldowns.get(player);
      if ((var10000 != null ? var10000 : 0) <= 0) {
         World var25 = player.getWorld();
         Intrinsics.checkNotNullExpressionValue(var25, "getWorld(...)");
         World world = var25;
         int startX = player.getLocation().getBlockX() - this.radius;
         int startY = player.getLocation().getBlockY() - this.radius;
         int startZ = player.getLocation().getBlockZ() - this.radius;
         int endX = player.getLocation().getBlockX() + this.radius;
         int endY = player.getLocation().getBlockY() + this.radius;
         int endZ = player.getLocation().getBlockZ() + this.radius;
         double particleRadius = 0.6D;
         int points = 20;
         int x = startX;
         if (startX <= endX) {
            while(true) {
               int y = startY;
               if (startY <= endY) {
                  while(true) {
                     int z = startZ;
                     if (startZ <= endZ) {
                        while(true) {
                           Block var26 = world.getBlockAt(x, y, z);
                           Intrinsics.checkNotNullExpressionValue(var26, "getBlockAt(...)");
                           Block block = var26;
                           if (block.getType() == Material.COBWEB) {
                              block.setType(Material.AIR);
                              block.getWorld().dropItem(block.getLocation(), new ItemStack(Material.COBWEB, 1));
                              Location var27 = block.getLocation().clone().add(0.5D, 0.5D, 0.5D);
                              Intrinsics.checkNotNullExpressionValue(var27, "add(...)");
                              Location base = var27;

                              for(int i = 0; i < points; ++i) {
                                 double angle = 6.283185307179586D * (double)i / (double)points;
                                 double px = Math.cos(angle) * particleRadius;
                                 double pz = Math.sin(angle) * particleRadius;
                                 var27 = base.clone().add(px, 0.0D, pz);
                                 Intrinsics.checkNotNullExpressionValue(var27, "add(...)");
                                 Location particleLocation = var27;
                                 world.spawnParticle(Particle.CLOUD, particleLocation, 1, 0.05D, 0.05D, 0.05D, 0.01D);
                                 if (i % 4 == 0) {
                                    world.spawnParticle(Particle.END_ROD, particleLocation, 1, 0.0D, 0.0D, 0.0D, 0.0D);
                                 }
                              }
                           }

                           if (z == endZ) {
                              break;
                           }

                           ++z;
                        }
                     }

                     if (y == endY) {
                        break;
                     }

                     ++y;
                  }
               }

               if (x == endX) {
                  break;
               }

               ++x;
            }
         }

         world.playSound(player.getLocation(), Sound.ENTITY_SPIDER_DEATH, 1.0F, 1.0F);
         this.playerCooldowns.put(player, 3);
         this.cooldownNotified.remove(player);
      }
   }
}
