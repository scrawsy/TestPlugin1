package me.scrawsy.testplugin;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class TestPlugin extends JavaPlugin implements Listener {
    @EventHandler
    public void onPlayerPickup(PlayerPickupItemEvent event) {
        Player player = (Player) event.getPlayer();
        int preAmount = 0;

        for (ItemStack invItem : player.getInventory().getContents()) {
            if (invItem != null)
                if (invItem.getType() == Material.GOLDEN_APPLE)
                    preAmount += invItem.getAmount();
        }


        preAmount = preAmount + event.getItem().getItemStack().getAmount();
        player.sendMessage("You currently have golden apples in total: " + preAmount);

        preAmount = preAmount + event.getItem().getItemStack().getAmount();
        int valueToDel = preAmount - 32;
        player.getInventory().removeItem(new ItemStack(Material.GOLDEN_APPLE, valueToDel, (short) 1));

    }
}