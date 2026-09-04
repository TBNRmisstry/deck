/* Decompiler 66ms, total 205ms, lines 161 */
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
import kotlin.jvm.internal.SourceDebugExtension;
import org.bukkit.ChatColor;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"},
   d2 = {"Lme/deck/decksmp/OceanCriticalAbility;", "Lorg/bukkit/event/Listener;", "plugin", "Lorg/bukkit/plugin/java/JavaPlugin;", "<init>", "(Lorg/bukkit/plugin/java/JavaPlugin;)V", "underwaterHitCounts", "", "Lorg/bukkit/entity/Player;", "", "underwaterCooldowns", "underwaterCooldownNotified", "", "startUnderwaterCooldownLoop", "", "onPlayerHit", "event", "Lorg/bukkit/event/entity/EntityDamageByEntityEvent;", "decksmp"}
)
@SourceDebugExtension({"SMAP\nocean.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ocean.kt\nme/deck/decksmp/OceanCriticalAbility\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,94:1\n12970#2,2:95\n*S KotlinDebug\n*F\n+ 1 ocean.kt\nme/deck/decksmp/OceanCriticalAbility\n*L\n58#1:95,2\n*E\n"})
public final class OceanCriticalAbility implements Listener {
   @NotNull
   private final JavaPlugin plugin;
   @NotNull
   private final Map<Player, Integer> underwaterHitCounts;
   @NotNull
   private final Map<Player, Integer> underwaterCooldowns;
   @NotNull
   private final Set<Player> underwaterCooldownNotified;

   public OceanCriticalAbility(@NotNull JavaPlugin plugin) {
      Intrinsics.checkNotNullParameter(plugin, "plugin");
      super();
      this.plugin = plugin;
      this.plugin.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)this.plugin);
      this.underwaterHitCounts = (Map)(new LinkedHashMap());
      this.underwaterCooldowns = (Map)(new LinkedHashMap());
      this.underwaterCooldownNotified = (Set)(new LinkedHashSet());
   }

   private final void startUnderwaterCooldownLoop() {
      (new BukkitRunnable() {
         public void run() {
            List toRemove = (List)(new ArrayList());
            Iterator var2 = OceanCriticalAbility.this.underwaterCooldowns.entrySet().iterator();

            while(var2.hasNext()) {
               Entry var3 = (Entry)var2.next();
               Player player = (Player)var3.getKey();
               int cd = ((Number)var3.getValue()).intValue();
               if (cd <= 1) {
                  toRemove.add(player);
                  if (!OceanCriticalAbility.this.underwaterCooldownNotified.contains(player)) {
                     player.sendMessage("§aUnderwater BloodRush ability is ready!");
                     OceanCriticalAbility.this.underwaterCooldownNotified.add(player);
                  }
               } else {
                  OceanCriticalAbility.this.underwaterCooldowns.put(player, cd - 1);
               }
            }

            Iterable $this$forEach$iv = (Iterable)toRemove;
            OceanCriticalAbility var10 = OceanCriticalAbility.this;
            int $i$f$forEach = false;
            Iterator var12 = $this$forEach$iv.iterator();

            while(var12.hasNext()) {
               Object element$iv = var12.next();
               Player it = (Player)element$iv;
               int var8 = false;
               var10.underwaterCooldowns.remove(it);
               var10.underwaterCooldownNotified.remove(it);
            }

         }
      }).runTaskTimer((Plugin)this.plugin, 20L, 20L);
   }

   @EventHandler
   public final void onPlayerHit(@NotNull EntityDamageByEntityEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      Entity var4 = event.getDamager();
      Player var10000 = var4 instanceof Player ? (Player)var4 : null;
      if ((var4 instanceof Player ? (Player)var4 : null) != null) {
         Player player = var10000;
         Entity var5 = event.getEntity();
         LivingEntity var15 = var5 instanceof LivingEntity ? (LivingEntity)var5 : null;
         if ((var5 instanceof LivingEntity ? (LivingEntity)var5 : null) != null) {
            LivingEntity target = var15;
            if (player.isInWater()) {
               String[] var16 = (String[])CardVariables.INSTANCE.getEquippedCards().get(player.getUniqueId().toString());
               if (var16 != null) {
                  String[] cards = var16;
                  Object[] $this$any$iv = cards;
                  int $i$f$any = false;
                  int var7 = 0;
                  int var8 = cards.length;

                  boolean var18;
                  while(true) {
                     if (var7 >= var8) {
                        var18 = false;
                        break;
                     }

                     Object element$iv = $this$any$iv[var7];
                     int var11 = false;
                     String var17 = element$iv;
                     if (element$iv == null) {
                        var17 = "";
                     }

                     if (Intrinsics.areEqual(ChatColor.stripColor(var17), "Ocean Card")) {
                        var18 = true;
                        break;
                     }

                     ++var7;
                  }

                  if (var18) {
                     event.setDamage(event.getDamage() * 1.5D);
                     player.getWorld().spawnParticle(Particle.CRIT, target.getLocation().add(0.0D, target.getHeight() / (double)2, 0.0D), 10, 0.2D, 0.5D, 0.2D, 0.05D);
                     player.getWorld().playSound(target.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1.0F, 1.0F);
                     if (this.underwaterCooldowns.get(player) == null) {
                        Integer var19 = (Integer)this.underwaterHitCounts.get(player);
                        int hits = (var19 != null ? var19 : 0) + 1;
                        this.underwaterHitCounts.put(player, hits);
                        if (hits >= 12) {
                           player.addPotionEffect(PotionEffectType.DOLPHINS_GRACE.createEffect(100, 0));
                           this.underwaterCooldowns.put(player, 30);
                           this.underwaterCooldownNotified.remove(player);
                           this.underwaterHitCounts.put(player, 0);
                           player.sendMessage("§bDolphin's Grace activated!");
                        }

                     }
                  }
               }
            }
         }
      }
   }
}
