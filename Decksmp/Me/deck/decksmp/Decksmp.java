/* Decompiler 122ms, total 281ms, lines 322 */
package me.deck.decksmp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import me.deck.decksmp.WithdrawCommand.CardDropOnDeath;
import me.deck.decksmp.adv.FeatherCardListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u00012\u00020\u0002:\u0001\u000eB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0006\u0010\b\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0006J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0007J\b\u0010\r\u001a\u00020\u0006H\u0002¨\u0006\u000f"},
   d2 = {"Lme/deck/decksmp/Decksmp;", "Lorg/bukkit/plugin/java/JavaPlugin;", "Lorg/bukkit/event/Listener;", "<init>", "()V", "onEnable", "", "onDisable", "saveCardVariables", "loadCardVariables", "onItemSpawn", "event", "Lorg/bukkit/event/entity/ItemSpawnEvent;", "startCardCheckLoop", "Companion", "decksmp"}
)
@SourceDebugExtension({"SMAP\nDecksmp.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Decksmp.kt\nme/deck/decksmp/Decksmp\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,556:1\n463#2:557\n413#2:558\n1252#3,4:559\n1761#3,3:563\n*S KotlinDebug\n*F\n+ 1 Decksmp.kt\nme/deck/decksmp/Decksmp\n*L\n179#1:557\n179#1:558\n179#1:559,4\n198#1:563,3\n*E\n"})
public final class Decksmp extends JavaPlugin implements Listener {
   @NotNull
   public static final Decksmp.Companion Companion = new Decksmp.Companion((DefaultConstructorMarker)null);
   public static Decksmp instance;
   private static boolean abilitiesEnabled = true;

