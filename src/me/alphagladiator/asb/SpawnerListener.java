package me.alphagladiator.asb;

import java.util.Iterator;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityExplodeEvent;

public class SpawnerListener implements Listener{
	
	@EventHandler
	public void blockBreak(BlockBreakEvent e){
		if(e.getBlock().getType().equals(Material.MOB_SPAWNER)){
			if(e.getPlayer().hasPermission("asb.Bypass")){
				return;
			}else{
				e.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void blockExplode(EntityExplodeEvent e){
		if (e.getEntity().getType() == EntityType.PRIMED_TNT) {
	          Iterator<Block> iter = e.blockList().iterator();
	          while (iter.hasNext()) {
	              Block b = iter.next();
	              if (b.getType() == Material.MOB_SPAWNER) {
	                  iter.remove();
	              }
	          }
	    }
	}

}
