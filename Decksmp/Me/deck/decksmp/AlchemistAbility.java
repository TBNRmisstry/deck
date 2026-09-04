/* Decompiler 9ms, total 162ms, lines 49 */
package me.deck.decksmp;

import java.util.Collection;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.StringsKt;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u001c\u0010\u0004\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"},
   d2 = {"Lme/deck/decksmp/AlchemistAbility;", "", "<init>", "()V", "tier2Effects", "", "Lorg/bukkit/potion/PotionEffectType;", "kotlin.jvm.PlatformType", "giveRandomEffect", "", "player", "Lorg/bukkit/entity/Player;", "decksmp"}
)
public final class AlchemistAbility {
   @NotNull
   public static final AlchemistAbility INSTANCE = new AlchemistAbility();
   @NotNull
   private static final List<PotionEffectType> tier2Effects;

   private AlchemistAbility() {
   }

   public final void giveRandomEffect(@NotNull Player player) {
      Intrinsics.checkNotNullParameter(player, "player");
      PotionEffectType chosen = (PotionEffectType)CollectionsKt.random((Collection)tier2Effects, (Random)Random.Default);
      PotionEffect effect = new PotionEffect(chosen, 200, 1, true, true);
      player.addPotionEffect(effect);
      String var10001 = chosen.getName();
      Intrinsics.checkNotNullExpressionValue(var10001, "getName(...)");
      var10001 = var10001.toLowerCase(Locale.ROOT);
      Intrinsics.checkNotNullExpressionValue(var10001, "toLowerCase(...)");
      player.sendMessage("§dThe Alchemist grants you the power of §e" + StringsKt.replace$default(var10001, '_', ' ', false, 4, (Object)null) + "§d!");
   }

   static {
      PotionEffectType[] var0 = new PotionEffectType[]{PotionEffectType.SPEED, PotionEffectType.HASTE, PotionEffectType.STRENGTH, PotionEffectType.ABSORPTION, PotionEffectType.RESISTANCE};
      tier2Effects = CollectionsKt.listOf(var0);
   }
}
