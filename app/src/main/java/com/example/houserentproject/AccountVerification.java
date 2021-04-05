package com.example.houserentproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.UUID;

public class AccountVerification extends AppCompatActivity {

    //private Button btnFrontChoose, btnBackChoose, btnImageUpload;

    private ImageView frontImageView, backImageView;

    private Uri frontFilePath, backFilePath;

    private FirebaseStorage storage;
    private StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_verification);

        //btnFrontChoose = (Button) findViewById(R.id.chooseFrontImageBtnId);
        //btnBackChoose = (Button) findViewById(R.id.chooseBacktImageBtnId);
        //btnImageUpload = (Button) findViewById(R.id.uploadVeriImageBtnId);

        frontImageView = (ImageView) findViewById(R.id.frontImageId);
        backImageView = (ImageView) findViewById(R.id.backImageId);

        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    public void uploadVeriImageBtn(View view) {
        //front side upload
        uploadFrontImage();

    }

    public void chooseFrontImageBtn(View view) {

        chooseFrontImage();

    }

    public void chooseBackImageBtn(View view) {

        chooseBackImage();

    }

    private void chooseFrontImage() {

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select Front Side of NID Card or Student ID Card"), 2);

    }

    private void chooseBackImage() {

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select Back Side of NID Card or Student ID Card"), 3);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 2 && resultCode == RESULT_OK && data != null && data.getData() != null){
            frontFilePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),frontFilePath);
                frontImageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (requestCode == 3 && resultCode == RESULT_OK && data != null && data.getData() != null){
            backFilePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),backFilePath);
                backImageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void uploadFrontImage() {


        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Front Side Uploading...");
        progressDialog.show();

        if (frontFilePath != null){

            StorageReference reference = storageReference.child("frontImages/" + UUID.randomUUID().toString());
            reference.putFile(frontFilePath)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            progressDialog.dismiss();
                            Toast.makeText(AccountVerification.this, "Front Side Uploaded", Toast.LENGTH_SHORT).show();
                            //back side upload
                            uploadBackImage();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                            double progress = (100.0*snapshot.getBytesTransferred()/snapshot.getTotalByteCount());
                            progressDialog.setMessage("Uploaded Front Side "+ (int) progress + "%");
                        }
                    });

        }

    }

    private void uploadBackImage() {

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Back Side Uploading...");
        progressDialog.show();

        if (backFilePath != null){

            StorageReference reference = storageReference.child("backImages/" + UUID.randomUUID().toString());
            reference.putFile(backFilePath)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            progressDialog.dismiss();
                            Toast.makeText(AccountVerification.this, "Back Side Uploaded", Toast.LENGTH_SHORT).show();

                            startActivity(new Intent(AccountVerification.this, MainActivity.class));
                            finish();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                            double progress = (100.0*snapshot.getBytesTransferred()/snapshot.getTotalByteCount());
                            progressDialog.setMessage("Uploaded Back Side "+ (int) progress + "%");
                        }
                    });

        }

    }



}