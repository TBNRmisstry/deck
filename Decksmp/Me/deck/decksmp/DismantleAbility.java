/* Decompiler 160ms, total 318ms, lines 261 */
package me.deck.decksmp;

import io.papermc.paper.event.player.PrePlayerAttackEntityEvent;
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
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.Particle.DustOptions;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bJ\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0015H\u0007J\u000e\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\bJ\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0018H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"},
   d2 = {"Lme/deck/decksmp/DismantleAbility;", "Lorg/bukkit/event/Listener;", "plugin", "Lorg/bukkit/plugin/java/JavaPlugin;", "<init>", "(Lorg/bukkit/plugin/java/JavaPlugin;)V", "lockedItems", "", "Lorg/bukkit/entity/Player;", "", "playerCooldowns", "cooldownNotified", "", "applyDismantle", "", "attacker", "victim", "onInventoryClick", "event", "Lorg/bukkit/event/inventory/InventoryClickEvent;", "onPlayerUse", "Lorg/bukkit/event/player/PlayerInteractEvent;", "spawnParticleLock", "onPlayerHit", "Lio/papermc/paper/event/player/PrePlayerAttackEntityEvent;", "decksmp"}
)
public final class DismantleAbility implements Listener {
   @NotNull
   private final JavaPlugin plugin;
   @NotNull
   private final Map<Player, Integer> lockedItems;
   @NotNull
   private final Map<Player, Integer> playerCooldowns;
   @NotNull
   private final Set<Player> cooldownNotified;

