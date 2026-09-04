package me.deck.decksmp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bJ\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0015H\u0007J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"},
   d2 = {"LGlideAbility;", "Lorg/bukkit/event/Listener;", "plugin", "Lorg/bukkit/plugin/java/JavaPlugin;", "<init>", "(Lorg/bukkit/plugin/java/JavaPlugin;)V", "glidingPlayers", "", "Lorg/bukkit/entity/Player;", "playerCooldowns", "", "", "cooldownNotified", "allowNextFallDamage", "startGlide", "", "player", "onFallDamage", "event", "Lorg/bukkit/event/entity/EntityDamageEvent;", "onPlayerQuit", "Lorg/bukkit/event/player/PlayerQuitEvent;", "createShockwave", "decksmp"}
)
public final class GlideAbility implements Listener {
   @NotNull
   private final JavaPlugin plugin;
   @NotNull
   private final Set<Player> glidingPlayers;
   @NotNull
   private final Map<Player, Integer> playerCooldowns;
   @NotNull
   private final Set<Player> cooldownNotified;
   @NotNull
   private final Set<Player> allowNextFallDamage;

   public GlideAbility(@NotNull JavaPlugin plugin) {
      Intrinsics.checkNotNullParameter(plugin, "plugin");
      super();
      this.plugin = plugin;
      this.glidingPlayers = (Set)(new LinkedHashSet());
      this.playerCooldowns = (Map)(new LinkedHashMap());
      this.cooldownNotified = (Set)(new LinkedHashSet());
      this.allowNextFallDamage = (Set)(new LinkedHashSet());
      this.plugin.getServer().getPluginManager().registerEvents(this, (Plugin)this.plugin);
      (new BukkitRunnable() {
         public void run() {
            List toRemove = (List)(new ArrayList());

            for(Map.Entry var3 : GlideAbility.this.playerCooldowns.entrySet()) {
               Player player = (Player)var3.getKey();
               int cd = ((Number)var3.getValue()).intValue();
               if (cd <= 1) {
                  toRemove.add(player);
                  if (!GlideAbility.this.cooldownNotified.contains(player)) {
                     player.sendMessage("§aGlide is off cooldown!");
                     GlideAbility.this.cooldownNotified.add(player);
                  }
               } else {
                  GlideAbility.this.playerCooldowns.put(player, cd - 1);
               }
            }

            Iterable var9 = (Iterable)toRemove;
            GlideAbility var10 = GlideAbility.this;
            int $i$f$forEach = 0;

            for(Object element$iv : var9) {
               Player it = (Player)element$iv;
               int var8 = 0;
               var10.playerCooldowns.remove(it);
               var10.cooldownNotified.remove(it);
            }

         }
      }).runTaskTimer((Plugin)this.plugin, 20L, 20L);
   }

   public final void startGlide(@NotNull final Player player) {
      Intrinsics.checkNotNullParameter(player, "player");
      if (!this.glidingPlayers.contains(player)) {
         Integer var10000 = (Integer)this.playerCooldowns.get(player);
         if ((var10000 != null ? var10000 : 0) <= 0) {
            Vector var4 = player.getLocation().getDirection().normalize();
            Intrinsics.checkNotNullExpressionValue(var4, "normalize(...)");
            Vector direction = var4;
            var4 = direction.multiply((double)2.5F).setY((double)1.0F);
            Intrinsics.checkNotNullExpressionValue(var4, "setY(...)");
            Vector launch = var4;
            player.setVelocity(launch);
            this.glidingPlayers.add(player);
            player.setGliding(true);
            this.playerCooldowns.put(player, 60);
            this.cooldownNotified.remove(player);
            (new BukkitRunnable() {
               private boolean hasLanded;

               public final boolean getHasLanded() {
                  return this.hasLanded;
               }

               public final void setHasLanded(boolean var1) {
                  this.hasLanded = var1;
               }

               public void run() {
                  if (player.isOnline() && GlideAbility.this.glidingPlayers.contains(player)) {
                     if (!player.isOnGround()) {
                        if (!player.isGliding()) {
                           player.setGliding(true);
                        }

                        Location var10000 = player.getLocation().clone().add((double)0.0F, 0.1, (double)0.0F);
                        Intrinsics.checkNotNullExpressionValue(var10000, "add(...)");
                        Location loc = var10000;
                        player.getWorld().spawnParticle(Particle.CLOUD, loc, 2, 0.2, 0.05, 0.2, (double)0.0F);
                     } else if (!this.hasLanded) {
                        GlideAbility.this.createShockwave(player);
                        player.setGliding(false);
                        player.setAllowFlight(false);
                        GlideAbility.this.glidingPlayers.remove(player);
                        GlideAbility.this.allowNextFallDamage.add(player);
                        this.hasLanded = true;
                        this.cancel();
                     }

                  } else {
                     GlideAbility.this.glidingPlayers.remove(player);
                     GlideAbility.this.allowNextFallDamage.remove(player);
                     this.cancel();
                  }
               }
            }).runTaskTimer((Plugin)this.plugin, 0L, 1L);
         }
      }
   }

