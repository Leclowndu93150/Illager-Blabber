package com.leclowndu93150.illagerblabber.mixin;

import com.leclowndu93150.illagerblabber.IllagerSounds;
import com.leclowndu93150.illagerblabber.stuff.voice.IllagerVoiceRegistry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.illager.Evoker;
import net.minecraft.world.entity.monster.illager.SpellcasterIllager;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Evoker.class)
public abstract class EvokerMixin extends SpellcasterIllager {

    protected EvokerMixin(EntityType<? extends SpellcasterIllager> entityType, Level world) {
        super(entityType, world);
    }

    @Inject(method = "getCelebrateSound", at = @At("HEAD"), cancellable = true)
    private void onGetCelebratingSound(CallbackInfoReturnable<SoundEvent> cir) {
        Evoker evoker = (Evoker)(Object)this;
        IllagerVoiceRegistry.setVictoryState(evoker);
        cir.setReturnValue(IllagerSounds.SILENCE);
    }

    @Inject(method = "getHurtSound", at = @At("HEAD"), cancellable = true)
    private void onHurt(DamageSource source, CallbackInfoReturnable<SoundEvent> cir) {
        Evoker evoker = (Evoker)(Object)this;
        IllagerVoiceRegistry.setHurtState(evoker);
        cir.setReturnValue(null);
    }

    @Inject(method = "getAmbientSound", at = @At("HEAD"), cancellable = true)
    private void onGetAmbientSound(CallbackInfoReturnable<SoundEvent> cir) {
        cir.setReturnValue(null);
    }
}
