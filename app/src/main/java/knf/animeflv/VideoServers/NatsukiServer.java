package knf.animeflv.VideoServers;

import android.content.Context;
import android.support.annotation.Nullable;

import org.json.JSONObject;
import org.jsoup.Jsoup;

import knf.animeflv.Cloudflare.BypassHolder;
import knf.animeflv.JsonFactory.Objects.Option;
import knf.animeflv.JsonFactory.Objects.VideoServer;

import static knf.animeflv.JsonFactory.Objects.VideoServer.Names.NATSUKI;

public class NatsukiServer extends Server {
    NatsukiServer(Context context, String baseLink) {
        super(context, baseLink);
    }

    @Override
    public boolean isValid() {
        return baseLink.contains("s=natsuki");
    }

    @Override
    public String getName() {
        return NATSUKI;
    }

    @Nullable
    @Override
    public VideoServer getVideoServer() {
        try {
            String frame = baseLink.substring(baseLink.indexOf("'") + 1, baseLink.lastIndexOf("'"));
            String down_link = Jsoup.parse(frame).select("iframe").first().attr("src");
            String link = new JSONObject(Jsoup.connect(down_link.replace("embed", "check")).cookies(BypassHolder.getBasicCookieMap()).userAgent(BypassHolder.getUserAgent()).get().body().text()).getString("file");
            return new VideoServer(NATSUKI, new Option(null, link));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
