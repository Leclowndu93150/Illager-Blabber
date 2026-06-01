package com.leclowndu93150.illagerblabber;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;

import java.util.Map;

public class IllagerBlabberFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        for (Map.Entry<Identifier, SoundEvent> entry : IllagerSounds.getAllSounds().entrySet()) {
            Registry.register(BuiltInRegistries.SOUND_EVENT, entry.getKey(), entry.getValue());
        }
        CommonClass.init();
    }
}
