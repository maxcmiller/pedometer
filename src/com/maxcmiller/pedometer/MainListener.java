package com.maxcmiller.pedometer;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MainListener implements Listener {
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		
		// Returns if the player hasn't actually moved a block
		if (e.getFrom().getBlockX() == e.getTo().getBlockX()
				&& e.getFrom().getBlockY() == e.getTo().getBlockY()
				&& e.getFrom().getBlockZ() == e.getTo().getBlockZ()) 
		return;
		
		for (ItemStack is : e.getPlayer().getInventory().getContents()) {
			if (is == null) return;
			if (is.getType() == Material.WATCH) {
				if (is.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Pedometer")) {
					ItemMeta im = is.getItemMeta();
					List<String> lore = im.getLore();
					
					int preNum = Integer.parseInt(lore.get(1));
					int newNum = preNum + 1;
					List<String> newLore = new ArrayList<String>();
					newLore.add(ChatColor.GRAY + "Total steps: ");
					newLore.add(newNum + "");
					newLore.add(ChatColor.GRAY + "Right click this item for options...");

					im.setLore(newLore);
					is.setItemMeta(im);
				}
			}
		}
	}
}
