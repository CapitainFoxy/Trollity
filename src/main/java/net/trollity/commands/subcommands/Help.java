package net.trollity.commands.subcommands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import net.trollity.Trollity;

public class Help {

    private final Trollity plugin;

    public Help(Trollity plugin) {
        this.plugin = plugin;
    }

    public void onCommand(CommandSender sender) {
        if (!sender.hasPermission("trollity.use")) {
            sender.sendMessage(ChatColor.RED + plugin.getConfig().getString("messages.no_permission"));
            return;
        }

      
        sender.sendMessage(ChatColor.YELLOW + plugin.getConfig().getString("messages.help_header"));
        
       
        sender.sendMessage(ChatColor.GOLD + plugin.getConfig().getString("messages.help_burn"));
        sender.sendMessage(ChatColor.GOLD + plugin.getConfig().getString("messages.help_lightning"));
        sender.sendMessage(ChatColor.GOLD + plugin.getConfig().getString("messages.help_freeze"));
        sender.sendMessage(ChatColor.GOLD + plugin.getConfig().getString("messages.help_hunger"));
        sender.sendMessage(ChatColor.GOLD + plugin.getConfig().getString("messages.help_mobs"));
        sender.sendMessage(ChatColor.GOLD + plugin.getConfig().getString("messages.help_blind"));
        sender.sendMessage(ChatColor.GOLD + plugin.getConfig().getString("messages.help_anvil"));
        sender.sendMessage(ChatColor.GOLD + plugin.getConfig().getString("messages.help_hurt"));
        sender.sendMessage(ChatColor.GOLD + plugin.getConfig().getString("messages.help_kill"));
    }
}
