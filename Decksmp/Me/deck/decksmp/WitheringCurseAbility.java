/* Decompiler 38ms, total 168ms, lines 170 */
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
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
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
   d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bJ\u0016\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011J \u0010\u0013\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0014"},
   d2 = {"Lme/deck/decksmp/WitheringCurseAbility;", "", "<init>", "()V", "playerCooldowns", "", "Ljava/util/UUID;", "", "cooldownNotified", "", "plugin", "Lorg/bukkit/plugin/java/JavaPlugin;", "init", "", "pluginInstance", "handleHit", "attacker", "Lorg/bukkit/entity/Player;", "victim", "triggerCurse", "decksmp"}
)
public final class WitheringCurseAbility {
   @NotNull
   public static final WitheringCurseAbility INSTANCE = new WitheringCurseAbility();
   @NotNull
   private static final Map<UUID, Integer> playerCooldowns = (Map)(new LinkedHashMap());
   @NotNull
   private static final Set<UUID> cooldownNotified = (Set)(new LinkedHashSet());
   private static JavaPlugin plugin;

   private WitheringCurseAbility() {
   }

   public final void init(@NotNull JavaPlugin pluginInstance) {
      Intrinsics.checkNotNullParameter(pluginInstance, "pluginInstance");
      plugin = pluginInstance;
      BukkitRunnable var10000 = new BukkitRunnable() {
         public void run() {
            List toRemove = (List)(new ArrayList());
            Iterator var2 = WitheringCurseAbility.playerCooldowns.entrySet().iterator();

            while(var2.hasNext()) {
               Entry var3 = (Entry)var2.next();
               UUID uuid = (UUID)var3.getKey();
               int cd = ((Number)var3.getValue()).intValue();
               if (cd <= 1) {
                  toRemove.add(uuid);
                  if (!WitheringCurseAbility.cooldownNotified.contains(uuid)) {
                     Player var10000 = Bukkit.getPlayer(uuid);
                     if (var10000 != null) {
                        var10000.sendMessage("§aWithering Curse is off cooldown!");
                     }

                     WitheringCurseAbility.cooldownNotified.add(uuid);
                  }
               } else {
                  WitheringCurseAbility.playerCooldowns.put(uuid, cd - 1);
               }
            }

            Iterable $this$forEach$iv = (Iterable)toRemove;
            int $i$f$forEach = false;
            Iterator var10 = $this$forEach$iv.iterator();

            while(var10.hasNext()) {
               Object element$iv = var10.next();
               UUID it = (UUID)element$iv;
               int var7 = false;
               WitheringCurseAbility.playerCooldowns.remove(it);
               WitheringCurseAbility.cooldownNotified.remove(it);
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
         UUID uuid = var10000;
         Integer var5 = (Integer)playerCooldowns.get(uuid);
         int cooldown = var5 != null ? var5 : 0;
         if (cooldown <= 0) {
            JavaPlugin var10003 = plugin;
            if (var10003 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("plugin");
               var10003 = null;
            }

            this.triggerCurse(attacker, victim, var10003);
            playerCooldowns.put(uuid, 60);
            cooldownNotified.remove(uuid);
         }
      }
   }

   private final void triggerCurse(Player attacker, final Player victim, JavaPlugin plugin) {
      BossBar var10000 = Bukkit.createBossBar("§8Withering Curse", BarColor.PURPLE, BarStyle.SOLID, new BarFlag[0]);
      Intrinsics.checkNotNullExpressionValue(var10000, "createBossBar(...)");
      final BossBar bossBar = var10000;
      bossBar.addPlayer(victim);
      bossBar.setProgress(1.0D);
      victim.addPotionEffect(new PotionEffect(PotionEffectType.SLOWNESS, 100, 4, false, false, true));
      victim.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 100, 2, false, false, true));
      victim.addPotionEffect(new PotionEffect(PotionEffectType.DARKNESS, 100, 2, false, false, true));
      AttributeInstance var8 = victim.getAttribute(Attribute.GRAVITY);
      if (var8 != null) {
         final AttributeInstance gravityAttr = var8;
         final double originalGravity = gravityAttr.getBaseValue();
         gravityAttr.setBaseValue(originalGravity + (double)3);
         (new BukkitRunnable() {
            private int ticks;

            public final int getTicks() {
               return this.ticks;
            }

            public final void setTicks(int var1) {
               this.ticks = var1;
            }

            public void run() {
               if (this.ticks < 100 && victim.isOnline()) {
                  bossBar.setProgress(1.0D - (double)this.ticks / 100.0D);
                  if (this.ticks % 10 == 0) {
                     victim.getWorld().spawnParticle(Particle.ASH, victim.getLocation().add(0.0D, 1.0D, 0.0D), 30, 0.5D, 1.0D, 0.5D, 0.01D);
                  }

                  if (this.ticks % 20 == 0) {
                     victim.getWorld().playSound(victim.getLocation(), Sound.ENTITY_WITHER_AMBIENT, 0.6F, 0.6F);
                  }

                  int var1 = this.ticks++;
               } else {
                  bossBar.removeAll();
                  gravityAttr.setBaseValue(originalGravity);
                  this.cancel();
               }
            }
         }).runTaskTimer((Plugin)plugin, 0L, 1L);
      }
   }
}
