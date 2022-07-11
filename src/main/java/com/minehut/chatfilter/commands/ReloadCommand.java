package com.minehut.chatfilter.commands;

import com.minehut.chatfilter.wordlist.WordList;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class ReloadCommand implements CommandExecutor {

    /** the word list **/
    private WordList wordList;

    /**
     * reload command for reloading the word list from a file
     * @param wordList to reload
     */
    public ReloadCommand(WordList wordList) {
        this.wordList = wordList;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        wordList.reload();
        sender.sendMessage(Component.text("Reloaded word list. Found %s words!".formatted(wordList.getWordList().size())).color(NamedTextColor.GREEN));
        return true;
    }
}
