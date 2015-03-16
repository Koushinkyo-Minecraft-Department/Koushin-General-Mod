package jp.koushin_lawfirm.www.core;

import jp.koushin_lawfirm.www.block.*;
import jp.koushin_lawfirm.www.entity.*;
import jp.koushin_lawfirm.www.item.*;
import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.BehaviorProjectileDispense;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = KoushinCore.MODID, version = KoushinCore.VERSION)
public class KoushinCore {

	// MODの初期設定
	public static final String MODID = "Koushin General Mod";
	public static final String VERSION = "0.1 Tsukushi-sonshi";
	@SidedProxy(clientSide = "jp.koushin_lawfirm.www.core.ClientProxy", serverSide = "jp.koushin_lawfirm.www.core.ServerProxy")
	public static CommonProxy proxy;

	// Items&Blocks
	public static Item6Char item6Char;

	public static BlockTNTNuke blockTNTNuke;

	// 以下init類
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		blockTNTNuke = new BlockTNTNuke();
		GameRegistry.registerBlock(blockTNTNuke, "Nuke");

		item6Char = new Item6Char();
		GameRegistry.registerItem(item6Char, "6Char");

		proxy.preInit(event);

	}

	@EventHandler
	public void init(FMLInitializationEvent event) {

		// 諸Entity
		EntityRegistry.registerModEntity(EntityLawyer.class, "Lawyer", 200,
				this, 80, 1, true);
		EntityRegistry.registerModEntity(Entity6Char.class, "6char", 201, this,
				128, 5, true);
		EntityRegistry.registerModEntity(EntityAtsushi.class, "Atsushi", 202,
				this, 80, 1, true);


		// Dispenser登録
		BlockDispenser.dispenseBehaviorRegistry.putObject(
				KoushinCore.item6Char, new BehaviorProjectileDispense() {

					protected IProjectile getProjectileEntity(World p_82499_1_,
							IPosition p_82499_2_) {
						return new Entity6Char(p_82499_1_, p_82499_2_.getX(),
								p_82499_2_.getY(), p_82499_2_.getZ());
					}
				});

		// 諸Recipe
		GameRegistry.addShapelessRecipe(new ItemStack(item6Char),
				Items.cooked_chicken,// 唐揚げ
				Items.fish,// 沢蟹
				Items.baked_potato,// コロッケ
				Items.cooked_porkchop// 酢豚
				);
		proxy.init(event);

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);

	}

}
