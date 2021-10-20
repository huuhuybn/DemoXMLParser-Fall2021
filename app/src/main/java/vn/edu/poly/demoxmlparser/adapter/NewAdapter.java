package vn.edu.poly.demoxmlparser.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import vn.edu.poly.demoxmlparser.ListActivity;
import vn.edu.poly.demoxmlparser.NewDAO;
import vn.edu.poly.demoxmlparser.R;
import vn.edu.poly.demoxmlparser.model.News;

public class NewAdapter extends RecyclerView.Adapter<NewsHolder> {

    private List<News> newsList;
    private Context context;
    private NewDAO newDAO;


    public NewAdapter(Context context, List<News> newsList) {
        this.newsList = newsList;
        this.context = context;
        this.newDAO = new NewDAO(context);
    }

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.views, viewGroup, false);
        return new NewsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final NewsHolder newsHolder, int i) {
        newsHolder.news = newsList.get(i);
        newsHolder.tv.setText(newsHolder.news.title);
        if (newsHolder.news.title.indexOf('n') > 0) {
            newsHolder.tv.setTextColor(context.getResources().getColor(R.color.colorAccent));
        } else {
            newsHolder.tv.setTextColor(context.getResources().getColor(R.color.colorPrimaryDark));
        }
        newsHolder.btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, ListActivity.class));
            }
        });
        newsHolder.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newDAO.insertNew(newsHolder.news);
                Toast.makeText(context, "Them thanh cong !!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }
}
