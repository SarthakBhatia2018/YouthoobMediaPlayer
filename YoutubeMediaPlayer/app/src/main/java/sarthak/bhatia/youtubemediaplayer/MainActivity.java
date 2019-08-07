package sarthak.bhatia.youtubemediaplayer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.youtube.player.YouTubePlayer;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public String Url;
    Context context = this;
    private ArrayList<Exampleitems> mExaplelist;
    private RecyclerView mrecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mlayoutmanager;
    private ImageView Add_button;
    private EditText URL_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createExampleList();
        buildRecyclerView();
        setbuttons();

    }

    private void setbuttons() {
        Add_button = findViewById(R.id.ADD);
        URL_text = findViewById(R.id.URL);
        Add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Url = URL_text.getText().toString();
            }
        });

    }

    private void buildRecyclerView() {
        mrecyclerView = findViewById(R.id.recyclerview);
        mrecyclerView.setHasFixedSize(true);
        mAdapter = new ExampleAdapter(this, mExaplelist);
        mlayoutmanager = new LinearLayoutManager(this);
        mrecyclerView.setAdapter(mAdapter);
        mrecyclerView.setLayoutManager(mlayoutmanager);

        mAdapter.setOnItemClickListener(new ExampleAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {
                Intent intent = new Intent(MainActivity.this,sarthak.bhatia.youtubemediaplayer.YoutubePlayer.class);
                intent.putExtra("URL_id", mExaplelist.get(position).getURL());
//        Log.d("Sarthak",mExaplelist.get(position).getURL());
                context.startActivity(intent);
            }

//            @Override
//            public void OnDeleteClick(int position) {
//                RemoveItem(position);
//            }
        });
    }
//
//    private void LoadYoutubevideo(int position) {
//        Intent intent = new Intent(MainActivity.this, YouTubePlayer.class);
//        intent.putExtra("URL_id", mExaplelist.get(position).getURL());
////        Log.d("Sarthak",mExaplelist.get(position).getURL());
//        context.startActivity(intent);
//    }

    private void createExampleList() {
        mExaplelist = new ArrayList<>();
        mExaplelist.add(new Exampleitems(R.drawable.ic_android, "Line1", "https://www.youtube.com/watch?v=mCHUw7ACS8o"));
        mExaplelist.add(new Exampleitems(R.drawable.ic_attach_money, "Line2", "https://www.youtube.com/watch?v=mCHUw7ACS8o"));
        mExaplelist.add(new Exampleitems(R.drawable.ic_attach_money, "Line3", "https://www.youtube.com/watch?v=mCHUw7ACS8o"));

    }
}

