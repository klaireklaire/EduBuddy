package com.example.myapplication.persistence;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import com.example.myapplication.model.UserLibrary;
import com.example.myapplication.model.User;
import com.example.myapplication.model.TutorUser;



public class FirestoreFacade implements IPersistenceFacade{

    private static final String USERS_COLLECTION = "users";
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    public FirestoreFacade(){ }

    @Override
    public void saveUser(User user) {
        db.collection(USERS_COLLECTION).add(user.toMap());
    }

    @Override
    public void saveTutorUser(@NonNull TutorUser tutorUser) {
        db.collection(USERS_COLLECTION).add(tutorUser.toMap());
    }


    @Override
    public void retrieveUserLibrary(DataListener<UserLibrary> listener) {
        db.collection(USERS_COLLECTION).get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot qsnap) {
                        UserLibrary ul = new UserLibrary();
                        for (DocumentSnapshot dsnap : qsnap){
                            if (dsnap.contains("ratePerHour")) {
                                User user = TutorUser.fromMap(dsnap.getData());
                                ul.addUser(user);
                            } else {
                                User user = User.fromMap(dsnap.getData());
                                ul.addUser(user);
                            }

                        }
                        listener.onDataReceived(ul);
                    }
                });
    }

    @Override
    public void createUserIfNotExists(@NonNull User user, @NonNull BinaryResultListener listener) {

        String username = user.getEmail();

        this.retrieveUser(username, new DataListener<User>() {
            @Override
            public void onDataReceived(@NonNull User data) {
                listener.onNoResult();
            }

            @Override
            public void onNoDataFound() {
                db.collection(USERS_COLLECTION).document(username).
                        set(user).
                        addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                listener.onYesResult();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        listener.onNoResult();
                    }
                });

            }
        });

    }

    @Override
    public void retrieveUser(@NonNull String username, @NonNull DataListener<User> listener) {

        db.collection(USERS_COLLECTION).document(username).get().
                addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                         @Override
                                         public void onSuccess(DocumentSnapshot dsnap) {
                                             if (dsnap.exists()){
                                                 if (dsnap.contains("ratePerHour")) {
                                                     User user = TutorUser.fromMap(dsnap.getData());
                                                     listener.onDataReceived(user);
                                                 } else {
                                                     User user = User.fromMap(dsnap.getData());
                                                     listener.onDataReceived(user);
                                                 }
                                             } else // no user found
                                                 listener.onNoDataFound();
                                         }
                                     }
                );

    }
}
