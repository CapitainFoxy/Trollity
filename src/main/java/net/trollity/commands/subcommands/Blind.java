package net.trollity.commands.subcommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import net.trollity.Trollity;

public class Blind {

    private final Trollity plugin;

    public Blind(Trollity plugin) {
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

    
        target.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, seconds * 20, 1)); 
        sender.sendMessage(ChatColor.GREEN + plugin.getConfig().getString("messages.blind_success")
                .replace("%seconds%", String.valueOf(seconds)));
        
     
        target.sendMessage(ChatColor.RED + plugin.getConfig().getString("messages.blind_effected")
                .replace("%seconds%", String.valueOf(seconds)));
    }
}
