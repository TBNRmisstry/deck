/* Decompiler 25ms, total 145ms, lines 80 */
package me.deck.decksmp;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

@Metadata(
   mv = {2, 2, 0},
   k = 2,
   xi = 48,
   d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\u0006"},
   d2 = {"playCardEquipAnimation", "", "player", "Lorg/bukkit/entity/Player;", "plugin", "Lorg/bukkit/plugin/java/JavaPlugin;", "decksmp"}
)
public final class DecksmpKt {
   private static final void playCardEquipAnimation(final Player player, JavaPlugin plugin) {
      World var10000 = player.getWorld();
      Intrinsics.checkNotNullExpressionValue(var10000, "getWorld(...)");
      final World world = var10000;
      final double startY = player.getLocation().getY() + player.getEyeHeight();
      final double endY = player.getLocation().getY();
      final int steps = 10;
      final int radius = 1;
      final int particlesPerStep = 50;
      BukkitRunnable var10 = new BukkitRunnable() {
         private int progress;

         public final int getProgress() {
            return this.progress;
         }

         public final void setProgress(int var1) {
            this.progress = var1;
         }

         public void run() {
            if (this.progress > steps) {
               this.cancel();
            } else {
               double fraction = (double)this.progress / (double)steps;
               double y = startY - (startY - endY) * fraction;
               Location var7 = player.getLocation().clone();
               int var9 = false;
               var7.setY(y);
               Intrinsics.checkNotNullExpressionValue(var7, "apply(...)");
               Location center = var7;

               int i;
               for(i = 0; i < particlesPerStep; ++i) {
                  double angle = 6.283185307179586D / (double)particlesPerStep * (double)i;
                  double x = (double)radius * Math.cos(angle);
                  double z = (double)radius * Math.sin(angle);
                  Location var10000 = center.clone().add(x, 0.0D, z);
                  Intrinsics.checkNotNullExpressionValue(var10000, "add(...)");
                  Location particleLoc = var10000;
                  world.spawnParticle(Particle.END_ROD, particleLoc, 0, 0.0D, 0.0D, 0.0D, 0.0D);
               }

               i = this.progress++;
            }
         }
      };
      Plugin var10001 = player.getServer().getPluginManager().getPlugin("DeckSMP");
      Intrinsics.checkNotNull(var10001, "null cannot be cast to non-null type org.bukkit.plugin.java.JavaPlugin");
      var10.runTaskTimer((Plugin)((JavaPlugin)var10001), 0L, 1L);
      player.playSound(player.getLocation(), Sound.ITEM_TOTEM_USE, 1.0F, 1.0F);
   }

   // $FF: synthetic method
   public static final void access$playCardEquipAnimation(Player player, JavaPlugin plugin) {
      playCardEquipAnimation(player, plugin);
   }
}
