package com.example.a1.themecolordemo;


import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.afollestad.materialdialogs.color.ColorChooserDialog;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends PreferenceFragment implements Preference.OnPreferenceChangeListener,
Preference.OnPreferenceClickListener{

    private Preference theme;

    public SettingFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.setting);
        theme = findPreference(ThemeSetting.THEME);

        String[] colorNames = getActivity().getResources().getStringArray(R.array.color_name);
        int currentThemeIndex = ThemeSetting.getTheme();
        if (currentThemeIndex >= colorNames.length) {
            theme.setSummary("自定义色");
        } else {
            theme.setSummary(colorNames[currentThemeIndex]);
        }
        theme.setOnPreferenceClickListener(this);
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        return false;
    }

    @Override
    public boolean onPreferenceClick(Preference preference) {
       if(preference==theme){
           new ColorChooserDialog.Builder((SettingActivity)getActivity(),R.string.theme)
                   .customColors(R.array.colors,null)
                   .doneButton(R.string.done)
                   .cancelButton(R.string.cancel)
                   .allowUserColorInput(false)
                   .show();
       }

        return true;
    }
}
