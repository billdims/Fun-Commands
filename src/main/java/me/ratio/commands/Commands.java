package me.ratio.commands;

import io.github.staudlol.util.player.PlayerUtility;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Commands extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("ping").setExecutor(new CommandExecutor() {
            @Override
            public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
//                Player player = (Player) sender;
//                int latency = PlayerUtility.getPing(player);
//                player.sendMessage(ChatColor.GRAY + "Your ping is " + ChatColor.DARK_RED + latency + "ms");
                Player target = (Player) sender;

                if(args.length >= 1) {
                    target = Bukkit.getPlayer(args[0]);
                }

                if(target == null) {
                    sender.sendMessage(ChatColor.DARK_RED + "This player is offline");
                    return false;
                }

                int latency = PlayerUtility.getPing(target);

                if(target == (Player) sender) {
                    sender.sendMessage(ChatColor.GRAY + "Your ping is " + ChatColor.DARK_RED + latency + "ms");
                } else {
                    sender.sendMessage(ChatColor.GRAY + target.getName() + "'s ping is" + ChatColor.DARK_RED + latency + "ms");
                }
                return false;
            }
        });
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
