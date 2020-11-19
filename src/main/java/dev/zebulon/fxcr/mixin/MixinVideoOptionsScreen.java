package dev.zebulon.fxcr.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import dev.zebulon.fxcr.FxcrMod;
import net.minecraft.client.gui.screen.VideoOptionsScreen;
import net.minecraft.client.options.Option;

@Mixin(VideoOptionsScreen.class)
public class MixinVideoOptionsScreen {
    @Shadow
    public static Option[] OPTIONS;

    static {
        Option[] oldOptions = OPTIONS;
        OPTIONS = new Option[oldOptions.length + 1];

        System.arraycopy(oldOptions, 0, OPTIONS, 0, oldOptions.length);

        OPTIONS[OPTIONS.length - 1] = FxcrMod.FXCR_ENABLED_OPTION;
    }
}
