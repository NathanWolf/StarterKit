package name.richardson.james.bukkit.starterkit;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class InventoryKit implements ConfigurationSerializable {

  private final ItemStack[] items;
  
  public InventoryKit(PlayerInventory inventory) {
    this.items = inventory.getContents();
  }
  
  public ItemStack[] getContents() {
    return items;
  }
  
  public Map<String, Object> serialize() {
    Map<String, Object> map = new HashMap<String, Object>();
    int slot = -1;
    for (ItemStack item : items) {
      slot++;
      if(item == null) continue;
      map.put(Integer.toString(slot), item);
    }
    return map;
  }  
  
}
