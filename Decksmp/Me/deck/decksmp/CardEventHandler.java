/* Decompiler 582ms, total 809ms, lines 1000 */
package me.deck.decksmp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import me.deck.decksmp.adv.FeatherCardListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.projectiles.ProjectileSource;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0018\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u0012H\u0002J\u0010\u0010#\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020$H\u0007J\u0010\u0010%\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020&H\u0007J\u0010\u0010'\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020(H\u0007J\b\u0010)\u001a\u00020\u001dH\u0002J\u0006\u0010*\u001a\u00020\u001dJ\u0010\u0010+\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020\u0012H\u0002J\u0010\u0010-\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020\u0012H\u0002J\u0010\u0010.\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020\u0012H\u0002J\u0010\u0010/\u001a\u00020\u001d2\u0006\u00100\u001a\u00020\u0012H\u0002J\u0018\u00101\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020\u00122\u0006\u00102\u001a\u00020\u0016H\u0002J\u0010\u00103\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020\u0012H\u0002J\u0010\u00104\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020\u0012H\u0002J\u0010\u00105\u001a\u0002062\u0006\u00107\u001a\u000206H\u0002J\u0010\u00108\u001a\u0002062\u0006\u00107\u001a\u000206H\u0002J\u0010\u00109\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020:H\u0007J\u0010\u0010;\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\b\u0010<\u001a\u00020\u001dH\u0002J\b\u0010=\u001a\u00020\u001dH\u0002J\u000e\u0010>\u001a\u00020\u001d2\u0006\u00100\u001a\u00020\u0012J\u000e\u0010?\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u0003J\u000e\u0010@\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00190\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006A"},
   d2 = {"Lme/deck/decksmp/CardEventHandler;", "Lorg/bukkit/event/Listener;", "plugin", "Lorg/bukkit/plugin/java/JavaPlugin;", "<init>", "(Lorg/bukkit/plugin/java/JavaPlugin;)V", "dismantleAbility", "Lme/deck/decksmp/DismantleAbility;", "spiderAbility", "Lme/deck/decksmp/SpiderAbility;", "glideAbility", "LGlideAbility;", "hopAbility", "Lme/deck/decksmp/HopAbility;", "featherListener", "Lme/deck/decksmp/adv/FeatherCardListener;", "crouchingPlayers", "", "Lorg/bukkit/entity/Player;", "resurrectingPlayers", "resurrectionCooldowns", "", "", "resurrectionNotified", "holograms", "Lorg/bukkit/entity/ArmorStand;", "getHolograms", "()Ljava/util/Map;", "onPlayerHit", "", "event", "Lorg/bukkit/event/entity/EntityDamageByEntityEvent;", "handleShieldCard", "attacker", "target", "onPlayerToggleSneak", "Lorg/bukkit/event/player/PlayerToggleSneakEvent;", "onPlayerInteract", "Lorg/bukkit/event/player/PlayerInteractEvent;", "onPlayerMove", "Lorg/bukkit/event/player/PlayerMoveEvent;", "startPassiveLoop", "startSpotlightHologramLoop", "handleOceanCard", "player", "handleShadowstepCard", "handleVillagerCard", "handleSpotlightCard", "holder", "repairArmor", "amount", "applyNetheriteCard", "revertNetheriteToDiamond", "convertDiamondToNetherite", "Lorg/bukkit/inventory/ItemStack;", "item", "convertNetheriteToDiamond", "onFallDamage", "Lorg/bukkit/event/entity/EntityDamageEvent;", "onArrowHit", "startOneMinuteLoop", "startResurrectionCooldownLoop", "updateHealthHologram", "startHologramCleanupLoop", "startHealthHologramTask", "decksmp"}
)
@SourceDebugExtension({"SMAP\nuseingcards(hell).kt\nKotlin\n*S Kotlin\n*F\n+ 1 useingcards(hell).kt\nme/deck/decksmp/CardEventHandler\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,453:1\n37#2,2:454\n37#2,2:456\n37#2,2:458\n37#2,2:460\n1761#3,3:462\n1761#3,3:465\n1761#3,3:468\n1869#3,2:471\n774#3:473\n865#3,2:474\n1869#3,2:476\n*S KotlinDebug\n*F\n+ 1 useingcards(hell).kt\nme/deck/decksmp/CardEventHandler\n*L\n261#1:454,2\n262#1:456,2\n272#1:458,2\n273#1:460,2\n319#1:462,3\n332#1:465,3\n384#1:468,3\n386#1:471,2\n405#1:473\n405#1:474,2\n406#1:476,2\n*E\n"})
public final class CardEventHandler implements Listener {
   @NotNull
   private final JavaPlugin plugin;
   @NotNull
   private final DismantleAbility dismantleAbility;
   @NotNull
   private final SpiderAbility spiderAbility;
   @NotNull
   private final GlideAbility glideAbility;
   @NotNull
   private final HopAbility hopAbility;
   @NotNull
   private final FeatherCardListener featherListener;
   @NotNull
   private final Set<Player> crouchingPlayers;
   @NotNull
   private final Set<Player> resurrectingPlayers;
   @NotNull
   private final Map<Player, Integer> resurrectionCooldowns;
   @NotNull
   private final Set<Player> resurrectionNotified;
   @NotNull
   private final Map<Player, ArmorStand> holograms;

