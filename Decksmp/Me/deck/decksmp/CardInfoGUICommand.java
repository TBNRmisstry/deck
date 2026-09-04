/* Decompiler 78ms, total 201ms, lines 109 */
package me.deck.decksmp;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J5\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\u0010H\u0016¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"},
   d2 = {"Lme/deck/decksmp/CardInfoGUICommand;", "Lorg/bukkit/command/CommandExecutor;", "Lorg/bukkit/event/Listener;", "plugin", "Lme/deck/decksmp/Decksmp;", "<init>", "(Lme/deck/decksmp/Decksmp;)V", "onCommand", "", "sender", "Lorg/bukkit/command/CommandSender;", "command", "Lorg/bukkit/command/Command;", "label", "", "args", "", "(Lorg/bukkit/command/CommandSender;Lorg/bukkit/command/Command;Ljava/lang/String;[Ljava/lang/String;)Z", "onInventoryClick", "", "event", "Lorg/bukkit/event/inventory/InventoryClickEvent;", "decksmp"}
)
@SourceDebugExtension({"SMAP\nDecksmp.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Decksmp.kt\nme/deck/decksmp/CardInfoGUICommand\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,556:1\n1#2:557\n*E\n"})
public final class CardInfoGUICommand implements CommandExecutor, Listener {
   @NotNull
   private final Decksmp plugin;

   public CardInfoGUICommand(@NotNull Decksmp plugin) {
      Intrinsics.checkNotNullParameter(plugin, "plugin");
      super();
      this.plugin = plugin;
   }

   public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
      Intrinsics.checkNotNullParameter(sender, "sender");
      Intrinsics.checkNotNullParameter(command, "command");
      Intrinsics.checkNotNullParameter(label, "label");
      Intrinsics.checkNotNullParameter(args, "args");
      if (!(sender instanceof Player)) {
         sender.sendMessage("Only players can use this command!");
         return true;
      } else {
         Inventory var10000 = Bukkit.createInventory((InventoryHolder)null, 54, "§6Card Abilities");
         Intrinsics.checkNotNullExpressionValue(var10000, "createInventory(...)");
         Inventory gui = var10000;
         ItemStack var7 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
         int var9 = false;
         ItemStack var17 = var7;
         ItemMeta var10001 = var7.getItemMeta();
         if (var10001 != null) {
            ItemMeta var10 = var10001;
            int var13 = false;
            var10.setDisplayName(" ");
            var17 = var7;
            var10001 = var10;
         } else {
            var10001 = null;
         }

         var17.setItemMeta(var10001);
         ItemStack filler = var7;

         int index;
         for(index = 0; index < 54; ++index) {
            gui.setItem(index, filler);
         }

         index = 10;

         for(Iterator var8 = Cards.INSTANCE.allCards().values().iterator(); var8.hasNext(); index += 2) {
            ItemStack card = (ItemStack)var8.next();
            var17 = card.clone();
            Intrinsics.checkNotNullExpressionValue(var17, "clone(...)");

            ItemStack cardItem;
            for(cardItem = var17; index < 54; ++index) {
               var17 = gui.getItem(index);
               if ((var17 != null ? var17.getType() : null) == Material.LIGHT_BLUE_STAINED_GLASS_PANE) {
                  break;
               }
            }

            if (index >= 54) {
               break;
            }

            gui.setItem(index, cardItem);
         }

         ((Player)sender).openInventory(gui);
         return true;
      }
   }

   @EventHandler
   public final void onInventoryClick(@NotNull InventoryClickEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      if (Intrinsics.areEqual(event.getView().getTitle(), "§6Card Abilities")) {
         event.setCancelled(true);
      }
   }
}
