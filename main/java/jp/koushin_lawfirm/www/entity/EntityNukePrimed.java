package jp.koushin_lawfirm.www.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.world.World;
import static java.lang.Math.*;

public class EntityNukePrimed extends EntityTNTPrimed {

	public EntityNukePrimed(World world) {
		super(world);
	}

	public EntityNukePrimed(World world, double x, double y, double z,
			EntityLivingBase player) {
		super(world, x, y, z, player);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public void onUpdate() {
		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;
		this.motionY -= 0.03999999910593033D;
		this.moveEntity(this.motionX, this.motionY, this.motionZ);
		this.motionX *= 0.9800000190734863D;
		this.motionY *= 0.9800000190734863D;
		this.motionZ *= 0.9800000190734863D;

		if (this.onGround) {
			this.motionX *= 0.699999988079071D;
			this.motionZ *= 0.699999988079071D;
			this.motionY *= -0.5D;
		}

		if (this.fuse-- <= 0) {
			this.setDead();

			if (!this.worldObj.isRemote) {
				this.explode();
			}
		} else {
			this.worldObj.spawnParticle("smoke", this.posX, this.posY + 0.5D,
					this.posZ, 0.0D, 0.0D, 0.0D);
		}
	}

	private void explode() {
        worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "random.explode", 4.0F, (1.0F + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 0.2F) * 0.7F);
		float f = 100.0F;
		this.createNukeExplosion(this, this.posX, this.posY, this.posZ, f,
				this.worldObj);
	}

	private void createNukeExplosion(Entity enitity, double posX, double posY,
			double posZ, float strength, World world) {
		double baseX = posX - strength;
		double baseY = posY - strength;
		double baseZ = posZ - strength;

		for (int x = 0; x < strength * 2; x++) {
			for (int y = 0; y < strength * 2; y++) {
				for (int z = 0; z < strength * 2; z++) {
					double curX = baseX + x;
					double curY = baseY + y;
					double curZ = baseZ + z;
					if (abs(sqrt(pow(curX - posX, 2) + pow(curY - posY, 2)
							+ pow(curZ - posZ, 2))) < strength) {
						if (!(world
								.getBlock((int) round(curX), (int) round(curY),
										(int) round(curZ)).equals(Block.getBlockFromName("minecraft:bedrock")))) {
							world.setBlockToAir((int) round(curX),
									(int) round(curY), (int) round(curZ));
						}
					}
				}
			}
		}
	}

}