   public CardEventHandler(@NotNull JavaPlugin plugin) {
      Intrinsics.checkNotNullParameter(plugin, "plugin");
      super();
      this.plugin = plugin;
      this.dismantleAbility = new DismantleAbility(this.plugin);
      this.spiderAbility = new SpiderAbility(this.plugin);
      this.glideAbility = new GlideAbility(this.plugin);
      this.hopAbility = new HopAbility(this.plugin);
      this.featherListener = new FeatherCardListener(this.plugin);
      this.crouchingPlayers = (Set)(new LinkedHashSet());
      this.resurrectingPlayers = (Set)(new LinkedHashSet());
      this.resurrectionCooldowns = (Map)(new LinkedHashMap());
      this.resurrectionNotified = (Set)(new LinkedHashSet());
      this.holograms = (Map)(new LinkedHashMap());
      Bukkit.getPluginManager().registerEvents((Listener)this, (Plugin)this.plugin);
      this.featherListener.register();
      this.startPassiveLoop();
      this.startOneMinuteLoop();
      this.startResurrectionCooldownLoop();
      this.startSpotlightHologramLoop();
      this.startHologramCleanupLoop(this.plugin);
   }

   @NotNull
   public final Map<Player, ArmorStand> getHolograms() {
      return this.holograms;
   }

   @EventHandler
   public final void onPlayerHit(@NotNull EntityDamageByEntityEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      Entity var4 = event.getDamager();
      Player var10000 = var4 instanceof Player ? (Player)var4 : null;
      if ((var4 instanceof Player ? (Player)var4 : null) != null) {
         Player damager = var10000;
         Entity var5 = event.getEntity();
         var10000 = var5 instanceof Player ? (Player)var5 : null;
         if ((var5 instanceof Player ? (Player)var5 : null) != null) {
            Player target = var10000;
            if (!ToggleCommand.Companion.getDisabledPlayers().contains(damager.getUniqueId())) {
               String[] var10 = (String[])CardVariables.INSTANCE.getEquippedCards().get(damager.getUniqueId().toString());
               if (var10 != null) {
                  String[] cards = var10;
                  Iterator var9 = ArraysKt.filterNotNull(cards).iterator();

                  while(var9.hasNext()) {
                     String cardName = (String)var9.next();
                     String var7 = ChatColor.stripColor(cardName);
                     if (var7 != null) {
                        switch(var7.hashCode()) {
                        case -1695437378:
                           if (var7.equals("BloodRush Card")) {
                              BloodRushAbility.INSTANCE.handleHit(damager);
                           }
                           break;
                        case -1042975319:
                           if (var7.equals("Conductor Card")) {
                              LightningStrikeAbility.INSTANCE.handleHit(damager, target);
                           }
                           break;
                        case -808958857:
                           if (var7.equals("Vindicator Card")) {
                              AxePullUtil.INSTANCE.pullTarget(damager, (LivingEntity)target);
                           }
                           break;
                        case -778738915:
                           if (var7.equals("Wither Card")) {
                              WitheringCurseAbility.INSTANCE.handleHit(damager, target);
                           }
                           break;
                        case 58054831:
                           if (var7.equals("Dismantle Card")) {
                              this.dismantleAbility.applyDismantle(damager, target);
                           }
                           break;
                        case 430226426:
                           if (var7.equals("Overdrive Card")) {
                              OverdriveAbility.Companion.handleAction(damager);
                           }
                           break;
                        case 1301061991:
                           if (var7.equals("Shield Card")) {
                              this.handleShieldCard(damager, target);
                           }
                           break;
                        case 1622894293:
                           if (var7.equals("Phase Card")) {
                              LuckyDodgeAbility.INSTANCE.tryDodge((EntityDamageEvent)event);
                           }
                           break;
                        case 1752332076:
                           if (var7.equals("Frost Card")) {
                              FrostAbility.INSTANCE.handleHit(damager);
                           }
                        }
                     }
                  }

               }
            }
         }
      }
   }

   private final void handleShieldCard(Player attacker, Player target) {
      if (!ToggleCommand.Companion.getDisabledPlayers().contains(attacker.getUniqueId())) {
         ItemStack var10000 = attacker.getInventory().getItemInMainHand();
         Intrinsics.checkNotNullExpressionValue(var10000, "getItemInMainHand(...)");
         ItemStack weapon = var10000;
         if (StringsKt.contains$default((CharSequence)weapon.getType().name(), (CharSequence)"AXE", false, 2, (Object)null)) {
            if (target.getInventory().getItemInOffHand().getType() == Material.SHIELD) {
               target.setCooldown(Material.SHIELD, 120);
            }

         }
      }
   }

