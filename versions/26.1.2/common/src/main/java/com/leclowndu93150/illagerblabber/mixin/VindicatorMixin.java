package com.leclowndu93150.illagerblabber.mixin;

import com.leclowndu93150.illagerblabber.IllagerSounds;
import com.leclowndu93150.illagerblabber.stuff.voice.IllagerVoiceRegistry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.illager.AbstractIllager;
import net.minecraft.world.entity.monster.illager.Vindicator;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Vindicator.class)
public abstract class VindicatorMixin extends AbstractIllager {

    protected VindicatorMixin(EntityType<? extends AbstractIllager> entityType, Level world) {
        super(entityType, world);
    }

    @Inject(method = "getHurtSound", at = @At("HEAD"), cancellable = true)
    private void onHurt(DamageSource source, CallbackInfoReturnable<SoundEvent> cir) {
        Vindicator vindicator = (Vindicator)(Object)this;
        IllagerVoiceRegistry.setHurtState(vindicator);
        cir.setReturnValue(null);
    }

    @Inject(method = "getCelebrateSound", at = @At("HEAD"), cancellable = true)
    private void onGetCelebratingSound(CallbackInfoReturnable<SoundEvent> cir) {
        Vindicator vindicator = (Vindicator)(Object)this;
        IllagerVoiceRegistry.setVictoryState(vindicator);
        cir.setReturnValue(IllagerSounds.SILENCE);
    }

    @Inject(method = "getAmbientSound", at = @At("HEAD"), cancellable = true)
    private void onGetAmbientSound(CallbackInfoReturnable<SoundEvent> cir) {
        cir.setReturnValue(null);
    }
}
