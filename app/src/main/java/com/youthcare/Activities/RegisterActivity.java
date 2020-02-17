package com.youthcare.Activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.youthcare.R;

public class RegisterActivity extends AppCompatActivity {
    static int PReqCode = 1;
    static int REQUEST_IMAGE_GET = 1;
    private static Uri DEFAULT_IMAGE_URI = Uri.parse("content://com.android.providers.media.documents/document/image%3A124");
    Uri pickedImageUri;
    private ImageView imgUserPhoto;
    private EditText email, password, password2, userName;
    private ProgressBar progressBar;
    private Button regBtn;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setTitle(getString(R.string.create_account));


        //image
        pickedImageUri = DEFAULT_IMAGE_URI;
        imgUserPhoto = findViewById(R.id.UserPhoto);
        imgUserPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= 22) {
                    CheckAndRequestForPermission();
                } else {
                    openGallery();
                }
            }
        });
        email = findViewById(R.id.registerEmail);
        password = findViewById(R.id.password);
        password2 = findViewById(R.id.confirm_password);
        userName = findViewById(R.id.userName);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);
        regBtn = findViewById(R.id.registerButton);
        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapProgressBar();
                final String usrName = userName.getText().toString();
                final String pass = password.getText().toString();
                final String pass2 = password2.getText().toString();
                final String mail = email.getText().toString();
                if (usrName.isEmpty() || mail.isEmpty() || pass.isEmpty() || !pass.equals(pass2)) {
                    showMessage("please verify all fields");

                    swapProgressBar();
                } else {
                    createAccount(mail, usrName, pass);
                }
            }
        });
        mAuth = FirebaseAuth.getInstance();
    }

    private void createAccount(String mail, final String usrName, String pass) {
        mAuth.createUserWithEmailAndPassword(mail, pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    showMessage("Account Created");
                    UpdateUserInfo(usrName, pickedImageUri, mAuth.getCurrentUser());
                } else {
                    showMessage("Account Creation Failed" + task.getException().getMessage());
                    swapProgressBar();
                }
            }
        });
    }

    private void UpdateUserInfo(final String usrName, final Uri pickedImageUri, final FirebaseUser currentUser) {
        StorageReference msStorageReference = FirebaseStorage.getInstance().getReference().child("users_photos");
        final StorageReference imageFilePath = msStorageReference.child(pickedImageUri.getLastPathSegment());
        imageFilePath.putFile(pickedImageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                imageFilePath.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        UserProfileChangeRequest profileUpdate = new UserProfileChangeRequest.Builder()
                                .setDisplayName(usrName)
                                .setPhotoUri(pickedImageUri)
                                .build();
                        currentUser.updateProfile(profileUpdate).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    //user info updated
                                    showMessage("Register Complete");
                                    UpdateUI();
                                } else {
                                    showMessage("Register Failed");
                                }
                            }
                        });
                    }
                });
            }
        });

    }

    private void UpdateUI() {
        Intent homeActivity = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(homeActivity);
        finish();
    }

    private void showMessage(String message) {
        Toast.makeText(RegisterActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    private void swapProgressBar() {
        if (progressBar.getVisibility() == View.VISIBLE) {
            progressBar.setVisibility(View.INVISIBLE);
            regBtn.setVisibility(View.VISIBLE);
        } else {
            regBtn.setVisibility(View.INVISIBLE);
            progressBar.setVisibility(View.VISIBLE);

        }
    }

    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_IMAGE_GET);
        }
    }

    private void CheckAndRequestForPermission() {
        if (ContextCompat.checkSelfPermission(RegisterActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(RegisterActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
                Toast.makeText(RegisterActivity.this, "Please accept for required permission", Toast.LENGTH_SHORT).show();
            } else {

                ActivityCompat.requestPermissions(RegisterActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, PReqCode);
            }

        } else {
            openGallery();
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == REQUEST_IMAGE_GET && data != null) {
            pickedImageUri = data.getData();
            imgUserPhoto.setImageURI(pickedImageUri);
            Toast.makeText(RegisterActivity.this, "get Image Uri successfully ", Toast.LENGTH_SHORT).show();
            Log.e("uri", pickedImageUri.toString());
        } else {
            Toast.makeText(RegisterActivity.this, "get Image Uri failed ", Toast.LENGTH_SHORT).show();
        }
    }

}
