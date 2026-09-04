/* Decompiler 10ms, total 132ms, lines 29 */
package me.deck.decksmp;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0011\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R%\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"},
   d2 = {"Lme/deck/decksmp/CardVariables;", "", "<init>", "()V", "equippedCards", "", "", "", "getEquippedCards", "()Ljava/util/Map;", "decksmp"}
)
public final class CardVariables {
   @NotNull
   public static final CardVariables INSTANCE = new CardVariables();
   @NotNull
   private static final Map<String, String[]> equippedCards = (Map)(new LinkedHashMap());

   private CardVariables() {
   }

   @NotNull
   public final Map<String, String[]> getEquippedCards() {
      return equippedCards;
   }
}
