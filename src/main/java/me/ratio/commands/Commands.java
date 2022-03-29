package me.ratio.commands;

import io.github.staudlol.util.player.PlayerUtility;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import javax.security.auth.callback.CallbackHandler;

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
                    sender.sendMessage(ChatColor.YELLOW + "This player is offline");
                    return false;
                }

                int latency = PlayerUtility.getPing(target);

                if(target == sender) {
                    sender.sendMessage(ChatColor.YELLOW + "Your ping is " + ChatColor.AQUA + latency + "ms");
                } else {
                    sender.sendMessage(ChatColor.YELLOW + target.getName() + "'s ping is " + ChatColor.AQUA + latency + "ms");
                }
                return false;
            }
        });
        this.getCommand("ratio").setExecutor(new CommandExecutor() {
            @Override
            public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
                sender.sendMessage(ChatColor.YELLOW + "counter " + ChatColor.AQUA + "ratio");
                return false;
            }
        });
        this.getCommand("wtf").setExecutor(new CommandExecutor() {
            @Override
            public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
                sender.sendMessage(ChatColor.YELLOW + "pcranaway: " + ChatColor.AQUA + "https://twitter.com/pcranaway");
                sender.sendMessage(ChatColor.YELLOW + "Staud: " + ChatColor.AQUA + "https://twitter.com/staudgg");
                sender.sendMessage(ChatColor.YELLOW + "billdims: " + ChatColor.AQUA + "https://twitter.com/ItsBillxd");
                return false;
            }
        });
    }

    @Override
    public void onDisable() {
    }
}
