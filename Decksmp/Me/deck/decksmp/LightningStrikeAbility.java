/* Decompiler 77ms, total 230ms, lines 184 */
package me.deck.decksmp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fJ\u0016\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012J\u0018\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0015"},
   d2 = {"Lme/deck/decksmp/LightningStrikeAbility;", "", "<init>", "()V", "playerHits", "", "Ljava/util/UUID;", "", "playerCooldowns", "cooldownNotified", "", "plugin", "Lorg/bukkit/plugin/java/JavaPlugin;", "init", "", "pluginInstance", "handleHit", "attacker", "Lorg/bukkit/entity/Player;", "victim", "triggerLightning", "decksmp"}
)
public final class LightningStrikeAbility {
   @NotNull
   public static final LightningStrikeAbility INSTANCE = new LightningStrikeAbility();
   @NotNull
   private static final Map<UUID, Integer> playerHits = (Map)(new LinkedHashMap());
   @NotNull
   private static final Map<UUID, Integer> playerCooldowns = (Map)(new LinkedHashMap());
   @NotNull
   private static final Set<UUID> cooldownNotified = (Set)(new LinkedHashSet());
   private static JavaPlugin plugin;

   private LightningStrikeAbility() {
   }

   public final void init(@NotNull JavaPlugin pluginInstance) {
      Intrinsics.checkNotNullParameter(pluginInstance, "pluginInstance");
      plugin = pluginInstance;
      BukkitRunnable var10000 = new BukkitRunnable() {
         public void run() {
            List toRemove = (List)(new ArrayList());
            Iterator var2 = LightningStrikeAbility.playerCooldowns.entrySet().iterator();

            while(var2.hasNext()) {
               Entry var3 = (Entry)var2.next();
               UUID uuid = (UUID)var3.getKey();
               int cd = ((Number)var3.getValue()).intValue();
               if (cd <= 1) {
                  toRemove.add(uuid);
                  if (!LightningStrikeAbility.cooldownNotified.contains(uuid)) {
                     Player player = Bukkit.getPlayer(uuid);
                     if (player != null) {
                        player.sendMessage("§aLightning Strike is off cooldown!");
                     }

                     LightningStrikeAbility.cooldownNotified.add(uuid);
                  }
               } else {
                  LightningStrikeAbility.playerCooldowns.put(uuid, cd - 1);
               }
            }

            Iterable $this$forEach$iv = (Iterable)toRemove;
            int $i$f$forEach = false;
            Iterator var10 = $this$forEach$iv.iterator();

            while(var10.hasNext()) {
               Object element$iv = var10.next();
               UUID it = (UUID)element$iv;
               int var7 = false;
               LightningStrikeAbility.playerCooldowns.remove(it);
               LightningStrikeAbility.cooldownNotified.remove(it);
            }

         }
      };
      JavaPlugin var10001 = plugin;
      if (var10001 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("plugin");
         var10001 = null;
      }

      var10000.runTaskTimer((Plugin)var10001, 20L, 20L);
   }

   public final void handleHit(@NotNull Player attacker, @NotNull Player victim) {
      Intrinsics.checkNotNullParameter(attacker, "attacker");
      Intrinsics.checkNotNullParameter(victim, "victim");
      if (plugin != null) {
         UUID var10000 = attacker.getUniqueId();
         Intrinsics.checkNotNullExpressionValue(var10000, "getUniqueId(...)");
         UUID attackerUUID = var10000;
         Integer var6 = (Integer)playerCooldowns.get(attackerUUID);
         int cooldown = var6 != null ? var6 : 0;
         if (cooldown <= 0) {
            var6 = (Integer)playerHits.get(attackerUUID);
            int hits = (var6 != null ? var6 : 0) + 1;
            playerHits.put(attackerUUID, hits);
            if (hits >= 12) {
               playerCooldowns.put(attackerUUID, 30);
               cooldownNotified.remove(attackerUUID);
               playerHits.put(attackerUUID, 0);
               this.triggerLightning(attacker, victim);
            }

         }
      }
   }

   private final void triggerLightning(Player attacker, final Player victim) {
      World var10000 = victim.getWorld();
      Intrinsics.checkNotNullExpressionValue(var10000, "getWorld(...)");
      final World world = var10000;
      world.strikeLightningEffect(victim.getLocation());
      if (victim.isOnline()) {
         victim.damage(6.0D, (Entity)attacker);
      }

      victim.playSound(victim.getLocation(), Sound.ENTITY_LIGHTNING_BOLT_THUNDER, 1.0F, 1.0F);
      attacker.playSound(attacker.getLocation(), Sound.ENTITY_LIGHTNING_BOLT_THUNDER, 1.0F, 1.0F);
      BukkitRunnable var4 = new BukkitRunnable() {
         private int ticks;
         private final int maxTicks = 20;

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
               Location var10000 = victim.getLocation().clone().add(0.0D, 1.0D, 0.0D);
               Intrinsics.checkNotNullExpressionValue(var10000, "add(...)");
               Location base = var10000;
               double radius = 0.8D;
               int points = 20;
               int i = 0;

               while(true) {
                  double angle = (double)this.ticks / 5.0D + 6.283185307179586D * (double)i / (double)points;
                  double x = Math.cos(angle) * radius;
                  double z = Math.sin(angle) * radius;
                  double y = (double)this.ticks / 20.0D * 1.5D;
                  world.spawnParticle(Particle.END_ROD, base.clone().add(x, y, z), 0, 0.0D, 0.0D, 0.0D, 0.0D);
                  if (i == points) {
                     i = this.ticks++;
                     return;
                  }

                  ++i;
               }
            } else {
               this.cancel();
            }
         }
      };
      JavaPlugin var10001 = plugin;
      if (var10001 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("plugin");
         var10001 = null;
      }

      var4.runTaskTimer((Plugin)var10001, 0L, 1L);
   }
}
