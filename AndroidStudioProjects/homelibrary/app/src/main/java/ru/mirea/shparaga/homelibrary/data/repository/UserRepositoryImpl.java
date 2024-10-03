package ru.mirea.shparaga.homelibrary.data.repository;

import android.content.Context;
import android.content.SharedPreferences;

import ru.mirea.shparaga.homelibrary.domain.model.User;
import ru.mirea.shparaga.homelibrary.domain.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository {
    private static final String PREFS_NAME = "user_prefs";
    private static final String KEY_USER_NAME = "user_name";
    private static final String KEY_USER_PHONE = "user_phone";
    private final SharedPreferences sharedPreferences;

    public UserRepositoryImpl(Context context) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public boolean updateUser(User user) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_USER_NAME, user.getName());
        editor.putString(KEY_USER_PHONE, user.getPhone());
        return editor.commit();
    }

    @Override
    public User getUserInfo() {
        String name = sharedPreferences.getString(KEY_USER_NAME, null);
        String phone = sharedPreferences.getString(KEY_USER_PHONE, null);

        if (name != null && phone != null) {
            return new User(name, phone);
        }
        return null;
    }

    @Override
    public void logOut() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}
