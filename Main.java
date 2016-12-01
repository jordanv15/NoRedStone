// No Redstone.
// This plugin allows server moderators to disable use of redstone items to certain players
// This plugin may also help with lag on your server do to redstone contraptions. 
// Author: Jordan Viehmeyer - Lighthouse 3718 

package noredstonedev;

import java.io.PrintStream;
import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.PluginManager;

public class Main extends org.bukkit.plugin.java.JavaPlugin implements org.bukkit.event.Listener
{
  public Main() {}
  
  public void onEnable()
  {
    System.out.println("[NoRedStone] Has been enabled");
    getServer().getPluginManager().registerEvents(this, this);
  }
  

  public void onDisable() { System.out.println("[NoRedStone] Has been disabled"); }
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    Player player = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("rs")) {
    	//Alerts the user of the current No Redstone Version. 
      player.sendMessage(ChatColor.RED + "NoRedStone Version 0.5 for 1.6.1");
    }
    else if (cmd.getName().equalsIgnoreCase("rshelp")) {
    	// Alerts the user to refer to the dev page on Bukkit to create a ticket
      player.sendMessage(ChatColor.RED + "Please Create A Ticket At http://dev.bukkit.org/server-mods/noredstone/");
    }
    else if (cmd.getName().equalsIgnoreCase("rsblocks")) {
    	// Alerts the user of the current list of blockable items
      player.sendMessage(ChatColor.RED + "Currently Blocked Items: Redstone Wiring, Sticky Pistons, Pistons, Repeaters and Red Stone Torches");
    }
    else if (cmd.getName().equalsIgnoreCase("rspermissions")) {
    	// Alerts the user of current permission nodes
      player.sendMessage(ChatColor.RED + "Current Permissions: Pistons: NoRedStone.Place.Piston, Sticky Pistons: NoRedStone.Place.StickyPiston, Red Stone: NoRedStone.Place.Redstone, Repeaters: NoRedStone.Place.Repeater Red Stone Torches: NoRedStone.Place.RedTorch");
    }
    return true;
  }
  
  @EventHandler(ignoreCancelled=true)
  public void onPlayerBlockPlace1(BlockPlaceEvent event) {
    if (event.getBlock().getTypeId() == 55) {
      Player player = event.getPlayer();
      if (!player.hasPermission("NoRedStone.Place.Redstone")) {
        event.setCancelled(true);
        player.sendMessage(ChatColor.RED + "[NoRedStone] You are not permitted to place this item!");
      }
    }
  }
  
  @EventHandler(ignoreCancelled=true)
  public void onPlayerBlockPlace2(BlockPlaceEvent event) {
    if (event.getBlock().getTypeId() == 29) {
      Player player = event.getPlayer();
      if (!player.hasPermission("NoRedStone.Place.StickyPiston")) {
        event.setCancelled(true);
        player.sendMessage(ChatColor.RED + "[NoRedStone] You are not permitted to place this item!");
      }
    }
  }
  
  @EventHandler(ignoreCancelled=true)
  public void onPlayerBlockPlace3(BlockPlaceEvent event)
  {
    if (event.getBlock().getTypeId() == 33) {
      Player player = event.getPlayer();
      if (!player.hasPermission("NoRedStone.Place.Piston")) {
        event.setCancelled(true);
        // Alert the player that they are not allowed to use Pistons
        player.sendMessage(ChatColor.RED + "[NoRedStone] You are not permitted to place this item!");
      }
    }
  }
  
  @EventHandler(ignoreCancelled=true)
  public void onPlayerBlockPlace5(BlockPlaceEvent event) {
    if (event.getBlock().getTypeId() == 93) {
      Player player = event.getPlayer();
      if (!player.hasPermission("NoRedStone.Place.Repeater")) {
        event.setCancelled(true);
     // Alert the player that they are not allowed to use Redstone Repeaters
        player.sendMessage(ChatColor.RED + "[NoRedStone] You are not permitted to place this item!");
      }
    }
  }
  
  @EventHandler(ignoreCancelled=true)
  public void onPlayerBlockPlace6(BlockPlaceEvent event) {
    if (event.getBlock().getTypeId() == 94) {
      Player player = event.getPlayer();
      if (!player.hasPermission("NoRedStone.Place.Repeater")) {
        event.setCancelled(true);
        // Alert the player that they are not allowed to use Repeaters
        player.sendMessage(ChatColor.RED + "[NoRedStone] You are not permitted to place this item!");
      }
    }
  }
  
  @EventHandler(ignoreCancelled=true)
  public void onPlayerBlockPlace7(BlockPlaceEvent event) {
    if (event.getBlock().getTypeId() == 75) {
      Player player = event.getPlayer();
      if (!player.hasPermission("NoRedStone.Place.RedTorch")) {
        event.setCancelled(true);
     // Alert the player that they are not allowed to use Redstone Torches
        player.sendMessage(ChatColor.RED + "[NoRedStone] You are not permitted to place this item!");
      }
    }
  }
  
  @EventHandler(ignoreCancelled=true)
  public void onPlayerBlockPlace8(BlockPlaceEvent event) {
    if (event.getBlock().getTypeId() == 76) {
      Player player = event.getPlayer();
      if (!player.hasPermission("NoRedStone.Place.RedTorch")) {
        event.setCancelled(true);
     // Alert the player that they are not allowed to use Redstone Torches
        player.sendMessage(ChatColor.RED + "[NoRedStone] You are not permitted to place this item!");
      }
    }
  }
  
  public void onPlayerBlockPlace4(BlockPlaceEvent event) {
    event.setCancelled(false);
  }
}
