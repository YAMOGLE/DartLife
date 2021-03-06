package com.example.dartlife.adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.SearchView;
import android.widget.TextView;
import org.honorato.multistatetogglebutton.MultiStateToggleButton;

import com.example.dartlife.R;

import java.util.ArrayList;


public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    //private ArrayList<MovieEntry> movies;
    private ArrayList<Integer> movies;
    private Context mContext;

    private static final int TYPE_TOP_FILTER = 0;
    private static final int TYPE_MOVIES = 1;


    public CustomAdapter(Context applicationContext) {
        mContext = applicationContext;
        movies = new ArrayList<>();
        movies.add(1);
        movies.add(2);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        RecyclerView.ViewHolder holder = getViewHolderByViewType(viewType);
        Log.d("adapter", "onCreateViewHolder");

        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if(i == 0) {

        }
        if(i > 0) {
            ((ViewHolder_Movies) viewHolder).moviePic.setImageResource(R.drawable.movie_top_5);
            ((ViewHolder_Movies) viewHolder).movieNameYear.setText("fight club. (2000) ");
            ((ViewHolder_Movies) viewHolder).movieScore.setText("3.5");
            ((ViewHolder_Movies) viewHolder).movieInfo.setText("shhhh");
        }
    }

    @Override
    public int getItemViewType(int position) {

        if (position == 0) {
            return TYPE_TOP_FILTER;
        }
        if (position > 0 && position <= movies.size()) {
            return TYPE_MOVIES;
        }
        return 0;
    }

    @Override
    public int getItemCount() {
        return 1 + movies.size();
    }

    private RecyclerView.ViewHolder getViewHolderByViewType(int viewType) {
        View view_movie_top5_filter = View.inflate(mContext, R.layout.movie_top_filter, null);
        View view_movie_list = View.inflate(mContext, R.layout.movie_list_view, null);
        RecyclerView.ViewHolder holder = null;
        switch (viewType) {
            case TYPE_TOP_FILTER:
                holder = new ViewHolder_Top_Filter(view_movie_top5_filter);
                break;
            case TYPE_MOVIES:
                holder = new ViewHolder_Movies(view_movie_list);
                break;
        }

        return holder;
    }




    class ViewHolder_Top_Filter extends RecyclerView.ViewHolder {
        public ImageView top_background;
        public TextView top_text;
        public TextView top1_movie;
        public TextView top2_movie;

        public SearchView search_view;
        public MultiStateToggleButton category_first;
        public MultiStateToggleButton category_second;

        public ViewHolder_Top_Filter(View itemView) {
            super(itemView);
            top_background = itemView.findViewById(R.id.MovieTop);
            top_text = itemView.findViewById(R.id.TopText);
            top1_movie = itemView.findViewById(R.id.Movie1);
            top2_movie = itemView.findViewById(R.id.Movie2);

            search_view = itemView.findViewById(R.id.searchView);
            category_first = itemView.findViewById(R.id.select_area);
            category_second = itemView.findViewById(R.id.select_type);


        }
    }

    class ViewHolder_Movies extends RecyclerView.ViewHolder {
        public ImageView moviePic;
        public TextView movieNameYear;
        public TextView movieScore;
        public TextView movieInfo;


        public ViewHolder_Movies(View itemView) {
            super(itemView);
            moviePic = itemView.findViewById(R.id.MoviePic);
            movieNameYear = itemView.findViewById(R.id.MovieNameYear);
             movieScore = itemView.findViewById(R.id.MovieScore);
             movieInfo = itemView.findViewById(R.id.MovieInfo);

        }
    }

}
