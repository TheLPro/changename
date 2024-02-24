package studio.thelpro.namechanger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class NameChanger extends JavaPlugin implements CommandExecutor {

    @Override
    public void onEnable() {

        getCommand("changename").setExecutor(this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        if (args.length == 1) {
            if (commandSender.hasPermission("cn.use")) {
                if (commandSender.hasPermission("cn.admin")) {
                    if (args[0].equals("reload")) {
                        reloadConfig();
                        return true;
                    }
                }

                Player player = (Player) commandSender;
                player.setDisplayName(args[0]);
                player.setPlayerListName(args[0]);
                player.setCustomName(args[0]);
                player.setCustomNameVisible(true);

                getServer().dispatchCommand(getServer().getConsoleSender(), "essentials:nick " + player.getName() + " " + args[0]);

            }
        }
        return true;
    }
}