package vn.edu.poly.demoxmlparser.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import vn.edu.poly.demoxmlparser.R;
import vn.edu.poly.demoxmlparser.model.News;

public class NewsHolder extends RecyclerView.ViewHolder {
    public TextView tv;
    public News news;

    private TextView tvText;
    public Button btnSave;
    public Button btnView;


    public NewsHolder(@NonNull View itemView) {
        super(itemView);
        tv = itemView.findViewById(R.id.tvText);
        btnSave = itemView.findViewById(R.id.btnSave);
        btnView = itemView.findViewById(R.id.btnView);
    }
}
