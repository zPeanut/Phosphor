package tk.peanut.hydrogen.command;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import tk.peanut.hydrogen.Hydrogen;

/**
 * Created by peanut on 13/03/2021
 */
public abstract class Command {

    public abstract void execute(String[] args);

    public abstract String getName();
    public abstract String getSyntax();
    public abstract String getDesc();

    public static void msg(String msg) {
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(Hydrogen.getClient().prefix + "§7 " + msg));
    }

    public void normal(String msg)  {
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(msg));
    }

    public String getCmd() {
        return getName();
    }

    public String getName1() {
        return getName();
    }

    public String getHelp() {
        return null;
    }
}
