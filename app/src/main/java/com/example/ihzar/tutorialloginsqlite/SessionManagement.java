package com.example.ihzar.tutorialloginsqlite;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

public class SessionManagement {
    //Share preference
    private SharedPreferences mSharedPreference;
    // Editor for Shared preference
    private SharedPreferences.Editor mEditor;
    // context
    private Context mContext;
    // Shared pref mode
    int PRIVATE_MODE;
    // Shared pref name
    private static final String PREF_NAME = "SharedPrefLatihan";
    // Shared Preferences Keys
    private static final String IS_LOGIN = "IsLoggedIn";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWORD = "username";

    public SessionManagement(Context mContext) {
        this.mContext = mContext;
        mSharedPreference = this.mContext.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        mEditor = mSharedPreference.edit();
    }

    public void createLoginSession(String username, String password) {
        //Membuat Session Login
        mEditor.putBoolean(IS_LOGIN, true);
        mEditor.putString(KEY_USERNAME, username);
        mEditor.putString(KEY_PASSWORD, password);
        mEditor.commit();
    }

    public HashMap<String, String> getUserInformation()
    {
        //
        HashMap<String, String> user = new HashMap<String, String>();
        user.put(KEY_USERNAME, mSharedPreference.getString(KEY_USERNAME, null));
        user.put(KEY_PASSWORD, mSharedPreference.getString(KEY_PASSWORD, null));
        return user;
    }

    public boolean isLoggedIn() {
        return mSharedPreference.getBoolean(IS_LOGIN, false);
    }

    public void checkIsLogin() {
        if (!isLoggedIn()) {
            Intent i = new Intent(mContext, MainActivity.class);
            // Closing all the Activities
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            // Add new Flag to start new Activity
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            mContext.startActivity(i);
            }
    }
    public void logoutUser(){
        //Menghilangkan session
        mEditor.clear();
        mEditor.commit();

        Intent i = new Intent(mContext, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(i);
    }
}