   @EventHandler
   public final void onPlayerToggleSneak(@NotNull PlayerToggleSneakEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      Player var10000 = event.getPlayer();
      Intrinsics.checkNotNullExpressionValue(var10000, "getPlayer(...)");
      Player player = var10000;
      if (!ToggleCommand.Companion.getDisabledPlayers().contains(player.getUniqueId())) {
         if (event.isSneaking()) {
            this.crouchingPlayers.add(player);
            String[] var6 = (String[])CardVariables.INSTANCE.getEquippedCards().get(player.getUniqueId().toString());
            if (var6 == null) {
               return;
            }

            String[] cards = var6;
            Iterator var4 = ArraysKt.filterNotNull(cards).iterator();

            while(var4.hasNext()) {
               String cardName = (String)var4.next();
               if (Intrinsics.areEqual(ChatColor.stripColor(cardName), "Spider Card")) {
                  this.spiderAbility.activateSpiderEffect(player);
               }
            }
         } else {
            this.crouchingPlayers.remove(player);
         }

      }
   }

   @EventHandler
   public final void onPlayerInteract(@NotNull PlayerInteractEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      Player var10000 = event.getPlayer();
      Intrinsics.checkNotNullExpressionValue(var10000, "getPlayer(...)");
      Player player = var10000;
      if (!ToggleCommand.Companion.getDisabledPlayers().contains(player.getUniqueId())) {
         String[] var6 = (String[])CardVariables.INSTANCE.getEquippedCards().get(player.getUniqueId().toString());
         if (var6 != null) {
            String[] cards = var6;
            Iterator var4 = ArraysKt.filterNotNull(cards).iterator();

            while(var4.hasNext()) {
               String cardName = (String)var4.next();
               if (Intrinsics.areEqual(ChatColor.stripColor(cardName), "Dragon Egg") && event.getAction() != Action.LEFT_CLICK_AIR && event.getAction() == Action.LEFT_CLICK_BLOCK) {
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
      if (!ToggleCommand.Companion.getDisabledPlayers().contains(player.getUniqueId())) {
         Location var12 = event.getFrom();
         Intrinsics.checkNotNullExpressionValue(var12, "getFrom(...)");
         Location from = var12;
         var12 = event.getTo();
         if (var12 != null) {
            Location to = var12;
            double velocityY = to.getY() - from.getY();
            boolean isJumping = velocityY > 0.1D && !player.isOnGround();
            if (isJumping && this.crouchingPlayers.contains(player)) {
               String[] var13 = (String[])CardVariables.INSTANCE.getEquippedCards().get(player.getUniqueId().toString());
               if (var13 != null) {
                  String[] cards = var13;
                  Iterator var9 = ArraysKt.filterNotNull(cards).iterator();

                  while(var9.hasNext()) {
                     String cardName = (String)var9.next();
                     String var11 = ChatColor.stripColor(cardName);
                     if (var11 != null) {
                        switch(var11.hashCode()) {
                        case -399903545:
                           if (var11.equals("Hop Card")) {
                              this.hopAbility.performHop(player);
                           }
                           break;
                        case 1086592747:
                           if (var11.equals("Glide Card")) {
                              this.glideAbility.startGlide(player);
                           }
                        }
                     }
                  }

               }
            }
         }
      }
   }

   private final void startPassiveLoop() {
      (new BukkitRunnable() {
         private int tickCounter;

         public final int getTickCounter() {
            return this.tickCounter;
         }

         public final void setTickCounter(int var1) {
            this.tickCounter = var1;
         }

         public void run() {
            int var1 = this.tickCounter++;
            Iterator var10 = Bukkit.getOnlinePlayers().iterator();

            while(true) {
               while(true) {
                  Player player;
                  do {
                     if (!var10.hasNext()) {
                        if (this.tickCounter >= 2147483627) {
                           this.tickCounter = 0;
                        }

                        return;
                     }

                     player = (Player)var10.next();
                  } while(ToggleCommand.Companion.getDisabledPlayers().contains(player.getUniqueId()));

                  String[] var10000 = (String[])CardVariables.INSTANCE.getEquippedCards().get(player.getUniqueId().toString());
                  if (var10000 != null) {
                     String[] cards = var10000;
                     Iterator var4 = ArraysKt.filterNotNull(cards).iterator();

                     CardEventHandler var14;
                     while(var4.hasNext()) {
                        String cardName = (String)var4.next();
                        String var6 = ChatColor.stripColor(cardName);
                        if (var6 != null) {
                           switch(var6.hashCode()) {
                           case -1911934098:
                              if (var6.equals("Netherite Card")) {
                                 var14 = CardEventHandler.this;
                                 Intrinsics.checkNotNull(player);
                                 var14.applyNetheriteCard(player);
                              }
                              break;
                           case -1355695420:
                              if (var6.equals("Shadowstep Card")) {
                                 var14 = CardEventHandler.this;
                                 Intrinsics.checkNotNull(player);
                                 var14.handleShadowstepCard(player);
                              }
                              break;
                           case -1004537430:
                              if (var6.equals("Villager Card")) {
                                 var14 = CardEventHandler.this;
                                 Intrinsics.checkNotNull(player);
                                 var14.handleVillagerCard(player);
                                 if (this.tickCounter % 20 == 0) {
                                    CardEventHandler.this.repairArmor(player, 5);
                                 }
                              }
                              break;
                           case 1374048924:
                              if (var6.equals("Spotlight Card")) {
                                 var14 = CardEventHandler.this;
                                 Intrinsics.checkNotNull(player);
                                 var14.handleSpotlightCard(player);
                              }
                              break;
                           case 2110517554:
                              if (var6.equals("Ocean Card")) {
                                 var14 = CardEventHandler.this;
                                 Intrinsics.checkNotNull(player);
                                 var14.handleOceanCard(player);
                              }
                           }
                        }
                     }

                     Iterable $this$any$iv = (Iterable)ArraysKt.filterNotNull(cards);
                     int $i$f$any = false;
                     boolean var15;
                     if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                        var15 = false;
                     } else {
                        Iterator var13 = $this$any$iv.iterator();

                        while(true) {
                           if (!var13.hasNext()) {
                              var15 = false;
                              break;
                           }

                           Object element$iv = var13.next();
                           String it = (String)element$iv;
                           int var9 = false;
                           if (Intrinsics.areEqual(ChatColor.stripColor(it), "Netherite Card")) {
                              var15 = true;
                              break;
                           }
                        }
                     }

                     if (!var15) {
                        var14 = CardEventHandler.this;
                        Intrinsics.checkNotNull(player);
                        var14.revertNetheriteToDiamond(player);
                     }
                  }
               }
            }
         }
      }).runTaskTimer((Plugin)this.plugin, 0L, 20L);
   }

   public final void startSpotlightHologramLoop() {
      (new BukkitRunnable() {
         public void run() {
            Iterator var1 = Bukkit.getOnlinePlayers().iterator();

            while(true) {
               while(true) {
                  Player holder;
                  do {
                     if (!var1.hasNext()) {
                        return;
                     }

                     holder = (Player)var1.next();
                  } while(ToggleCommand.Companion.getDisabledPlayers().contains(holder.getUniqueId()));

                  String[] var10000 = (String[])CardVariables.INSTANCE.getEquippedCards().get(holder.getUniqueId().toString());
                  if (var10000 != null) {
                     String[] cards = var10000;
                     Iterable $this$any$iv = (Iterable)ArraysKt.filterNotNull(cards);
                     int $i$f$any = false;
                     boolean var10;
                     if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                        var10 = false;
                     } else {
                        Iterator var6 = $this$any$iv.iterator();

                        while(true) {
                           if (!var6.hasNext()) {
                              var10 = false;
                              break;
                           }

                           Object element$iv = var6.next();
                           String it = (String)element$iv;
                           int var9 = false;
                           if (Intrinsics.areEqual(ChatColor.stripColor(it), "Spotlight Card")) {
                              var10 = true;
                              break;
                           }
                        }
                     }

                     if (var10) {
                        CardEventHandler var11 = CardEventHandler.this;
                        Intrinsics.checkNotNull(holder);
                        var11.updateHealthHologram(holder);
                     }
                  }
               }
            }
         }
      }).runTaskTimer((Plugin)this.plugin, 0L, 1L);
   }

   private final void handleOceanCard(Player player) {
      if (!ToggleCommand.Companion.getDisabledPlayers().contains(player.getUniqueId())) {
         if (player.isInWater()) {
            player.addPotionEffect(PotionEffectType.WATER_BREATHING.createEffect(60, 0));
         } else {
            player.addPotionEffect(PotionEffectType.CONDUIT_POWER.createEffect(60, 0));
         }

      }
   }

   private final void handleShadowstepCard(Player player) {
      if (!ToggleCommand.Companion.getDisabledPlayers().contains(player.getUniqueId())) {
         player.addPotionEffect(PotionEffectType.SPEED.createEffect(60, 1));
         long var2 = player.getWorld().getTime();
         if (13000L <= var2 ? var2 < 23001L : false) {
            player.addPotionEffect(PotionEffectType.INVISIBILITY.createEffect(60, 0));
         }

      }
   }

   private final void handleVillagerCard(Player player) {
      if (!ToggleCommand.Companion.getDisabledPlayers().contains(player.getUniqueId())) {
         player.addPotionEffect(PotionEffectType.HERO_OF_THE_VILLAGE.createEffect(60, 2));
      }
   }

   private final void handleSpotlightCard(Player holder) {
      if (!ToggleCommand.Companion.getDisabledPlayers().contains(holder.getUniqueId())) {
         double radius = 30.0D;
         TrustCommand trustPlugin = TrustCommand.Companion.get();
         Iterator var5 = holder.getWorld().getPlayers().iterator();

         while(var5.hasNext()) {
            Player player = (Player)var5.next();
            if (!Intrinsics.areEqual(player, holder) && player.getLocation().distance(holder.getLocation()) <= radius) {
               UUID var10001 = holder.getUniqueId();
               Intrinsics.checkNotNullExpressionValue(var10001, "getUniqueId(...)");
               UUID var10002 = player.getUniqueId();
               Intrinsics.checkNotNullExpressionValue(var10002, "getUniqueId(...)");
               if (!trustPlugin.isTrusted(var10001, var10002)) {
                  player.addPotionEffect(PotionEffectType.GLOWING.createEffect(50, 0));
               }
            }
         }

      }
   }

   private final void repairArmor(Player player, int amount) {
      if (!ToggleCommand.Companion.getDisabledPlayers().contains(player.getUniqueId())) {
         ItemStack[] var10000 = player.getInventory().getArmorContents();
         Intrinsics.checkNotNullExpressionValue(var10000, "getArmorContents(...)");
         ItemStack[] armor = var10000;
         boolean repaired = false;
         int i = 0;

         for(int var6 = armor.length; i < var6; ++i) {
            ItemStack var10 = armor[i];
            if (armor[i] != null) {
               ItemStack item = var10;
               if (item.getType().getMaxDurability() > 0) {
                  ItemMeta var9 = item.getItemMeta();
                  Damageable var11 = var9 instanceof Damageable ? (Damageable)var9 : null;
                  if ((var9 instanceof Damageable ? (Damageable)var9 : null) != null) {
                     Damageable meta = var11;
                     if (meta.hasDamage()) {
                        meta.setDamage(RangesKt.coerceAtLeast(meta.getDamage() - amount, 0));
                        item.setItemMeta((ItemMeta)meta);
                        armor[i] = item;
                        repaired = true;
                     }
                  }
               }
            }
         }

         if (repaired) {
            player.getInventory().setArmorContents(armor);
         }

      }
   }

   private final void applyNetheriteCard(Player player) {
      if (!ToggleCommand.Companion.getDisabledPlayers().contains(player.getUniqueId())) {
         ItemStack[] var10000 = player.getInventory().getArmorContents();
         Intrinsics.checkNotNullExpressionValue(var10000, "getArmorContents(...)");
         Object[] var8 = (Object[])var10000;
         ItemStack[] var10001 = player.getInventory().getContents();
         Intrinsics.checkNotNullExpressionValue(var10001, "getContents(...)");
         ItemStack[] armorTools = (ItemStack[])ArraysKt.plus(var8, (Object[])var10001);
         int i = 0;

         for(int var4 = armorTools.length; i < var4; ++i) {
            ItemStack var9 = armorTools[i];
            if (armorTools[i] != null) {
               ItemStack item = var9;
               armorTools[i] = this.convertDiamondToNetherite(item);
            }
         }

         PlayerInventory var10 = player.getInventory();
         Collection $this$toTypedArray$iv = (Collection)ArraysKt.take(armorTools, 4);
         int $i$f$toTypedArray = false;
         var10.setArmorContents((ItemStack[])$this$toTypedArray$iv.toArray(new ItemStack[0]));
         var10 = player.getInventory();
         $this$toTypedArray$iv = (Collection)ArraysKt.drop(armorTools, 4);
         $i$f$toTypedArray = false;
         var10.setContents((ItemStack[])$this$toTypedArray$iv.toArray(new ItemStack[0]));
      }
   }

   private final void revertNetheriteToDiamond(Player player) {
      if (!ToggleCommand.Companion.getDisabledPlayers().contains(player.getUniqueId())) {
         ItemStack[] var10000 = player.getInventory().getArmorContents();
         Intrinsics.checkNotNullExpressionValue(var10000, "getArmorContents(...)");
         Object[] var8 = (Object[])var10000;
         ItemStack[] var10001 = player.getInventory().getContents();
         Intrinsics.checkNotNullExpressionValue(var10001, "getContents(...)");
         ItemStack[] armorTools = (ItemStack[])ArraysKt.plus(var8, (Object[])var10001);
         int i = 0;

         for(int var4 = armorTools.length; i < var4; ++i) {
            ItemStack var9 = armorTools[i];
            if (armorTools[i] != null) {
               ItemStack item = var9;
               armorTools[i] = this.convertNetheriteToDiamond(item);
            }
         }

         PlayerInventory var10 = player.getInventory();
         Collection $this$toTypedArray$iv = (Collection)ArraysKt.take(armorTools, 4);
         int $i$f$toTypedArray = false;
         var10.setArmorContents((ItemStack[])$this$toTypedArray$iv.toArray(new ItemStack[0]));
         var10 = player.getInventory();
         $this$toTypedArray$iv = (Collection)ArraysKt.drop(armorTools, 4);
         $i$f$toTypedArray = false;
         var10.setContents((ItemStack[])$this$toTypedArray$iv.toArray(new ItemStack[0]));
      }
   }

   private final ItemStack convertDiamondToNetherite(ItemStack item) {
      Pair[] var3 = new Pair[]{TuplesKt.to(Material.DIAMOND_SWORD, Material.NETHERITE_SWORD), TuplesKt.to(Material.DIAMOND_PICKAXE, Material.NETHERITE_PICKAXE), TuplesKt.to(Material.DIAMOND_AXE, Material.NETHERITE_AXE), TuplesKt.to(Material.DIAMOND_SHOVEL, Material.NETHERITE_SHOVEL), TuplesKt.to(Material.DIAMOND_HOE, Material.NETHERITE_HOE), TuplesKt.to(Material.DIAMOND_HELMET, Material.NETHERITE_HELMET), TuplesKt.to(Material.DIAMOND_CHESTPLATE, Material.NETHERITE_CHESTPLATE), TuplesKt.to(Material.DIAMOND_LEGGINGS, Material.NETHERITE_LEGGINGS), TuplesKt.to(Material.DIAMOND_BOOTS, Material.NETHERITE_BOOTS)};
      Map map = MapsKt.mapOf(var3);
      Material var10000 = (Material)map.get(item.getType());
      if (var10000 == null) {
         return item;
      } else {
         Material target = var10000;
         ItemStack newItem = new ItemStack(target, item.getAmount());
         newItem.setItemMeta(item.getItemMeta());
         return newItem;
      }
   }

   private final ItemStack convertNetheriteToDiamond(ItemStack item) {
      Pair[] var3 = new Pair[]{TuplesKt.to(Material.NETHERITE_SWORD, Material.DIAMOND_SWORD), TuplesKt.to(Material.NETHERITE_PICKAXE, Material.DIAMOND_PICKAXE), TuplesKt.to(Material.NETHERITE_AXE, Material.DIAMOND_AXE), TuplesKt.to(Material.NETHERITE_SHOVEL, Material.DIAMOND_SHOVEL), TuplesKt.to(Material.NETHERITE_HOE, Material.DIAMOND_HOE), TuplesKt.to(Material.NETHERITE_HELMET, Material.DIAMOND_HELMET), TuplesKt.to(Material.NETHERITE_CHESTPLATE, Material.DIAMOND_CHESTPLATE), TuplesKt.to(Material.NETHERITE_LEGGINGS, Material.DIAMOND_LEGGINGS), TuplesKt.to(Material.NETHERITE_BOOTS, Material.DIAMOND_BOOTS)};
      Map map = MapsKt.mapOf(var3);
      Material var10000 = (Material)map.get(item.getType());
      if (var10000 == null) {
         return item;
      } else {
         Material target = var10000;
         ItemStack newItem = new ItemStack(target, item.getAmount());
         newItem.setItemMeta(item.getItemMeta());
         return newItem;
      }
   }

   @EventHandler
   public final void onFallDamage(@NotNull EntityDamageEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      Entity var4 = event.getEntity();
      Player var10000 = var4 instanceof Player ? (Player)var4 : null;
      if ((var4 instanceof Player ? (Player)var4 : null) != null) {
         Player player = var10000;
         if (!ToggleCommand.Companion.getDisabledPlayers().contains(player.getUniqueId())) {
            String[] var11 = (String[])CardVariables.INSTANCE.getEquippedCards().get(player.getUniqueId().toString());
            if (var11 != null) {
               String[] cards = var11;
               if (event.getCause() == DamageCause.FALL) {
                  Iterable $this$any$iv = (Iterable)ArraysKt.filterNotNull(cards);
                  int $i$f$any = false;
                  boolean var12;
                  if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                     var12 = false;
                  } else {
                     Iterator var6 = $this$any$iv.iterator();

                     while(true) {
                        if (!var6.hasNext()) {
                           var12 = false;
                           break;
                        }

                        Object element$iv = var6.next();
                        String it = (String)element$iv;
                        int var9 = false;
                        if (Intrinsics.areEqual(ChatColor.stripColor(it), "Feather Card")) {
                           var12 = true;
                           break;
                        }
                     }
                  }

                  if (var12) {
                     event.setCancelled(true);
                  }
               }

            }
         }
      }
   }

   @EventHandler
   public final void onArrowHit(@NotNull EntityDamageByEntityEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      Entity var4 = event.getDamager();
      Arrow var10000 = var4 instanceof Arrow ? (Arrow)var4 : null;
      if ((var4 instanceof Arrow ? (Arrow)var4 : null) != null) {
         Arrow arrow = var10000;
         ProjectileSource var5 = arrow.getShooter();
         Player var14 = var5 instanceof Player ? (Player)var5 : null;
         if ((var5 instanceof Player ? (Player)var5 : null) != null) {
            Player shooter = var14;
            if (!ToggleCommand.Companion.getDisabledPlayers().contains(shooter.getUniqueId())) {
               String[] var15 = (String[])CardVariables.INSTANCE.getEquippedCards().get(shooter.getUniqueId().toString());
               if (var15 != null) {
                  String[] cards = var15;
                  Iterable $this$any$iv = (Iterable)ArraysKt.filterNotNull(cards);
                  int $i$f$any = false;
                  boolean var16;
                  if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                     var16 = false;
                  } else {
                     Iterator var7 = $this$any$iv.iterator();

                     while(true) {
                        if (!var7.hasNext()) {
                           var16 = false;
                           break;
                        }

                        Object element$iv = var7.next();
                        String it = (String)element$iv;
                        int var10 = false;
                        if (Intrinsics.areEqual(ChatColor.stripColor(it), "Feather Card")) {
                           var16 = true;
                           break;
                        }
                     }
                  }

                  if (var16) {
                     Entity var17 = event.getEntity();
                     Intrinsics.checkNotNullExpressionValue(var17, "getEntity(...)");
                     Entity target = var17;
                     if (target instanceof LivingEntity) {
                        ((LivingEntity)target).addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 100, 0, false, false, true));
                     }

                  }
               }
            }
         }
      }
   }

   private final void startOneMinuteLoop() {
      (new BukkitRunnable() {
         public void run() {
            Iterator var1 = Bukkit.getOnlinePlayers().iterator();

            while(true) {
               while(true) {
                  Player player;
                  do {
                     if (!var1.hasNext()) {
                        return;
                     }

                     player = (Player)var1.next();
                  } while(ToggleCommand.Companion.getDisabledPlayers().contains(player.getUniqueId()));

                  String[] var10000 = (String[])CardVariables.INSTANCE.getEquippedCards().get(player.getUniqueId().toString());
                  if (var10000 != null) {
                     String[] cards = var10000;
                     Iterator var4 = ArraysKt.filterNotNull(cards).iterator();

                     while(var4.hasNext()) {
                        String cardName = (String)var4.next();
                        if (Intrinsics.areEqual(ChatColor.stripColor(cardName), "Alchemist Card")) {
                           AlchemistAbility var6 = AlchemistAbility.INSTANCE;
                           Intrinsics.checkNotNull(player);
                           var6.giveRandomEffect(player);
                        }
                     }
                  }
               }
            }
         }
      }).runTaskTimer((Plugin)this.plugin, 0L, 1200L);
   }

   private final void startResurrectionCooldownLoop() {
      (new BukkitRunnable() {
         public void run() {
            List toRemove = (List)(new ArrayList());
            Iterator var2 = CardEventHandler.this.resurrectionCooldowns.entrySet().iterator();

            while(var2.hasNext()) {
               Entry var3 = (Entry)var2.next();
               Player player = (Player)var3.getKey();
               int cd = ((Number)var3.getValue()).intValue();
               if (cd <= 1) {
                  toRemove.add(player);
                  if (!CardEventHandler.this.resurrectionNotified.contains(player)) {
                     player.sendMessage("§aResurrection is off cooldown!");
                     CardEventHandler.this.resurrectionNotified.add(player);
                  }
               } else {
                  CardEventHandler.this.resurrectionCooldowns.put(player, cd - 1);
               }
            }

            Iterable $this$forEach$iv = (Iterable)toRemove;
            CardEventHandler var10 = CardEventHandler.this;
            int $i$f$forEach = false;
            Iterator var12 = $this$forEach$iv.iterator();

            while(var12.hasNext()) {
               Object element$iv = var12.next();
               Player it = (Player)element$iv;
               int var8 = false;
               var10.resurrectionCooldowns.remove(it);
               var10.resurrectionNotified.remove(it);
            }

         }
      }).runTaskTimer((Plugin)this.plugin, 20L, 20L);
   }

   public final void updateHealthHologram(@NotNull Player holder) {
      Intrinsics.checkNotNullParameter(holder, "holder");
      if (!ToggleCommand.Companion.getDisabledPlayers().contains(holder.getUniqueId())) {
         String[] var10000 = (String[])CardVariables.INSTANCE.getEquippedCards().get(holder.getUniqueId().toString());
         if (var10000 != null) {
            String[] cards = var10000;
            Iterable $this$forEach$iv = (Iterable)ArraysKt.filterNotNull(cards);
            int $i$f$forEach = false;
            Iterator var5;
            Object element$iv;
            boolean $i$f$filterTo;
            boolean var25;
            if ($this$forEach$iv instanceof Collection && ((Collection)$this$forEach$iv).isEmpty()) {
               var25 = false;
            } else {
               var5 = $this$forEach$iv.iterator();

               while(true) {
                  if (!var5.hasNext()) {
                     var25 = false;
                     break;
                  }

                  element$iv = var5.next();
                  String it = (String)element$iv;
                  $i$f$filterTo = false;
                  if (Intrinsics.areEqual(ChatColor.stripColor(it), "Spotlight Card")) {
                     var25 = true;
                     break;
                  }
               }
            }

            if (!var25) {
               $this$forEach$iv = (Iterable)this.holograms.keySet();
               $i$f$forEach = false;
               var5 = $this$forEach$iv.iterator();

               while(var5.hasNext()) {
                  element$iv = var5.next();
                  Player victim = (Player)element$iv;
                  $i$f$filterTo = false;
                  ArmorStand var29 = (ArmorStand)this.holograms.get(victim);
                  if (var29 != null) {
                     var29.remove();
                  }
               }

               this.holograms.clear();
            } else {
               TrustCommand trustPlugin = TrustCommand.Companion.get();
               this.holograms.entrySet().removeIf(CardEventHandler::updateHealthHologram$lambda$3);
               List var26 = holder.getWorld().getPlayers();
               Intrinsics.checkNotNullExpressionValue(var26, "getPlayers(...)");
               Iterable $this$forEach$iv = (Iterable)var26;
               int $i$f$forEach = false;
               Collection destination$iv$iv = (Collection)(new ArrayList());
               $i$f$filterTo = false;
               Iterator var9 = $this$forEach$iv.iterator();

               while(var9.hasNext()) {
                  Object element$iv$iv = var9.next();
                  Player it = (Player)element$iv$iv;
                  int var12 = false;
                  if (!Intrinsics.areEqual(it, holder) && it.getLocation().distance(holder.getLocation()) <= 30.0D) {
                     destination$iv$iv.add(element$iv$iv);
                  }
               }

               $this$forEach$iv = (Iterable)((List)destination$iv$iv);
               $i$f$forEach = false;
               Iterator var16 = $this$forEach$iv.iterator();

               while(var16.hasNext()) {
                  Object element$iv = var16.next();
                  Player victim = (Player)element$iv;
                  int var21 = false;
                  UUID var10001 = holder.getUniqueId();
                  Intrinsics.checkNotNullExpressionValue(var10001, "getUniqueId(...)");
                  UUID var10002 = victim.getUniqueId();
                  Intrinsics.checkNotNullExpressionValue(var10002, "getUniqueId(...)");
                  if (!trustPlugin.isTrusted(var10001, var10002)) {
                     int var27 = (int)victim.getHealth();
                     String healthText = "§c" + var27 + "/" + (int)victim.getMaxHealth() + " ❤";
                     ArmorStand stand = (ArmorStand)this.holograms.get(victim);
                     if (stand != null && !stand.isDead()) {
                        stand.setCustomName(healthText);
                        stand.teleport(victim.getLocation().clone().add(0.0D, 2.0D, 0.0D));
                     } else {
                        Entity var28 = holder.getWorld().spawn(victim.getLocation().clone().add(0.0D, 2.0D, 0.0D), ArmorStand.class, CardEventHandler::updateHealthHologram$lambda$5$1);
                        Intrinsics.checkNotNullExpressionValue(var28, "spawn(...)");
                        ArmorStand newStand = (ArmorStand)var28;
                        this.holograms.put(victim, newStand);
                     }
                  }
               }

            }
         }
      }
   }

   public final void startHologramCleanupLoop(@NotNull JavaPlugin plugin) {
      Intrinsics.checkNotNullParameter(plugin, "plugin");
      (new BukkitRunnable() {
         public void run() {
            Iterable $this$forEach$iv = (Iterable)CardEventHandler.this.getHolograms().values();
            int $i$f$forEach = false;
            Iterator var3 = $this$forEach$iv.iterator();

            while(var3.hasNext()) {
               Object element$iv = var3.next();
               ArmorStand stand = (ArmorStand)element$iv;
               int var6 = false;
               if (!stand.isDead()) {
                  stand.remove();
               }
            }

            CardEventHandler.this.getHolograms().clear();
         }
      }).runTaskTimer((Plugin)plugin, 0L, 60L);
   }

   public final void startHealthHologramTask(@NotNull JavaPlugin plugin) {
      Intrinsics.checkNotNullParameter(plugin, "plugin");
      (new BukkitRunnable() {
         public void run() {
            Collection var10000 = Bukkit.getOnlinePlayers();
            Intrinsics.checkNotNullExpressionValue(var10000, "getOnlinePlayers(...)");
            Iterable $this$forEach$iv = (Iterable)var10000;
            CardEventHandler var2 = CardEventHandler.this;
            int $i$f$forEach = false;
            Iterator var4 = $this$forEach$iv.iterator();

            while(var4.hasNext()) {
               Object element$iv = var4.next();
               Player player = (Player)element$iv;
               int var7 = false;
               Intrinsics.checkNotNull(player);
               var2.updateHealthHologram(player);
            }

         }
      }).runTaskTimer((Plugin)plugin, 0L, 10L);
   }

   private static final boolean updateHealthHologram$lambda$2(Player $holder, Entry var1) {
      Intrinsics.checkNotNullParameter(var1, "<destruct>");
      Player victim = (Player)var1.getKey();
      ArmorStand stand = (ArmorStand)var1.getValue();
      boolean var10000;
      if (victim.isOnline() && Intrinsics.areEqual(victim.getWorld(), $holder.getWorld()) && victim.getLocation().distance($holder.getLocation()) <= 30.0D) {
         var10000 = false;
      } else {
         stand.remove();
         var10000 = true;
      }

      return var10000;
   }

   private static final boolean updateHealthHologram$lambda$3(Function1 $tmp0, Object p0) {
      return (Boolean)$tmp0.invoke(p0);
   }

   private static final Unit updateHealthHologram$lambda$5$0(String $healthText, ArmorStand asd) {
      asd.setInvisible(true);
      asd.setMarker(true);
      asd.setGravity(false);
      asd.setCustomNameVisible(true);
      asd.setCustomName($healthText);
      return Unit.INSTANCE;
   }

   private static final void updateHealthHologram$lambda$5$1(Function1 $tmp0, Object p0) {
      $tmp0.invoke(p0);
   }
}
