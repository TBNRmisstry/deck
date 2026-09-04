/* Decompiler 22ms, total 152ms, lines 69 */
package me.deck.decksmp;

import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"},
   d2 = {"Lme/deck/decksmp/AxePullUtil;", "", "<init>", "()V", "axeTypes", "", "Lorg/bukkit/Material;", "pullTarget", "", "player", "Lorg/bukkit/entity/Player;", "target", "Lorg/bukkit/entity/LivingEntity;", "decksmp"}
)
public final class AxePullUtil {
   @NotNull
   public static final AxePullUtil INSTANCE = new AxePullUtil();
   @NotNull
   private static final Set<Material> axeTypes;

   private AxePullUtil() {
   }

   public final void pullTarget(@NotNull Player player, @NotNull LivingEntity target) {
      Intrinsics.checkNotNullParameter(player, "player");
      Intrinsics.checkNotNullParameter(target, "target");
      if (!Intrinsics.areEqual(target, player)) {
         ItemStack var10000 = player.getInventory().getItemInMainHand();
         Intrinsics.checkNotNullExpressionValue(var10000, "getItemInMainHand(...)");
         ItemStack item = var10000;
         if (axeTypes.contains(item.getType())) {
            JavaPlugin var5 = JavaPlugin.getProvidingPlugin(Decksmp.class);
            Intrinsics.checkNotNullExpressionValue(var5, "getProvidingPlugin(...)");
            JavaPlugin plugin = var5;
            Bukkit.getScheduler().runTask((Plugin)plugin, AxePullUtil::pullTarget$lambda$0);
         }
      }
   }

   private static final void pullTarget$lambda$0(Player $player, LivingEntity $target) {
      double distance = $player.getLocation().distance($target.getLocation());
      if (distance >= 0.5D) {
         Vector var10000 = $player.getLocation().toVector().subtract($target.getLocation().toVector());
         Intrinsics.checkNotNullExpressionValue(var10000, "subtract(...)");
         Vector direction = var10000;
         double strength = Math.min(0.3D * distance, 1.5D);
         var10000 = direction.normalize().multiply(strength);
         Intrinsics.checkNotNullExpressionValue(var10000, "multiply(...)");
         Vector velocity = var10000;
         velocity.setY(0.2D);
         $target.setVelocity(velocity);
      }
   }

   static {
      Material[] var0 = new Material[]{Material.NETHERITE_AXE, Material.DIAMOND_AXE, Material.IRON_AXE, Material.STONE_AXE, Material.WOODEN_AXE, Material.GOLDEN_AXE};
      axeTypes = SetsKt.setOf(var0);
   }
}
