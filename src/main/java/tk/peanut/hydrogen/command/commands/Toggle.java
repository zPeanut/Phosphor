package tk.peanut.hydrogen.command.commands;

import tk.peanut.hydrogen.Hydrogen;
import tk.peanut.hydrogen.command.Command;
import tk.peanut.hydrogen.file.files.ModuleFile;
import tk.peanut.hydrogen.module.Module;

/**
 * Created by peanut on 14/03/2021
 */
public class Toggle extends Command {

    public void execute(String[] args) {
        if (args.length != 1) {
            msg(getAll());
        } else {
            String module = args[0];
            Module mod = Hydrogen.getClient().moduleManager.getModulebyName(module);
            if (mod == null) {
                msg("§cThe requested module was not found!");
            } else {
                Hydrogen.getClient().moduleManager.getModulebyName(module).toggle();
                msg(String.format("§b%s §7has been %s", Hydrogen.getClient().moduleManager.getModulebyName(module).getName(), Hydrogen.getClient().moduleManager.getModulebyName(module).isEnabled() ? "§aenabled" : "§cdisabled."));
                ModuleFile.saveModules();
            }
        }
    }

    public String getName() {
        return "t";
    }

    public String getDesc() {
        return "Toggles modules.";
    }

    public String getSyntax() {
        return ".t";
    }

    public String getAll() {
        return getSyntax() + " - " + getDesc();
    }

}