   @EventHandler
   public final void onFallDamage(@NotNull EntityDamageEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      if (event.getEntity() instanceof Player) {
         Entity var10000 = event.getEntity();
         Intrinsics.checkNotNull(var10000, "null cannot be cast to non-null type org.bukkit.entity.Player");
         Player player = (Player)var10000;
         if (this.glidingPlayers.contains(player)) {
            event.setCancelled(true);
         } else if (this.allowNextFallDamage.contains(player) && event.getCause() == DamageCause.FALL) {
            this.allowNextFallDamage.remove(player);
         }

      }
   }

   @EventHandler
   public final void onPlayerQuit(@NotNull PlayerQuitEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      Player var10000 = event.getPlayer();
      Intrinsics.checkNotNullExpressionValue(var10000, "getPlayer(...)");
      Player player = var10000;
      this.glidingPlayers.remove(player);
      this.allowNextFallDamage.remove(player);
      this.cooldownNotified.remove(player);
   }

   private final void createShockwave(final Player player) {
      World var10000 = player.getWorld();
      Intrinsics.checkNotNullExpressionValue(var10000, "getWorld(...)");
      final World world = var10000;
      Location var8 = player.getLocation().clone();
      Intrinsics.checkNotNullExpressionValue(var8, "clone(...)");
      final Location base = var8;
      final double maxRadius = (double)8.0F;
      final int points = 40;
      final int expansionTicks = 20;
      world.playSound(base, Sound.ENTITY_GENERIC_EXPLODE, 1.0F, 1.0F);
      (new BukkitRunnable() {
         private int tick;

         public final int getTick() {
            return this.tick;
         }

         public final void setTick(int var1) {
            this.tick = var1;
         }

         public void run() {
            if (this.tick > expansionTicks) {
               this.cancel();
            } else {
               double radius = maxRadius * ((double)this.tick / (double)expansionTicks);

               for(int i = 0; i < points; ++i) {
                  double angle = (Math.PI * 2D) * (double)i / (double)points;
                  double x = Math.cos(angle) * radius;
                  double z = Math.sin(angle) * radius;
                  Location var10000 = base.clone().add(x, (double)0.0F, z);
                  Intrinsics.checkNotNullExpressionValue(var10000, "add(...)");
                  Location particleLoc = var10000;
                  world.spawnParticle(Particle.CRIT, particleLoc, 1, 0.1, 0.1, 0.1, (double)0.0F);
               }

               List var25 = world.getPlayers();
               Intrinsics.checkNotNullExpressionValue(var25, "getPlayers(...)");
               Iterable $this$forEach$iv = (Iterable)var25;
               Player $i$f$forEach = player;
               Location var5 = base;
               int $i$f$filter = 0;
               Collection destination$iv$iv = (Collection)(new ArrayList());
               int $i$f$filterTo = 0;

               for(Object element$iv$iv : $this$forEach$iv) {
                  Player it = (Player)element$iv$iv;
                  int var13 = 0;
                  if (!Intrinsics.areEqual((Object)it, (Object)$i$f$forEach) && it.getLocation().distance(var5) <= radius) {
                     destination$iv$iv.add(element$iv$iv);
                  }
               }

               $this$forEach$iv = (Iterable)((List)destination$iv$iv);
               int $i$f$forEach = 0;

               for(Object element$iv : $this$forEach$iv) {
                  Player p = (Player)element$iv;
                  int var23 = 0;
                  p.setVelocity(p.getVelocity().setY((double)1.5F));
               }

               int var16 = this.tick++;
            }
         }
      }).runTaskTimer((Plugin)this.plugin, 0L, 1L);
   }
}
