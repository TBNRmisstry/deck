/* Decompiler 18ms, total 135ms, lines 55 */
package me.deck.decksmp;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\rH\u0016¢\u0006\u0002\u0010\u000e¨\u0006\u000f"},
   d2 = {"Lme/deck/decksmp/CardGUICommand;", "Lorg/bukkit/command/CommandExecutor;", "<init>", "()V", "onCommand", "", "sender", "Lorg/bukkit/command/CommandSender;", "command", "Lorg/bukkit/command/Command;", "label", "", "args", "", "(Lorg/bukkit/command/CommandSender;Lorg/bukkit/command/Command;Ljava/lang/String;[Ljava/lang/String;)Z", "decksmp"}
)
@SourceDebugExtension({"SMAP\nDecksmp.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Decksmp.kt\nme/deck/decksmp/CardGUICommand\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,556:1\n1869#2,2:557\n*S KotlinDebug\n*F\n+ 1 Decksmp.kt\nme/deck/decksmp/CardGUICommand\n*L\n314#1:557,2\n*E\n"})
public final class CardGUICommand implements CommandExecutor {
   public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
      Intrinsics.checkNotNullParameter(sender, "sender");
      Intrinsics.checkNotNullParameter(command, "command");
      Intrinsics.checkNotNullParameter(label, "label");
      Intrinsics.checkNotNullParameter(args, "args");
      if (!(sender instanceof Player)) {
         sender.sendMessage("Only players can use this command!");
         return true;
      } else {
         Inventory var10000 = Bukkit.createInventory((InventoryHolder)null, 27, "§6Your Cards");
         Intrinsics.checkNotNullExpressionValue(var10000, "createInventory(...)");
         Inventory gui = var10000;
         Iterable $this$forEach$iv = (Iterable)Cards.INSTANCE.allCards().values();
         int $i$f$forEach = false;
         Iterator var8 = $this$forEach$iv.iterator();

         while(var8.hasNext()) {
            Object element$iv = var8.next();
            ItemStack it = (ItemStack)element$iv;
            int var11 = false;
            ItemStack[] var12 = new ItemStack[]{it.clone()};
            gui.addItem(var12);
         }

         ((Player)sender).openInventory(gui);
         return true;
      }
   }
}
