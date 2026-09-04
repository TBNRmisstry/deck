/* Decompiler 153ms, total 277ms, lines 382 */
package me.deck.decksmp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0001\"B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0002J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010J\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u00132\u0006\u0010\u000f\u001a\u00020\u0010J5\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u000e\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001a0\u001cH\u0016¢\u0006\u0002\u0010\u001dJ;\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u001a2\u000e\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001a0\u001cH\u0016¢\u0006\u0002\u0010!R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"},
   d2 = {"Lme/deck/decksmp/TrustCommand;", "Lorg/bukkit/command/CommandExecutor;", "Lorg/bukkit/command/TabCompleter;", "plugin", "Lorg/bukkit/plugin/java/JavaPlugin;", "<init>", "(Lorg/bukkit/plugin/java/JavaPlugin;)V", "trustFile", "Ljava/io/File;", "trustConfig", "Lorg/bukkit/configuration/file/FileConfiguration;", "saveTrustFile", "", "isTrusted", "", "owner", "Ljava/util/UUID;", "target", "getTrusted", "", "onCommand", "sender", "Lorg/bukkit/command/CommandSender;", "command", "Lorg/bukkit/command/Command;", "label", "", "args", "", "(Lorg/bukkit/command/CommandSender;Lorg/bukkit/command/Command;Ljava/lang/String;[Ljava/lang/String;)Z", "onTabComplete", "", "alias", "(Lorg/bukkit/command/CommandSender;Lorg/bukkit/command/Command;Ljava/lang/String;[Ljava/lang/String;)Ljava/util/List;", "Companion", "decksmp"}
)
@SourceDebugExtension({"SMAP\ntrust.kt\nKotlin\n*S Kotlin\n*F\n+ 1 trust.kt\nme/deck/decksmp/TrustCommand\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,154:1\n1617#2,9:155\n1869#2:164\n1870#2:167\n1626#2:168\n1617#2,9:169\n1869#2:178\n1870#2:180\n1626#2:181\n774#2:182\n865#2,2:183\n1563#2:185\n1634#2,3:186\n774#2:189\n865#2,2:190\n1#3:165\n1#3:166\n1#3:179\n*S KotlinDebug\n*F\n+ 1 trust.kt\nme/deck/decksmp/TrustCommand\n*L\n57#1:155,9\n57#1:164\n57#1:167\n57#1:168\n123#1:169,9\n123#1:178\n123#1:180\n123#1:181\n147#1:182\n147#1:183,2\n149#1:185\n149#1:186,3\n149#1:189\n149#1:190,2\n57#1:166\n123#1:179\n*E\n"})
public final class TrustCommand implements CommandExecutor, TabCompleter {
   @NotNull
   public static final TrustCommand.Companion Companion = new TrustCommand.Companion((DefaultConstructorMarker)null);
   @NotNull
   private final JavaPlugin plugin;
   @NotNull
   private final File trustFile;
   @NotNull
   private final FileConfiguration trustConfig;
   private static TrustCommand instance;

   public TrustCommand(@NotNull JavaPlugin plugin) {
      Intrinsics.checkNotNullParameter(plugin, "plugin");
      super();
      this.plugin = plugin;
      this.trustFile = new File(this.plugin.getDataFolder(), "trust.yml");
      if (!this.trustFile.exists()) {
         this.trustFile.getParentFile().mkdirs();
         this.trustFile.createNewFile();
      }

      YamlConfiguration var10001 = YamlConfiguration.loadConfiguration(this.trustFile);
      Intrinsics.checkNotNullExpressionValue(var10001, "loadConfiguration(...)");
      this.trustConfig = (FileConfiguration)var10001;
   }

   private final void saveTrustFile() {
      try {
         this.trustConfig.save(this.trustFile);
      } catch (IOException var2) {
         var2.printStackTrace();
      }

   }

   public final boolean isTrusted(@NotNull UUID owner, @NotNull UUID target) {
      Intrinsics.checkNotNullParameter(owner, "owner");
      Intrinsics.checkNotNullParameter(target, "target");
      List var10000 = this.trustConfig.getStringList("trusted." + owner);
      Intrinsics.checkNotNullExpressionValue(var10000, "getStringList(...)");
      List list = var10000;
      return list.contains(target.toString());
   }

   @NotNull
   public final List<UUID> getTrusted(@NotNull UUID owner) {
      Intrinsics.checkNotNullParameter(owner, "owner");
      List var10000 = this.trustConfig.getStringList("trusted." + owner);
      Intrinsics.checkNotNullExpressionValue(var10000, "getStringList(...)");
      List list = var10000;
      Iterable $this$mapNotNull$iv = (Iterable)list;
      int $i$f$mapNotNull = false;
      Collection destination$iv$iv = (Collection)(new ArrayList());
      int $i$f$mapNotNullTo = false;
      int $i$f$forEach = false;
      Iterator var10 = $this$mapNotNull$iv.iterator();

      while(var10.hasNext()) {
         Object element$iv$iv$iv = var10.next();
         int var13 = false;
         String it = (String)element$iv$iv$iv;
         int var15 = false;
         TrustCommand var16 = this;

         Object var17;
         kotlin.Result.Companion var22;
         try {
            var22 = Result.Companion;
            TrustCommand $this$getTrusted_u24lambda_u240_u240 = (TrustCommand)var16;
            int var18 = false;
            var17 = Result.constructor-impl(UUID.fromString(it));
         } catch (Throwable var21) {
            var22 = Result.Companion;
            var17 = Result.constructor-impl(ResultKt.createFailure(var21));
         }

         UUID var23 = (UUID)(Result.isFailure-impl(var17) ? null : var17);
         if (var23 != null) {
            Object it$iv$iv = var23;
            int var20 = false;
            destination$iv$iv.add(it$iv$iv);
         }
      }

      return (List)destination$iv$iv;
   }

