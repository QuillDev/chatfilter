package com.minehut.chatfilter.listener;

import com.minehut.chatfilter.wordlist.WordList;
import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import java.nio.file.Path;

public class ChatListener implements Listener {
    private final WordList wordList;

    public ChatListener(Path wordPath) {
        this.wordList = new WordList(wordPath);
        wordList.reload();
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onChat(AsyncChatEvent event) {
        if (!(event.originalMessage() instanceof TextComponent original)) return;
        String raw = original.content();

        if (!wordList.getWordList().contains(raw)) return;
        event.setCancelled(true);
        event.getPlayer().sendMessage(Component.text("Your message was blocked due to inappropriate language.").color(NamedTextColor.RED));
    }

    public WordList getWordList() {
        return wordList;
    }
}
