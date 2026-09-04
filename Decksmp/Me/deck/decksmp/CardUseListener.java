/* Decompiler 103ms, total 222ms, lines 165 */
package me.deck.decksmp;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"},
   d2 = {"Lme/deck/decksmp/CardUseListener;", "Lorg/bukkit/event/Listener;", "plugin", "Lme/deck/decksmp/Decksmp;", "<init>", "(Lme/deck/decksmp/Decksmp;)V", "onCardUse", "", "event", "Lorg/bukkit/event/player/PlayerInteractEvent;", "decksmp"}
)
@SourceDebugExtension({"SMAP\nDecksmp.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Decksmp.kt\nme/deck/decksmp/CardUseListener\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 4 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,556:1\n1761#2,3:557\n382#3,7:560\n1772#4,6:567\n*S KotlinDebug\n*F\n+ 1 Decksmp.kt\nme/deck/decksmp/CardUseListener\n*L\n228#1:557,3\n231#1:560,7\n238#1:567,6\n*E\n"})
public final class CardUseListener implements Listener {
   @NotNull
   private final Decksmp plugin;

   public CardUseListener(@NotNull Decksmp plugin) {
      Intrinsics.checkNotNullParameter(plugin, "plugin");
      super();
      this.plugin = plugin;
   }

   @EventHandler
   public final void onCardUse(@NotNull PlayerInteractEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      Player var10000 = event.getPlayer();
      Intrinsics.checkNotNullExpressionValue(var10000, "getPlayer(...)");
      Player player = var10000;
      ItemStack item = event.getItem();
      if (item != null && item.getType() == Material.NETHER_STAR && event.getHand() == EquipmentSlot.HAND) {
         ItemMeta var27 = item.getItemMeta();
         if (var27 != null) {
            ItemMeta meta = var27;
            if (meta.hasDisplayName()) {
               String var28 = meta.getDisplayName();
               Intrinsics.checkNotNullExpressionValue(var28, "getDisplayName(...)");
               String cardName = var28;
               Iterable $this$any$iv = (Iterable)Cards.INSTANCE.allCards().values();
               int $i$f$any = false;
               boolean var29;
               if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                  var29 = false;
               } else {
                  label114: {
                     Iterator var8 = $this$any$iv.iterator();

                     while(var8.hasNext()) {
                        Object element$iv = var8.next();
                        ItemStack it = (ItemStack)element$iv;
                        int var11 = false;
                        var27 = it.getItemMeta();
                        if (Intrinsics.areEqual(var27 != null ? var27.getDisplayName() : null, cardName)) {
                           var29 = true;
                           break label114;
                        }
                     }

                     var29 = false;
                  }
               }

               if (var29) {
                  var28 = player.getUniqueId().toString();
                  Intrinsics.checkNotNullExpressionValue(var28, "toString(...)");
                  String uuid = var28;
                  Map $this$getOrPut$iv = CardVariables.INSTANCE.getEquippedCards();
                  int $i$f$indexOfFirst = false;
                  Object value$iv = $this$getOrPut$iv.get(uuid);
                  Object var30;
                  if (value$iv == null) {
                     int var12 = false;
                     Object answer$iv = new String[2];
                     $this$getOrPut$iv.put(uuid, answer$iv);
                     var30 = answer$iv;
                  } else {
                     var30 = value$iv;
                  }

                  String[] slots = (String[])var30;
                  if (ArraysKt.contains(slots, cardName)) {
                     player.sendMessage("§cYou have already equipped " + cardName + "!");
                  } else {
                     Object[] $this$indexOfFirst$iv = slots;
                     $i$f$indexOfFirst = false;
                     int index$iv = 0;
                     int var26 = slots.length;

                     int var31;
                     while(true) {
                        if (index$iv >= var26) {
                           var31 = -1;
                           break;
                        }

                        String it = $this$indexOfFirst$iv[index$iv];
                        int var14 = false;
                        if (it == null) {
                           var31 = index$iv;
                           break;
                        }

                        ++index$iv;
                     }

                     int slotIndex = var31;
                     if (slotIndex == -1) {
                        player.sendMessage("§cYou can only equip up to 2 cards!");
                     } else {
                        int amount = item.getAmount();
                        if (amount > 1) {
                           item.setAmount(amount - 1);
                        } else {
                           player.getInventory().remove(item);
                        }

                        slots[slotIndex] = cardName;
                        CardVariables.INSTANCE.getEquippedCards().put(uuid, slots);
                        this.plugin.saveCardVariables();
                        DecksmpKt.access$playCardEquipAnimation(player, (JavaPlugin)this.plugin);
                        player.sendMessage("§aYou have equipped " + cardName);
                        String var22 = ChatColor.stripColor(cardName);
                        if (var22 != null) {
                           switch(var22.hashCode()) {
                           case -303653292:
                              if (var22.equals("Health Card")) {
                                 AttributeInstance var32 = player.getAttribute(Attribute.MAX_HEALTH);
                                 if (var32 != null) {
                                    var32.setBaseValue(30.0D);
                                 }

                                 if (player.getHealth() > 30.0D) {
                                    player.setHealth(30.0D);
                                 }
                              }
                           }
                        }

                     }
                  }
               }
            }
         }
      }
   }
}
