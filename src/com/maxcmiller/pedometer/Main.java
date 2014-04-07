package com.maxcmiller.pedometer;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public void onEnable() {
		Bukkit.getServer().getPluginManager().registerEvents(new MainListener(), this);
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "The console cannot use pedometers.");
		}
		Player player = (Player) sender;
		if (commandLabel.equals("pedometer")) {
			ItemStack is = new ItemStack(Material.WATCH);
			ItemMeta im = is.getItemMeta();
			im.setDisplayName(ChatColor.WHITE + "Pedometer");
			List<String> lore = new ArrayList<String>();
			lore.add(ChatColor.GRAY + "Total steps: ");
			lore.add("0");
			lore.add(ChatColor.GRAY + "Right click this item for options...");
			im.setLore(lore);
			is.setItemMeta(im);
			player.getInventory().addItem(is);
			
			player.sendMessage(ChatColor.GREEN + "A pedometer has been added to your inventory.");
		}
		return true;
	}
}
