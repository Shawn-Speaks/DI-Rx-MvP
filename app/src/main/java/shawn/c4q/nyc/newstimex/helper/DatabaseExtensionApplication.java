package shawn.c4q.nyc.newstimex.helper;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.facebook.stetho.Stetho;

import java.io.File;
import java.util.HashMap;

import shawn.c4q.nyc.newstimex.daggersetup.component.ActivityComponent;
import shawn.c4q.nyc.newstimex.daggersetup.component.DaggerActivityComponent;
import shawn.c4q.nyc.newstimex.daggersetup.modules.AppModule;
import shawn.c4q.nyc.newstimex.daggersetup.modules.HandlerModule;
import shawn.c4q.nyc.newstimex.daggersetup.modules.NetworkModule;

/**
 * Created by shawnspeaks on 5/14/17.
 */

public class DatabaseExtensionApplication extends Application {

    private ActivityComponent component;
    HashMap<String, String> i = new HashMap<>();


    @Override
    public void onCreate(){
        super.onCreate();

        initSharedPref();

        File cacheFile = new File(getCacheDir(), "responses");
        component = DaggerActivityComponent.builder()
                .networkModule(new NetworkModule(cacheFile))
                .handlerModule(new HandlerModule())
                .appModule(new AppModule(this))
                .build();


        Stetho.initializeWithDefaults(this);
    }

