/* Decompiler 48ms, total 170ms, lines 238 */
package me.deck.decksmp;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u00102\u001a\u00020\u00052\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\f\u00107\u001a\b\u0012\u0004\u0012\u00020408H\u0002J\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u00050:R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0007R\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0007R\u0011\u0010\u0016\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0007R\u0011\u0010\u0018\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0007R\u0011\u0010\u001a\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0007R\u0011\u0010\u001c\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0007R\u0011\u0010\u001e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0007R\u0011\u0010 \u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0007R\u0011\u0010\"\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0007R\u0011\u0010$\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0007R\u0011\u0010&\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0007R\u0011\u0010(\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0007R\u0011\u0010*\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0007R\u0011\u0010,\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0007R\u0011\u0010.\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0007R\u0011\u00100\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0007R\u001d\u00109\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u0002040:¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<¨\u0006>"},
   d2 = {"Lme/deck/decksmp/Cards;", "", "<init>", "()V", "NETHERITE", "Lorg/bukkit/inventory/ItemStack;", "getNETHERITE", "()Lorg/bukkit/inventory/ItemStack;", "ALCHEMIST", "getALCHEMIST", "DISMANTLE", "getDISMANTLE", "GLIDE", "getGLIDE", "FROST", "getFROST", "OCEAN", "getOCEAN", "CONDUCTOR", "getCONDUCTOR", "PHASE", "getPHASE", "HEALTH", "getHEALTH", "HOP", "getHOP", "SPOTLIGHT", "getSPOTLIGHT", "SHADOWSTEP", "getSHADOWSTEP", "VILLAGER", "getVILLAGER", "RESURRECTION", "getRESURRECTION", "BLOODRUSH", "getBLOODRUSH", "SPIDER", "getSPIDER", "FEATHER", "getFEATHER", "VINDICATOR", "getVINDICATOR", "OVERDRIVE", "getOVERDRIVE", "DRAGON_EGG", "getDRAGON_EGG", "WITHER", "getWITHER", "SHIELD", "getSHIELD", "createCard", "name", "", "modelData", "", "lore", "", "cardEmojis", "", "getCardEmojis", "()Ljava/util/Map;", "allCards", "decksmp"}
)
public final class Cards {
   @NotNull
   public static final Cards INSTANCE = new Cards();
   @NotNull
   private static final ItemStack NETHERITE;
   @NotNull
   private static final ItemStack ALCHEMIST;
   @NotNull
   private static final ItemStack DISMANTLE;
   @NotNull
   private static final ItemStack GLIDE;
   @NotNull
   private static final ItemStack FROST;
   @NotNull
   private static final ItemStack OCEAN;
   @NotNull
   private static final ItemStack CONDUCTOR;
   @NotNull
   private static final ItemStack PHASE;
   @NotNull
   private static final ItemStack HEALTH;
   @NotNull
   private static final ItemStack HOP;
   @NotNull
   private static final ItemStack SPOTLIGHT;
   @NotNull
   private static final ItemStack SHADOWSTEP;
   @NotNull
   private static final ItemStack VILLAGER;
   @NotNull
   private static final ItemStack RESURRECTION;
   @NotNull
   private static final ItemStack BLOODRUSH;
   @NotNull
   private static final ItemStack SPIDER;
   @NotNull
   private static final ItemStack FEATHER;
   @NotNull
   private static final ItemStack VINDICATOR;
   @NotNull
   private static final ItemStack OVERDRIVE;
   @NotNull
   private static final ItemStack DRAGON_EGG;
   @NotNull
   private static final ItemStack WITHER;
   @NotNull
   private static final ItemStack SHIELD;
   @NotNull
   private static final Map<String, String> cardEmojis;

   private Cards() {
   }

   @NotNull
   public final ItemStack getNETHERITE() {
      return NETHERITE;
   }

   @NotNull
   public final ItemStack getALCHEMIST() {
      return ALCHEMIST;
   }

   @NotNull
   public final ItemStack getDISMANTLE() {
      return DISMANTLE;
   }

   @NotNull
   public final ItemStack getGLIDE() {
      return GLIDE;
   }

   @NotNull
   public final ItemStack getFROST() {
      return FROST;
   }

