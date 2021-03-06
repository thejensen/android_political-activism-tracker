package com.epicodus.politicalactivismtracker.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.politicalactivismtracker.Constants;
import com.epicodus.politicalactivismtracker.R;
import com.epicodus.politicalactivismtracker.models.Event;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

/**
 * Created by jensese on 12/22/16.
 */

public class FirebaseSavedEventViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public static final int MAX_WIDTH = 200;
    private static final int MAX_HEIGHT = 200;

    View mView;
    Context mContext;

    public FirebaseSavedEventViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void bindAction(Event event) {
        TextView actionNameTextView = (TextView) mView.findViewById(R.id.actionNameTextView);
        TextView actionLocationTextView = (TextView) mView.findViewById(R.id.locationTextView);
        ImageView actionImageView = (ImageView) mView.findViewById(R.id.actionImageView);
        TextView actionActionTextView = (TextView) mView.findViewById(R.id.actionCategoryTextView);
        ImageView eventThresholdListImageView = (ImageView) mView.findViewById(R.id.thresholdListImageView);

        Picasso.with(mContext)
                .load(event.getImageUrl())
                .resize(MAX_WIDTH, MAX_HEIGHT)
                .centerCrop()
                .into(actionImageView);

        actionNameTextView.setText(event.getName());
        actionLocationTextView.setText(event.getLocation());
        actionActionTextView.setText(event.getCategoryAction());

        if (event.getHappening() == 1) {
            eventThresholdListImageView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(View v) {
        final ArrayList<Event> events = new ArrayList<>();
        final ArrayList<String> keys = new ArrayList<>();

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_ACTIONS);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String key = snapshot.getKey();
                    keys.add(key);
                    events.add(snapshot.getValue(Event.class));
                }

                int itemPosition = getLayoutPosition();

                Intent intent = new Intent(mContext, EventDetailActivity.class);
                intent.putExtra("position", itemPosition);
                intent.putExtra("keys", Parcels.wrap(keys));
                intent.putExtra("events", Parcels.wrap(events));

                mContext.startActivity(intent);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
}

