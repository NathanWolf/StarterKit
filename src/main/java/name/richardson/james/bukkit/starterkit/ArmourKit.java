package name.richardson.james.bukkit.starterkit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.configuration.serialization.SerializableAs;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

@SerializableAs("ArmourKit")
public class ArmourKit implements ConfigurationSerializable {

  private ItemStack[] items;
  
  @SuppressWarnings("unchecked")
  public static ArmourKit deserialize(Map<String, Object> map) {
    List<ItemStack> items = new ArrayList<ItemStack>(4);
    for (String key :  map.keySet()) {
      if (key.startsWith("==")) continue;
      items.add(Integer.parseInt(key), ItemStack.deserialize((Map<String, Object>) map.get(key)));
    }
    return new ArmourKit(items);
  }
  
  public ArmourKit() {
    this.items = new ItemStack[0];
  }
  
  public ArmourKit(PlayerInventory inventory) {
    this.items = inventory.getArmorContents();
  }
  
  public ArmourKit(List<ItemStack> items) {
    this.items = items.toArray(new ItemStack[items.size()]);
  }

  public ItemStack[] getContents() {
    return items;
  }
  
  public Map<String, Object> serialize() {
    Map<String, Object> map = new HashMap<String, Object>();
    int slot = -1;
    for (ItemStack item : items) {
      slot++;
      if(item == null || item.getType() == Material.AIR) continue;
      map.put(Integer.toString(slot), item);
    }
    return map;
  }  

}