   public DismantleAbility(@NotNull JavaPlugin plugin) {
      Intrinsics.checkNotNullParameter(plugin, "plugin");
      super();
      this.plugin = plugin;
      this.lockedItems = (Map)(new LinkedHashMap());
      this.playerCooldowns = (Map)(new LinkedHashMap());
      this.cooldownNotified = (Set)(new LinkedHashSet());
      this.plugin.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)this.plugin);
      (new BukkitRunnable() {
         public void run() {
            List toRemove = (List)(new ArrayList());
            Iterator var2 = DismantleAbility.this.playerCooldowns.entrySet().iterator();

            while(var2.hasNext()) {
               Entry var3 = (Entry)var2.next();
               Player player = (Player)var3.getKey();
               int cd = ((Number)var3.getValue()).intValue();
               if (cd <= 1) {
                  toRemove.add(player);
                  if (!DismantleAbility.this.cooldownNotified.contains(player)) {
                     player.sendMessage("§aDismantle is now off cooldown!");
                     DismantleAbility.this.cooldownNotified.add(player);
                  }
               } else {
                  DismantleAbility.this.playerCooldowns.put(player, cd - 1);
               }
            }

            Iterable $this$forEach$iv = (Iterable)toRemove;
            DismantleAbility var10 = DismantleAbility.this;
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

   public final void applyDismantle(@NotNull Player attacker, @NotNull final Player victim) {
      Intrinsics.checkNotNullParameter(attacker, "attacker");
      Intrinsics.checkNotNullParameter(victim, "victim");
      Integer var10000 = (Integer)this.playerCooldowns.get(attacker);
      int cooldown = var10000 != null ? var10000 : 0;
      if (cooldown <= 0) {
         int slot = victim.getInventory().getHeldItemSlot();
         ItemStack var6 = victim.getInventory().getItem(slot);
         if (var6 != null) {
            final ItemStack victimItem = var6;
            if (victimItem.getType() == Material.AIR) {
               attacker.sendMessage("§eVictim is not holding anything to dismantle.");
            } else {
               this.lockedItems.put(victim, slot);
               victim.setCooldown(victimItem.getType(), 100);
               String var10001 = victim.getName();
               attacker.sendMessage("§aYou dismantled §e" + var10001 + "§a’s " + victimItem.getType() + "!");
               victim.sendMessage("§cYour " + victimItem.getType() + " has been locked temporarily!");
               victim.playSound(victim.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0F, 0.7F);
               this.spawnParticleLock(victim);
               (new BukkitRunnable() {
                  public void run() {
                     DismantleAbility.this.lockedItems.remove(victim);
                     if (victim.isOnline()) {
                        victim.sendMessage("§aYour " + victimItem.getType() + " is no longer locked!");
                        victim.setCooldown(victimItem.getType(), 0);
                     }

                  }
               }).runTaskLater((Plugin)this.plugin, 100L);
               this.playerCooldowns.put(attacker, 60);
               this.cooldownNotified.remove(attacker);
            }
         }
      }
   }

   @EventHandler
   public final void onInventoryClick(@NotNull InventoryClickEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      HumanEntity var4 = event.getWhoClicked();
      Player var10000 = var4 instanceof Player ? (Player)var4 : null;
      if ((var4 instanceof Player ? (Player)var4 : null) != null) {
         Player player = var10000;
         int slot = event.getSlot();
         Integer var5 = (Integer)this.lockedItems.get(player);
         if (var5 != null) {
            if (var5 == slot) {
               event.setCancelled(true);
               player.sendMessage("§cThis item is temporarily locked!");
            }
         }

      }
   }

   @EventHandler
   public final void onPlayerUse(@NotNull PlayerInteractEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      Player var10000 = event.getPlayer();
      Intrinsics.checkNotNullExpressionValue(var10000, "getPlayer(...)");
      Player player = var10000;
      int slot = player.getInventory().getHeldItemSlot();
      Integer var5 = (Integer)this.lockedItems.get(player);
      if (var5 != null) {
         if (var5 == slot) {
            event.setCancelled(true);
            player.sendMessage("§cThis item is temporarily locked!");
         }
      }

   }

   public final void spawnParticleLock(@NotNull final Player victim) {
      Intrinsics.checkNotNullParameter(victim, "victim");
      World var10000 = victim.getWorld();
      Intrinsics.checkNotNullExpressionValue(var10000, "getWorld(...)");
      final World world = var10000;
      final DustOptions greyDust = new DustOptions(Color.YELLOW, 1.0F);
      final DustOptions yellowDust = new DustOptions(Color.SILVER, 1.0F);
      final double bodyWidth = 0.6D;
      final double bodyHeight = 0.8D;
      final double shackleRadius = 0.5D;
      final int bodyPoints = 10;
      final int shacklePoints = 16;
      (new BukkitRunnable() {
         private int ticks;
         private final int maxTicks = 100;

         public final int getTicks() {
            return this.ticks;
         }

         public final void setTicks(int var1) {
            this.ticks = var1;
         }

         public final int getMaxTicks() {
            return this.maxTicks;
         }

         public void run() {
            if (this.ticks < this.maxTicks && victim.isOnline()) {
               Location var10000 = victim.getLocation().clone().add(0.0D, 2.5D, 0.0D);
               Intrinsics.checkNotNullExpressionValue(var10000, "add(...)");
               Location base = var10000;
               int i;
               if (this.ticks % 2 == 0) {
                  i = 0;
                  double angle;
                  if (i <= bodyPoints) {
                     while(true) {
                        angle = (double)i * (bodyHeight / (double)bodyPoints);
                        world.spawnParticle(Particle.DUST, base.clone().add(-bodyWidth, angle, 0.0D), 1, greyDust);
                        world.spawnParticle(Particle.DUST, base.clone().add(bodyWidth, angle, 0.0D), 1, greyDust);
                        world.spawnParticle(Particle.DUST, base.clone().add(-bodyWidth + (double)i * ((double)2 * bodyWidth / (double)bodyPoints), 0.0D, 0.0D), 1, greyDust);
                        world.spawnParticle(Particle.DUST, base.clone().add(-bodyWidth + (double)i * ((double)2 * bodyWidth / (double)bodyPoints), bodyHeight, 0.0D), 1, greyDust);
                        if (i == bodyPoints) {
                           break;
                        }

                        ++i;
                     }
                  }

                  i = 0;
                  if (i <= shacklePoints) {
                     while(true) {
                        angle = 3.141592653589793D * (double)i / (double)shacklePoints;
                        double x = Math.cos(angle) * shackleRadius;
                        double y = bodyHeight + Math.sin(angle) * shackleRadius;
                        world.spawnParticle(Particle.DUST, base.clone().add(x, y, 0.0D), 1, yellowDust);
                        if (i == shacklePoints) {
                           break;
                        }

                        ++i;
                     }
                  }
               }

               i = this.ticks++;
            } else {
               this.cancel();
            }
         }
      }).runTaskTimer((Plugin)this.plugin, 0L, 1L);
   }

   @EventHandler
   public final void onPlayerHit(@NotNull PrePlayerAttackEntityEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      Player var10000 = event.getPlayer();
      Intrinsics.checkNotNullExpressionValue(var10000, "getPlayer(...)");
      Player player = var10000;
      Integer var4 = (Integer)this.lockedItems.get(player);
      if (var4 != null) {
         int lockedSlot = var4;
         if (player.getInventory().getHeldItemSlot() == lockedSlot) {
            event.setCancelled(true);
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0F, 1.0F);
         }

      }
   }
}
