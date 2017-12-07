package io.gresse.hugo.tp2;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.ArrayList;

/**
 * Created by kykyl on 04/12/2017.
 */

public class UserStorage {

    private static final String USER_NAME = "Name";
    private static final String USER_EMAIL = "Email";
    public static final String USER_NOTDEFINED = null;

    public static void saveUserInfo(Context context, String name, String email) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putString(USER_NAME, name);
        editor.putString(USER_EMAIL, email);
        editor.apply();
    }


    public static User getUser(Context context) {
        SharedPreferences preference = PreferenceManager.getDefaultSharedPreferences(context);
        return new User(preference.getString(USER_NAME, USER_NOTDEFINED), preference.getString(USER_EMAIL,USER_NOTDEFINED));
    }

    public static boolean delete(Context context){
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.remove(USER_NAME);
        editor.remove(USER_EMAIL);
        editor.apply();
        return true;
    }
}
