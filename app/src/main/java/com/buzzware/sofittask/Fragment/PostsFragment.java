package com.buzzware.sofittask.Fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.buzzware.sofittask.Adapter.PostServices;
import com.buzzware.sofittask.Class.CustomProgressDialog;
import com.buzzware.sofittask.R;
import com.buzzware.sofittask.Retrofit.Api.ApiClient;
import com.buzzware.sofittask.Retrofit.Api.Controller;
import com.buzzware.sofittask.Retrofit.PostService.PostModel;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class PostsFragment extends Fragment {
    RecyclerView postservicerecycler;
    ArrayList<PostModel> postServiceModels;
    PostServices postServices;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_posts, container, false);
        initail(view);
        postSerViceDataShow();
        return view;
    }

    private void initail(View view) {
        postservicerecycler = view.findViewById(R.id.postrecyclerView);
        postServiceModels = new ArrayList<>();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        postservicerecycler.setLayoutManager(mLayoutManager);
    }

    //todo Method 1 if getting resp from
    public void  postSerViceData()
    {
        CustomProgressDialog.getInstance(getActivity()).showProgressDialog();
        Controller.
                getApi().postData()
                .enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        CustomProgressDialog.getInstance(getActivity()).dismissProgressDialog();
                        if(response.body()!=null)
                        {
                            try {

                                //postServiceModels.addAll(response.body());
                                postServices = new PostServices(postServiceModels,getActivity());
                                postservicerecycler.setAdapter(postServices);
                                postServices.notifyDataSetChanged();
                            }
                            catch (Exception e)
                            {
                                Log.d("postservice",e.getMessage());
                                Toast.makeText(getActivity(), "Exception"+e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        CustomProgressDialog.getInstance(getActivity()).dismissProgressDialog();
                    }
                });
    }
    //todo Method 2
    public void postSerViceDataShow()
    {
        CustomProgressDialog.getInstance(getActivity()).showProgressDialog();
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiClient apiInterface= retrofit.create(ApiClient.class);
        Call<ArrayList<PostModel>> call= apiInterface.postServiceData();
        call.enqueue(new Callback<ArrayList<PostModel>>() {
            @Override
            public void onResponse(Call<ArrayList<PostModel>> call, Response<ArrayList<PostModel>> response) {
                CustomProgressDialog.getInstance(getActivity()).dismissProgressDialog();
                postServiceModels.addAll(response.body());
                postServices = new PostServices(postServiceModels,getActivity());
                postservicerecycler.setAdapter(postServices);
                postServices.notifyDataSetChanged();

            }
            @Override
            public void onFailure(Call<ArrayList<PostModel>> call, Throwable t) {
                CustomProgressDialog.getInstance(getActivity()).dismissProgressDialog();
                Log.d("checkapp","test");
            }
        });
    }
}