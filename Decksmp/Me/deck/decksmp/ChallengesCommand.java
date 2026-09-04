/* Decompiler 437ms, total 581ms, lines 948 */
package me.deck.decksmp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World.Environment;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Rabbit;
import org.bukkit.entity.Snowball;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Vindicator;
import org.bukkit.entity.Warden;
import org.bukkit.entity.WitherSkeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityResurrectEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.projectiles.ProjectileSource;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010'\u001a\u00020(H\u0002J\b\u0010)\u001a\u00020(H\u0002J\u0018\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\nH\u0002J5\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\n2\u000e\u00105\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n06H\u0016¢\u0006\u0002\u00107J\u0010\u00108\u001a\u00020(2\u0006\u00109\u001a\u00020:H\u0007J\u0010\u0010;\u001a\u00020(2\u0006\u00109\u001a\u00020<H\u0007J\u0010\u0010=\u001a\u00020(2\u0006\u00109\u001a\u00020>H\u0007J\u0010\u0010?\u001a\u00020(2\u0006\u00109\u001a\u00020@H\u0007J\u0010\u0010A\u001a\u00020(2\u0006\u00109\u001a\u00020>H\u0007J\u0010\u0010B\u001a\u00020(2\u0006\u00109\u001a\u00020CH\u0007J\u0010\u0010D\u001a\u00020(2\u0006\u00109\u001a\u00020EH\u0007J\u0010\u0010F\u001a\u00020(2\u0006\u00109\u001a\u00020GH\u0007J\u0010\u0010H\u001a\u00020(2\u0006\u00109\u001a\u00020IH\u0007J\u0010\u0010J\u001a\u00020(2\u0006\u00109\u001a\u00020KH\u0007J\u0010\u0010L\u001a\u00020(2\u0006\u00109\u001a\u00020MH\u0007J\u0010\u0010N\u001a\u00020(2\u0006\u00109\u001a\u00020OH\u0007J\u0010\u0010P\u001a\u00020(2\u0006\u00109\u001a\u00020GH\u0007J\u0010\u0010Q\u001a\u00020(2\u0006\u00109\u001a\u00020RH\u0007J\u0010\u0010S\u001a\u00020(2\u0006\u00109\u001a\u00020TH\u0007J\u0010\u0010U\u001a\u00020(2\u0006\u00109\u001a\u00020IH\u0007J\u0010\u0010V\u001a\u00020(2\u0006\u00109\u001a\u00020WH\u0007J\u0010\u0010X\u001a\u00020(2\u0006\u00109\u001a\u00020RH\u0007J\u0010\u0010Y\u001a\u00020(2\u0006\u00109\u001a\u00020>H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u001b0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u001c\u001a \u0012\u0004\u0012\u00020\u000f\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u001d0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Z"},
   d2 = {"Lme/deck/decksmp/ChallengesCommand;", "Lorg/bukkit/command/CommandExecutor;", "Lorg/bukkit/event/Listener;", "plugin", "Lorg/bukkit/plugin/java/JavaPlugin;", "<init>", "(Lorg/bukkit/plugin/java/JavaPlugin;)V", "challenges", "", "Lkotlin/Pair;", "", "completedChallenges", "", "bloodRushKills", "", "Ljava/util/UUID;", "", "hopKills", "phaseReached", "spiderBreaks", "healthEaten", "conductorKills", "vindicatorKills", "spectralArrowsCrafted", "overdriveMined", "shieldBlocks", "glideDistance", "", "dismantleProgress", "Lkotlin/Triple;", "alchemistDone", "villagerTrades", "oceanBuilt", "resurrectionProgress", "witherSkulls", "dataFile", "Ljava/io/File;", "dataConfig", "Lorg/bukkit/configuration/file/YamlConfiguration;", "saveChallenges", "", "loadChallenges", "completeChallenge", "player", "Lorg/bukkit/entity/Player;", "challenge", "onCommand", "", "sender", "Lorg/bukkit/command/CommandSender;", "command", "Lorg/bukkit/command/Command;", "label", "args", "", "(Lorg/bukkit/command/CommandSender;Lorg/bukkit/command/Command;Ljava/lang/String;[Ljava/lang/String;)Z", "onInventoryClick", "event", "Lorg/bukkit/event/inventory/InventoryClickEvent;", "onPlayerDeath", "Lorg/bukkit/event/entity/PlayerDeathEvent;", "onEntityDeath", "Lorg/bukkit/event/entity/EntityDeathEvent;", "onTotemPop", "Lorg/bukkit/event/entity/EntityResurrectEvent;", "onChargedCreeperKill", "onFrostDamage", "Lorg/bukkit/event/entity/EntityDamageByEntityEvent;", "onBlockBreak", "Lorg/bukkit/event/block/BlockBreakEvent;", "onEat", "Lorg/bukkit/event/player/PlayerItemConsumeEvent;", "onAdvancement", "Lorg/bukkit/event/player/PlayerAdvancementDoneEvent;", "onCraft", "Lorg/bukkit/event/inventory/CraftItemEvent;", "onPlayerMove", "Lorg/bukkit/event/player/PlayerMoveEvent;", "onShieldBlock", "Lorg/bukkit/event/entity/EntityDamageEvent;", "onDismantleEat", "onDismantlePlace", "Lorg/bukkit/event/block/BlockPlaceEvent;", "onDismantleXP", "Lorg/bukkit/event/player/PlayerExpChangeEvent;", "onAlchemistAdvancement", "onVillagerTrade", "Lorg/bukkit/event/player/PlayerInteractEntityEvent;", "onConduitBuild", "onWitherSkeletonDrop", "decksmp"}
)
@SourceDebugExtension({"SMAP\nadv.kt\nKotlin\n*S Kotlin\n*F\n+ 1 adv.kt\nme/deck/decksmp/ChallengesCommand\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,456:1\n1#2:457\n774#3:458\n865#3,2:459\n1869#3,2:461\n774#3:463\n865#3,2:464\n1788#3,4:468\n12767#4,2:466\n*S KotlinDebug\n*F\n+ 1 adv.kt\nme/deck/decksmp/ChallengesCommand\n*L\n151#1:458\n151#1:459,2\n152#1:461,2\n154#1:463\n154#1:464,2\n439#1:468,4\n225#1:466,2\n*E\n"})
public final class ChallengesCommand implements CommandExecutor, Listener {
   @NotNull
   private final JavaPlugin plugin;
   @NotNull
   private final List<Pair<String, String>> challenges;
   @NotNull
   private final Set<String> completedChallenges;
   @NotNull
   private final Map<UUID, Integer> bloodRushKills;
   @NotNull
   private final Map<UUID, Integer> hopKills;
   @NotNull
   private final Set<UUID> phaseReached;
   @NotNull
   private final Map<UUID, Integer> spiderBreaks;
   @NotNull
   private final Map<UUID, Integer> healthEaten;
   @NotNull
   private final Map<UUID, Integer> conductorKills;
   @NotNull
   private final Map<UUID, Integer> vindicatorKills;
   @NotNull
   private final Map<UUID, Integer> spectralArrowsCrafted;
   @NotNull
   private final Map<UUID, Integer> overdriveMined;
   @NotNull
   private final Map<UUID, Integer> shieldBlocks;
   @NotNull
   private final Map<UUID, Double> glideDistance;
   @NotNull
   private final Map<UUID, Triple<Integer, Integer, Integer>> dismantleProgress;
   @NotNull
   private final Set<UUID> alchemistDone;
   @NotNull
   private final Map<UUID, Integer> villagerTrades;
   @NotNull
   private final Set<UUID> oceanBuilt;
   @NotNull
   private final Map<UUID, Integer> resurrectionProgress;
   @NotNull
   private final Map<UUID, Integer> witherSkulls;
   @NotNull
   private final File dataFile;
   @NotNull
   private final YamlConfiguration dataConfig;

