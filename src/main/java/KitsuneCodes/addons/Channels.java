package KitsuneCodes.addons;

/**
 * @author Paqlio
 * @since 07.26.2023 - 12:17
 **/
public enum Channels {
    WELCOME("1093196649976823858"),
    REGULAMIN("1093192788608303144");

    private final String channelId;

    Channels(String channelId) {
        this.channelId = channelId;
    }

    public String getChannelId() {
        return channelId;
    }
}
