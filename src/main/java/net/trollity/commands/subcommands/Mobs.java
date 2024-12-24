package net.trollity.commands.subcommands;

import net.trollity.Trollity;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class Mobs {

    private final Trollity plugin;

    public Mobs(Trollity plugin) {
        this.plugin = plugin;
    }

    public void onCommand(CommandSender sender, String[] args) {
        if (!sender.hasPermission("trollity.use")) {
            sender.sendMessage(ChatColor.RED + plugin.getConfig().getString("messages.no_permission"));
            return;
        }

        if (args.length < 2) {
            sender.sendMessage(ChatColor.RED + plugin.getConfig().getString("messages.usage"));
            return;
        }

        Player target = Bukkit.getPlayer(args[1]);
        if (target == null) {
            sender.sendMessage(ChatColor.RED + plugin.getConfig().getString("messages.player_not_found"));
            return;
        }

        for (int i = 0; i < 5; i++) {
            EntityType mob = Math.random() > 0.5 ? EntityType.SKELETON : EntityType.ZOMBIE;
            target.getWorld().spawnEntity(target.getLocation(), mob);
        }

        sender.sendMessage(ChatColor.GREEN + plugin.getConfig().getString("messages.mobs_spawned"));
    }
}
