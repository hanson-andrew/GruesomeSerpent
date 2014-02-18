package net.gruesomeserpent;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class MagicMissileEntity extends EntityThrowable {

  public MagicMissileEntity(World par1World, double par2, double par4, double par6) {
    super(par1World, par2, par4, par6);
    
  }

  public MagicMissileEntity(World par1World, EntityLivingBase par2EntityLivingBase) {
    super(par1World, par2EntityLivingBase);
    
  }

  public MagicMissileEntity(World par1World) {
    super(par1World);
    
  }

  private Entity shootingEntity;
  
  @Override
  protected void onImpact(MovingObjectPosition movingobjectposition) {
    if (movingobjectposition.entityHit != null) {
      byte b0 = 0;

      if (movingobjectposition.entityHit instanceof EntityBlaze) {
        b0 = 3;
      }

      movingobjectposition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), (float) b0);
    }

    for (int i = 0; i < 8; ++i) {
      this.worldObj.spawnParticle("snowballpoof", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
    }

    if (!this.worldObj.isRemote) {
      this.setDead();
    }
  }
  
  @Override
  protected float getGravityVelocity() {
    return 0f;
  }

}
