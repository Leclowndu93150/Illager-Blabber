package com.leclowndu93150.illagerblabber;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Map;

@Mod(Constants.MOD_ID)
public class IllagerBlabberNeoForge {

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, Constants.MOD_ID);

    public IllagerBlabberNeoForge(IEventBus modEventBus) {
        for (Map.Entry<Identifier, SoundEvent> entry : IllagerSounds.getAllSounds().entrySet()) {
            SOUND_EVENTS.register(entry.getKey().getPath(), () -> entry.getValue());
        }
        SOUND_EVENTS.register(modEventBus);
        CommonClass.init();
    }
}
