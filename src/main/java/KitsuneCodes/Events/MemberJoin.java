package KitsuneCodes.Events;

import KitsuneCodes.addons.Channels;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

/**
 * @author Paqlio
 * @since 07.26.2023 - 12:05
 **/
public class MemberJoin extends ListenerAdapter {
    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event){
        var member = event.getMember();
        var guild = event.getGuild();
        var channel = guild.getTextChannelById(Channels.WELCOME.getChannelId());
        var embed = new EmbedBuilder()
                .setTitle("👋 ┊ nowy użytkownik".toUpperCase())
                .setColor(new Color(0x53FF63))
                .setThumbnail(member.getEffectiveAvatarUrl())
                .setDescription("> Witaj" + member.getAsMention() + " na serwerze " +
                        "Regulamin znajdziesz tutaj -> <#" + Channels.REGULAMIN +"> " + "jesteś naszym `" + guild.getMembers().size() +
                        "` użytkownikiem na discord!" )
                .setFooter(guild.getName(),guild.getIconUrl());
        assert channel != null;
        channel.sendMessageEmbeds(embed.build()).queue();

    }
}
