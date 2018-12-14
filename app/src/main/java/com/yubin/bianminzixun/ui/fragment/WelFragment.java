package com.yubin.bianminzixun.ui.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.yubin.bianminzixun.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link WelFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WelFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_SECTION_NUMBER = "section_num";
    Unbinder unbinder;
    @BindView(R.id.section_img)
    ImageView sectionImg;
    @BindView(R.id.section_label)
    AppCompatTextView sectionLabel;
    @BindView(R.id.section_intro)
    AppCompatTextView sectionIntro;
    private int page;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public WelFragment() {
        // Required empty public constructor
    }

    public static WelFragment newInstance(int sectionNumber) {
        WelFragment fragment = new WelFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            page = getArguments().getInt(ARG_SECTION_NUMBER);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_wel, container, false);
        unbinder = ButterKnife.bind(this, view);
        switch (page) {
            case 0:
                sectionImg.setImageResource(R.drawable.ic_wel1);
                sectionLabel.setText(R.string.section_1);
                sectionIntro.setText(R.string.intro_1);
                break;

            case 1:
                sectionImg.setImageResource(R.drawable.ic_wel2);
                sectionLabel.setText(R.string.section_2);
                sectionIntro.setText(R.string.intro_2);
                break;

            case 2:
                sectionImg.setImageResource(R.drawable.ic_wel3);
                sectionLabel.setText(R.string.section_3);
                sectionIntro.setText(R.string.intro_3);
                break;

            default:
                break;
        }
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
