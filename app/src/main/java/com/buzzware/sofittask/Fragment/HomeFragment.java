package com.buzzware.sofittask.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.buzzware.sofittask.Activity.BaseActivity;
import com.buzzware.sofittask.Adapter.Cardhistory;
import com.buzzware.sofittask.Adapter.NewsAdapter;
import com.buzzware.sofittask.Model.NewsModel;
import com.buzzware.sofittask.Model.PaymentHistoryModel;
import com.buzzware.sofittask.R;
import java.util.ArrayList;

public class HomeFragment extends Fragment {
    LinearLayout homefrag,postfrag,servicefrag;
    TextView serviceTv,postTv,profileTV,govtsettingiconView;
    RecyclerView newsdataRecyclerView,paymentcardrecyclerView;
    ArrayList<NewsModel> newsModels;
    ArrayList<PaymentHistoryModel> paymentHistoryModels;
    Cardhistory cardhistory;
    NewsAdapter newsAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        init(view);
        setListner();
        NewsDetails();
        CardHistory();
        return view;
    }
    private void init(View view) {
      //
        servicefrag=view.findViewById(R.id.servicefragment);
        postfrag=view.findViewById(R.id.postfragment);
        homefrag=view.findViewById(R.id.homefragment);
        serviceTv=view.findViewById(R.id.serviceTV);
        postTv=view.findViewById(R.id.postTV);
        profileTV=view.findViewById(R.id.profileTV);
        govtsettingiconView=view.findViewById(R.id.govtsettingiconView);

        newsdataRecyclerView =view.findViewById(R.id.newsrecyclerView);
        paymentcardrecyclerView =view.findViewById(R.id.cardsrecyclerview);
        paymentHistoryModels = new ArrayList<>();
        newsModels = new ArrayList<>();

    }
    //todo setListner
    private void setListner() {

        homefrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Homefragment(homefrag,servicefrag,postfrag);
            }
        });
        servicefrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                serviceFragment(homefrag,servicefrag,postfrag);
            }
        });
        postfrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postFragment(homefrag,servicefrag,postfrag);
            }
        });

        govtsettingiconView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                BaseActivity.toolbartitle_TV.setText("Gove Services");
                loadFragment(new ServicesFragment());
            }
        });
    }
//todo here i have no image to show wich view is clickable or not to show the user friendly
    //todo if anybody want to chane only imageview then chnage only resource here!!!

    private void Homefragment(LinearLayout homeLayout,LinearLayout servicelayout,LinearLayout postLayout){
        homeLayout.setBackground ( getResources ().getDrawable ( R.drawable.backgroundbottomsheet_layout ) );
        servicelayout.setBackground ( getResources ().getDrawable ( R.drawable.gradientshape_background ) );
        postLayout.setBackground ( getResources ().getDrawable ( R.drawable.gradientshape_background ) );
        serviceTv.setTextColor ( Color.WHITE );
        postTv.setTextColor ( Color.BLACK );
        profileTV.setTextColor ( Color.BLACK );

    }

    private void serviceFragment(LinearLayout homeLayout,LinearLayout servicelayout,LinearLayout postLayout){
        homeLayout.setBackground ( getResources ().getDrawable ( R.drawable.gradientshape_background ) );
        servicelayout.setBackground ( getResources ().getDrawable ( R.drawable.backgroundbottomsheet_layout ) );
        postLayout.setBackground ( getResources ().getDrawable ( R.drawable.gradientshape_background ) );
        serviceTv.setTextColor ( Color.BLACK );
        postTv.setTextColor ( Color.WHITE );
        profileTV.setTextColor ( Color.BLACK );
        BaseActivity.toolbartitle_TV.setText("Gove Services");

        loadFragment(new ServicesFragment());

    }
    private void postFragment(LinearLayout homeLayout,LinearLayout servicelayout,LinearLayout postLayout){
        homeLayout.setBackground ( getResources ().getDrawable ( R.drawable.gradientshape_background ) );
        servicelayout.setBackground ( getResources ().getDrawable ( R.drawable.gradientshape_background ) );
        postLayout.setBackground ( getResources ().getDrawable ( R.drawable.backgroundbottomsheet_layout ) );
        serviceTv.setTextColor ( Color.BLACK );
        postTv.setTextColor ( Color.BLACK );
        profileTV.setTextColor ( Color.WHITE );
        BaseActivity.toolbartitle_TV.setText("Post");
        loadFragment(new PostsFragment());

    }
    private boolean loadFragment(Fragment fragment)
    {
        if (fragment != null) {
            getChildFragmentManager().beginTransaction().replace(R.id.homefrag_frame, fragment).commit();
            return true;
        }
        return false;
    }

    public void NewsDetails()
    {
        newsModels.add ( new NewsModel ( R.drawable.menicon,"Lorem Ipsum is simply dummy text of the printing and typesetting industry."));
        newsModels.add ( new NewsModel ( R.drawable.menicon,"Lorem Ipsum is simply dummy text of the printing and typesetting industry."));
        newsModels.add ( new NewsModel ( R.drawable.menicon,"Lorem Ipsum is simply dummy text of the printing and typesetting industry."));
        newsAdapter = new NewsAdapter( newsModels,getActivity ());
        newsdataRecyclerView.setAdapter(newsAdapter);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, true);
        newsdataRecyclerView.setLayoutManager(mLayoutManager);
    }

    public void CardHistory()
    {
        paymentHistoryModels.add ( new PaymentHistoryModel ( 12,"Payment History"));
        paymentHistoryModels.add ( new PaymentHistoryModel ( 12,"Payment History"));// R.drawable.mediaiv
        paymentHistoryModels.add ( new PaymentHistoryModel ( 12,"Payment History"));
        cardhistory = new Cardhistory( paymentHistoryModels,getActivity ());
        paymentcardrecyclerView.setAdapter(cardhistory);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, true);
        paymentcardrecyclerView.setLayoutManager(mLayoutManager);
    }

}