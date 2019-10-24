package com.example.slinder;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricPrompt;
import android.os.Bundle;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import androidx.fragment.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.Toast;
//import android.support.annotation.Nullable;
//import android.support.v/.app.AppCompatActivity;

import androidx.annotation.NonNull;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


//import static android.app.ProgressDialog.show;
//import static com.example.slinder.MainActivity.REQUEST_CODE;

public class LoginActivity extends AppCompatActivity {

    List<AuthUI.IdpConfig> providers;
//
//    private static final String TAG = LoginActivity.class.getName();

    private BackPressCloseHandler backPressCloseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        backPressCloseHandler = new BackPressCloseHandler(this);

        //List provider
        providers = Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build(),
                new AuthUI.IdpConfig.PhoneBuilder().build(),
                new AuthUI.IdpConfig.FacebookBuilder().build(),
                new AuthUI.IdpConfig.GoogleBuilder().build()
        );

        showSignInOptions();
//
////Create a thread pool with a single thread//
//
//        Executor newExecutor = Executors.newSingleThreadExecutor();
//
//        FragmentActivity activity = this;
//
////Start listening for authentication events//
//
//        final BiometricPrompt myBiometricPrompt = new BiometricPrompt(activity, newExecutor, new BiometricPrompt.AuthenticationCallback() {
//            @Override
//
////onAuthenticationError is called when a fatal error occurrs//
//
//            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
//                super.onAuthenticationError(errorCode, errString);
//                if (errorCode == BiometricPrompt.ERROR_NEGATIVE_BUTTON) {
//                } else {
//
////Print a message to Logcat//
//
//                    Log.d(TAG, "An unrecoverable error occurred");
//                }
//            }
//
////onAuthenticationSucceeded is called when a fingerprint is matched successfully//
//
//            @Override
//            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
//                super.onAuthenticationSucceeded(result);
//
////Print a message to Logcat//
//
//                Log.d(TAG, "Fingerprint recognised successfully");
//

//
//            }
//
////onAuthenticationFailed is called when the fingerprint doesn’t match//
//
//            @Override
//            public void onAuthenticationFailed() {
//                super.onAuthenticationFailed();
//
////Print a message to Logcat//
//
//                Log.d(TAG, "Fingerprint not recognised");
//            }
//        });
//
////Create the BiometricPrompt instance//
//
//        String mContext = getString(R.string.auth);
//
//        final BiometricPrompt.PromptInfo promptInfo = new BiometricPrompt.PromptInfo.Builder()
//
////Add some text to the dialog//
//
//                .setTitle(mContext)
//                .setSubtitle("지문을 스캔해 주세요")
//                .setDescription(" ")
//                .setNegativeButtonText("Cancel")
//
////Build the dialog//
//
//                .build();
//
//
////Assign an onClickListener to the app’s “Authentication” button//
//
//        findViewById(R.id.fingerprint).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                myBiometricPrompt.authenticate(promptInfo);
//            }
//        });

    }
//
    private void showSignInOptions() {
        startActivityForResult(
                AuthUI.getInstance().createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .setTheme(R.style.SignTheme)
                        .build(),1
        );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            IdpResponse response = IdpResponse.fromResultIntent(data);
            if(resultCode == RESULT_OK){
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                Toast.makeText(this, ""+user.getEmail(), Toast.LENGTH_SHORT).show();
            }
        }

        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);

    }
    @Override
    public void onBackPressed(){
        backPressCloseHandler.onBackPressed();
    }
}