   public void onEnable() {
      this.getLogger().info("Deck SMP plugin has started!");
      this.loadCardVariables();
      PluginCommand var10000 = this.getCommand("card");
      if (var10000 != null) {
         var10000.setExecutor((CommandExecutor)(new CardCommand()));
      }

      var10000 = this.getCommand("card");
      if (var10000 != null) {
         var10000.setTabCompleter((TabCompleter)(new CardCommand()));
      }

      var10000 = this.getCommand("withdraw");
      if (var10000 != null) {
         var10000.setExecutor((CommandExecutor)(new WithdrawCommand()));
      }

      var10000 = this.getCommand("withdraw");
      if (var10000 != null) {
         var10000.setTabCompleter((TabCompleter)(new WithdrawCommand()));
      }

      var10000 = this.getCommand("cards");
      if (var10000 != null) {
         var10000.setExecutor((CommandExecutor)(new CardGUICommand()));
      }

      var10000 = this.getCommand("cardinfo");
      if (var10000 != null) {
         var10000.setExecutor((CommandExecutor)(new CardInfoGUICommand(this)));
      }

      this.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)this);
      this.getServer().getPluginManager().registerEvents((Listener)(new CardUseListener(this)), (Plugin)this);
      this.getServer().getPluginManager().registerEvents((Listener)(new CardGUIListener(this)), (Plugin)this);
      this.getServer().getPluginManager().registerEvents((Listener)(new CardInfoGUICommand(this)), (Plugin)this);
      this.getServer().getPluginManager().registerEvents((Listener)(new CardEventHandler((JavaPlugin)this)), (Plugin)this);
      this.getServer().getPluginManager().registerEvents((Listener)(new CardDropOnDeath(this)), (Plugin)this);
      LightningStrikeAbility.INSTANCE.init((JavaPlugin)this);
      FrostAbility.INSTANCE.init((JavaPlugin)this);
      BloodRushAbility.INSTANCE.init((JavaPlugin)this);
      new ResurrectionAbility((JavaPlugin)this);
      new GlideAbility((JavaPlugin)this);
      ChallengesCommand challengesCommand = new ChallengesCommand((JavaPlugin)this);
      this.getServer().getPluginManager().registerEvents((Listener)challengesCommand, (Plugin)this);
      var10000 = this.getCommand("challenges");
      if (var10000 != null) {
         var10000.setExecutor((CommandExecutor)challengesCommand);
      }

      var10000 = this.getCommand("resetchallenges");
      if (var10000 != null) {
         var10000.setExecutor((CommandExecutor)challengesCommand);
      }

      FeatherCardListener featherListener = new FeatherCardListener((JavaPlugin)this);
      featherListener.register();
      this.startCardCheckLoop();
      new DragonEggAbility((JavaPlugin)this);
      new OceanCriticalAbility((JavaPlugin)this);
      WitheringCurseAbility.INSTANCE.init((JavaPlugin)this);
      var10000 = this.getCommand("toggle");
      if (var10000 != null) {
         var10000.setExecutor((CommandExecutor)(new ToggleCommand()));
      }

      TrustCommand.Companion.init((JavaPlugin)this);
      TrustCommand trustCommand = TrustCommand.Companion.get();
      var10000 = this.getCommand("trust");
      if (var10000 != null) {
         var10000.setExecutor((CommandExecutor)trustCommand);
      }

      var10000 = this.getCommand("trust");
      if (var10000 != null) {
         var10000.setTabCompleter((TabCompleter)trustCommand);
      }

      Companion.setInstance(this);
   }

   public void onDisable() {
      this.saveCardVariables();
      this.getLogger().info("Deck SMP plugin has stopped!");
   }

   public final void saveCardVariables() {
      FileConfiguration var10000 = this.getConfig();
      Map $this$mapValues$iv = CardVariables.INSTANCE.getEquippedCards();
      String var17 = "equippedCards";
      FileConfiguration var16 = var10000;
      int $i$f$mapValues = false;
      Map destination$iv$iv = (Map)(new LinkedHashMap(MapsKt.mapCapacity($this$mapValues$iv.size())));
      int $i$f$mapValuesTo = false;
      Iterable $this$associateByTo$iv$iv$iv = (Iterable)$this$mapValues$iv.entrySet();
      Map destination$iv$iv$iv = destination$iv$iv;
      int $i$f$associateByTo = false;
      Iterator var9 = $this$associateByTo$iv$iv$iv.iterator();

      while(var9.hasNext()) {
         Object element$iv$iv$iv = var9.next();
         Entry it$iv$iv = (Entry)element$iv$iv$iv;
         int var13 = false;
         Object var10001 = it$iv$iv.getKey();
         Entry it = (Entry)element$iv$iv$iv;
         Object var19 = var10001;
         int var15 = false;
         List var20 = ArraysKt.toList((Object[])it.getValue());
         destination$iv$iv$iv.put(var19, var20);
      }

      var16.set(var17, destination$iv$iv$iv);
      this.saveConfig();
   }

   public final void loadCardVariables() {
      if (this.getConfig().contains("equippedCards")) {
         ConfigurationSection var10000 = this.getConfig().getConfigurationSection("equippedCards");
         if (var10000 != null) {
            ConfigurationSection section = var10000;
            Iterator var2 = section.getKeys(false).iterator();

            while(var2.hasNext()) {
               String uuid = (String)var2.next();
               List var8 = section.getStringList(uuid);
               Intrinsics.checkNotNullExpressionValue(var8, "getStringList(...)");
               List list = var8;
               String[] array = new String[2];
               int i = 0;

               for(int var7 = ((Collection)list).size(); i < var7; ++i) {
                  array[i] = (String)list.get(i);
               }

               CardVariables.INSTANCE.getEquippedCards().put(uuid, array);
            }

         }
      }
   }

   @EventHandler
   public final void onItemSpawn(@NotNull ItemSpawnEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      Item var10000 = event.getEntity();
      Intrinsics.checkNotNullExpressionValue(var10000, "getEntity(...)");
      Item itemEntity = var10000;
      ItemStack var10 = itemEntity.getItemStack();
      Intrinsics.checkNotNullExpressionValue(var10, "getItemStack(...)");
      ItemStack itemStack = var10;
      Iterable $this$any$iv = (Iterable)Cards.INSTANCE.allCards().values();
      int $i$f$any = false;
      boolean var11;
      if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
         var11 = false;
      } else {
         Iterator var6 = $this$any$iv.iterator();

         while(true) {
            if (!var6.hasNext()) {
               var11 = false;
               break;
            }

            Object element$iv = var6.next();
            ItemStack it = (ItemStack)element$iv;
            int var9 = false;
            if (it.isSimilar(itemStack)) {
               var11 = true;
               break;
            }
         }
      }

      if (var11) {
         itemEntity.setGlowing(true);
      }

   }

   private final void startCardCheckLoop() {
      (new BukkitRunnable() {
         public void run() {
            Iterator var1 = Bukkit.getOnlinePlayers().iterator();

            while(var1.hasNext()) {
               Player player = (Player)var1.next();
               String var10000 = player.getUniqueId().toString();
               Intrinsics.checkNotNullExpressionValue(var10000, "toString(...)");
               String uuid = var10000;
               String[] var19 = (String[])CardVariables.INSTANCE.getEquippedCards().get(uuid);
               if (var19 == null) {
                  var19 = new String[2];
               }

               String[] slots = var19;
               int $i$f$map = false;
               String[] $this$mapTo$iv$iv = slots;
               Collection destination$iv$iv = (Collection)(new ArrayList(slots.length));
               int $i$f$mapTo = false;
               int var11 = 0;

               for(int var12 = slots.length; var11 < var12; ++var11) {
                  label25: {
                     Object item$iv$iv = $this$mapTo$iv$iv[var11];
                     int var15 = false;
                     if (item$iv$iv != null) {
                        int var17 = false;
                        var10000 = (String)Cards.INSTANCE.getCardEmojis().get(ChatColor.stripColor(item$iv$iv));
                        if (var10000 != null) {
                           break label25;
                        }
                     }

                     var10000 = "";
                  }

                  destination$iv$iv.add(var10000);
               }

               String message = CollectionsKt.joinToString$default((Iterable)((List)destination$iv$iv), (CharSequence)"   ", (CharSequence)null, (CharSequence)null, 0, (CharSequence)null, (Function1)null, 62, (Object)null);
               player.sendActionBar(String.valueOf(message));
            }

         }
      }).runTaskTimer((Plugin)this, 0L, 20L);
   }

   @Metadata(
      mv = {2, 2, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"},
      d2 = {"Lme/deck/decksmp/Decksmp$Companion;", "", "<init>", "()V", "instance", "Lme/deck/decksmp/Decksmp;", "getInstance", "()Lme/deck/decksmp/Decksmp;", "setInstance", "(Lme/deck/decksmp/Decksmp;)V", "abilitiesEnabled", "", "getAbilitiesEnabled", "()Z", "setAbilitiesEnabled", "(Z)V", "decksmp"}
   )
   public static final class Companion {
      private Companion() {
      }

      @NotNull
      public final Decksmp getInstance() {
         Decksmp var10000 = Decksmp.instance;
         if (var10000 != null) {
            return var10000;
         } else {
            Intrinsics.throwUninitializedPropertyAccessException("instance");
            return null;
         }
      }

      public final void setInstance(@NotNull Decksmp var1) {
         Intrinsics.checkNotNullParameter(var1, "<set-?>");
         Decksmp.instance = var1;
      }

      public final boolean getAbilitiesEnabled() {
         return Decksmp.abilitiesEnabled;
      }

      public final void setAbilitiesEnabled(boolean var1) {
         Decksmp.abilitiesEnabled = var1;
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }
}
