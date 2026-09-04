/* Decompiler 45ms, total 192ms, lines 183 */
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
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.EntityEffect;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\r\u001a\u00020\u000eH\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bJ\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"},
   d2 = {"Lme/deck/decksmp/ResurrectionAbility;", "Lorg/bukkit/event/Listener;", "plugin", "Lorg/bukkit/plugin/java/JavaPlugin;", "<init>", "(Lorg/bukkit/plugin/java/JavaPlugin;)V", "resurrectingPlayers", "", "Lorg/bukkit/entity/Player;", "playerCooldowns", "", "", "cooldownNotified", "startCooldownTicker", "", "tryResurrect", "", "player", "onPlayerDamage", "event", "Lorg/bukkit/event/entity/EntityDamageEvent;", "playTotemPop", "decksmp"}
)
@SourceDebugExtension({"SMAP\nReserection.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Reserection.kt\nme/deck/decksmp/ResurrectionAbility\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,107:1\n19985#2,2:108\n*S KotlinDebug\n*F\n+ 1 Reserection.kt\nme/deck/decksmp/ResurrectionAbility\n*L\n85#1:108,2\n*E\n"})
public final class ResurrectionAbility implements Listener {
   @NotNull
   private final JavaPlugin plugin;
   @NotNull
   private final Set<Player> resurrectingPlayers;
   @NotNull
   private final Map<Player, Integer> playerCooldowns;
   @NotNull
   private final Set<Player> cooldownNotified;

   public ResurrectionAbility(@NotNull JavaPlugin plugin) {
      Intrinsics.checkNotNullParameter(plugin, "plugin");
      super();
      this.plugin = plugin;
      this.resurrectingPlayers = (Set)(new LinkedHashSet());
      this.playerCooldowns = (Map)(new LinkedHashMap());
      this.cooldownNotified = (Set)(new LinkedHashSet());
      Bukkit.getPluginManager().registerEvents((Listener)this, (Plugin)this.plugin);
      this.startCooldownTicker();
   }

   private final void startCooldownTicker() {
      (new BukkitRunnable() {
         public void run() {
            List toRemove = (List)(new ArrayList());
            Iterator var2 = ResurrectionAbility.this.playerCooldowns.entrySet().iterator();

            while(var2.hasNext()) {
               Entry var3 = (Entry)var2.next();
               Player player = (Player)var3.getKey();
               int cd = ((Number)var3.getValue()).intValue();
               if (cd <= 1) {
                  toRemove.add(player);
                  if (!ResurrectionAbility.this.cooldownNotified.contains(player)) {
                     player.sendMessage("§aResurrection is off cooldown!");
                     ResurrectionAbility.this.cooldownNotified.add(player);
                  }
               } else {
                  ResurrectionAbility.this.playerCooldowns.put(player, cd - 1);
               }
            }

            Iterable $this$forEach$iv = (Iterable)toRemove;
            ResurrectionAbility var10 = ResurrectionAbility.this;
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

   public final boolean tryResurrect(@NotNull final Player player) {
      Intrinsics.checkNotNullParameter(player, "player");
      if (this.resurrectingPlayers.contains(player)) {
         return false;
      } else {
         Integer var10000 = (Integer)this.playerCooldowns.get(player);
         if ((var10000 != null ? var10000 : 0) > 0) {
            return false;
         } else {
            this.playerCooldowns.put(player, 300);
            this.cooldownNotified.remove(player);
            this.resurrectingPlayers.add(player);
            player.setHealth(player.getMaxHealth());
            player.setFoodLevel(20);
            player.setFireTicks(0);
            this.playTotemPop(player);
            (new BukkitRunnable() {
               public void run() {
                  ResurrectionAbility.this.resurrectingPlayers.remove(player);
               }
            }).runTaskLater((Plugin)this.plugin, 20L);
            return true;
         }
      }
   }

   @EventHandler
   public final void onPlayerDamage(@NotNull EntityDamageEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      Entity var4 = event.getEntity();
      Player var10000 = var4 instanceof Player ? (Player)var4 : null;
      if ((var4 instanceof Player ? (Player)var4 : null) != null) {
         Player player = var10000;
         if (!this.resurrectingPlayers.contains(player)) {
            String[] var13 = (String[])CardVariables.INSTANCE.getEquippedCards().get(player.getUniqueId().toString());
            if (var13 != null) {
               String[] cards = var13;
               Object[] $this$none$iv = cards;
               int $i$f$none = false;
               int var6 = 0;
               int var7 = cards.length;

               boolean var15;
               while(true) {
                  if (var6 >= var7) {
                     var15 = true;
                     break;
                  }

                  Object element$iv = $this$none$iv[var6];
                  int var10 = false;
                  String var14 = element$iv;
                  if (element$iv == null) {
                     var14 = "";
                  }

                  if (Intrinsics.areEqual(ChatColor.stripColor(var14), "Resurrection Card")) {
                     var15 = false;
                     break;
                  }

                  ++var6;
               }

               if (!var15) {
                  if (player.getHealth() - event.getFinalDamage() <= 0.0D) {
                     boolean activated = this.tryResurrect(player);
                     if (activated) {
                        event.setCancelled(true);
                     }
                  }

               }
            }
         }
      }
   }

   private final void playTotemPop(Player player) {
      Intrinsics.checkNotNullExpressionValue(player.getLocation().clone().add(0.0D, 1.0D, 0.0D), "add(...)");
      World var10000 = player.getWorld();
      Intrinsics.checkNotNullExpressionValue(var10000, "getWorld(...)");
      World world = var10000;
      world.playSound(player.getLocation(), Sound.ITEM_TOTEM_USE, 1.0F, 1.0F);
      player.playEffect(EntityEffect.TOTEM_RESURRECT);
   }
}
