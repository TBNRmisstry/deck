/* Decompiler 133ms, total 308ms, lines 307 */
package me.deck.decksmp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0018B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J5\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000eH\u0016¢\u0006\u0002\u0010\u000fJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J;\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u00152\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000eH\u0016¢\u0006\u0002\u0010\u0017¨\u0006\u0019"},
   d2 = {"Lme/deck/decksmp/WithdrawCommand;", "Lorg/bukkit/command/CommandExecutor;", "Lorg/bukkit/command/TabCompleter;", "<init>", "()V", "onCommand", "", "sender", "Lorg/bukkit/command/CommandSender;", "command", "Lorg/bukkit/command/Command;", "label", "", "args", "", "(Lorg/bukkit/command/CommandSender;Lorg/bukkit/command/Command;Ljava/lang/String;[Ljava/lang/String;)Z", "applyHeartCard", "", "player", "Lorg/bukkit/entity/Player;", "onTabComplete", "", "alias", "(Lorg/bukkit/command/CommandSender;Lorg/bukkit/command/Command;Ljava/lang/String;[Ljava/lang/String;)Ljava/util/List;", "CardDropOnDeath", "decksmp"}
)
@SourceDebugExtension({"SMAP\nDecksmp.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Decksmp.kt\nme/deck/decksmp/WithdrawCommand\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,556:1\n295#2,2:557\n*S KotlinDebug\n*F\n+ 1 Decksmp.kt\nme/deck/decksmp/WithdrawCommand\n*L\n479#1:557,2\n*E\n"})
public final class WithdrawCommand implements CommandExecutor, TabCompleter {
   public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
      Intrinsics.checkNotNullParameter(sender, "sender");
      Intrinsics.checkNotNullParameter(command, "command");
      Intrinsics.checkNotNullParameter(label, "label");
      Intrinsics.checkNotNullParameter(args, "args");
      if (!(sender instanceof Player)) {
         sender.sendMessage("Only players can use this command!");
         return true;
      } else if (args.length == 0) {
         sender.sendMessage("§cUsage: /withdraw <slot>");
         return true;
      } else if (((Player)sender).getInventory().firstEmpty() == -1) {
         sender.sendMessage("§cYour inventory is full! You cannot withdraw a card.");
         return true;
      } else {
         Integer slotNum = StringsKt.toIntOrNull(args[0]);
         if (slotNum != null) {
            int var6 = slotNum;
            if (1 <= var6 ? var6 < 3 : false) {
               String var10000 = ((Player)sender).getUniqueId().toString();
               Intrinsics.checkNotNullExpressionValue(var10000, "toString(...)");
               String uuid = var10000;
               String[] var19 = (String[])CardVariables.INSTANCE.getEquippedCards().get(uuid);
               if (var19 == null) {
                  var19 = new String[2];
               }

               String[] slots = var19;
               int index = slotNum - 1;
               String cardName = slots[index];
               if (cardName == null) {
                  sender.sendMessage("§cSlot " + slotNum + " is already empty!");
                  return true;
               }

               Iterable $this$firstOrNull$iv = (Iterable)Cards.INSTANCE.allCards().values();
               int $i$f$firstOrNull = false;
               Iterator var13 = $this$firstOrNull$iv.iterator();

               Object var20;
               while(true) {
                  if (var13.hasNext()) {
                     Object element$iv = var13.next();
                     ItemStack it = (ItemStack)element$iv;
                     int var16 = false;
                     ItemMeta var21 = it.getItemMeta();
                     if (!Intrinsics.areEqual(var21 != null ? var21.getDisplayName() : null, cardName)) {
                        continue;
                     }

                     var20 = element$iv;
                     break;
                  }

                  var20 = null;
                  break;
               }

               ItemStack cardItem = (ItemStack)var20;
               if (cardItem != null) {
                  if (((Player)sender).getInventory().firstEmpty() == -1) {
                     sender.sendMessage("§cYour inventory is full! Cannot withdraw " + cardName + ".");
                     return true;
                  }

                  PlayerInventory var22 = ((Player)sender).getInventory();
                  ItemStack[] var18 = new ItemStack[]{cardItem.clone()};
                  var22.addItem(var18);
               }

               slots[index] = null;
               CardVariables.INSTANCE.getEquippedCards().put(uuid, slots);
               this.applyHeartCard((Player)sender);
               sender.sendMessage("§aYou have withdrawn " + cardName + " from slot " + slotNum);
               return true;
            }
         }

         sender.sendMessage("§cSlot must be 1 or 2!");
         return true;
      }
   }

   public final void applyHeartCard(@NotNull final Player player) {
      Intrinsics.checkNotNullParameter(player, "player");
      (new BukkitRunnable() {
         public void run() {
            String[] var10000 = (String[])CardVariables.INSTANCE.getEquippedCards().get(player.getUniqueId().toString());
            if (var10000 != null) {
               String[] cards = var10000;
               Iterable $this$any$iv = (Iterable)ArraysKt.filterNotNull(cards);
               int $i$f$any = false;
               boolean var9;
               if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                  var9 = false;
               } else {
                  Iterator var5 = $this$any$iv.iterator();

                  while(true) {
                     if (!var5.hasNext()) {
                        var9 = false;
                        break;
                     }

                     Object element$iv = var5.next();
                     String it = (String)element$iv;
                     int var8 = false;
                     if (Intrinsics.areEqual(ChatColor.stripColor(it), "Health Card")) {
                        var9 = true;
                        break;
                     }
                  }
               }

               boolean hasHeartCard = var9;
               if (hasHeartCard) {
                  player.setMaxHealth(30.0D);
                  if (player.getHealth() > 30.0D) {
                     player.setHealth(30.0D);
                  }
               } else {
                  player.setMaxHealth(20.0D);
                  if (player.getHealth() > 20.0D) {
                     player.setHealth(20.0D);
                  }
               }

            }
         }
      }).runTaskLater((Plugin)Decksmp.Companion.getInstance(), 10L);
   }

   @NotNull
   public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
      Intrinsics.checkNotNullParameter(sender, "sender");
      Intrinsics.checkNotNullParameter(command, "command");
      Intrinsics.checkNotNullParameter(alias, "alias");
      Intrinsics.checkNotNullParameter(args, "args");
      List var10000;
      if (args.length == 1) {
         String[] var5 = new String[]{"1", "2"};
         var10000 = CollectionsKt.mutableListOf(var5);
      } else {
         var10000 = (List)(new ArrayList());
      }

      return var10000;
   }

   @Metadata(
      mv = {2, 2, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"},
      d2 = {"Lme/deck/decksmp/WithdrawCommand$CardDropOnDeath;", "Lorg/bukkit/event/Listener;", "plugin", "Lme/deck/decksmp/Decksmp;", "<init>", "(Lme/deck/decksmp/Decksmp;)V", "onPlayerDeath", "", "event", "Lorg/bukkit/event/entity/PlayerDeathEvent;", "decksmp"}
   )
   @SourceDebugExtension({"SMAP\nDecksmp.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Decksmp.kt\nme/deck/decksmp/WithdrawCommand$CardDropOnDeath\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,556:1\n295#2,2:557\n*S KotlinDebug\n*F\n+ 1 Decksmp.kt\nme/deck/decksmp/WithdrawCommand$CardDropOnDeath\n*L\n526#1:557,2\n*E\n"})
   public static final class CardDropOnDeath implements Listener {
      @NotNull
      private final Decksmp plugin;

      public CardDropOnDeath(@NotNull Decksmp plugin) {
         Intrinsics.checkNotNullParameter(plugin, "plugin");
         super();
         this.plugin = plugin;
      }

      @EventHandler
      public final void onPlayerDeath(@NotNull PlayerDeathEvent event) {
         Intrinsics.checkNotNullParameter(event, "event");
         Player var10000 = event.getEntity();
         Intrinsics.checkNotNullExpressionValue(var10000, "getEntity(...)");
         final Player player = var10000;
         String var15 = player.getUniqueId().toString();
         Intrinsics.checkNotNullExpressionValue(var15, "toString(...)");
         String uuid = var15;
         String[] var16 = (String[])CardVariables.INSTANCE.getEquippedCards().get(uuid);
         if (var16 == null) {
            var16 = new String[2];
         }

         String[] slots = var16;
         int i = 0;

         for(int var6 = slots.length; i < var6; ++i) {
            String cardName = slots[i];
            if (cardName != null) {
               Iterable $this$firstOrNull$iv = (Iterable)Cards.INSTANCE.allCards().values();
               int $i$f$firstOrNull = false;
               Iterator var11 = $this$firstOrNull$iv.iterator();

               Object var17;
               while(true) {
                  if (var11.hasNext()) {
                     Object element$iv = var11.next();
                     ItemStack it = (ItemStack)element$iv;
                     int var14 = false;
                     ItemMeta var18 = it.getItemMeta();
                     if (!Intrinsics.areEqual(var18 != null ? var18.getDisplayName() : null, cardName)) {
                        continue;
                     }

                     var17 = element$iv;
                     break;
                  }

                  var17 = null;
                  break;
               }

               ItemStack cardItem = (ItemStack)var17;
               if (cardItem != null) {
                  player.getWorld().dropItemNaturally(player.getLocation(), cardItem.clone());
               }

               slots[i] = null;
            }
         }

         CardVariables.INSTANCE.getEquippedCards().put(uuid, slots);
         this.plugin.saveCardVariables();
         (new BukkitRunnable() {
            public void run() {
               String[] var10000 = (String[])CardVariables.INSTANCE.getEquippedCards().get(player.getUniqueId().toString());
               if (var10000 != null) {
                  String[] cards = var10000;
                  Iterable $this$any$iv = (Iterable)ArraysKt.filterNotNull(cards);
                  int $i$f$any = false;
                  boolean var9;
                  if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                     var9 = false;
                  } else {
                     Iterator var5 = $this$any$iv.iterator();

                     while(true) {
                        if (!var5.hasNext()) {
                           var9 = false;
                           break;
                        }

                        Object element$iv = var5.next();
                        String it = (String)element$iv;
                        int var8 = false;
                        if (Intrinsics.areEqual(ChatColor.stripColor(it), "Health Card")) {
                           var9 = true;
                           break;
                        }
                     }
                  }

                  boolean hasHeartCard = var9;
                  if (hasHeartCard) {
                     player.setMaxHealth(30.0D);
                     if (player.getHealth() > 30.0D) {
                        player.setHealth(30.0D);
                     }
                  } else {
                     player.setMaxHealth(20.0D);
                     if (player.getHealth() > 20.0D) {
                        player.setHealth(20.0D);
                     }
                  }

               }
            }
         }).runTaskLater((Plugin)this.plugin, 10L);
      }
   }
}
