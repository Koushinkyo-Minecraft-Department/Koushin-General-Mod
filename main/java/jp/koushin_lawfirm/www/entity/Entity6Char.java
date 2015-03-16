package jp.koushin_lawfirm.www.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class Entity6Char extends EntityThrowable {
	public Entity6Char(World world) {
		super(world);
	}

	public Entity6Char(World world, double x, double y, double z) {
		super(world, x, y, z);
	}

	public Entity6Char(World world, EntityLivingBase livingBase) {
		super(world, livingBase);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	protected void onImpact(MovingObjectPosition pos) {
		if (pos.entityHit != null) {
			pos.entityHit.attackEntityFrom(
					DamageSource.causeThrownDamage(this, this.getThrower()),
					0.0F);
		}

		if (!this.worldObj.isRemote) {
			byte b0 = 1;
			if (Math.random() < 0.8) {
				for (int i = 0; i < b0; ++i) {

					EntityLawyer entityLawyer = new EntityLawyer(this.worldObj);
					entityLawyer.setLocationAndAngles(this.posX, this.posY,
							this.posZ, this.rotationYaw, 0.0F);
					this.worldObj.spawnEntityInWorld(entityLawyer);
				}
			} else {
				for (int i = 0; i < b0; ++i) {

					EntityAtsushi entityAtsushi = new EntityAtsushi(this.worldObj);
					entityAtsushi.setLocationAndAngles(this.posX, this.posY,
							this.posZ, this.rotationYaw, 0.0F);
					this.worldObj.spawnEntityInWorld(entityAtsushi);
				}
			}
		}

		for (int j = 0; j < 8; ++j) {
			this.worldObj.spawnParticle("snowballpoof", this.posX, this.posY,
					this.posZ, 0.0D, 0.0D, 0.0D);
		}

		if (!this.worldObj.isRemote) {
			this.setDead();
		}

	}

}
