package com.devedidayg.lenovocomputersapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.devedidayg.lenovocomputersapp.Models.ItemsModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment  {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    GridView gridView;
    SearchView searchView;

    List<ItemsModel> itemsList = new ArrayList<>();
    CustomAdapter customAdapter;




    int images[] = {R.drawable.lenovo1,R.drawable.lenovo2,R.drawable.lenovo3,R.drawable.lenovo4,R.drawable.lenovo5,R.drawable.lenovo6,R.drawable.yuoga,R.drawable.business};
    String names[] ={"Lenovo ThinkPad X1 Carbon (Gen 9)","Lenovo ThinkPad X1 Yoga (Gen 6)","Lenovo ThinkPad X1 Extreme (Gen 4)","Lenovo ThinkPad T14s","Lenovo ThinkPad L14","Lenovo ThinkPad P1 (Gen 4)","Lenovo Yoga 9i (14)","Lenovo Yoga 7i (15)"};

    String desc[] = {"Processor: 11th Gen Intel Core i5/i7/i9\n" +
            "RAM: Up to 32GB\n" +
            "Storage: Up to 2TB SSD\n" +
            "Display: 14-inch 4K UHD IPS",

            "Processor: 11th Gen Intel Core i5/i7\n" +
            "RAM: Up to 32GB\n" +
            "Storage: Up to 2TB SSD\n" +
            "Display: 14-inch WQHD IPS Touchscreen",

            "Processor: 11th Gen Intel Core i5/i7/i9\n" +
                    "RAM: Up to 64GB\n" +
                    "Storage: Up to 4TB SSD\n" +
                    "Display: 15.6-inch 4K UHD OLED Touchscreen",

            "Processor: 11th Gen Intel Core i5/i7\n" +
                    "RAM: Up to 32GB\n" +
                    "Storage: Up to 2TB SSD\n" +
                    "Display: 14-inch FHD IPS",

            "Processor: 11th Gen Intel Core i5/i7\n" +
                    "RAM: Up to 64GB\n" +
                    "Storage: Up to 1TB SSD\n" +
                    "Display: 14-inch FHD IPS",

            "Processor: 11th Gen Intel Core i7/i9 or Intel Xeon\n" +
                    "RAM: Up to 128GB\n" +
                    "Storage: Up to 4TB SSD\n" +
                    "Display: 15.6-inch 4K UHD IPS",

            "Processor: 11th Gen Intel Core i7\n" +
                    "RAM: Up to 16GB\n" +
                    "Storage: Up to 1TB SSD\n" +
                    "Display: 14-inch FHD IPS Touchscreen",

            "Processor: 11th Gen Intel Core i5/i7\n" +
                    "RAM: Up to 16GB\n" +
                    "Storage: Up to 1TB SSD\n" +
                    "Display: 15.6-inch FHD IPS Touchscreen",};

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FavouritesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        gridView = view.findViewById(R.id.gridView_view);
        searchView = view.findViewById(R.id.searchView_home);
        TextView textView_nothing = view.findViewById(R.id.textView_nothingToShow);

        for (int i = 0; i < names.length; i++){
            ItemsModel itemsModel = new ItemsModel(names[i],images[i], desc[i]);
            itemsList.add(itemsModel);
        }
        customAdapter = new CustomAdapter(itemsList,getContext(),textView_nothing);
        gridView.setAdapter(customAdapter);

        //new search try
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                customAdapter.getFilter().filter(newText);

                return true;
            }
        });



    }

    public class CustomAdapter extends BaseAdapter implements Filterable{

        private List<ItemsModel> itemsModelList;
        private List<ItemsModel> itemsModelListFilter;
        private Context context;
        private TextView textView_nothing;

        public CustomAdapter(List<ItemsModel> itemsModelList, Context context, TextView textView_nothing) {
            this.itemsModelList = itemsModelList;
            this.itemsModelListFilter = new ArrayList<>(itemsModelList);
            this.context = context;
            this.textView_nothing = textView_nothing;
        }


        @Override
        public int getCount() {
            return itemsModelListFilter.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup viewGroup) {
            View view = convertView;
            LayoutInflater.from(context).inflate(R.layout.row_items, null);

            if (view == null) {
                view = getLayoutInflater().inflate(R.layout.row_items, null);
            }

            ImageView imageView = view.findViewById(R.id.imageView_view_search);
            TextView textView = view.findViewById(R.id.textView_name);

            imageView.setImageResource(itemsModelListFilter.get(i).getImages());
            textView.setText(itemsModelListFilter.get(i).getName());


            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(requireActivity(), ItemsViewActivity.class).putExtra("item",itemsModelListFilter.get(i)));
                }
            });
            return view;
        }

        @Override
        public Filter getFilter() {
            Filter filter = new Filter() {
                @Override
                protected FilterResults performFiltering(CharSequence charSequence) {

                    FilterResults filterResults = new FilterResults();

                    if (charSequence == null || charSequence.length() == 0 ){
                        filterResults.count = itemsModelList.size();
                        filterResults.values  = itemsModelList;
                    }else {
                        String searchStr = charSequence.toString().toLowerCase();
                        List<ItemsModel>  resultData = new ArrayList<>();

                        for (ItemsModel itemsModel:itemsModelList){
                            if (itemsModel.getName().toLowerCase().contains(searchStr.toLowerCase())){
                                resultData.add(itemsModel);
                            }

                        }
                        filterResults.count = resultData.size();
                        filterResults.values = resultData;

                    }
                    return filterResults;
                }

                @Override
                protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                    itemsModelListFilter = (List<ItemsModel>) filterResults.values;
                    notifyDataSetChanged();

                    if (itemsModelListFilter.isEmpty()) {
                        textView_nothing.setVisibility(View.VISIBLE);
                    } else {
                        textView_nothing.setVisibility(View.GONE);
                    }

                }
            };
            return filter;
        }
    }

}