package in.ac.amrapali.amrapaliinstitute;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class about extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        simulateDayNight(/* DAY */ 0);

        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setImage(R.drawable.amrapali_about)
                .addItem(new Element().setTitle("Version 1"))
                .addGroup("Connect with us")
                .addEmail("query@amrapali.ac.in")
                .addWebsite("http://www.amrapali.ac.in")
                .addFacebook("AGI.HLD")
                .addTwitter("amrapaligroup15")
                .addYoutube("UCF8i_kuxpGG5DycApVK8xxg")
                .addInstagram("agihld")
                .setDescription("AMRAPALI Group of Institutes was established in 1999 under the aegis of Modern Academy Society.\n" +
                        "\n" +
                        "The Institutes constituting the group are:\n" +
                        "» Institute of Technology & Sciences (AITS)\n" +
                        "» Institute of Management & Computer Applications (AIMCA)\n" +
                        "» Institute of Hospitality Management (AIHM)\n" +
                        "» Institute of Applied Sciences (AIAS)\n")
                .create();

        setContentView(aboutPage);
    }
    void simulateDayNight(int currentSetting) {
        final int DAY = 0;
        final int NIGHT = 1;
        final int FOLLOW_SYSTEM = 3;

        int currentNightMode = getResources().getConfiguration().uiMode
                & Configuration.UI_MODE_NIGHT_MASK;
        if (currentSetting == DAY && currentNightMode != Configuration.UI_MODE_NIGHT_NO) {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_NO);
        } else if (currentSetting == NIGHT && currentNightMode != Configuration.UI_MODE_NIGHT_YES) {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_YES);
        } else if (currentSetting == FOLLOW_SYSTEM) {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
        }
    }
}
