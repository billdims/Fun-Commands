package me.ratio.commands;

import io.github.staudlol.util.player.PlayerUtility;
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
                Player player = (Player) sender;
                int latency = PlayerUtility.getPing(player);
                player.sendMessage(ChatColor.GRAY + "Your ping is " + ChatColor.DARK_RED + latency + "ms");
                return false;
            }
        });
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
