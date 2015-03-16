package jp.koushin_lawfirm.www.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderAtsushi extends RenderLiving {

	public RenderAtsushi(ModelBase p_i1262_1_, float p_i1262_2_) {
		super(p_i1262_1_, p_i1262_2_);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
		// TODO 自動生成されたメソッド・スタブ
		return new ResourceLocation("koushingeneralmod:entities/atsushi.png");
	}

}
