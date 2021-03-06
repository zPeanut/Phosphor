package tk.peanut.hydrogen.ui.mainmenu;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.ForgeVersion;
import net.minecraftforge.fml.common.Loader;
import org.lwjgl.opengl.GL11;
import tk.peanut.hydrogen.Hydrogen;
import tk.peanut.hydrogen.utils.FontHelper;
import tk.peanut.hydrogen.utils.FontUtil;
import tk.peanut.hydrogen.utils.ParticleGenerator;
import tk.peanut.hydrogen.utils.Utils;

import java.awt.*;

/**
 * Created by peanut on 26/02/2021
 */
public class MainMenu extends GuiScreen {

    public static Minecraft mc = Minecraft.getMinecraft();
    public static ParticleGenerator particleGenerator = new ParticleGenerator(100, mc.displayWidth, mc.displayHeight);

    public static void drawMenu(int mouseX, int mouseY) {
        drawRect(40, 0, 140, Utils.getScaledRes().getScaledHeight(), 0x60000000);

        String mds = String.format("%s mods loaded, %s mods active", Loader.instance().getModList().size(), Loader.instance().getActiveModList().size());
        String fml = String.format("Powered by Forge %s", ForgeVersion.getVersion());
        String mcp = "MCP 9.19";
        String mcv = "Minecraft 1.8.9";
        String name = String.format("%s %s", Hydrogen.name, Hydrogen.version);
        String mname = String.format("Logged in as §7%s", Minecraft.getMinecraft().getSession().getUsername());

        FontHelper.comfortaa_r.drawStringWithShadowMainMenu(mds, Utils.getScaledRes().getScaledWidth() - FontHelper.comfortaa_r.getStringWidth(mds) - 4, Utils.getScaledRes().getScaledHeight() - 14, Color.WHITE);
        FontHelper.comfortaa_r.drawStringWithShadowMainMenu(fml, Utils.getScaledRes().getScaledWidth() - FontHelper.comfortaa_r.getStringWidth(fml) - 4, Utils.getScaledRes().getScaledHeight() - 26, Color.WHITE);
        FontHelper.comfortaa_r.drawStringWithShadowMainMenu(mcp, Utils.getScaledRes().getScaledWidth() - FontHelper.comfortaa_r.getStringWidth(mcp) - 4, Utils.getScaledRes().getScaledHeight() - 38, Color.WHITE);
        FontHelper.comfortaa_r.drawStringWithShadowMainMenu(mcv, Utils.getScaledRes().getScaledWidth() - FontHelper.comfortaa_r.getStringWidth(mcv) - 4, Utils.getScaledRes().getScaledHeight() - 50, Color.WHITE);

        if(Hydrogen.version.contains("dev") || Hydrogen.version.contains("beta")) {
            FontHelper.comfortaa_r.drawStringWithShadowMainMenu("§cWARNING: §7Early access version! Major issues may arise!", 2, Utils.getScaledRes().getScaledHeight() - 12, Color.white);
        }

        FontHelper.comfortaa_r.drawStringWithShadowMainMenu(name, Utils.getScaledRes().getScaledWidth() - FontHelper.comfortaa_r.getStringWidth(name) - 4, 4, Color.WHITE);
        FontHelper.comfortaa_r.drawStringWithShadowMainMenu("Developed by §7" + Hydrogen.devs, Utils.getScaledRes().getScaledWidth() - FontHelper.comfortaa_r.getStringWidth("Developed by §7" + Hydrogen.devs) - 4, 16, Color.WHITE);
        FontHelper.comfortaa_r.drawStringWithShadowMainMenu(mname, Utils.getScaledRes().getScaledWidth() - FontHelper.comfortaa_r.getStringWidth(mname) - 4, 28, Color.WHITE);

        if(Hydrogen.getClient().outdated) {
            FontHelper.comfortaa_r.drawStringWithShadowMainMenu("§cOutdated!", 66, 10, Color.WHITE);
            FontUtil.drawTotalCenteredStringWithShadow3("Newest Version: §a" + Hydrogen.getClient().newversion, 91, 25, Color.WHITE);
        }

        float scale = 5F;

        GL11.glScalef(scale, scale, scale);
        mc.fontRendererObj.drawStringWithShadow("Hydrogen", Utils.getScaledRes().getScaledWidth() / 2 / scale - 13, Utils.getScaledRes().getScaledHeight() / 2 / scale - 5F, -4198401);
        GL11.glScalef(1.0F / scale, 1.0F / scale, 1.0F / scale);

        float scalever = 2.0F;

        GL11.glScalef(scalever, scalever, scalever);
        mc.fontRendererObj.drawStringWithShadow("§7" + Hydrogen.version, Utils.getScaledRes().getScaledWidth() / 2 / scalever + 85, Utils.getScaledRes().getScaledHeight() / 2 / scalever - 17F, -1);
        GL11.glScalef(1.0F / scalever, 1.0F / scalever, 1.0F / scalever);

        particleGenerator.drawParticles(mouseX, mouseY);
    }

}
