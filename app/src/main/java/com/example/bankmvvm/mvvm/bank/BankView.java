package com.example.bankmvvm.mvvm.bank;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.bankmvvm.R;
import com.example.bankmvvm.databinding.ActivityBankViewBinding;
import com.example.bankmvvm.mvvm.bank.adapter.BankAdapter;
import com.example.bankmvvm.mvvm.bank.adapter.OnclickBankName;
import com.example.bankmvvm.mvvm.bank.model.BankModel;
import com.example.bankmvvm.mvvm.map.Map;


public class BankView extends AppCompatActivity implements OnclickBankName  {
   private ActivityBankViewBinding binding;
   private BankViewModel viewModel;
   private RecyclerView recyclerView;
   private BankAdapter bankAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_bank_view);
        viewModel = new ViewModelProvider(this).get(BankViewModel.class);
        recyclerView = binding.recycler;
        viewModel.getListMutableLiveData();

        viewModel.getListBankLiveData().observe(this, bankModels -> {
            recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
            bankAdapter = new BankAdapter(this,bankModels , this);
            binding.setMyAdapter(bankAdapter);
        });

        viewModel.errorMassage().observe(this, error -> {
            Toast.makeText(this,error,Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public void bankClick(BankModel bank) {
        Log.i("clickAdapter" , bank.getNameBank());
    }

}