package com.example.mobilefragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class CategoryFragment extends Fragment implements View.OnClickListener{

    public CategoryFragment(){
        //Req
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        return inflater.inflate(R.layout.fragment_category, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        Button btnDetailCategory = view.findViewById(R.id.btn_detail_category);
        btnDetailCategory.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if (v.getId()== R.id.btn_detail_category){
            DetailCategoryFragment mDetailCategoryFragment = new DetailCategoryFragment();

            Bundle mBundle = new Bundle();
            mBundle.putString(DetailCategoryFragment.EXTRA_NAME,"LifeStyle");
            String description = "Kategori ini akan berisi produk lifestyle";

            mDetailCategoryFragment.setArguments(mBundle);
            mDetailCategoryFragment.setDescription(description);

            FragmentManager mFragmentManager = getParentFragmentManager();
            if (mFragmentManager != null) {
                mFragmentManager.beginTransaction().replace(R.id.frame_container,
                        mDetailCategoryFragment, DetailCategoryFragment.class.getSimpleName())
                .addToBackStack(null)
                        .commit();
            }
        }
    }
}