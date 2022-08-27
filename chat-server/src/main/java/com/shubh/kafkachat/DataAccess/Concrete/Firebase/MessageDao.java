package com.shubh.kafkachat.DataAccess.Concrete.Firebase;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.shubh.kafkachat.Entities.Message;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class MessageDao {
    private static final String COLLECTION_NAME="message";

    public String saveMessage(Message message) throws ExecutionException, InterruptedException {

        Firestore dbFirestore= FirestoreClient.getFirestore();

        ApiFuture<WriteResult> collectionApiFuture= dbFirestore.collection(COLLECTION_NAME).document(message.getSender()).set(message);

        return collectionApiFuture.get().getUpdateTime().toString();
    }





    public List<Message> getMessageDetails() throws ExecutionException, InterruptedException {
        Firestore dbFirestore= FirestoreClient.getFirestore();

        Iterable<DocumentReference> documentReference= dbFirestore.collection(COLLECTION_NAME).listDocuments();
        Iterator<DocumentReference> iterator=documentReference.iterator();

        List<Message> messageList=new ArrayList<>();
        Message message=null;


        while (iterator.hasNext()){
            DocumentReference documentReference1=iterator.next();
            ApiFuture<DocumentSnapshot> future=documentReference1.get();
            DocumentSnapshot document=future.get();

            message=document.toObject(Message.class);
            messageList.add(message);

        }
        return messageList;

    }




}