    private void initSharedPref() {
        i.put("abc-news-au", "https://i.vimeocdn.com/portrait/5584804_640x640");
        i.put("al-jazeera-english", "https://kodi.tv/sites/default/files/addon_assets/plugin.video.aljazeera/icon/icon.png");
        i.put("ars-technica", "http://www.freewarepocketpc.net/wp7/img/ars-technica-news.png");
        i.put("associated-press", "http://4.bp.blogspot.com/-S3a1WmRI2f8/T0ajVCX_n_I/AAAAAAAAER4/brLH7e8f6EA/s1600/AP+logo+1981.png");
        i.put("bbc-news", "http://logodatabases.com/wp-content/uploads/2012/03/bbc-world-news-logo.jpg");
        i.put("bbc-sport", "http://www.baseballsoftballuk.com/uploads/_images/Images/logos/bsuk/partners/bbcsport_2_u.png");
        i.put("bloomberg", "https://www.afsc.org/sites/afsc.civicactions.net/files/styles/maxsize/public/images/Bloomberg.png?itok=eu1P--tr");
        i.put("breitbard-news", "https://www.thewrap.com/wp-content/uploads/2016/11/Breitbart-logo.jpg");
        i.put("business-insider", "http://static5.businessinsider.com/assets/images/us/logos/og-image-logo-social.png");
        i.put("business-insider-uk", "https://pbs.twimg.com/profile_images/573908562033799168/KXHj-uHb.png");
        i.put("buzzfeed", "https://pmcvariety.files.wordpress.com/2016/04/buzzfeed-logo.jpg?w=670&h=377&crop=1");
        i.put("cnbc", "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e3/CNBC_logo.svg/961px-CNBC_logo.svg.png");
        i.put("cnn", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8b/Cnn.svg/2000px-Cnn.svg.png");
        i.put("daily-mail", "https://seeklogo.com/images/D/Daily_Mail-logo-EBD7A83A1F-seeklogo.com.gif");
        i.put("engadget", "https://s.blogcdn.com/www.engadget.com/media/2013/11/engadget-icon-big.png");
        i.put("entertainment-weekly", "https://vignette3.wikia.nocookie.net/logopedia/images/d/d4/Entertainment_Weekly_2006.gif/revision/latest?cb=20120814180831");
        i.put("espn", "http://www.pycomall.com/images/P1/ESPN_logo_in_vector_format.png");
        i.put("espn-cric-info", "https://www.google.com/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&ved=0ahUKEwjQrZusjNzUAhVDOj4KHYCABdQQjBwIBA&url=http%3A%2F%2Fi.imgci.com%2Fespncricinfo%2Fmobile%2FCI_appicon_flat.png&psig=AFQjCNF6PMVLt4BPBpV_XooK8i1APuietA&ust=1498586613811076");
        i.put("financial-times", "https://images-na.ssl-images-amazon.com/images/I/315eO0sIFpL._SY445_.jpg");
        i.put("football-italia", "http://cdn.playbuzz.com/cdn/13c8361f-4f55-4f79-a9e1-fbb763a30e1d/25049662-dcb5-455b-8c52-e424b3ee9e6c.png");
        i.put("fortune", "https://fortunedotcom.files.wordpress.com/2014/05/f_icon_orange_1.png");
        i.put("four-four-two", "https://www.fourfourtwo.com/sites/fourfourtwo.com/themes/fourfourtwo/images/logo-big.png");
        i.put("fox-sports", "https://deltafonts.com/wp-content/uploads/Fox-Sports-logo.png");
        i.put("google-news", "http://searchengineland.com/figz/wp-content/seloads/2011/08/google-news-logo-square.jpg");
        i.put("hacker-news", "https://ih1.redbubble.net/image.120481552.6003/flat,800x800,075,f.jpg");
        i.put("ign", "http://emblemsbf.com/img/12639.jpg");
        i.put("independent", "https://static.independent.co.uk/s3fs-public/styles/article_small/public/thumbnails/image/2017/06/02/11/independent-logo-eagle.png");
        i.put("mashable", "https://deltafonts.com/wp-content/uploads/Mashable-Logo.jpg");
        i.put("metro", "https://www.sfu.ca/content/sfu/surrey/engage/visit-us/open-house/jcr:content/below-main/parsys/image_4.img.1280.high.png/1454638337820.png");
        i.put("mirror", "https://lh3.googleusercontent.com/MDO8iNBCRl_94UrF7Gfp1nY6Pb3V-u7JKsAwdLZNK5zo9qD2QdCvtFF9gjAMgx7KnA=w300");
        i.put("mtv-news", "http://www.scoopmarketing.com/wp-content/uploads/2013/09/mtvnews512.png");
        i.put("mtv-news-uk", "https://pbs.twimg.com/profile_images/1801520411/MTV_News_Logo_Black.png");
        i.put("national-geographic", "http://fontslogo.com/wp-content/uploads/2013/07/National-Geographic-Logo-Font.jpg");
        i.put("new-scientist", "http://www.peteraldhous.com/Images/ns.jpg");
        i.put("new-scientist", "http://www.peteraldhous.com/Images/ns.jpg");
        i.put("newsweek", "http://www.printmediacentr.com/wp-content/uploads/2014/03/Newsweek-logo-print-media-centr.png");
        i.put("new-york-magazine", "http://www.studiosofield.com/wp-content/uploads/2015/10/logo.jpg");
        i.put("nfl-news", "http://cdn.bleacherreport.net/images/team_logos/328x328/nfl.png");
        i.put("polygon", "http://www.mcvuk.com/cimages/053c3b944854750daa0a38f68da3a905.jpg");
        i.put("recode", "https://s-media-cache-ak0.pinimg.com/736x/a7/96/46/a796461b027ac908d6ba79686ab1e215.jpg");
        i.put("reddit-r-all", "https://www.workinghomeguide.com/wp-content/uploads/2012/01/reddit-logo.jpg");
        i.put("reuters", "https://s2.reutersmedia.net/resources/r/?m=02&d=20170413&t=2&i=1180539451&w=780&fh=&fw=&ll=&pl=&sq=&r=LYNXMPED3C183");
        i.put("talksport", "http://talksport.com/sites/all/themes/talkGroup/img/talkSPORT_stacked2.svg");
        i.put("techcrunch", "http://wanderful.com/wp-content/uploads/2013/04/Techcrunch-logo-150x150.jpg");
        i.put("techradar", "https://seeklogo.com/images/T/techradar-logo-2349EA4BCA-seeklogo.com.gif");
        i.put("the-economist", "https://lh3.googleusercontent.com/j0rfLNcDw7hmSdKKXH88JA6tG6WKANNPIg1_9prDyLL2nLEUESd47CfTmyH1JLpTxxoD=w300");
        i.put("the-guardian-au", "http://static.guim.co.uk/icons/social/og/gu-logo-fallback.png");
        i.put("the-guardian-uk", "http://static.guim.co.uk/icons/social/og/gu-logo-fallback.png");
        i.put("the-hindu", "http://georgebishopjr.com/wp-content/uploads/2015/08/TheHindu-Logo.jpg");
        i.put("the-huffington-post", "http://www.girlswithsole.org/wp-content/uploads/2017/03/huffington-post-logo.jpg-500x321.png");
        i.put("the-lad-bible", "https://pbs.twimg.com/profile_images/847847622585057280/emlDmI7g.jpg");
        i.put("the-new-york-times", "https://static01.nyt.com/images/icons/t_logo_291_black.png");
        i.put("the-next-web", "http://www.abc.nl/images/uploads/20160419tnw.png");
        i.put("the-sport-bible", "https://www.soccerex.com/media/5490/sportbiblelogo-website.jpg?anchor=center&mode=crop&width=300&height=300&rnd=131387342370000000");
        i.put("the-telegraph", "http://www.telegraph.co.uk/content/dam/best/telegraph_OUTLINE-small.png");
        i.put("the-times-of-india", "https://plumvillage.org/wp-content/uploads/2014/11/times-of-india-logo-2.jpeg");
        i.put("the-verge", "https://cdn.vox-cdn.com/community_logos/35025/verge-logo-lg.jpg");
        i.put("the-wall-street-journal", "https://www.wsj.com/apple-touch-icon.png");
        i.put("the-washington-post", "http://andrewmaraniss.com/wp-content/uploads/2015/01/washingtonpost.png");
        i.put("time", "http://www.spi-global.com/blog/cs-blog/files/2015/01/time-logo.png");
        i.put("usa-today", "https://www.gannett-cdn.com/GDContent/applogos/usatoday.png");


        Context context = getApplicationContext();
        SharedPreferences sharedPref = context.getSharedPreferences("prefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor valuesEditor = sharedPref.edit();

        for(String s: i.keySet()){
            valuesEditor.putString(s, i.get(s));
        }

        valuesEditor.apply();
    }

    public ActivityComponent getComponent() {
        return component;
    }

    public HashMap<String, String> getI() {
        return i;
    }
}
