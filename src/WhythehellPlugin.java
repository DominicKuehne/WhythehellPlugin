/**
 * Created by Tino on 12.05.2015.
 */

import java.util.Set;
import java.util.logging.Logger;

import org.bukkit.Location;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.event.EventHandler;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;



public class WhythehellPlugin extends JavaPlugin implements Listener {
    public static Logger log = Logger.getLogger("Minecraft");

    public void onLoad() {

        log.info("[WhythehellPlugin] Loaded...");

    }

    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this,this);
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
            opfer.getWorld().createExplosion(opfer.getLocation(),12);
            opfer.setHealth(0.0);
        }
        return false;
    }
    @EventHandler
    public void onPlayerInteractBlock(PlayerInteractEvent event){
        Player p = event.getPlayer();
        if (p.getItemOnCursor().getType() == Material.SEEDS){

            Location loc = p.getTargetBlock((Set<Material>)null, 200).getLocation();
            p.getWorld().strikeLightning(loc);

        }
    }
}


