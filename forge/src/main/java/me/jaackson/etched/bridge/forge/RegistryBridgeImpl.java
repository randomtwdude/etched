package me.jaackson.etched.bridge.forge;

import me.jaackson.etched.Etched;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

/**
 * @author Jackson
 */
public class RegistryBridgeImpl {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Etched.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Etched.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Etched.MOD_ID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Etched.MOD_ID);

    public static <T extends SoundEvent> Supplier<T> registerSound(String name, T object) {
        return SOUND_EVENTS.register(name, () -> object);
    }

    public static <T extends Item> Supplier<T> registerItem(String name, T object) {
        return ITEMS.register(name, () -> object);
    }

    public static <T extends Block> Supplier<T> registerBlock(String name, T object) {
        return BLOCKS.register(name, () -> object);
    }

    public static <V extends BlockEntity, T extends BlockEntityType<V>> Supplier<T> registerBlockEntity(String name, T object) {
        return BLOCK_ENTITIES.register(name, () -> object);
    }

}
