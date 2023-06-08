package relitestudio.azmine.aztrasher.Listener;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CommandListener implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] strings) {
        if (!(sender instanceof Player)) return true;

        //createTrashboxType
        if (cmd.getName().equalsIgnoreCase("createtrashboxtype")) {


        } else if (cmd.getName().equalsIgnoreCase("additemtotrashboxtype")) {

        }

        return true;
    }
}
