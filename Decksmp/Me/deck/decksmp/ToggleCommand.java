/* Decompiler 12ms, total 127ms, lines 74 */
package me.deck.decksmp;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\rH\u0016¢\u0006\u0002\u0010\u000e¨\u0006\u0010"},
   d2 = {"Lme/deck/decksmp/ToggleCommand;", "Lorg/bukkit/command/CommandExecutor;", "<init>", "()V", "onCommand", "", "sender", "Lorg/bukkit/command/CommandSender;", "command", "Lorg/bukkit/command/Command;", "label", "", "args", "", "(Lorg/bukkit/command/CommandSender;Lorg/bukkit/command/Command;Ljava/lang/String;[Ljava/lang/String;)Z", "Companion", "decksmp"}
)
public final class ToggleCommand implements CommandExecutor {
   @NotNull
   public static final ToggleCommand.Companion Companion = new ToggleCommand.Companion((DefaultConstructorMarker)null);
   @NotNull
   private static final Set<UUID> disabledPlayers = (Set)(new LinkedHashSet());

   public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
      Intrinsics.checkNotNullParameter(sender, "sender");
      Intrinsics.checkNotNullParameter(command, "command");
      Intrinsics.checkNotNullParameter(label, "label");
      Intrinsics.checkNotNullParameter(args, "args");
      if (!(sender instanceof Player)) {
         sender.sendMessage("§cOnly players can use this command.");
         return true;
      } else {
         UUID var10000 = ((Player)sender).getUniqueId();
         Intrinsics.checkNotNullExpressionValue(var10000, "getUniqueId(...)");
         UUID uuid = var10000;
         if (disabledPlayers.contains(uuid)) {
            disabledPlayers.remove(uuid);
            sender.sendMessage("§eYour abilities are now §aenabled§e!");
         } else {
            disabledPlayers.add(uuid);
            sender.sendMessage("§eYour abilities are now §cdisabled§e!");
         }

         return true;
      }
   }

   @Metadata(
      mv = {2, 2, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"},
      d2 = {"Lme/deck/decksmp/ToggleCommand$Companion;", "", "<init>", "()V", "disabledPlayers", "", "Ljava/util/UUID;", "getDisabledPlayers", "()Ljava/util/Set;", "decksmp"}
   )
   public static final class Companion {
      private Companion() {
      }

      @NotNull
      public final Set<UUID> getDisabledPlayers() {
         return ToggleCommand.disabledPlayers;
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }
}
