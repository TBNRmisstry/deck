/* Decompiler 126ms, total 258ms, lines 226 */
package me.deck.decksmp;

import java.util.ArrayList;
import java.util.Collection;
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
import kotlin.jvm.internal.Ref.DoubleRef;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Entity;
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
   d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bJ\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"},
   d2 = {"Lme/deck/decksmp/FrostAbility;", "", "<init>", "()V", "playerCooldowns", "", "Ljava/util/UUID;", "", "cooldownNotified", "", "plugin", "Lorg/bukkit/plugin/java/JavaPlugin;", "init", "", "pluginInstance", "handleHit", "attacker", "Lorg/bukkit/entity/Player;", "activeFrostRings", "triggerFrost", "decksmp"}
)
public final class FrostAbility {
   @NotNull
   public static final FrostAbility INSTANCE = new FrostAbility();
   @NotNull
   private static final Map<UUID, Integer> playerCooldowns = (Map)(new LinkedHashMap());
   @NotNull
   private static final Set<UUID> cooldownNotified = (Set)(new LinkedHashSet());
   private static JavaPlugin plugin;
   @NotNull
   private static final Set<UUID> activeFrostRings = (Set)(new LinkedHashSet());

   private FrostAbility() {
   }

   public final void init(@NotNull JavaPlugin pluginInstance) {
      Intrinsics.checkNotNullParameter(pluginInstance, "pluginInstance");
      plugin = pluginInstance;
      BukkitRunnable var10000 = new BukkitRunnable() {
         public void run() {
            List toRemove = (List)(new ArrayList());
            Iterator var2 = FrostAbility.playerCooldowns.entrySet().iterator();

            while(var2.hasNext()) {
               Entry var3 = (Entry)var2.next();
               UUID uuid = (UUID)var3.getKey();
               int cd = ((Number)var3.getValue()).intValue();
               if (cd <= 1) {
                  toRemove.add(uuid);
                  if (!FrostAbility.cooldownNotified.contains(uuid)) {
                     Player var10000 = Bukkit.getPlayer(uuid);
                     if (var10000 != null) {
                        var10000.sendMessage("§aFrost Ability is off cooldown!");
                     }

                     FrostAbility.cooldownNotified.add(uuid);
                  }
               } else {
                  FrostAbility.playerCooldowns.put(uuid, cd - 1);
               }
            }

            Iterable $this$forEach$iv = (Iterable)toRemove;
            int $i$f$forEach = false;
            Iterator var10 = $this$forEach$iv.iterator();

            while(var10.hasNext()) {
               Object element$iv = var10.next();
               UUID it = (UUID)element$iv;
               int var7 = false;
               FrostAbility.playerCooldowns.remove(it);
               FrostAbility.cooldownNotified.remove(it);
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

   public final void handleHit(@NotNull Player attacker) {
      Intrinsics.checkNotNullParameter(attacker, "attacker");
      if (plugin != null) {
         UUID var10000 = attacker.getUniqueId();
         Intrinsics.checkNotNullExpressionValue(var10000, "getUniqueId(...)");
         UUID uuid = var10000;
         Integer var4 = (Integer)playerCooldowns.get(uuid);
         int cooldown = var4 != null ? var4 : 0;
         if (cooldown <= 0) {
            this.triggerFrost(attacker);
            playerCooldowns.put(uuid, 30);
            cooldownNotified.remove(uuid);
         }
      }
   }

   private final void triggerFrost(final Player attacker) {
      UUID var10000 = attacker.getUniqueId();
      Intrinsics.checkNotNullExpressionValue(var10000, "getUniqueId(...)");
      final UUID uuid = var10000;
      if (!activeFrostRings.contains(uuid)) {
         activeFrostRings.add(uuid);
         World var11 = attacker.getWorld();
         Intrinsics.checkNotNullExpressionValue(var11, "getWorld(...)");
         final World world = var11;
         final double maxRadius = 10.0D;
         final int radialPoints = 80;
         final DoubleRef currentRadius = new DoubleRef();
         final DoubleRef radiusIncrement = new DoubleRef();
         radiusIncrement.element = 0.3D;
         final double incrementStep = 0.05D;
         BukkitRunnable var12 = new BukkitRunnable() {
            private long ticks;

            public final long getTicks() {
               return this.ticks;
            }

            public final void setTicks(long var1) {
               this.ticks = var1;
            }

            public void run() {
               if (currentRadius.element >= maxRadius) {
                  FrostAbility.activeFrostRings.remove(uuid);
                  this.cancel();
               } else {
                  Location var10000 = attacker.getLocation().clone().add(0.0D, 1.0D, 0.0D);
                  Intrinsics.checkNotNullExpressionValue(var10000, "add(...)");
                  Location base = var10000;
                  List var29 = world.getPlayers();
                  Intrinsics.checkNotNullExpressionValue(var29, "getPlayers(...)");
                  Iterable $this$forEach$iv = (Iterable)var29;
                  Player var3 = attacker;
                  DoubleRef var4 = currentRadius;
                  int $i$f$filter = false;
                  Collection destination$iv$iv = (Collection)(new ArrayList());
                  int $i$f$filterTo = false;
                  Iterator var9 = $this$forEach$iv.iterator();

                  while(var9.hasNext()) {
                     Object element$iv$iv = var9.next();
                     Player it = (Player)element$iv$iv;
                     int var12 = false;
                     if (!Intrinsics.areEqual(it, var3) && it.getLocation().distance(base) <= var4.element + 1.5D) {
                        destination$iv$iv.add(element$iv$iv);
                     }
                  }

                  $this$forEach$iv = (Iterable)((List)destination$iv$iv);
                  var3 = attacker;
                  int $i$f$forEach = false;
                  Iterator var21 = $this$forEach$iv.iterator();

                  while(var21.hasNext()) {
                     Object element$iv = var21.next();
                     Player player = (Player)element$iv;
                     $i$f$filterTo = false;
                     player.damage(3.0D, (Entity)var3);
                     player.setFreezeTicks(120);
                     player.addPotionEffect(new PotionEffect(PotionEffectType.SLOWNESS, 60, 0, true, true));
                  }

                  int i;
                  for(i = 0; i < radialPoints; ++i) {
                     double angle = 6.283185307179586D * (double)i / (double)radialPoints;
                     double x = Math.cos(angle) * currentRadius.element;
                     double z = Math.sin(angle) * currentRadius.element;
                     var10000 = base.clone().add(x, 0.0D, z);
                     Intrinsics.checkNotNullExpressionValue(var10000, "add(...)");
                     Location loc = var10000;
                     world.spawnParticle(Particle.SNOWFLAKE, loc, 1, 0.05D, 0.05D, 0.05D, 0.0D);
                     int flyingCount = 1 + (int)(Math.random() * (double)2);

                     for(int j = 0; j < flyingCount; ++j) {
                        double offsetX = Math.cos(angle) * (0.5D + Math.random());
                        double offsetZ = Math.sin(angle) * (0.5D + Math.random());
                        double offsetY = 0.3D + Math.random() * (double)0;
                        world.spawnParticle(Particle.SNOWFLAKE, loc.getX(), loc.getY(), loc.getZ(), 1, offsetX, offsetY, offsetZ, 0.2D);
                     }
                  }

                  if (this.ticks % (long)5 == 0L) {
                     world.playSound(base, Sound.BLOCK_SNOW_BREAK, 0.8F, 0.9F);
                  }

                  currentRadius.element += radiusIncrement.element;
                  if (this.ticks % (long)5 == 0L) {
                     radiusIncrement.element += incrementStep;
                  }

                  i = this.ticks++;
               }
            }
         };
         JavaPlugin var10001 = plugin;
         if (var10001 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("plugin");
            var10001 = null;
         }

         var12.runTaskTimer((Plugin)var10001, 0L, 1L);
      }
   }
}
