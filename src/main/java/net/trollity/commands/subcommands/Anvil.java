package net.trollity.commands.subcommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import net.trollity.Trollity;

public class Anvil {

    private final Trollity plugin;

    public Anvil(Trollity plugin) {
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

        
        double x = target.getLocation().getX();
        double y = target.getLocation().getY() + 10; 
        double z = target.getLocation().getZ();
        
    
        ItemStack anvil = new ItemStack(Material.ANVIL);
        target.getWorld().dropItem(new org.bukkit.Location(target.getWorld(), x, y, z), anvil);

        target.getWorld().getBlockAt(new org.bukkit.Location(target.getWorld(), x, y, z)).setType(Material.ANVIL);

  
        org.bukkit.entity.Item droppedAnvil = target.getWorld().dropItem(new org.bukkit.Location(target.getWorld(), x, y, z), anvil);
        droppedAnvil.setVelocity(new Vector(0, -1, 0)); 

     
        sender.sendMessage(ChatColor.GREEN + plugin.getConfig().getString("messages.anvil_success"));
    }
}
