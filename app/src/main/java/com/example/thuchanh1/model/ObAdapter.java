package com.example.thuchanh1.model;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thuchanh1.R;

import java.util.ArrayList;
import java.util.List;

public class ObAdapter extends RecyclerView.Adapter<ObAdapter.ObViewHolder> {
    private Context context;
    private List<Object> listBackUp;
    private List<Object> mList;

    public void setmList(List<Object> mList) {
        this.mList = mList;
    }

    public List<Object> getmList() {
        return mList;
    }

    private ObItemListener itemListener;

    public ObAdapter(Context context) {
        this.context = context;
        mList = new ArrayList<>();
        listBackUp = new ArrayList<>();
    }

    public List<Object> getBackUp() {
        return listBackUp;
    }

    public void setClickListener(ObItemListener itemListener) {
        this.itemListener = itemListener;
    }

    @NonNull
    @Override
    public ObViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new ObViewHolder(view);
    }

    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public void onBindViewHolder(@NonNull ObViewHolder holder, int position) {
        Object object = mList.get(position);
        if (object == null)
            return;
        //Log.d("Fail", object.getDes() + "-" + object.getImg());
        holder.img.setImageResource(object.getImg());
        holder.tvKyhan.setText(object.getKyhan());
        holder.tvLaiXuat.setText(object.getLaixuat() + "");
        if (object.getHinhthuc() == Object.ONLINE)
            holder.checkBox.setChecked(true);
        else
            holder.checkBox.setChecked(false);
        holder.btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mList.remove(position);
                notifyDataSetChanged();
            }
        });

    }

    public void filterList(List<Object> filterList) {
        mList = filterList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mList != null)
            return mList.size();
        else return 0;
    }

    public void add(Object object) {
        mList.add(object);
        listBackUp.add(object);
        notifyDataSetChanged();
    }

    public void Update(int position, Object object) {
        listBackUp.set(position, object);
        mList.set(position, object);
        notifyDataSetChanged();
    }

    public class ObViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView img;
        private TextView tvKyhan, tvLaiXuat;
        private CheckBox checkBox;
        private Button btnRemove;

        public ObViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img1);
            tvKyhan = itemView.findViewById(R.id.tvkyhan);
            tvLaiXuat = itemView.findViewById(R.id.tvLaiXuat);
            //tvDes = itemView.findViewById(R.id.tvDes);
            checkBox = itemView.findViewById(R.id.checkbox);
            btnRemove = itemView.findViewById(R.id.btnDelete);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (itemListener != null) {
                itemListener.onItemClick(v, getAdapterPosition());
            }
        }
    }

    public interface ObItemListener {
        void onItemClick(View view, int position);
    }
}
