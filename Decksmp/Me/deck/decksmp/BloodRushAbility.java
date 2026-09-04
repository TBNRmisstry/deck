/* Decompiler 89ms, total 245ms, lines 172 */
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
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.Particle.DustOptions;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005J\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"},
   d2 = {"Lme/deck/decksmp/BloodRushAbility;", "", "<init>", "()V", "plugin", "Lorg/bukkit/plugin/java/JavaPlugin;", "playerHits", "", "Ljava/util/UUID;", "", "playerCooldowns", "cooldownNotified", "", "activeParticles", "Lorg/bukkit/scheduler/BukkitRunnable;", "init", "", "pluginInstance", "handleHit", "player", "Lorg/bukkit/entity/Player;", "triggerBloodRush", "decksmp"}
)
public final class BloodRushAbility {
   @NotNull
   public static final BloodRushAbility INSTANCE = new BloodRushAbility();
   private static JavaPlugin plugin;
   @NotNull
   private static final Map<UUID, Integer> playerHits = (Map)(new LinkedHashMap());
   @NotNull
   private static final Map<UUID, Integer> playerCooldowns = (Map)(new LinkedHashMap());
   @NotNull
   private static final Set<UUID> cooldownNotified = (Set)(new LinkedHashSet());
   @NotNull
   private static final Map<UUID, BukkitRunnable> activeParticles = (Map)(new LinkedHashMap());

   private BloodRushAbility() {
   }

   public final void init(@NotNull JavaPlugin pluginInstance) {
      Intrinsics.checkNotNullParameter(pluginInstance, "pluginInstance");
      plugin = pluginInstance;
      BukkitRunnable var10000 = new BukkitRunnable() {
         public void run() {
            List toRemove = (List)(new ArrayList());
            Iterator var2 = BloodRushAbility.playerCooldowns.entrySet().iterator();

            while(var2.hasNext()) {
               Entry var3 = (Entry)var2.next();
               UUID uuid = (UUID)var3.getKey();
               int cd = ((Number)var3.getValue()).intValue();
               if (cd <= 1) {
                  toRemove.add(uuid);
                  if (!BloodRushAbility.cooldownNotified.contains(uuid)) {
                     JavaPlugin var10000 = BloodRushAbility.plugin;
                     if (var10000 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("plugin");
                        var10000 = null;
                     }

                     Player player = var10000.getServer().getPlayer(uuid);
                     if (player != null) {
                        player.sendMessage("§aBlood Rush is off cooldown!");
                     }

                     BloodRushAbility.cooldownNotified.add(uuid);
                  }
               } else {
                  BloodRushAbility.playerCooldowns.put(uuid, cd - 1);
               }
            }

            Iterable $this$forEach$iv = (Iterable)toRemove;
            int $i$f$forEach = false;
            Iterator var10 = $this$forEach$iv.iterator();

            while(var10.hasNext()) {
               Object element$iv = var10.next();
               UUID it = (UUID)element$iv;
               int var7 = false;
               BloodRushAbility.playerCooldowns.remove(it);
               BloodRushAbility.cooldownNotified.remove(it);
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

   public final void handleHit(@NotNull Player player) {
      Intrinsics.checkNotNullParameter(player, "player");
      UUID var10000 = player.getUniqueId();
      Intrinsics.checkNotNullExpressionValue(var10000, "getUniqueId(...)");
      UUID uuid = var10000;
      Integer var4 = (Integer)playerCooldowns.get(uuid);
      if ((var4 != null ? var4 : 0) <= 0) {
         var4 = (Integer)playerHits.get(uuid);
         int hits = (var4 != null ? var4 : 0) + 1;
         playerHits.put(uuid, hits);
         if (hits >= 5) {
            this.triggerBloodRush(player);
            playerHits.put(uuid, 0);
            playerCooldowns.put(uuid, 60);
            cooldownNotified.remove(uuid);
         }

      }
   }

   private final void triggerBloodRush(final Player player) {
      player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 1));
      player.addPotionEffect(new PotionEffect(PotionEffectType.STRENGTH, 100, 1));
      player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
      player.sendMessage("§cBlood Rush activated!");
      final DustOptions redDust = new DustOptions(Color.RED, 1.0F);
      <undefinedtype> runnable = new BukkitRunnable() {
         private int tick;

         public final int getTick() {
            return this.tick;
         }

         public final void setTick(int var1) {
            this.tick = var1;
         }

         public void run() {
            if (player.isOnline() && player.hasPotionEffect(PotionEffectType.STRENGTH)) {
               Location var10000 = player.getLocation().clone().add(0.0D, 2.2D, 0.0D);
               Intrinsics.checkNotNullExpressionValue(var10000, "add(...)");
               Location base = var10000;
               double radius = 0.6D;
               double angle = (double)this.tick / 4.0D % 6.283185307179586D;
               double x = Math.cos(angle) * radius;
               double z = Math.sin(angle) * radius;
               var10000 = base.clone().add(x, 0.0D, z);
               Intrinsics.checkNotNullExpressionValue(var10000, "add(...)");
               Location particleLocation = var10000;
               player.getWorld().spawnParticle(Particle.DUST, particleLocation, 1, redDust);
               int var11 = this.tick++;
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

      runnable.runTaskTimer((Plugin)var10001, 0L, 1L);
      activeParticles.put(player.getUniqueId(), runnable);
   }
}
