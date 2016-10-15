package knf.animeflv.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.annotation.ColorRes;

import knf.animeflv.ColorsRes;
import knf.animeflv.R;

/**
 * Created by Jordy on 30/03/2016.
 */
public class ThemeUtils {
    private static Context contex;

    public static void init(Context con) {
        contex = con;
    }

    public static int getAcentColor(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        int accent = preferences.getInt("accentColor", ColorsRes.Naranja(context));
        int color = ColorsRes.Naranja(context);
        if (accent == ColorsRes.Rojo(context)) {
            color = ColorsRes.Rojo(context);
        }
        if (accent == ColorsRes.Naranja(context)) {
            color = ColorsRes.Naranja(context);
        }
        if (accent == ColorsRes.Gris(context)) {
            color = ColorsRes.Gris(context);
        }
        if (accent == ColorsRes.Verde(context)) {
            color = ColorsRes.Verde(context);
        }
        if (accent == ColorsRes.Rosa(context)) {
            color = ColorsRes.Rosa(context);
        }
        if (accent == ColorsRes.Morado(context)) {
            color = ColorsRes.Morado(context);
        }
        return color;
    }

    public static void setThemeOn(Activity context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        int accent = preferences.getInt("accentColor", ColorsRes.Naranja(context));
        if (preferences.getBoolean("is_amoled", false)) {
            if (accent == ColorsRes.Rojo(context)) {
                context.setTheme(R.style.AppThemeDarkRojo);
            }
            if (accent == ColorsRes.Naranja(context)) {
                context.setTheme(R.style.AppThemeDarkNaranja);
            }
            if (accent == ColorsRes.Gris(context)) {
                context.setTheme(R.style.AppThemeDarkGris);
            }
            if (accent == ColorsRes.Verde(context)) {
                context.setTheme(R.style.AppThemeDarkVerde);
            }
            if (accent == ColorsRes.Rosa(context)) {
                context.setTheme(R.style.AppThemeDarkRosa);
            }
            if (accent == ColorsRes.Morado(context)) {
                context.setTheme(R.style.AppThemeDarkMorado);
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                context.getWindow().setNavigationBarColor(context.getResources().getColor(R.color.negro));
            }
        } else {
            if (accent == ColorsRes.Rojo(context)) {
                context.setTheme(R.style.AppThemeRojo);
            }
            if (accent == ColorsRes.Naranja(context)) {
                context.setTheme(R.style.AppThemeNaranja);
            }
            if (accent == ColorsRes.Gris(context)) {
                context.setTheme(R.style.AppThemeGris);
            }
            if (accent == ColorsRes.Verde(context)) {
                context.setTheme(R.style.AppThemeVerde);
            }
            if (accent == ColorsRes.Rosa(context)) {
                context.setTheme(R.style.AppThemeRosa);
            }
            if (accent == ColorsRes.Morado(context)) {
                context.setTheme(R.style.AppThemeMorado);
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                context.getWindow().setNavigationBarColor(context.getResources().getColor(R.color.prim));
            }
        }
        setOrientation(context);
    }

    public static void setSplashTheme(Activity activity, @ColorRes int color) {
        switch (color) {
            case R.color.nmain:
                activity.setTheme(R.style.SplashNormal);
                break;
            case R.color.prim:
                activity.setTheme(R.style.SplashDark);
                break;
            case R.color.navidad:
                activity.setTheme(R.style.SplashNavidad);
                break;
            case R.color.anuevo:
                activity.setTheme(R.style.SplashAnuevo);
                break;
            case R.color.amor:
                activity.setTheme(R.style.SplashAmor);
                break;
            case R.color.negro:
                activity.setTheme(R.style.SplashNegro);
                break;
        }
    }

    public static void setOrientation(Activity activity){
        boolean isXLargeScreen=(activity.getResources().getConfiguration().screenLayout
                & Configuration.SCREENLAYOUT_SIZE_MASK)
                >= Configuration.SCREENLAYOUT_SIZE_XLARGE;
        if (!isXLargeScreen) { //Portrait
            activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        } else {
            activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
    }

    public static boolean isAmoled(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("is_amoled", false);
    }
}
