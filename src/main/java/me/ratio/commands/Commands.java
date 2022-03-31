package me.ratio.commands;

import io.github.staudlol.util.CC;
import io.github.staudlol.util.player.PlayerUtility;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

import javax.management.monitor.CounterMonitorMBean;
import javax.security.auth.callback.CallbackHandler;
import java.util.Arrays;

public final class Commands extends JavaPlugin {

    public static String motd = "";

    @Override
    public void onEnable() {
        this.getCommand("ping").setExecutor(new CommandExecutor() {
            @Override
            public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

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

        this.getCommand("credits").setExecutor(new CommandExecutor() {
            @Override
            public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
                sender.sendMessage(ChatColor.GREEN + "--------------------------------------");
                sender.sendMessage(ChatColor.YELLOW + "pcranaway: " + ChatColor.AQUA + "https://twitter.com/pcranaway");
                sender.sendMessage(ChatColor.YELLOW + "Staud: " + ChatColor.AQUA + "https://twitter.com/staudgg");
                sender.sendMessage(ChatColor.YELLOW + "billdims: " + ChatColor.AQUA + "https://twitter.com/ItsBillxd");
                sender.sendMessage(ChatColor.GREEN + "--------------------------------------");
                return false;
            }
        });

        this.getCommand("bc").setExecutor(new CommandExecutor() {
            @Override
            public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
                String message = String.join(" ", Arrays.asList(args));

                for(Player it : Bukkit.getOnlinePlayers()){
                    it.sendMessage(CC.translate(message));
                }
                return false;
            }
        });

        this.getCommand("logs").setExecutor(new CommandExecutor() {
            @Override
            public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
                sender.sendMessage(CC.translate("&3billdims &7failed &bReach A &7(D: &33.0473 &7VL: &34)"));
                sender.sendMessage(CC.translate("&3billdims &7failed &bAutoclicker B &7(CPS: &318 &7VL: &312)"));
                return false;
            }
        });

        this.getCommand("push").setExecutor(new CommandExecutor() {
            @Override
            public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
                Player player = (Player) sender;
                player.setVelocity(player.getEyeLocation().toVector().add(new Vector(0.15, 0.15, 0.15)));
                player.sendMessage(ChatColor.YELLOW + "Successfully pushed " + ChatColor.AQUA + player.getName());
                return false;
            }
        });

        this.getCommand("book").setExecutor(new CommandExecutor() {
            @Override
            public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
                Player player = (Player) sender;
                player.getInventory().addItem(new ItemStack(Material.BOOK_AND_QUILL));
                return false;
            }
        });

        this.getCommand("motd").setExecutor(new CommandExecutor() {
            @Override
            public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
                String message = String.join("", Arrays.asList(args));
                motd = CC.translate(message);
                motd = motd.replace("\\n", "\n");
                sender.sendMessage(ChatColor.YELLOW + "The MOTD has successfully changed to " + ChatColor.AQUA + "\"" + motd + ChatColor.AQUA + "\"");
                return false;
            }
        });

        this.getServer().getPluginManager().registerEvents(new Listener() {
            @EventHandler
            public void onMotd(ServerListPingEvent event){
                event.setMotd(motd);
            }
        }, this);

        this.getCommand("comver").setExecutor(new CommandExecutor() {
            @Override
            public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
                sender.sendMessage(ChatColor.YELLOW + "The server is currently running " + ChatColor.AQUA + "Commands 1.0.0" + ChatColor.YELLOW + " developed by " + ChatColor.AQUA + "billdims");
                return false;
            }
        });
    }

    @Override
    public void onDisable() {
    }
}
