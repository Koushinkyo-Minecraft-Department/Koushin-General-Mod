package jp.koushin_lawfirm.www.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
@SideOnly(Side.CLIENT)
public class RenderLawyer extends RenderLiving {

	public RenderLawyer(ModelBase modelBase, float shadowSize) {
		super(modelBase, shadowSize);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
		// TODO 自動生成されたメソッド・スタブ
		return new ResourceLocation("koushingeneralmod:entities/lawyer.png");
	}

}
