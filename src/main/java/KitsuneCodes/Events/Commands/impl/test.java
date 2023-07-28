package KitsuneCodes.Events.Commands.impl;

import KitsuneCodes.Events.Commands.Info;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.SlashCommandInteraction;

/**
 * @author Paqlio
 * @since 07.28.2023 - 12:55
 **/
@Info(name = "test", description = "test")
public class test extends ListenerAdapter {
    @Override
    public void onSlashCommand(SlashCommandInteraction event) {
        if (event.getName().equals("test")) {
            event.reply("test").queue();
        }
    }
}
