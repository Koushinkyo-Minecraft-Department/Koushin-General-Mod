package jp.koushin_lawfirm.www.core;

import jp.koushin_lawfirm.www.entity.EntityAtsushi;
import jp.koushin_lawfirm.www.entity.EntityLawyer;
import jp.koushin_lawfirm.www.entity.EntityNukePrimed;
import jp.koushin_lawfirm.www.entity.ModelAtsushi;
import jp.koushin_lawfirm.www.entity.RenderAtsushi;
import jp.koushin_lawfirm.www.entity.RenderLawyer;
import jp.koushin_lawfirm.www.entity.RenderNukePrimed;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelZombie;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		RenderingRegistry.registerEntityRenderingHandler(EntityLawyer.class,
				new RenderLawyer(new ModelZombie(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityNukePrimed.class,
				new RenderNukePrimed());
		RenderingRegistry.registerEntityRenderingHandler(EntityAtsushi.class,
				new RenderAtsushi(new ModelAtsushi(), 0.5F));


	}

	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
	}
}
