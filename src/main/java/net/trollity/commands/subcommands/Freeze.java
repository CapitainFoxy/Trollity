package net.trollity.commands.subcommands;

import net.trollity.Trollity;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Freeze {

    private final Trollity plugin;

    public Freeze(Trollity plugin) {
        this.plugin = plugin;
    }

    public void onCommand(CommandSender sender, String[] args) {
        if (!sender.hasPermission("trollity.use")) {
            sender.sendMessage(ChatColor.RED + plugin.getConfig().getString("messages.no_permission"));
            return;
        }

        if (args.length < 3) {
            sender.sendMessage(ChatColor.RED + plugin.getConfig().getString("messages.usage"));
            return;
        }

        Player target = Bukkit.getPlayer(args[1]);
        if (target == null) {
            sender.sendMessage(ChatColor.RED + plugin.getConfig().getString("messages.player_not_found"));
            return;
        }

        int seconds;
        try {
            seconds = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            sender.sendMessage(ChatColor.RED + plugin.getConfig().getString("messages.usage"));
            return;
        }

    
        target.setWalkSpeed(0); 
        Bukkit.getScheduler().runTaskLater(plugin, () -> target.setWalkSpeed(0.2f), seconds * 20);

        sender.sendMessage(ChatColor.GREEN + plugin.getConfig().getString("messages.freeze_success").replace("%seconds%", String.valueOf(seconds)));
    }
}
