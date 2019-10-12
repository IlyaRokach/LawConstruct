package by.europrotocol.data.repository;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


public class SettingApplication {

    private static final String NAME = "BalbatunApplicationSettings";

    private static final String TOKEN = "BalbatunTokenAuthentication";

    private static final String USERNAME = "BalbatunUsernameAuthentication";


    private static final Object sLockObject = new Object();

    @NonNull
    private final static MutableLiveData<Boolean> sStatusAuthorization = new MutableLiveData<>();

    @NonNull
    private static SharedPreferences getStorageSettings(@NonNull Context context){

        return context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
    }

    public static void saveToken(@NonNull Context context, @Nullable String token, @Nullable String username){

        synchronized (sLockObject) {

            SharedPreferences sharedPreferences = getStorageSettings(context);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            editor.putString(TOKEN, token);
            editor.putString(USERNAME, username);

            editor.apply();

            sStatusAuthorization.postValue(token != null);
        }
    }

    @Nullable
    public static String getToken(@NonNull Context context){

        synchronized (sLockObject) {

            SharedPreferences sharedPreferences = getStorageSettings(context);

            return sharedPreferences.getString(TOKEN, null);
        }
    }

    public static boolean isAuthorization(@NonNull Context context) {

        synchronized (sLockObject) {

            SharedPreferences sharedPreferences = getStorageSettings(context);

            boolean result = sharedPreferences.getString(TOKEN, null) != null;

            Boolean status = sStatusAuthorization.getValue();

            if((status != null && status != result)) {

                sStatusAuthorization.postValue(result);
            } else if(status == null){

                sStatusAuthorization.postValue(result);
            }

            return result;
        }
    }

    @NonNull
    public static LiveData<Boolean> getStatusAuthorization() {
        return sStatusAuthorization;
    }
}
