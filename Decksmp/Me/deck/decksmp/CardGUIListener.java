/* Decompiler 59ms, total 153ms, lines 114 */
package me.deck.decksmp;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"},
   d2 = {"Lme/deck/decksmp/CardGUIListener;", "Lorg/bukkit/event/Listener;", "plugin", "Lme/deck/decksmp/Decksmp;", "<init>", "(Lme/deck/decksmp/Decksmp;)V", "onInventoryClick", "", "event", "Lorg/bukkit/event/inventory/InventoryClickEvent;", "decksmp"}
)
@SourceDebugExtension({"SMAP\nDecksmp.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Decksmp.kt\nme/deck/decksmp/CardGUIListener\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,556:1\n382#2,7:557\n1772#3,6:564\n*S KotlinDebug\n*F\n+ 1 Decksmp.kt\nme/deck/decksmp/CardGUIListener\n*L\n334#1:557,7\n341#1:564,6\n*E\n"})
public final class CardGUIListener implements Listener {
   @NotNull
   private final Decksmp plugin;

   public CardGUIListener(@NotNull Decksmp plugin) {
      Intrinsics.checkNotNullParameter(plugin, "plugin");
      super();
      this.plugin = plugin;
   }

   @EventHandler
   public final void onInventoryClick(@NotNull InventoryClickEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      HumanEntity var4 = event.getWhoClicked();
      Player var10000 = var4 instanceof Player ? (Player)var4 : null;
      if ((var4 instanceof Player ? (Player)var4 : null) != null) {
         Player player = var10000;
         ItemStack var20 = event.getCurrentItem();
         if (var20 != null) {
            ItemStack item = var20;
            if (item.getType() == Material.NETHER_STAR) {
               if (Intrinsics.areEqual(event.getView().getTitle(), "§6Cards (admin gui)")) {
                  event.setCancelled(true);
                  ItemMeta var21 = item.getItemMeta();
                  if (var21 != null) {
                     ItemMeta meta = var21;
                     String var22 = meta.getDisplayName();
                     Intrinsics.checkNotNullExpressionValue(var22, "getDisplayName(...)");
                     String cardName = var22;
                     var22 = player.getUniqueId().toString();
                     Intrinsics.checkNotNullExpressionValue(var22, "toString(...)");
                     String uuid = var22;
                     Map $this$getOrPut$iv = CardVariables.INSTANCE.getEquippedCards();
                     int $i$f$indexOfFirst = false;
                     Object value$iv = $this$getOrPut$iv.get(uuid);
                     Object var23;
                     if (value$iv == null) {
                        int var12 = false;
                        Object answer$iv = new String[2];
                        $this$getOrPut$iv.put(uuid, answer$iv);
                        var23 = answer$iv;
                     } else {
                        var23 = value$iv;
                     }

                     String[] slots = (String[])var23;
                     if (ArraysKt.contains(slots, cardName)) {
                        player.sendMessage("§cYou have already equipped " + cardName + "!");
                     } else {
                        Object[] $this$indexOfFirst$iv = slots;
                        $i$f$indexOfFirst = false;
                        int index$iv = 0;
                        int var19 = slots.length;

                        int var24;
                        while(true) {
                           if (index$iv >= var19) {
                              var24 = -1;
                              break;
                           }

                           String it = $this$indexOfFirst$iv[index$iv];
                           int var14 = false;
                           if (it == null) {
                              var24 = index$iv;
                              break;
                           }

                           ++index$iv;
                        }

                        int slotIndex = var24;
                        if (slotIndex == -1) {
                           player.sendMessage("§cYou can only equip up to 2 cards!");
                        } else {
                           slots[slotIndex] = cardName;
                           CardVariables.INSTANCE.getEquippedCards().put(uuid, slots);
                           this.plugin.saveCardVariables();
                           player.sendMessage("§aYou equipped " + cardName + " via GUI!");
                        }
                     }
                  }
               }
            }
         }
      }
   }
}
