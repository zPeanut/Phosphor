package tk.peanut.phosphor.module.modules.render;

import org.lwjgl.input.Keyboard;
import tk.peanut.phosphor.Phosphor;
import tk.peanut.phosphor.module.Category;
import tk.peanut.phosphor.module.Module;
import tk.peanut.phosphor.settings.Setting;

/**
 * Created by peanut on 05/02/2021
 */
public class ESP extends Module {
    public ESP() {
        super("OutlineESP", "Outlines entities through walls", Keyboard.KEY_NONE, Category.Render, -1);
    }
}