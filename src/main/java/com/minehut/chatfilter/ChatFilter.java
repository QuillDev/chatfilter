package com.minehut.chatfilter;

import com.minehut.chatfilter.commands.ReloadCommand;
import com.minehut.chatfilter.listener.ChatListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.nio.file.Path;
import java.util.Optional;

public final class ChatFilter extends JavaPlugin {

    @Override
    public void onEnable() {

        final ChatListener chatListener = new ChatListener(Path.of(getDataFolder().toPath().toString(), "blockedwords.txt"));

        // Plugin startup logic
        getServer().getPluginManager().registerEvents(chatListener, this);
        Optional.ofNullable(getCommand("reload")).ifPresent((command) -> command.setExecutor(new ReloadCommand(chatListener.getWordList())));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
