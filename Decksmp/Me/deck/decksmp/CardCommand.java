/* Decompiler 21ms, total 183ms, lines 94 */
package me.deck.decksmp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J5\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000eH\u0016¢\u0006\u0002\u0010\u000fJ;\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u00112\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000eH\u0016¢\u0006\u0002\u0010\u0013¨\u0006\u0014"},
   d2 = {"Lme/deck/decksmp/CardCommand;", "Lorg/bukkit/command/CommandExecutor;", "Lorg/bukkit/command/TabCompleter;", "<init>", "()V", "onCommand", "", "sender", "Lorg/bukkit/command/CommandSender;", "command", "Lorg/bukkit/command/Command;", "label", "", "args", "", "(Lorg/bukkit/command/CommandSender;Lorg/bukkit/command/Command;Ljava/lang/String;[Ljava/lang/String;)Z", "onTabComplete", "", "alias", "(Lorg/bukkit/command/CommandSender;Lorg/bukkit/command/Command;Ljava/lang/String;[Ljava/lang/String;)Ljava/util/List;", "decksmp"}
)
@SourceDebugExtension({"SMAP\nDecksmp.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Decksmp.kt\nme/deck/decksmp/CardCommand\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,556:1\n774#2:557\n865#2,2:558\n*S KotlinDebug\n*F\n+ 1 Decksmp.kt\nme/deck/decksmp/CardCommand\n*L\n412#1:557\n412#1:558,2\n*E\n"})
public final class CardCommand implements CommandExecutor, TabCompleter {
   public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
      Intrinsics.checkNotNullParameter(sender, "sender");
      Intrinsics.checkNotNullParameter(command, "command");
      Intrinsics.checkNotNullParameter(label, "label");
      Intrinsics.checkNotNullParameter(args, "args");
      if (!(sender instanceof Player)) {
         sender.sendMessage("Only players can use this command!");
         return true;
      } else if (args.length == 0) {
         sender.sendMessage("§cUsage: /card <name>");
         return true;
      } else {
         Map var10000 = Cards.INSTANCE.allCards();
         String var10001 = args[0].toLowerCase(Locale.ROOT);
         Intrinsics.checkNotNullExpressionValue(var10001, "toLowerCase(...)");
         ItemStack card = (ItemStack)var10000.get(var10001);
         if (card != null) {
            PlayerInventory var7 = ((Player)sender).getInventory();
            ItemStack[] var6 = new ItemStack[]{card.clone()};
            var7.addItem(var6);
            ItemMeta var8 = card.getItemMeta();
            sender.sendMessage("§aYou received the §f" + (var8 != null ? var8.getDisplayName() : null));
         } else {
            sender.sendMessage("§cThat card does not exist!");
         }

         return true;
      }
   }

   @NotNull
   public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
      Intrinsics.checkNotNullParameter(sender, "sender");
      Intrinsics.checkNotNullParameter(command, "command");
      Intrinsics.checkNotNullParameter(alias, "alias");
      Intrinsics.checkNotNullParameter(args, "args");
      List var10000;
      if (args.length == 1) {
         Iterable $this$filter$iv = (Iterable)Cards.INSTANCE.allCards().keySet();
         int $i$f$filter = false;
         Collection destination$iv$iv = (Collection)(new ArrayList());
         int $i$f$filterTo = false;
         Iterator var10 = $this$filter$iv.iterator();

         while(var10.hasNext()) {
            Object element$iv$iv = var10.next();
            String it = (String)element$iv$iv;
            int var13 = false;
            if (StringsKt.startsWith(it, args[0], true)) {
               destination$iv$iv.add(element$iv$iv);
            }
         }

         var10000 = CollectionsKt.toMutableList((Collection)((List)destination$iv$iv));
      } else {
         var10000 = (List)(new ArrayList());
      }

      return var10000;
   }
}
