/**
 * Created by Tino on 12.05.2015.
 */

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

public class WhythehellPlugin extends JavaPlugin {
    public static Logger log =Logger.getLogger("Minecraft");

    public void onLoad() {

        log.info("[WhythehellPlugin] Loaded...");

    }
    public void onEnable() {

        log.info("[WhythehellPlugin] Starting up...");

    }
    public void onDisable() {

        log.info("[WhythehellPlugin] Shuting down...");

    }
}
