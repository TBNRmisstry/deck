/* Decompiler 13ms, total 139ms, lines 41 */
package me.deck.decksmp;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
   d2 = {"Lme/deck/decksmp/LuckyDodgeAbility;", "", "<init>", "()V", "tryDodge", "", "event", "Lorg/bukkit/event/entity/EntityDamageEvent;", "decksmp"}
)
public final class LuckyDodgeAbility {
   @NotNull
   public static final LuckyDodgeAbility INSTANCE = new LuckyDodgeAbility();

   private LuckyDodgeAbility() {
   }

   public final void tryDodge(@NotNull EntityDamageEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      Entity var3 = event.getEntity();
      Player var10000 = var3 instanceof Player ? (Player)var3 : null;
      if ((var3 instanceof Player ? (Player)var3 : null) != null) {
         Player victim = var10000;
         if (Random.Default.nextDouble(100.0D) < 15.0D) {
            event.setCancelled(true);
            victim.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 20, 0, true, false));
         }

      }
   }
}
