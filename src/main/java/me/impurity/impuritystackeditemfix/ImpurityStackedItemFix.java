package me.impurity.impuritystackeditemfix;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class ImpurityStackedItemFix extends JavaPlugin {

    private final PluginManager pluginManager = getServer().getPluginManager();
    public IllegalUtils illegalUtils = new IllegalUtils();

    public static ImpurityStackedItemFix getPlugin() {
        return getPlugin(ImpurityStackedItemFix.class);
    }

    @Override
    public void onEnable() {
        getLogger().info("32k PvP Meta ENABLED");
        getCommand("heal").setExecutor(new HealNiggaBrolapseSevGirlfriendPussyAsshole());
        pluginManager.registerEvents(new Listeners(), this);


    }

    @Override
    public void onDisable() {
        getLogger().info("32k PvP Meta DISABLED");
    }
}
