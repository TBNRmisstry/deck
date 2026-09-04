/* Decompiler 24ms, total 141ms, lines 75 */
package me.deck.decksmp;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¨\u0006\b"},
   d2 = {"Lme/deck/decksmp/GearConversion;", "Lorg/bukkit/event/Listener;", "<init>", "()V", "convertDiamondToNetherite", "Lorg/bukkit/inventory/ItemStack;", "item", "convertNetheriteToDiamond", "decksmp"}
)
public final class GearConversion implements Listener {
   @NotNull
   public static final GearConversion INSTANCE = new GearConversion();

   private GearConversion() {
   }

   @Nullable
   public final ItemStack convertDiamondToNetherite(@Nullable ItemStack item) {
      if (item == null) {
         return null;
      } else {
         Pair[] var3 = new Pair[]{TuplesKt.to(Material.DIAMOND_SWORD, Material.NETHERITE_SWORD), TuplesKt.to(Material.DIAMOND_PICKAXE, Material.NETHERITE_PICKAXE), TuplesKt.to(Material.DIAMOND_AXE, Material.NETHERITE_AXE), TuplesKt.to(Material.DIAMOND_SHOVEL, Material.NETHERITE_SHOVEL), TuplesKt.to(Material.DIAMOND_HOE, Material.NETHERITE_HOE), TuplesKt.to(Material.DIAMOND_HELMET, Material.NETHERITE_HELMET), TuplesKt.to(Material.DIAMOND_CHESTPLATE, Material.NETHERITE_CHESTPLATE), TuplesKt.to(Material.DIAMOND_LEGGINGS, Material.NETHERITE_LEGGINGS), TuplesKt.to(Material.DIAMOND_BOOTS, Material.NETHERITE_BOOTS)};
         Map diamondToNetherite = MapsKt.mapOf(var3);
         Material var10000 = (Material)diamondToNetherite.get(item.getType());
         if (var10000 == null) {
            return item;
         } else {
            Material targetMaterial = var10000;
            ItemStack newItem = new ItemStack(targetMaterial, item.getAmount());
            ItemMeta meta = item.getItemMeta();
            if (meta != null) {
               newItem.setItemMeta(meta);
            }

            return newItem;
         }
      }
   }

   @Nullable
   public final ItemStack convertNetheriteToDiamond(@Nullable ItemStack item) {
      if (item == null) {
         return null;
      } else {
         Pair[] var3 = new Pair[]{TuplesKt.to(Material.NETHERITE_SWORD, Material.DIAMOND_SWORD), TuplesKt.to(Material.NETHERITE_PICKAXE, Material.DIAMOND_PICKAXE), TuplesKt.to(Material.NETHERITE_AXE, Material.DIAMOND_AXE), TuplesKt.to(Material.NETHERITE_SHOVEL, Material.DIAMOND_SHOVEL), TuplesKt.to(Material.NETHERITE_HOE, Material.DIAMOND_HOE), TuplesKt.to(Material.NETHERITE_HELMET, Material.DIAMOND_HELMET), TuplesKt.to(Material.NETHERITE_CHESTPLATE, Material.DIAMOND_CHESTPLATE), TuplesKt.to(Material.NETHERITE_LEGGINGS, Material.DIAMOND_LEGGINGS), TuplesKt.to(Material.NETHERITE_BOOTS, Material.DIAMOND_BOOTS)};
         Map netheriteToDiamond = MapsKt.mapOf(var3);
         Material var10000 = (Material)netheriteToDiamond.get(item.getType());
         if (var10000 == null) {
            return item;
         } else {
            Material targetMaterial = var10000;
            ItemStack newItem = new ItemStack(targetMaterial, item.getAmount());
            ItemMeta meta = item.getItemMeta();
            if (meta != null) {
               newItem.setItemMeta(meta);
            }

            return newItem;
         }
      }
   }
}
