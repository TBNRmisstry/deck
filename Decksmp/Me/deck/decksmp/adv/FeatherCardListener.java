/* Decompiler 40ms, total 233ms, lines 84 */
package me.deck.decksmp.adv;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import me.deck.decksmp.Cards;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0012\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"},
   d2 = {"Lme/deck/decksmp/adv/FeatherCardListener;", "Lorg/bukkit/event/Listener;", "plugin", "Lorg/bukkit/plugin/java/JavaPlugin;", "<init>", "(Lorg/bukkit/plugin/java/JavaPlugin;)V", "register", "", "hasFeatherCard", "", "player", "Lorg/bukkit/entity/Player;", "isFeatherCard", "item", "Lorg/bukkit/inventory/ItemStack;", "decksmp"}
)
@SourceDebugExtension({"SMAP\nfeayeter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 feayeter.kt\nme/deck/decksmp/adv/FeatherCardListener\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,35:1\n1761#2,3:36\n*S KotlinDebug\n*F\n+ 1 feayeter.kt\nme/deck/decksmp/adv/FeatherCardListener\n*L\n26#1:36,3\n*E\n"})
public final class FeatherCardListener implements Listener {
   @NotNull
   private final JavaPlugin plugin;

   public FeatherCardListener(@NotNull JavaPlugin plugin) {
      Intrinsics.checkNotNullParameter(plugin, "plugin");
      super();
      this.plugin = plugin;
   }

   public final void register() {
      this.plugin.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)this.plugin);
   }

   private final boolean hasFeatherCard(Player player) {
      PlayerInventory var10000 = player.getInventory();
      Intrinsics.checkNotNullExpressionValue(var10000, "getInventory(...)");
      Iterable $this$any$iv = (Iterable)var10000;
      int $i$f$any = false;
      boolean var8;
      if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
         var8 = false;
      } else {
         Iterator var4 = $this$any$iv.iterator();

         while(true) {
            if (!var4.hasNext()) {
               var8 = false;
               break;
            }

            Object element$iv = var4.next();
            ItemStack it = (ItemStack)element$iv;
            int var7 = false;
            if (this.isFeatherCard(it)) {
               var8 = true;
               break;
            }
         }
      }

      return var8;
   }

   private final boolean isFeatherCard(ItemStack item) {
      if (item == null) {
         return false;
      } else {
         ItemMeta var10000 = item.getItemMeta();
         if (var10000 == null) {
            return false;
         } else {
            ItemMeta meta = var10000;
            return Intrinsics.areEqual(meta, Cards.INSTANCE.getFEATHER().getItemMeta());
         }
      }
   }
}
