package com.example.bankmvvm.mvvm.bank.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bankmvvm.BR;
import com.example.bankmvvm.R;
import com.example.bankmvvm.databinding.ItemBankBinding;
import com.example.bankmvvm.mvvm.bank.model.BankModel;

import java.util.ArrayList;

public class BankAdapter extends RecyclerView.Adapter<BankAdapter.MyViewHolder>  {
    Context context;
    ArrayList<BankModel> models;
    OnclickBankName onclickBankName;
    private int lastPosition = -1;

    public BankAdapter(Context context, ArrayList<BankModel> models,OnclickBankName onclickBankName) {
        this.context = context;
        this.models = models;
        this.onclickBankName = onclickBankName;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ItemBankBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_bank, parent, false);
        return new MyViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.binding.txtBankName.setText(models.get(position).getNameBank());
        setAnimation(holder.itemView, position);
        holder.bind(models.get(position));
        holder.binding.setClickListener(onclickBankName);
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    private void setAnimation(View viewToAnimate, int position) {
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {

        ItemBankBinding binding;

        public MyViewHolder(@NonNull ItemBankBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Object obj) {
            binding.setVariable(BR.bank, obj);
            binding.executePendingBindings();
        }
    }
}
