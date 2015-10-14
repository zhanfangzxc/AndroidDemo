package com.yingshibao.recyclerviewdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by zhaoshanshan on 15/10/14.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> implements View.OnClickListener {

    private List<DataModel> datas;
    public OnRecyclerViewItemClickListener mOnRecyclerViewItemClickListener;

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnRecyclerViewItemClickListener = listener;
    }

    public MyAdapter(List<DataModel> datas) {
        this.datas = datas;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        view.setOnClickListener(this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        DataModel model = datas.get(position);
        holder.data.setText(model.getData());
        holder.itemView.setTag(datas.get(position));
        holder.insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData((DataModel) holder.itemView.getTag(), position);
            }
        });
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteData((DataModel) holder.itemView.getTag());
            }
        });

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    private void insertData(DataModel model, int position) {
        datas.add(position, model);
        notifyItemInserted(position);
    }

    private void deleteData(DataModel model) {
        int position = datas.indexOf(model);
        datas.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public void onClick(View v) {
        if (mOnRecyclerViewItemClickListener != null) {
            mOnRecyclerViewItemClickListener.onItemClick(v, (DataModel) v.getTag());
        }
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView data;
        private Button insert;
        private Button delete;

        public MyViewHolder(View itemView) {
            super(itemView);
            data = (TextView) itemView.findViewById(R.id.id_data);
            insert = (Button) itemView.findViewById(R.id.id_insert);
            delete = (Button) itemView.findViewById(R.id.id_delete);
        }
    }
}
