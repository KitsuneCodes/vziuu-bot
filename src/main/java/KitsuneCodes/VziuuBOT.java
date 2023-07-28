package KitsuneCodes;


import KitsuneCodes.Events.Commands.Info;
import KitsuneCodes.addons.Config;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import org.reflections.Reflections;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

/**
 * @author Paqlio
 * @since 07.26.2023 - 13:12
 **/


    public class VziuuBOT {

        public void start() throws LoginException {
                JDA api = JDABuilder.createDefault(Config.get("TOKEN"))
                        .build();
                api.getPresence().setActivity(Activity.playing("\uD83D\uDD11〢KitsuneCodes"));
                var packetName = getClass().getPackageName();
                for (Class<?> clazz : new Reflections(packetName + ".Events")
                        .getSubTypesOf(ListenerAdapter.class)) {
                    try {
                        ListenerAdapter Listener = (ListenerAdapter) clazz
                                .getConstructor()
                                .newInstance();
                        api.addEventListener(Listener);
                        System.out.println("✅ " + Listener.getClass().getSimpleName());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                for (Class<?> cmd : new Reflections(packetName + ".Events.Commands.impl")
                        .getTypesAnnotatedWith(Info.class)) {
                    try {
                        var info = cmd.getAnnotation(Info.class);
                        api.updateCommands().addCommands(Commands.slash(info.name(),info.description())).queue();
                        System.out.println("✅ " + cmd.getSimpleName());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
        }
    }
