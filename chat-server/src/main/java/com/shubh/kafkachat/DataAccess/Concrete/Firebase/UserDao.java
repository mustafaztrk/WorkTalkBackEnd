package com.shubh.kafkachat.DataAccess.Concrete.Firebase;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.shubh.kafkachat.core.Abstract.IUserDao;
import com.shubh.kafkachat.Entities.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;


@Service
public class UserDao implements IUserDao {

    private static final String COLLECTION_NAME="users";

    public String saveUser(User user) throws ExecutionException, InterruptedException {

        Firestore dbFirestore= FirestoreClient.getFirestore();

        ApiFuture<WriteResult> collectionApiFuture= dbFirestore.collection(COLLECTION_NAME).document(user.getName()).set(user);

        return collectionApiFuture.get().getUpdateTime().toString();
    }



    public List<User> getUserDetails() throws ExecutionException, InterruptedException {
        Firestore dbFirestore= FirestoreClient.getFirestore();

        Iterable<DocumentReference> documentReference= dbFirestore.collection(COLLECTION_NAME).listDocuments();
        Iterator<DocumentReference> iterator=documentReference.iterator();

        List<User> userList=new ArrayList<>();
        User user=null;


        while (iterator.hasNext()){
            DocumentReference documentReference1=iterator.next();
            ApiFuture<DocumentSnapshot> future=documentReference1.get();
            DocumentSnapshot document=future.get();

            user=document.toObject(User.class);
            userList.add(user);

        }
        return userList;

    }





    public User getUserDetailsByName(String name) throws ExecutionException, InterruptedException {
        Firestore dbFirestore= FirestoreClient.getFirestore();

        DocumentReference documentReference= dbFirestore.collection(COLLECTION_NAME).document(name);

        ApiFuture<DocumentSnapshot> future=documentReference.get();

        DocumentSnapshot document=future.get();

        User user=null;
        if (document.exists()){
            user=document.toObject(User.class);
            return user;
        }
        else{
            return null;
        }

    }


    @Override
    public ArrayList<User> GetAll() throws ExecutionException, InterruptedException {
        Firestore dbFirestore= FirestoreClient.getFirestore();

        Iterable<DocumentReference> documentReference= dbFirestore.collection(COLLECTION_NAME).listDocuments();
        Iterator<DocumentReference> iterator=documentReference.iterator();

        ArrayList<User> userList=new ArrayList<>();
        User user=null;


        while (iterator.hasNext()){
            DocumentReference documentReference1=iterator.next();
            ApiFuture<DocumentSnapshot> future=documentReference1.get();
            DocumentSnapshot document=future.get();

            user=document.toObject(User.class);
            userList.add(user);

        }
        return userList;
    }

    @Override
    public void Add(User user) throws ExecutionException, InterruptedException {
        Firestore dbFirestore= FirestoreClient.getFirestore();

        ApiFuture<WriteResult> collectionApiFuture= dbFirestore.collection(COLLECTION_NAME).document(user.getName()).set(user);


    }

    @Override
    public void Update(User entity) {

    }

    @Override
    public void Delete(User entity) {

    }


    @Override
    public User getByName(String name) throws ExecutionException, InterruptedException {
        Firestore dbFirestore= FirestoreClient.getFirestore();

        DocumentReference documentReference= dbFirestore.collection(COLLECTION_NAME).document(name);

        ApiFuture<DocumentSnapshot> future=documentReference.get();

        DocumentSnapshot document=future.get();

        User user=null;
        if (document.exists()){
            user=document.toObject(User.class);
            return user;
        }
        else{
            return null;
        }
    }
}