   public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
      Intrinsics.checkNotNullParameter(sender, "sender");
      Intrinsics.checkNotNullParameter(command, "command");
      Intrinsics.checkNotNullParameter(label, "label");
      Intrinsics.checkNotNullParameter(args, "args");
      if (!(sender instanceof Player)) {
         sender.sendMessage(ChatColor.RED + "Only players can use this command.");
         return true;
      } else {
         String var10000 = ((Player)sender).getUniqueId().toString();
         Intrinsics.checkNotNullExpressionValue(var10000, "toString(...)");
         String uuid = var10000;
         if (args.length == 0) {
            sender.sendMessage(ChatColor.YELLOW + "Usage: /trust <add|remove|list> [player]");
            return true;
         } else {
            var10000 = args[0].toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(var10000, "toLowerCase(...)");
            String var7 = var10000;
            List list;
            ChatColor var10001;
            OfflinePlayer target;
            List var31;
            OfflinePlayer var33;
            switch(var7.hashCode()) {
            case -934610812:
               if (var7.equals("remove")) {
                  if (args.length < 2) {
                     sender.sendMessage(ChatColor.RED + "Usage: /trust remove <player>");
                     return true;
                  }

                  var33 = Bukkit.getOfflinePlayerIfCached(args[1]);
                  if (var33 == null) {
                     var33 = Bukkit.getOfflinePlayer(args[1]);
                     Intrinsics.checkNotNullExpressionValue(var33, "getOfflinePlayer(...)");
                  }

                  target = var33;
                  var31 = this.trustConfig.getStringList("trusted." + uuid);
                  Intrinsics.checkNotNullExpressionValue(var31, "getStringList(...)");
                  list = CollectionsKt.toMutableList((Collection)var31);
                  if (!list.contains(target.getUniqueId().toString())) {
                     var10001 = ChatColor.RED;
                     sender.sendMessage(var10001 + target.getName() + " is not on your trust list.");
                     return true;
                  }

                  list.remove(target.getUniqueId().toString());
                  this.trustConfig.set("trusted." + uuid, list);
                  this.saveTrustFile();
                  var10001 = ChatColor.YELLOW;
                  sender.sendMessage(var10001 + "You have removed " + target.getName() + " from your trust list.");
                  return true;
               }
               break;
            case 96417:
               if (var7.equals("add")) {
                  if (args.length < 2) {
                     sender.sendMessage(ChatColor.RED + "Usage: /trust add <player>");
                     return true;
                  }

                  var33 = Bukkit.getOfflinePlayerIfCached(args[1]);
                  if (var33 == null) {
                     var33 = Bukkit.getOfflinePlayer(args[1]);
                     Intrinsics.checkNotNullExpressionValue(var33, "getOfflinePlayer(...)");
                  }

                  target = var33;
                  if (!target.hasPlayedBefore() && !target.isOnline()) {
                     sender.sendMessage(ChatColor.RED + "Player not found.");
                     return true;
                  }

                  var31 = this.trustConfig.getStringList("trusted." + uuid);
                  Intrinsics.checkNotNullExpressionValue(var31, "getStringList(...)");
                  list = CollectionsKt.toMutableList((Collection)var31);
                  if (list.contains(target.getUniqueId().toString())) {
                     var10001 = ChatColor.RED;
                     sender.sendMessage(var10001 + target.getName() + " is already trusted.");
                     return true;
                  }

                  list.add(target.getUniqueId().toString());
                  this.trustConfig.set("trusted." + uuid, list);
                  this.saveTrustFile();
                  var10001 = ChatColor.GREEN;
                  sender.sendMessage(var10001 + "You have trusted " + target.getName() + ".");
                  return true;
               }
               break;
            case 3322014:
               if (var7.equals("list")) {
                  var31 = this.trustConfig.getStringList("trusted." + uuid);
                  Intrinsics.checkNotNullExpressionValue(var31, "getStringList(...)");
                  List list = var31;
                  if (list.isEmpty()) {
                     sender.sendMessage(ChatColor.GRAY + "You have no trusted players.");
                  } else {
                     Iterable $this$mapNotNull$iv = (Iterable)list;
                     int $i$f$mapNotNull = false;
                     Collection destination$iv$iv = (Collection)(new ArrayList());
                     int $i$f$mapNotNullTo = false;
                     int $i$f$forEach = false;
                     Iterator var17 = $this$mapNotNull$iv.iterator();

                     while(var17.hasNext()) {
                        Object element$iv$iv$iv = var17.next();
                        int var20 = false;
                        String id = (String)element$iv$iv$iv;
                        int var22 = false;
                        TrustCommand var23 = this;

                        Object var24;
                        kotlin.Result.Companion var32;
                        try {
                           var32 = Result.Companion;
                           TrustCommand $this$onCommand_u24lambda_u240_u240 = (TrustCommand)var23;
                           int var25 = false;
                           var24 = Result.constructor-impl(Bukkit.getOfflinePlayer(UUID.fromString(id)));
                        } catch (Throwable var29) {
                           var32 = Result.Companion;
                           var24 = Result.constructor-impl(ResultKt.createFailure(var29));
                        }

                        OfflinePlayer offline = (OfflinePlayer)(Result.isFailure-impl(var24) ? null : var24);
                        var10000 = offline != null ? offline.getName() : null;
                        if (var10000 != null) {
                           Object it$iv$iv = var10000;
                           int var28 = false;
                           destination$iv$iv.add(it$iv$iv);
                        }
                     }

                     list = (List)destination$iv$iv;
                     var10001 = ChatColor.AQUA;
                     sender.sendMessage(var10001 + "Your trusted players: " + ChatColor.YELLOW + CollectionsKt.joinToString$default((Iterable)list, (CharSequence)", ", (CharSequence)null, (CharSequence)null, 0, (CharSequence)null, (Function1)null, 62, (Object)null));
                  }

                  return true;
               }
            }

            sender.sendMessage(ChatColor.YELLOW + "Usage: /trust <add|remove|list> [player]");
            return true;
         }
      }
   }

   @NotNull
   public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
      Intrinsics.checkNotNullParameter(sender, "sender");
      Intrinsics.checkNotNullParameter(command, "command");
      Intrinsics.checkNotNullParameter(alias, "alias");
      Intrinsics.checkNotNullParameter(args, "args");
      List completions = (List)(new ArrayList());
      boolean $i$f$filter;
      Collection destination$iv$iv;
      boolean $i$f$filterTo;
      Iterator var11;
      Object element$iv$iv;
      String it;
      boolean var14;
      Iterable $this$filter$iv;
      if (args.length == 1) {
         String[] var6 = new String[]{"add", "remove", "list"};
         $this$filter$iv = (Iterable)CollectionsKt.listOf(var6);
         $i$f$filter = false;
         destination$iv$iv = (Collection)(new ArrayList());
         $i$f$filterTo = false;
         var11 = $this$filter$iv.iterator();

         while(var11.hasNext()) {
            element$iv$iv = var11.next();
            it = (String)element$iv$iv;
            var14 = false;
            if (StringsKt.startsWith(it, args[0], true)) {
               destination$iv$iv.add(element$iv$iv);
            }
         }

         completions.addAll((Collection)((List)destination$iv$iv));
      } else if (args.length == 2 && (StringsKt.equals(args[0], "add", true) || StringsKt.equals(args[0], "remove", true))) {
         Collection var10001 = Bukkit.getOnlinePlayers();
         Intrinsics.checkNotNullExpressionValue(var10001, "getOnlinePlayers(...)");
         $this$filter$iv = (Iterable)var10001;
         $i$f$filter = false;
         destination$iv$iv = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault($this$filter$iv, 10)));
         $i$f$filterTo = false;
         var11 = $this$filter$iv.iterator();

         while(var11.hasNext()) {
            element$iv$iv = var11.next();
            Player it = (Player)element$iv$iv;
            var14 = false;
            destination$iv$iv.add(it.getName());
         }

         $this$filter$iv = (Iterable)((List)destination$iv$iv);
         $i$f$filter = false;
         destination$iv$iv = (Collection)(new ArrayList());
         $i$f$filterTo = false;
         var11 = $this$filter$iv.iterator();

         while(var11.hasNext()) {
            element$iv$iv = var11.next();
            it = (String)element$iv$iv;
            var14 = false;
            Intrinsics.checkNotNull(it);
            if (StringsKt.startsWith(it, args[1], true)) {
               destination$iv$iv.add(element$iv$iv);
            }
         }

         completions.addAll((Collection)((List)destination$iv$iv));
      }

      return completions;
   }

   @Metadata(
      mv = {2, 2, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u000b"},
      d2 = {"Lme/deck/decksmp/TrustCommand$Companion;", "", "<init>", "()V", "instance", "Lme/deck/decksmp/TrustCommand;", "init", "", "plugin", "Lorg/bukkit/plugin/java/JavaPlugin;", "get", "decksmp"}
   )
   public static final class Companion {
      private Companion() {
      }

      public final void init(@NotNull JavaPlugin plugin) {
         Intrinsics.checkNotNullParameter(plugin, "plugin");
         TrustCommand.instance = new TrustCommand(plugin);
      }

      @NotNull
      public final TrustCommand get() {
         TrustCommand var10000 = TrustCommand.instance;
         if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("instance");
            var10000 = null;
         }

         return var10000;
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }
}
