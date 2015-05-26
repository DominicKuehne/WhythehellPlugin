/**
 * Created by Tino on 12.05.2015.
 */

import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class WhythehellPlugin extends JavaPlugin {
    public static Logger log = Logger.getLogger("Minecraft");

    public void onLoad() {

        log.info("[WhythehellPlugin] Loaded...");

    }

    public void onEnable() {

        log.info("[WhythehellPlugin] Starting up...");

    }

    public void onDisable() {

        log.info("[WhythehellPlugin] Shuting down...");

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("Whythehell")) {

            if (sender instanceof Player) {
                String message = "[Server]: YO was geht'n hier?";
                getServer().broadcastMessage(message);
                return true;
            } else {
                sender.sendMessage("[Server]:Du Kacklappen das kannste so nisch machen!");
            }

        } else if (command.getName().equalsIgnoreCase("killplayer")) {
            Player opfer = sender.getServer().getPlayer(args[0]);
            if (opfer == null) {
                sender.sendMessage("Player" +args[0]+"is not online!");
                return true;
            }
            opfer.setHealth(0.0);
        }
        return false;
    }
}
