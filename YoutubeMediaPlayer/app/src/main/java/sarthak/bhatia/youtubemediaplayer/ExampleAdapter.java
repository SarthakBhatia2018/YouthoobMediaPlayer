package sarthak.bhatia.youtubemediaplayer;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubePlayer;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
    public ArrayList<Exampleitems> mexamplelist;
    public OnItemClickListener mlistener;
    public Context mcontext;

    public ExampleAdapter(Context context, ArrayList<Exampleitems> exampleitems) {
        mcontext = context;
        mexamplelist = exampleitems;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mlistener = listener;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.datacard, viewGroup, false);
        ExampleViewHolder evs = new ExampleViewHolder(v, mlistener);
        return evs;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder exampleViewHolder, final int i) {
        Exampleitems currentItem = mexamplelist.get(i);
        exampleViewHolder.mimage.setImageResource(currentItem.getImageResource());
        exampleViewHolder.mTitle.setText(currentItem.getTitle());
//        exampleViewHolder.mimage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(mcontext, YouTubePlayer.class);
//                intent.putExtra("URL_id", mexamplelist.get(i).getURL());
//                Log.d("Sarthak", mexamplelist.get(i).getURL());
//                mcontext.startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return mexamplelist.size();
    }

    public interface OnItemClickListener {
        void OnItemClick(int position);

//        void OnDeleteClick(int position);
    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {

        public ImageView mimage;
        public TextView mTitle;

        public ExampleViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            mimage = itemView.findViewById(R.id.mimage);
            mTitle = itemView.findViewById(R.id.mTitle);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.OnItemClick(position);
                        }
                    }
                }
            });

        }

    }
}