   public ChallengesCommand(@NotNull JavaPlugin plugin) {
      Intrinsics.checkNotNullParameter(plugin, "plugin");
      super();
      this.plugin = plugin;
      Pair[] var2 = new Pair[]{TuplesKt.to("BloodRush", "Kill 5 players"), TuplesKt.to("Frost", "Bring a blaze to the overworld and kill it with snowballs"), TuplesKt.to("Hop", "Kill 10 bunnies whilst having Jump Boost II"), TuplesKt.to("Conductor", "Kill a charged creeper"), TuplesKt.to("Phase", "Get onto the Nether roof."), TuplesKt.to("Spider", "Break 10 mob spawners"), TuplesKt.to("Resurrection", "Kill The Wither"), TuplesKt.to("Health", "Eat 3 enchanted golden apples"), TuplesKt.to("Feather", "Get the Caves and Cliffs advancement"), TuplesKt.to("Ocean", "Build a conduit"), TuplesKt.to("Vindicator", "Kill 100 vindicators"), TuplesKt.to("Spotlight", "Craft 500 spectral arrows"), TuplesKt.to("Villager", "Trade with one villager 500 times"), TuplesKt.to("Shadowstep", "Kill a warden naked"), TuplesKt.to("Overdrive", "Mine 500 obsidian"), TuplesKt.to("Alchemist", "Get the Furious Cocktail advancement"), TuplesKt.to("Dismantle", "Eat 64 golden apples, place 64 cobwebs, use 640 XP bottles"), TuplesKt.to("Glide", "Travel 25,000 blocks with an Elytra"), TuplesKt.to("Shield", "Deflect 100 hits from a skeleton"), TuplesKt.to("Wither", "Collect 5 Wither Skeleton Skulls")};
      this.challenges = CollectionsKt.listOf(var2);
      this.completedChallenges = (Set)(new LinkedHashSet());
      this.bloodRushKills = (Map)(new LinkedHashMap());
      this.hopKills = (Map)(new LinkedHashMap());
      this.phaseReached = (Set)(new LinkedHashSet());
      this.spiderBreaks = (Map)(new LinkedHashMap());
      this.healthEaten = (Map)(new LinkedHashMap());
      this.conductorKills = (Map)(new LinkedHashMap());
      this.vindicatorKills = (Map)(new LinkedHashMap());
      this.spectralArrowsCrafted = (Map)(new LinkedHashMap());
      this.overdriveMined = (Map)(new LinkedHashMap());
      this.shieldBlocks = (Map)(new LinkedHashMap());
      this.glideDistance = (Map)(new LinkedHashMap());
      this.dismantleProgress = (Map)(new LinkedHashMap());
      this.alchemistDone = (Set)(new LinkedHashSet());
      this.villagerTrades = (Map)(new LinkedHashMap());
      this.oceanBuilt = (Set)(new LinkedHashSet());
      this.resurrectionProgress = (Map)(new LinkedHashMap());
      this.witherSkulls = (Map)(new LinkedHashMap());
      this.dataFile = new File(this.plugin.getDataFolder(), "challenges.yml");
      YamlConfiguration var10001 = YamlConfiguration.loadConfiguration(this.dataFile);
      Intrinsics.checkNotNullExpressionValue(var10001, "loadConfiguration(...)");
      this.dataConfig = var10001;
      this.plugin.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)this.plugin);
      this.loadChallenges();
   }

   private final void saveChallenges() {
      try {
         this.dataConfig.set("completedChallenges", CollectionsKt.toList((Iterable)this.completedChallenges));
         this.dataConfig.save(this.dataFile);
      } catch (IOException var2) {
         var2.printStackTrace();
      }

   }

   private final void loadChallenges() {
      this.completedChallenges.clear();
      Set var10000 = this.completedChallenges;
      List var10001 = this.dataConfig.getStringList("completedChallenges");
      Intrinsics.checkNotNullExpressionValue(var10001, "getStringList(...)");
      var10000.addAll((Collection)var10001);
   }

   private final void completeChallenge(Player player, String challenge) {
      if (this.completedChallenges.contains(challenge)) {
         player.sendMessage("§cThe " + challenge + " challenge has already been completed by someone else!");
      } else {
         ItemStack var9;
         label99: {
            this.completedChallenges.add(challenge);
            String var10000 = player.getName();
            Bukkit.broadcastMessage("§6" + var10000 + " §acompleted the §e" + challenge + " §achallenge for the server!");
            switch(challenge.hashCode()) {
            case -2139068607:
               if (challenge.equals("Dismantle")) {
                  var9 = Cards.INSTANCE.getDISMANTLE();
                  break label99;
               }
               break;
            case -2137395588:
               if (challenge.equals("Health")) {
                  var9 = Cards.INSTANCE.getHEALTH();
                  break label99;
               }
               break;
            case -1819473015:
               if (challenge.equals("Shield")) {
                  var9 = Cards.INSTANCE.getSHIELD();
                  break label99;
               }
               break;
            case -1812086011:
               if (challenge.equals("Spider")) {
                  var9 = Cards.INSTANCE.getSPIDER();
                  break label99;
               }
               break;
            case -1703702509:
               if (challenge.equals("Wither")) {
                  var9 = Cards.INSTANCE.getWITHER();
                  break label99;
               }
               break;
            case -1532857614:
               if (challenge.equals("Alchemist")) {
                  var9 = Cards.INSTANCE.getALCHEMIST();
                  break label99;
               }
               break;
            case -1081514798:
               if (challenge.equals("BloodRush")) {
                  var9 = Cards.INSTANCE.getBLOODRUSH();
                  break label99;
               }
               break;
            case -432292231:
               if (challenge.equals("Vindicator")) {
                  var9 = Cards.INSTANCE.getVINDICATOR();
                  break label99;
               }
               break;
            case 72745:
               if (challenge.equals("Hop")) {
                  var9 = Cards.INSTANCE.getHOP();
                  break label99;
               }
               break;
            case 68152996:
               if (challenge.equals("Frost")) {
                  var9 = Cards.INSTANCE.getFROST();
                  break label99;
               }
               break;
            case 68891525:
               if (challenge.equals("Glide")) {
                  var9 = Cards.INSTANCE.getGLIDE();
                  break label99;
               }
               break;
            case 76007646:
               if (challenge.equals("Ocean")) {
                  var9 = Cards.INSTANCE.getOCEAN();
                  break label99;
               }
               break;
            case 77076827:
               if (challenge.equals("Phase")) {
                  var9 = Cards.INSTANCE.getPHASE();
                  break label99;
               }
               break;
            case 685432963:
               if (challenge.equals("Feather")) {
                  var9 = Cards.INSTANCE.getFEATHER();
                  break label99;
               }
               break;
            case 943016423:
               if (challenge.equals("Resurrection")) {
                  var9 = Cards.INSTANCE.getRESURRECTION();
                  break label99;
               }
               break;
            case 973786124:
               if (challenge.equals("Shadowstep")) {
                  var9 = Cards.INSTANCE.getSHADOWSTEP();
                  break label99;
               }
               break;
            case 1084009780:
               if (challenge.equals("Spotlight")) {
                  var9 = Cards.INSTANCE.getSPOTLIGHT();
                  break label99;
               }
               break;
            case 1153242631:
               if (challenge.equals("Conductor")) {
                  var9 = Cards.INSTANCE.getCONDUCTOR();
                  break label99;
               }
               break;
            case 1241342230:
               if (challenge.equals("Overdrive")) {
                  var9 = Cards.INSTANCE.getOVERDRIVE();
                  break label99;
               }
               break;
            case 1451119974:
               if (challenge.equals("Villager")) {
                  var9 = Cards.INSTANCE.getVILLAGER();
                  break label99;
               }
            }

            var9 = null;
         }

         ItemStack reward = var9;
         if (reward != null) {
            int var6 = false;
            PlayerInventory var8 = player.getInventory();
            ItemStack[] var7 = new ItemStack[]{reward.clone()};
            var8.addItem(var7);
         }

         this.saveChallenges();
      }
   }

   public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
      Intrinsics.checkNotNullParameter(sender, "sender");
      Intrinsics.checkNotNullParameter(command, "command");
      Intrinsics.checkNotNullParameter(label, "label");
      Intrinsics.checkNotNullParameter(args, "args");
      if (!(sender instanceof Player)) {
         return true;
      } else {
         String var10000 = command.getName();
         Intrinsics.checkNotNullExpressionValue(var10000, "getName(...)");
         var10000 = var10000.toLowerCase(Locale.ROOT);
         Intrinsics.checkNotNullExpressionValue(var10000, "toLowerCase(...)");
         String var6 = var10000;
         if (Intrinsics.areEqual(var6, "challenges")) {
            Inventory var39 = this.plugin.getServer().createInventory((InventoryHolder)null, 54, "§6Challenges");
            Intrinsics.checkNotNullExpressionValue(var39, "createInventory(...)");
            Inventory gui = var39;
            ItemStack var9 = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
            int $i$f$forEach = false;
            ItemStack var41 = var9;
            ItemMeta var10001 = var9.getItemMeta();
            boolean $i$f$filterTo;
            if (var10001 != null) {
               ItemMeta var12 = var10001;
               $i$f$filterTo = false;
               var12.setDisplayName(" ");
               var41 = var9;
               var10001 = var12;
            } else {
               var10001 = null;
            }

            var41.setItemMeta(var10001);
            ItemStack blackPane = var9;
            Iterable $this$forEach$iv = (Iterable)(new IntRange(0, 53));
            $i$f$forEach = false;
            Collection destination$iv$iv = (Collection)(new ArrayList());
            int $i$f$filterTo = false;
            Iterator var36 = $this$forEach$iv.iterator();

            while(var36.hasNext()) {
               Object element$iv$iv = var36.next();
               int it = ((Number)element$iv$iv).intValue();
               int var18 = false;
               if (it < 9 || it >= 45 || it % 9 == 0 || it % 9 == 8) {
                  destination$iv$iv.add(element$iv$iv);
               }
            }

            List borderSlots = (List)destination$iv$iv;
            $this$forEach$iv = (Iterable)borderSlots;
            $i$f$forEach = false;
            Iterator var28 = $this$forEach$iv.iterator();

            while(var28.hasNext()) {
               Object element$iv = var28.next();
               int it = ((Number)element$iv).intValue();
               $i$f$filterTo = false;
               gui.setItem(it, blackPane);
            }

            Iterable $this$filter$iv = (Iterable)(new IntRange(0, 53));
            int $i$f$filter = false;
            Collection destination$iv$iv = (Collection)(new ArrayList());
            $i$f$filterTo = false;
            Iterator var37 = $this$filter$iv.iterator();

            while(var37.hasNext()) {
               Object element$iv$iv = var37.next();
               int it = ((Number)element$iv$iv).intValue();
               int var19 = false;
               if (!borderSlots.contains(it)) {
                  destination$iv$iv.add(element$iv$iv);
               }
            }

            List centerSlots = (List)destination$iv$iv;
            int index = 0;
            var28 = this.challenges.iterator();

            while(var28.hasNext()) {
               Pair var32 = (Pair)var28.next();
               String name = (String)var32.component1();
               String desc = (String)var32.component2();
               if (!this.completedChallenges.contains(name)) {
                  if (index >= centerSlots.size()) {
                     break;
                  }

                  int slot = ((Number)centerSlots.get(index)).intValue();
                  ItemStack var44 = new ItemStack(Material.NETHER_STAR);
                  int var20 = false;
                  var41 = var44;
                  var10001 = var44.getItemMeta();
                  if (var10001 != null) {
                     ItemMeta var21 = var10001;
                     int var24 = false;
                     var21.setDisplayName("§c" + name + " Challenge");
                     var21.setLore(CollectionsKt.listOf("§7" + desc));
                     var41 = var44;
                     var10001 = var21;
                  } else {
                     var10001 = null;
                  }

                  var41.setItemMeta(var10001);
                  gui.setItem(slot, var44);
                  ++index;
               }
            }

            ((Player)sender).openInventory(gui);
         } else if (Intrinsics.areEqual(var6, "resetchallenges")) {
            this.completedChallenges.clear();
            this.saveChallenges();
            sender.sendMessage("§aAll server challenges have been reset!");
         }

         return true;
      }
   }

   @EventHandler
   public final void onInventoryClick(@NotNull InventoryClickEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      if (Intrinsics.areEqual(event.getView().getTitle(), "§6Challenges")) {
         event.setCancelled(true);
      }
   }

   @EventHandler
   public final void onPlayerDeath(@NotNull PlayerDeathEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      Player var10000 = event.getEntity().getKiller();
      if (var10000 != null) {
         Player killer = var10000;
         if (!this.completedChallenges.contains("BloodRush")) {
            Map var4 = this.bloodRushKills;
            UUID var10001 = killer.getUniqueId();
            Intrinsics.checkNotNullExpressionValue(var10001, "getUniqueId(...)");
            int kills = ((Number)var4.getOrDefault(var10001, 0)).intValue() + 1;
            this.bloodRushKills.put(killer.getUniqueId(), kills);
            if (kills >= 5) {
               this.completeChallenge(killer, "BloodRush");
            }

         }
      }
   }

   @EventHandler
   public final void onEntityDeath(@NotNull EntityDeathEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      Player var10000 = event.getEntity().getKiller();
      if (var10000 != null) {
         Player killer = var10000;
         int kills;
         Map var12;
         UUID var10001;
         if (event.getEntity() instanceof Rabbit && killer.hasPotionEffect(PotionEffectType.JUMP_BOOST) && !this.completedChallenges.contains("Hop")) {
            var12 = this.hopKills;
            var10001 = killer.getUniqueId();
            Intrinsics.checkNotNullExpressionValue(var10001, "getUniqueId(...)");
            kills = ((Number)var12.getOrDefault(var10001, 0)).intValue() + 1;
            this.hopKills.put(killer.getUniqueId(), kills);
            if (kills >= 10) {
               this.completeChallenge(killer, "Hop");
            }
         }

         if (event.getEntity() instanceof Vindicator && !this.completedChallenges.contains("Vindicator")) {
            var12 = this.vindicatorKills;
            var10001 = killer.getUniqueId();
            Intrinsics.checkNotNullExpressionValue(var10001, "getUniqueId(...)");
            kills = ((Number)var12.getOrDefault(var10001, 0)).intValue() + 1;
            this.vindicatorKills.put(killer.getUniqueId(), kills);
            if (kills >= 100) {
               this.completeChallenge(killer, "Vindicator");
            }
         }

         if (event.getEntity() instanceof Warden && !this.completedChallenges.contains("Shadowstep")) {
            ItemStack[] var13 = killer.getInventory().getArmorContents();
            Intrinsics.checkNotNullExpressionValue(var13, "getArmorContents(...)");
            ItemStack[] armor = var13;
            Object[] $this$all$iv = armor;
            int $i$f$all = false;
            int var6 = 0;
            int var7 = armor.length;

            boolean var14;
            while(true) {
               if (var6 >= var7) {
                  var14 = true;
                  break;
               }

               Object element$iv = $this$all$iv[var6];
               int var10 = false;
               if (element$iv != null && element$iv.getType() != Material.AIR) {
                  var14 = false;
                  break;
               }

               ++var6;
            }

            if (var14) {
               this.completeChallenge(killer, "Shadowstep");
            }
         }

      }
   }

   @EventHandler
   public final void onTotemPop(@NotNull EntityResurrectEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      LivingEntity var4 = event.getEntity();
      Player var10000 = var4 instanceof Player ? (Player)var4 : null;
      if ((var4 instanceof Player ? (Player)var4 : null) != null) {
         Player player = var10000;
         Material var5 = player.getInventory().getItemInMainHand().getType();
         Intrinsics.checkNotNullExpressionValue(var5, "getType(...)");
         Material mainHand = var5;
         var5 = player.getInventory().getItemInOffHand().getType();
         Intrinsics.checkNotNullExpressionValue(var5, "getType(...)");
         Material offHand = var5;
         if (mainHand == Material.TOTEM_OF_UNDYING || offHand == Material.TOTEM_OF_UNDYING) {
            if (this.completedChallenges.contains("Resurrection")) {
               return;
            }

            this.completeChallenge(player, "Resurrection");
         }

      }
   }

   @EventHandler
   public final void onChargedCreeperKill(@NotNull EntityDeathEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      LivingEntity var4 = event.getEntity();
      Creeper var10000 = var4 instanceof Creeper ? (Creeper)var4 : null;
      if ((var4 instanceof Creeper ? (Creeper)var4 : null) != null) {
         Creeper entity = var10000;
         if (entity.isPowered()) {
            Player var5 = entity.getKiller();
            if (var5 != null) {
               Player killer = var5;
               if (!this.completedChallenges.contains("Conductor")) {
                  this.completeChallenge(killer, "Conductor");
               }
            }
         }
      }
   }

   @EventHandler
   public final void onFrostDamage(@NotNull EntityDamageByEntityEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      Entity var4 = event.getDamager();
      Snowball var10000 = var4 instanceof Snowball ? (Snowball)var4 : null;
      if ((var4 instanceof Snowball ? (Snowball)var4 : null) != null) {
         Snowball snowball = var10000;
         ProjectileSource var5 = snowball.getShooter();
         Player var8 = var5 instanceof Player ? (Player)var5 : null;
         if ((var5 instanceof Player ? (Player)var5 : null) != null) {
            Player shooter = var8;
            Entity var6 = event.getEntity();
            Blaze var9 = var6 instanceof Blaze ? (Blaze)var6 : null;
            if ((var6 instanceof Blaze ? (Blaze)var6 : null) != null) {
               Blaze blaze = var9;
               if (!this.completedChallenges.contains("Frost")) {
                  if (Intrinsics.areEqual(blaze.getWorld().getName(), "world")) {
                     if (blaze.getHealth() - event.getFinalDamage() <= 0.0D) {
                        this.completeChallenge(shooter, "Frost");
                     }

                  }
               }
            }
         }
      }
   }

   @EventHandler
   public final void onBlockBreak(@NotNull BlockBreakEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      Player var10000 = event.getPlayer();
      Intrinsics.checkNotNullExpressionValue(var10000, "getPlayer(...)");
      Player player = var10000;
      UUID var10001;
      int count;
      Map var4;
      if (!this.completedChallenges.contains("Spider") && StringsKt.contains$default((CharSequence)event.getBlock().getType().name(), (CharSequence)"SPAWNER", false, 2, (Object)null)) {
         var4 = this.spiderBreaks;
         var10001 = player.getUniqueId();
         Intrinsics.checkNotNullExpressionValue(var10001, "getUniqueId(...)");
         count = ((Number)var4.getOrDefault(var10001, 0)).intValue() + 1;
         this.spiderBreaks.put(player.getUniqueId(), count);
         if (count >= 10) {
            this.completeChallenge(player, "Spider");
         }
      }

      if (!this.completedChallenges.contains("Overdrive") && event.getBlock().getType() == Material.OBSIDIAN) {
         var4 = this.overdriveMined;
         var10001 = player.getUniqueId();
         Intrinsics.checkNotNullExpressionValue(var10001, "getUniqueId(...)");
         count = ((Number)var4.getOrDefault(var10001, 0)).intValue() + 1;
         this.overdriveMined.put(player.getUniqueId(), count);
         if (count >= 500) {
            this.completeChallenge(player, "Overdrive");
         }
      }

   }

   @EventHandler
   public final void onEat(@NotNull PlayerItemConsumeEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      Player var10000 = event.getPlayer();
      Intrinsics.checkNotNullExpressionValue(var10000, "getPlayer(...)");
      Player player = var10000;
      if (!this.completedChallenges.contains("Health")) {
         if (event.getItem().getType() == Material.ENCHANTED_GOLDEN_APPLE) {
            Map var4 = this.healthEaten;
            UUID var10001 = player.getUniqueId();
            Intrinsics.checkNotNullExpressionValue(var10001, "getUniqueId(...)");
            int count = ((Number)var4.getOrDefault(var10001, 0)).intValue() + 1;
            this.healthEaten.put(player.getUniqueId(), count);
            if (count >= 5) {
               this.completeChallenge(player, "Health");
            }

         }
      }
   }

   @EventHandler
   public final void onAdvancement(@NotNull PlayerAdvancementDoneEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      Player var10000 = event.getPlayer();
      Intrinsics.checkNotNullExpressionValue(var10000, "getPlayer(...)");
      Player player = var10000;
      if (Intrinsics.areEqual(event.getAdvancement().getKey().getKey(), "adventure/fall_from_world_height") && !this.completedChallenges.contains("Feather")) {
         this.completeChallenge(player, "Feather");
      }

      if (Intrinsics.areEqual(event.getAdvancement().getKey().getKey(), "nether/all_potions") && !this.completedChallenges.contains("Alchemist")) {
         this.completeChallenge(player, "Alchemist");
      }

   }

   @EventHandler
   public final void onCraft(@NotNull CraftItemEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      HumanEntity var4 = event.getWhoClicked();
      Player var10000 = var4 instanceof Player ? (Player)var4 : null;
      if ((var4 instanceof Player ? (Player)var4 : null) != null) {
         Player player = var10000;
         if (!this.completedChallenges.contains("Spotlight")) {
            ItemStack var6 = event.getCurrentItem();
            if (var6 != null) {
               ItemStack item = var6;
               if (item.getType() == Material.SPECTRAL_ARROW) {
                  Map var7 = this.spectralArrowsCrafted;
                  UUID var10001 = player.getUniqueId();
                  Intrinsics.checkNotNullExpressionValue(var10001, "getUniqueId(...)");
                  int count = ((Number)var7.getOrDefault(var10001, 0)).intValue() + item.getAmount();
                  this.spectralArrowsCrafted.put(player.getUniqueId(), count);
                  if (count >= 1) {
                     this.completeChallenge(player, "Spotlight");
                  }

               }
            }
         }
      }
   }

   @EventHandler
   public final void onPlayerMove(@NotNull PlayerMoveEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      Player var10000 = event.getPlayer();
      Intrinsics.checkNotNullExpressionValue(var10000, "getPlayer(...)");
      Player player = var10000;
      if (!this.completedChallenges.contains("Phase")) {
         UUID var10001;
         if (player.getWorld().getEnvironment() == Environment.NETHER && player.getLocation().getY() >= 127.0D && !this.phaseReached.contains(player.getUniqueId())) {
            Set var9 = this.phaseReached;
            var10001 = player.getUniqueId();
            Intrinsics.checkNotNullExpressionValue(var10001, "getUniqueId(...)");
            var9.add(var10001);
            this.completeChallenge(player, "Phase");
         }

         if (player.isGliding() && !this.completedChallenges.contains("Glide")) {
            Map var10 = this.glideDistance;
            var10001 = player.getUniqueId();
            Intrinsics.checkNotNullExpressionValue(var10001, "getUniqueId(...)");
            double last = ((Number)var10.getOrDefault(var10001, 0.0D)).doubleValue();
            double dist = event.getFrom().distance(event.getTo());
            double total = last + dist;
            this.glideDistance.put(player.getUniqueId(), total);
            if (total >= 25000.0D) {
               this.completeChallenge(player, "Glide");
            }

         }
      }
   }

   @EventHandler
   public final void onShieldBlock(@NotNull EntityDamageEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      Entity var4 = event.getEntity();
      Player var10000 = var4 instanceof Player ? (Player)var4 : null;
      if ((var4 instanceof Player ? (Player)var4 : null) != null) {
         Player player = var10000;
         if (!this.completedChallenges.contains("Shield")) {
            if (event.getCause() == DamageCause.PROJECTILE) {
               if (player.getInventory().getItemInMainHand().getType() == Material.SHIELD || player.getInventory().getItemInOffHand().getType() == Material.SHIELD) {
                  Map var5 = this.shieldBlocks;
                  UUID var10001 = player.getUniqueId();
                  Intrinsics.checkNotNullExpressionValue(var10001, "getUniqueId(...)");
                  int count = ((Number)var5.getOrDefault(var10001, 0)).intValue() + 1;
                  this.shieldBlocks.put(player.getUniqueId(), count);
                  if (count >= 100) {
                     this.completeChallenge(player, "Shield");
                  }

               }
            }
         }
      }
   }

   @EventHandler
   public final void onDismantleEat(@NotNull PlayerItemConsumeEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      Player var10000 = event.getPlayer();
      Intrinsics.checkNotNullExpressionValue(var10000, "getPlayer(...)");
      Player player = var10000;
      if (!this.completedChallenges.contains("Dismantle")) {
         if (event.getItem().getType() == Material.GOLDEN_APPLE) {
            Map var8 = this.dismantleProgress;
            UUID var10001 = player.getUniqueId();
            Intrinsics.checkNotNullExpressionValue(var10001, "getUniqueId(...)");
            Triple var3 = (Triple)var8.getOrDefault(var10001, new Triple(0, 0, 0));
            int apples = ((Number)var3.component1()).intValue();
            int webs = ((Number)var3.component2()).intValue();
            int xp = ((Number)var3.component3()).intValue();
            Triple newProgress = new Triple(apples + 1, webs, xp);
            this.dismantleProgress.put(player.getUniqueId(), newProgress);
            if (((Number)newProgress.getFirst()).intValue() >= 64 && ((Number)newProgress.getSecond()).intValue() >= 64 && ((Number)newProgress.getThird()).intValue() >= 640) {
               this.completeChallenge(player, "Dismantle");
            }

         }
      }
   }

   @EventHandler
   public final void onDismantlePlace(@NotNull BlockPlaceEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      Player var10000 = event.getPlayer();
      Intrinsics.checkNotNullExpressionValue(var10000, "getPlayer(...)");
      Player player = var10000;
      if (!this.completedChallenges.contains("Dismantle")) {
         if (event.getBlock().getType() == Material.COBWEB) {
            Map var8 = this.dismantleProgress;
            UUID var10001 = player.getUniqueId();
            Intrinsics.checkNotNullExpressionValue(var10001, "getUniqueId(...)");
            Triple var3 = (Triple)var8.getOrDefault(var10001, new Triple(0, 0, 0));
            int apples = ((Number)var3.component1()).intValue();
            int webs = ((Number)var3.component2()).intValue();
            int xp = ((Number)var3.component3()).intValue();
            Triple newProgress = new Triple(apples, webs + 1, xp);
            this.dismantleProgress.put(player.getUniqueId(), newProgress);
            if (((Number)newProgress.getFirst()).intValue() >= 64 && ((Number)newProgress.getSecond()).intValue() >= 64 && ((Number)newProgress.getThird()).intValue() >= 640) {
               this.completeChallenge(player, "Dismantle");
            }

         }
      }
   }

   @EventHandler
   public final void onDismantleXP(@NotNull PlayerExpChangeEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      Player var10000 = event.getPlayer();
      Intrinsics.checkNotNullExpressionValue(var10000, "getPlayer(...)");
      Player player = var10000;
      if (!this.completedChallenges.contains("Dismantle")) {
         Map var8 = this.dismantleProgress;
         UUID var10001 = player.getUniqueId();
         Intrinsics.checkNotNullExpressionValue(var10001, "getUniqueId(...)");
         Triple var3 = (Triple)var8.getOrDefault(var10001, new Triple(0, 0, 0));
         int apples = ((Number)var3.component1()).intValue();
         int webs = ((Number)var3.component2()).intValue();
         int xp = ((Number)var3.component3()).intValue();
         Triple newProgress = new Triple(apples, webs, xp + event.getAmount());
         this.dismantleProgress.put(player.getUniqueId(), newProgress);
         if (((Number)newProgress.getFirst()).intValue() >= 64 && ((Number)newProgress.getSecond()).intValue() >= 64 && ((Number)newProgress.getThird()).intValue() >= 640) {
            this.completeChallenge(player, "Dismantle");
         }

      }
   }

   @EventHandler
   public final void onAlchemistAdvancement(@NotNull PlayerAdvancementDoneEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      Player var10000 = event.getPlayer();
      Intrinsics.checkNotNullExpressionValue(var10000, "getPlayer(...)");
      Player player = var10000;
      if (!this.completedChallenges.contains("Alchemist")) {
         if (Intrinsics.areEqual(event.getAdvancement().getKey().getKey(), "nether/all_potions")) {
            if (!this.alchemistDone.contains(player.getUniqueId())) {
               Set var3 = this.alchemistDone;
               UUID var10001 = player.getUniqueId();
               Intrinsics.checkNotNullExpressionValue(var10001, "getUniqueId(...)");
               var3.add(var10001);
               this.completeChallenge(player, "Alchemist");
               this.saveChallenges();
            }
         }
      }
   }

   @EventHandler
   public final void onVillagerTrade(@NotNull PlayerInteractEntityEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      Player var10000 = event.getPlayer();
      Intrinsics.checkNotNullExpressionValue(var10000, "getPlayer(...)");
      Player player = var10000;
      if (!this.completedChallenges.contains("Villager")) {
         Entity var5 = event.getRightClicked();
         if ((var5 instanceof Villager ? (Villager)var5 : null) != null) {
            Map var6 = this.villagerTrades;
            UUID var10001 = player.getUniqueId();
            Intrinsics.checkNotNullExpressionValue(var10001, "getUniqueId(...)");
            int trades = ((Number)var6.getOrDefault(var10001, 0)).intValue() + 1;
            this.villagerTrades.put(player.getUniqueId(), trades);
            if (trades >= 500) {
               this.completeChallenge(player, "Villager");
            }

         }
      }
   }

   @EventHandler
   public final void onConduitBuild(@NotNull BlockPlaceEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      Player var10000 = event.getPlayer();
      Intrinsics.checkNotNullExpressionValue(var10000, "getPlayer(...)");
      Player player = var10000;
      if (event.getBlock().getType() == Material.CONDUIT) {
         if (!this.completedChallenges.contains("Ocean")) {
            this.completeChallenge(player, "Ocean");
         }

      }
   }

   @EventHandler
   public final void onWitherSkeletonDrop(@NotNull EntityDeathEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      LivingEntity var10000 = event.getEntity();
      Intrinsics.checkNotNullExpressionValue(var10000, "getEntity(...)");
      LivingEntity entity = var10000;
      if (entity instanceof WitherSkeleton) {
         Player var15 = ((WitherSkeleton)entity).getKiller();
         if (var15 != null) {
            Player killer = var15;
            if (!this.completedChallenges.contains("Wither")) {
               EntityEquipment var16 = ((WitherSkeleton)entity).getEquipment();
               ItemStack drops = var16 != null ? var16.getItemInMainHand() : null;
               List var17 = event.getDrops();
               Intrinsics.checkNotNullExpressionValue(var17, "getDrops(...)");
               Iterable $this$count$iv = (Iterable)var17;
               int $i$f$count = false;
               int var18;
               if ($this$count$iv instanceof Collection && ((Collection)$this$count$iv).isEmpty()) {
                  var18 = 0;
               } else {
                  int count$iv = 0;
                  Iterator var9 = $this$count$iv.iterator();

                  while(var9.hasNext()) {
                     Object element$iv = var9.next();
                     ItemStack it = (ItemStack)element$iv;
                     int var12 = false;
                     if (it.getType() == Material.WITHER_SKELETON_SKULL) {
                        ++count$iv;
                        if (count$iv < 0) {
                           CollectionsKt.throwCountOverflow();
                        }
                     }
                  }

                  var18 = count$iv;
               }

               int skulls = var18;
               if (skulls > 0) {
                  Map var19 = this.witherSkulls;
                  UUID var10001 = killer.getUniqueId();
                  Intrinsics.checkNotNullExpressionValue(var10001, "getUniqueId(...)");
                  int current = ((Number)var19.getOrDefault(var10001, 0)).intValue();
                  int total = current + skulls;
                  this.witherSkulls.put(killer.getUniqueId(), total);
                  if (total >= 5) {
                     this.completeChallenge(killer, "Wither");
                  }
               }

            }
         }
      }
   }
}
