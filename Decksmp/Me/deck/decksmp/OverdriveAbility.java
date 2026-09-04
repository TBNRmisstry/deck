/* Decompiler 35ms, total 159ms, lines 143 */
package me.deck.decksmp;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
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
   d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000bH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"},
   d2 = {"Lme/deck/decksmp/OverdriveAbility;", "Lorg/bukkit/event/Listener;", "plugin", "Lorg/bukkit/plugin/java/JavaPlugin;", "<init>", "(Lorg/bukkit/plugin/java/JavaPlugin;)V", "onHit", "", "event", "Lorg/bukkit/event/entity/EntityDamageByEntityEvent;", "onMine", "Lorg/bukkit/event/block/BlockBreakEvent;", "Companion", "decksmp"}
)
public final class OverdriveAbility implements Listener {
   @NotNull
   public static final OverdriveAbility.Companion Companion = new OverdriveAbility.Companion((DefaultConstructorMarker)null);
   @NotNull
   private final JavaPlugin plugin;
   @NotNull
   private static final Map<UUID, Integer> actionCounters = (Map)(new LinkedHashMap());
   @NotNull
   private static final Map<UUID, Long> lastActionTime = (Map)(new LinkedHashMap());
   @NotNull
   private static final Map<UUID, Integer> activeLevels = (Map)(new LinkedHashMap());

   public OverdriveAbility(@NotNull JavaPlugin plugin) {
      Intrinsics.checkNotNullParameter(plugin, "plugin");
      super();
      this.plugin = plugin;
      (new BukkitRunnable() {
         public void run() {
            long now = System.currentTimeMillis();
            Iterator var3 = Bukkit.getOnlinePlayers().iterator();

            while(var3.hasNext()) {
               Player player = (Player)var3.next();
               UUID var10000 = player.getUniqueId();
               Intrinsics.checkNotNullExpressionValue(var10000, "getUniqueId(...)");
               UUID uuid = var10000;
               Long var8 = (Long)OverdriveAbility.lastActionTime.get(uuid);
               if (var8 != null) {
                  long last = var8;
                  if (now - last > 3000L) {
                     OverdriveAbility.actionCounters.put(uuid, 0);
                     OverdriveAbility.activeLevels.remove(uuid);
                     player.removePotionEffect(PotionEffectType.HASTE);
                  }
               }
            }

         }
      }).runTaskTimer((Plugin)this.plugin, 20L, 20L);
   }

   @EventHandler
   public final void onHit(@NotNull EntityDamageByEntityEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      Entity var3 = event.getDamager();
      Player var10000 = var3 instanceof Player ? (Player)var3 : null;
      if ((var3 instanceof Player ? (Player)var3 : null) != null) {
         Player player = var10000;
         Companion.handleAction(player);
      }
   }

   @EventHandler
   public final void onMine(@NotNull BlockBreakEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      Player var10000 = event.getPlayer();
      Intrinsics.checkNotNullExpressionValue(var10000, "getPlayer(...)");
      Player player = var10000;
      Companion.handleAction(player);
   }

   @Metadata(
      mv = {2, 2, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"},
      d2 = {"Lme/deck/decksmp/OverdriveAbility$Companion;", "", "<init>", "()V", "actionCounters", "", "Ljava/util/UUID;", "", "lastActionTime", "", "activeLevels", "handleAction", "", "player", "Lorg/bukkit/entity/Player;", "decksmp"}
   )
   public static final class Companion {
      private Companion() {
      }

      public final void handleAction(@NotNull Player player) {
         Intrinsics.checkNotNullParameter(player, "player");
         UUID var10000 = player.getUniqueId();
         Intrinsics.checkNotNullExpressionValue(var10000, "getUniqueId(...)");
         UUID uuid = var10000;
         long now = System.currentTimeMillis();
         Long var12 = (Long)OverdriveAbility.lastActionTime.get(uuid);
         long last = var12 != null ? var12 : 0L;
         if (now - last > 3000L) {
            OverdriveAbility.actionCounters.put(uuid, 0);
            OverdriveAbility.activeLevels.remove(uuid);
            player.removePotionEffect(PotionEffectType.HASTE);
         }

         OverdriveAbility.lastActionTime.put(uuid, now);
         Map var7 = OverdriveAbility.actionCounters;
         Integer var13 = (Integer)OverdriveAbility.actionCounters.get(uuid);
         Integer var8 = (var13 != null ? var13 : 0) + 1;
         var7.put(uuid, var8);
         Object var14 = OverdriveAbility.actionCounters.get(uuid);
         Intrinsics.checkNotNull(var14);
         int counter = ((Number)var14).intValue();
         var13 = (Integer)OverdriveAbility.activeLevels.get(uuid);
         int currentLevel = var13 != null ? var13 : 0;
         if (counter % 3 == 0) {
            int newLevel = RangesKt.coerceAtMost(currentLevel + 1, 10);
            OverdriveAbility.activeLevels.put(uuid, newLevel);
            player.addPotionEffect(new PotionEffect(PotionEffectType.HASTE, 100, newLevel - 1, true, false));
            player.sendMessage("§b[Overdrive] §fHaste increased to §e" + newLevel);
         }

      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }
}
