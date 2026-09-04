/* Decompiler 184ms, total 326ms, lines 259 */
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
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"},
   d2 = {"Lme/deck/decksmp/DragonEggAbility;", "Lorg/bukkit/event/Listener;", "plugin", "Lorg/bukkit/plugin/java/JavaPlugin;", "<init>", "(Lorg/bukkit/plugin/java/JavaPlugin;)V", "playerCooldowns", "", "Lorg/bukkit/entity/Player;", "", "cooldownNotified", "", "affectedPlayers", "", "bossBars", "Lorg/bukkit/boss/BossBar;", "onDragonEggUse", "", "event", "Lorg/bukkit/event/player/PlayerInteractEvent;", "decksmp"}
)
public final class DragonEggAbility implements Listener {
   @NotNull
   private final JavaPlugin plugin;
   @NotNull
   private final Map<Player, Integer> playerCooldowns;
   @NotNull
   private final Set<Player> cooldownNotified;
   @NotNull
   private final Map<Player, Long> affectedPlayers;
   @NotNull
   private final Map<Player, BossBar> bossBars;

   public DragonEggAbility(@NotNull JavaPlugin plugin) {
      Intrinsics.checkNotNullParameter(plugin, "plugin");
      super();
      this.plugin = plugin;
      this.playerCooldowns = (Map)(new LinkedHashMap());
      this.cooldownNotified = (Set)(new LinkedHashSet());
      this.affectedPlayers = (Map)(new LinkedHashMap());
      this.bossBars = (Map)(new LinkedHashMap());
      this.plugin.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)this.plugin);
      (new BukkitRunnable() {
         public void run() {
            List toRemove = (List)(new ArrayList());
            Iterator var2 = DragonEggAbility.this.playerCooldowns.entrySet().iterator();

            while(var2.hasNext()) {
               Entry var3 = (Entry)var2.next();
               Player player = (Player)var3.getKey();
               int cd = ((Number)var3.getValue()).intValue();
               if (cd <= 1) {
                  toRemove.add(player);
                  if (!DragonEggAbility.this.cooldownNotified.contains(player)) {
                     player.sendMessage("§dDragon Egg ability is ready!");
                     DragonEggAbility.this.cooldownNotified.add(player);
                  }
               } else {
                  DragonEggAbility.this.playerCooldowns.put(player, cd - 1);
               }
            }

            Iterable $this$forEach$iv = (Iterable)toRemove;
            DragonEggAbility var10 = DragonEggAbility.this;
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
      (new BukkitRunnable() {
         public void run() {
            long now = System.currentTimeMillis();
            Iterator iterator = DragonEggAbility.this.affectedPlayers.entrySet().iterator();

            while(true) {
               while(iterator.hasNext()) {
                  Entry var4 = (Entry)iterator.next();
                  Player player = (Player)var4.getKey();
                  long endTime = ((Number)var4.getValue()).longValue();
                  BossBar var10000;
                  if (player.isOnline() && now <= endTime) {
                     player.damage(1.0D);
                     player.getWorld().spawnParticle(Particle.DRAGON_BREATH, player.getLocation().add(0.0D, 1.0D, 0.0D), 10, 0.3D, 0.6D, 0.3D, 0.01D);
                     var10000 = (BossBar)DragonEggAbility.this.bossBars.get(player);
                     if (var10000 != null) {
                        BossBar bar = var10000;
                        int var9 = false;
                        long millisLeft = endTime - now;
                        double secondsLeft = RangesKt.coerceAtLeast((double)millisLeft / 1000.0D, 0.0D);
                        bar.setProgress(RangesKt.coerceIn(secondsLeft / 6.0D, 0.0D, 1.0D));
                        bar.setTitle("§cDragon Curse §7(" + (int)secondsLeft + "s left)");
                     }
                  } else {
                     iterator.remove();
                     var10000 = (BossBar)DragonEggAbility.this.bossBars.get(player);
                     if (var10000 != null) {
                        var10000.removeAll();
                     }

                     DragonEggAbility.this.bossBars.remove(player);
                  }
               }

               return;
            }
         }
      }).runTaskTimer((Plugin)this.plugin, 0L, 1L);
   }

   @EventHandler
   public final void onDragonEggUse(@NotNull PlayerInteractEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      Player var10000 = event.getPlayer();
      Intrinsics.checkNotNullExpressionValue(var10000, "getPlayer(...)");
      final Player player = var10000;
      ItemStack var6 = player.getInventory().getItemInMainHand();
      Intrinsics.checkNotNullExpressionValue(var6, "getItemInMainHand(...)");
      ItemStack item = var6;
      if (item.getType() == Material.DRAGON_EGG) {
         if (StringsKt.contains$default((CharSequence)event.getAction().name(), (CharSequence)"LEFT_CLICK", false, 2, (Object)null)) {
            Integer var7 = (Integer)this.playerCooldowns.get(player);
            int cooldown = var7 != null ? var7 : 0;
            if (cooldown > 0) {
               player.sendMessage("§cDragon Egg ability on cooldown: §e" + cooldown + "§cs left.");
            } else {
               this.playerCooldowns.put(player, 60);
               this.cooldownNotified.remove(player);
               World var8 = player.getWorld();
               Intrinsics.checkNotNullExpressionValue(var8, "getWorld(...)");
               final World world = var8;
               world.playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_FLAP, 1.0F, 1.2F);
               (new BukkitRunnable() {
                  private double yOffset = 2.0D;
                  private int stage;
                  private double expandRadius = 1.0D;

                  public final double getYOffset() {
                     return this.yOffset;
                  }

                  public final void setYOffset(double var1) {
                     this.yOffset = var1;
                  }

                  public final int getStage() {
                     return this.stage;
                  }

                  public final void setStage(int var1) {
                     this.stage = var1;
                  }

                  public final double getExpandRadius() {
                     return this.expandRadius;
                  }

                  public final void setExpandRadius(double var1) {
                     this.expandRadius = var1;
                  }

                  public void run() {
                     if (!player.isOnline()) {
                        this.cancel();
                     } else {
                        Location var10000 = player.getLocation().clone().add(0.0D, this.yOffset, 0.0D);
                        Intrinsics.checkNotNullExpressionValue(var10000, "add(...)");
                        Location loc = var10000;
                        int i;
                        double angle;
                        double x;
                        double z;
                        switch(this.stage) {
                        case 0:
                           for(i = 0; i < 41; ++i) {
                              angle = 6.283185307179586D * (double)i / (double)40;
                              x = Math.cos(angle);
                              z = Math.sin(angle);
                              world.spawnParticle(Particle.DRAGON_BREATH, loc.clone().add(x, 0.0D, z), 1, 0.02D, 0.02D, 0.02D, 0.0D);
                           }

                           this.yOffset -= 0.15D;
                           if (this.yOffset <= 0.5D) {
                              this.stage = 1;
                              world.playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 1.0F, 0.8F);
                           }
                           break;
                        case 1:
                           for(i = 0; i < 81; ++i) {
                              angle = 6.283185307179586D * (double)i / (double)80;
                              x = Math.cos(angle) * this.expandRadius;
                              z = Math.sin(angle) * this.expandRadius;
                              world.spawnParticle(Particle.DRAGON_BREATH, player.getLocation().clone().add(x, 0.1D, z), 2, 0.05D, 0.05D, 0.05D, 0.0D);
                           }

                           Iterator var9 = world.getNearbyPlayers(player.getLocation(), this.expandRadius).iterator();

                           while(var9.hasNext()) {
                              Player nearby = (Player)var9.next();
                              if (!Intrinsics.areEqual(nearby, player)) {
                                 Vector var12 = nearby.getLocation().toVector().subtract(player.getLocation().toVector()).normalize();
                                 Intrinsics.checkNotNullExpressionValue(var12, "normalize(...)");
                                 Vector pushDir = var12;
                                 nearby.setVelocity(pushDir.multiply(0.5D).setY(0.3D));
                                 DragonEggAbility.this.affectedPlayers.put(nearby, System.currentTimeMillis() + (long)6000);
                                 if (!DragonEggAbility.this.bossBars.containsKey(nearby)) {
                                    BossBar var13 = Bukkit.createBossBar("§cDragon Curse §7(6s left)", BarColor.RED, BarStyle.SOLID, new BarFlag[0]);
                                    Intrinsics.checkNotNullExpressionValue(var13, "createBossBar(...)");
                                    BossBar bar = var13;
                                    bar.addPlayer(nearby);
                                    DragonEggAbility.this.bossBars.put(nearby, bar);
                                 }
                              }
                           }

                           this.expandRadius += 0.3D;
                           if (this.expandRadius >= 7.0D) {
                              world.playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_SHOOT, 1.0F, 1.0F);
                              this.cancel();
                           }
                        }

                     }
                  }
               }).runTaskTimer((Plugin)this.plugin, 0L, 1L);
            }
         }
      }
   }
}
