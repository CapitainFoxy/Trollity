package net.trollity.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import net.trollity.Trollity;
import net.trollity.commands.subcommands.Anvil;
import net.trollity.commands.subcommands.Blind;
import net.trollity.commands.subcommands.Burn;
import net.trollity.commands.subcommands.Freeze;
import net.trollity.commands.subcommands.Help;
import net.trollity.commands.subcommands.Hunger;
import net.trollity.commands.subcommands.Hurt;
import net.trollity.commands.subcommands.Kill;
import net.trollity.commands.subcommands.Lightning;
import net.trollity.commands.subcommands.Mobs;

public class TrollCommand implements CommandExecutor {

    private final Trollity plugin;

    public TrollCommand(Trollity plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage("Usage: /trollity <command> [args]");
            return false;
        }

        switch (args[0].toLowerCase()) {
            case "burn":
                new Burn(plugin).onCommand(sender, args);
                break;
            case "lightning":
                new Lightning(plugin).onCommand(sender, args);
                break;
            case "freeze":
                new Freeze(plugin).onCommand(sender, args);
                break;
            case "hunger":
                new Hunger(plugin).onCommand(sender, args);
                break;
            case "mobs":
                new Mobs(plugin).onCommand(sender, args);
                break;
            case "blind":
                new Blind(plugin).onCommand(sender, args);
                break;
            case "anvil":
                new Anvil(plugin).onCommand(sender, args);
                break;
            case "hurt":
                new Hurt(plugin).onCommand(sender, args);
                break;
            case "help":
                new Help(plugin).onCommand(sender);
                break;
            case "kill":
                new Kill(plugin).onCommand(sender, args);
                break;
            default:
                sender.sendMessage("Cmd not found!");
                break;
        }
        return true;
    }
}