   @NotNull
   public final ItemStack getOCEAN() {
      return OCEAN;
   }

   @NotNull
   public final ItemStack getCONDUCTOR() {
      return CONDUCTOR;
   }

   @NotNull
   public final ItemStack getPHASE() {
      return PHASE;
   }

   @NotNull
   public final ItemStack getHEALTH() {
      return HEALTH;
   }

   @NotNull
   public final ItemStack getHOP() {
      return HOP;
   }

   @NotNull
   public final ItemStack getSPOTLIGHT() {
      return SPOTLIGHT;
   }

   @NotNull
   public final ItemStack getSHADOWSTEP() {
      return SHADOWSTEP;
   }

   @NotNull
   public final ItemStack getVILLAGER() {
      return VILLAGER;
   }

   @NotNull
   public final ItemStack getRESURRECTION() {
      return RESURRECTION;
   }

   @NotNull
   public final ItemStack getBLOODRUSH() {
      return BLOODRUSH;
   }

   @NotNull
   public final ItemStack getSPIDER() {
      return SPIDER;
   }

   @NotNull
   public final ItemStack getFEATHER() {
      return FEATHER;
   }

   @NotNull
   public final ItemStack getVINDICATOR() {
      return VINDICATOR;
   }

   @NotNull
   public final ItemStack getOVERDRIVE() {
      return OVERDRIVE;
   }

   @NotNull
   public final ItemStack getDRAGON_EGG() {
      return DRAGON_EGG;
   }

   @NotNull
   public final ItemStack getWITHER() {
      return WITHER;
   }

   @NotNull
   public final ItemStack getSHIELD() {
      return SHIELD;
   }

   private final ItemStack createCard(String name, int modelData, List<String> lore) {
      ItemStack item = new ItemStack(Material.NETHER_STAR);
      ItemMeta var10000 = item.getItemMeta();
      Intrinsics.checkNotNull(var10000);
      ItemMeta meta = var10000;
      meta.setDisplayName(name);
      meta.setCustomModelData(modelData);
      meta.setLore(lore);
      item.setItemMeta(meta);
      return item;
   }

   @NotNull
   public final Map<String, String> getCardEmojis() {
      return cardEmojis;
   }

   @NotNull
   public final Map<String, ItemStack> allCards() {
      Pair[] var1 = new Pair[]{TuplesKt.to("netherite", NETHERITE), TuplesKt.to("alchemist", ALCHEMIST), TuplesKt.to("dismantle", DISMANTLE), TuplesKt.to("glide", GLIDE), TuplesKt.to("frost", FROST), TuplesKt.to("ocean", OCEAN), TuplesKt.to("conductor", CONDUCTOR), TuplesKt.to("phase", PHASE), TuplesKt.to("health", HEALTH), TuplesKt.to("hop", HOP), TuplesKt.to("spotlight", SPOTLIGHT), TuplesKt.to("shadowstep", SHADOWSTEP), TuplesKt.to("villager", VILLAGER), TuplesKt.to("resurrection", RESURRECTION), TuplesKt.to("bloodrush", BLOODRUSH), TuplesKt.to("spider", SPIDER), TuplesKt.to("feather", FEATHER), TuplesKt.to("vindicator", VINDICATOR), TuplesKt.to("overdrive", OVERDRIVE), TuplesKt.to("dragonegg", DRAGON_EGG), TuplesKt.to("wither", WITHER), TuplesKt.to("shield", SHIELD)};
      return MapsKt.mapOf(var1);
   }

