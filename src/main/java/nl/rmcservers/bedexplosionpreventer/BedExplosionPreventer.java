package nl.rmcservers.bedexplosionpreventer;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.Material;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

public final class BedExplosionPreventer extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }
    
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getPlayer().getWorld().getEnvironment() == World.Environment.NETHER) {
            if (event.getClickedBlock().getType() == Material.BED_BLOCK) {
                event.setCancelled(true);
                event.getPlayer().sendMessage("\u00a7cYou cannot explode beds in the Nether dimension!");
            }
        }
    }
}