   static {
      NETHERITE = INSTANCE.createCard("§4Netherite Card", 7, CollectionsKt.listOf("§7Upgrades all armor/tools to netherite"));
      ALCHEMIST = INSTANCE.createCard("§dAlchemist Card", 20, CollectionsKt.listOf("§7Random positive tier 2 potion effect every 1 minute"));
      DISMANTLE = INSTANCE.createCard("§8Dismantle Card", 21, CollectionsKt.listOf("§7Lock any item the victim is holding for 10 seconds"));
      GLIDE = INSTANCE.createCard("§fGlide Card", 19, CollectionsKt.listOf("§7Shift jump to glide into the air"));
      FROST = INSTANCE.createCard("§bFrost Card", 15, CollectionsKt.listOf("§7Frostblast an entity after hit every 30s"));
      OCEAN = INSTANCE.createCard("§3Ocean Card", 3, CollectionsKt.listOf("§7Permanent dolphins grace and conduit power"));
      CONDUCTOR = INSTANCE.createCard("§eConductor Card", 2, CollectionsKt.listOf("§7Every 12 hits lightning strikes last target"));
      PHASE = INSTANCE.createCard("§9Phase Card", 8, CollectionsKt.listOf("§74% chance of phasing through attacks"));
      HEALTH = INSTANCE.createCard("§cHealth Card", 5, CollectionsKt.listOf("§7Permanent 15 hearts"));
      HOP = INSTANCE.createCard("§fHop Card", 6, CollectionsKt.listOf("§7Sneak jump to dash into the air"));
      SPOTLIGHT = INSTANCE.createCard("§7Spotlight Card", 11, CollectionsKt.listOf("§7Gives glowing and shows health on hit"));
      SHADOWSTEP = INSTANCE.createCard("§8Shadowstep Card", 9, CollectionsKt.listOf("§7Speed 3 + invisibility at night"));
      VILLAGER = INSTANCE.createCard("§aVillager Card", 13, CollectionsKt.listOf("§7Lowers villager costs, mends armor slowly"));
      RESURRECTION = INSTANCE.createCard("§2Resurrection Card", 12, CollectionsKt.listOf("§7Pops an imaginary totem when near death"));
      BLOODRUSH = INSTANCE.createCard("§cBloodRush Card", 1, CollectionsKt.listOf("§7Every 4 hits: +1.5 attack & Speed II for 5s"));
      SPIDER = INSTANCE.createCard("§6Spider Card", 10, CollectionsKt.listOf("§7Clears cobwebs around you"));
      FEATHER = INSTANCE.createCard("§fFeather Card", 4, CollectionsKt.listOf("§7No fall damage, arrows apply slow falling"));
      VINDICATOR = INSTANCE.createCard("§7Vindicator Card", 14, CollectionsKt.listOf("§7Every axe crit pulls the entity towards you"));
      OVERDRIVE = INSTANCE.createCard("§eOverdrive Card", 16, CollectionsKt.listOf("§7Every block/hit adds haste, max Haste X"));
      Cards var10000 = INSTANCE;
      String[] var0 = new String[]{"§7Equip 3 cards instead of 2", "§7Left click: Wither nearby enemies (10s)"};
      DRAGON_EGG = var10000.createCard("§5Dragon Egg", 99, CollectionsKt.listOf(var0));
      WITHER = INSTANCE.createCard("§8Wither Card", 23, CollectionsKt.listOf("§7Unleash the power of decay and darkness"));
      SHIELD = INSTANCE.createCard("§bShield Card", 23, CollectionsKt.listOf("§7Custom effect for the Shield Card"));
      Pair[] var1 = new Pair[]{TuplesKt.to("BloodRush Card", "\uf6b0"), TuplesKt.to("Conductor Card", "\uf6b1"), TuplesKt.to("Ocean Card", "\uf6b3"), TuplesKt.to("Feather Card", "\uf6b9"), TuplesKt.to("Health Card", "\uf6b2"), TuplesKt.to("Hop Card", "\uf6ae"), TuplesKt.to("Shadowstep Card", "\uf6bb"), TuplesKt.to("Netherite Card", "\uf6b5"), TuplesKt.to("Spider Card", "\uf6b8"), TuplesKt.to("Villager Card", "\uf6b6"), TuplesKt.to("Vindicator Card", "\uf6af"), TuplesKt.to("Resurrection Card", "\uf6bd"), TuplesKt.to("Phase Card", "\uf6bc"), TuplesKt.to("Dismantle Card", "\uf6ab"), TuplesKt.to("Spotlight Card", "\uf6b7"), TuplesKt.to("Overdrive Card", "\uf6b4"), TuplesKt.to("Glide Card", "\uf6c0"), TuplesKt.to("Alchemist Card", "\uf6ac"), TuplesKt.to("Frost Card", "\uf6be"), TuplesKt.to("Wither Card", "notdone"), TuplesKt.to("Shield Card", "\uf6ba")};
      cardEmojis = MapsKt.mapOf(var1);
   }
}
