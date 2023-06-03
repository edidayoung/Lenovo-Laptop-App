package com.devedidayg.lenovocomputersapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devedidayg.lenovocomputersapp.Adapters.CategoriesRecyclerView;
import com.devedidayg.lenovocomputersapp.Listeners.SelectListener;
import com.devedidayg.lenovocomputersapp.Models.CategoriesItems;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CategoriesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CategoriesFragment extends Fragment implements SelectListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView recyclerView;


    public CategoriesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CategoriesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CategoriesFragment newInstance(String param1, String param2) {
        CategoriesFragment fragment = new CategoriesFragment();
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
        return inflater.inflate(R.layout.fragment_categories, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.items_recycler_View);

        List<CategoriesItems> categoriesItems = new ArrayList<>();

        categoriesItems.add(new CategoriesItems("Gaming Laptops", R.drawable.yuoga, "https://www.lenovo.com/us/en/d/gaming-laptops/?orgRef=https%253A%252F%252Fwww.google.com%252F","Lenovo offers a wide range of gaming laptops designed to deliver exceptional performance and immersive gaming experiences. These laptops are equipped with high-performance processors, powerful graphics cards, and ample RAM to handle demanding games. They feature high-resolution displays with fast refresh rates and vibrant colors for stunning visuals. Gaming laptops from Lenovo also incorporate advanced cooling systems to prevent overheating during intense gaming sessions. Additionally, they come with customizable RGB keyboards and advanced audio systems to enhance the gaming experience."));
        categoriesItems.add(new CategoriesItems("Business Laptops", R.drawable.business,"https://www.lenovo.com/us/en/business/laptops/?orgRef=https%253A%252F%252Fwww.google.com%252F", "Lenovo business laptops are designed to meet the demands of professionals, providing the perfect blend of performance, security, and durability. These laptops offer powerful processors, ample RAM, and fast storage options for seamless productivity. They come with high-resolution displays and robust security features, such as fingerprint readers and encrypted storage, to protect sensitive business data. Lenovo business laptops also prioritize connectivity with a range of ports and wireless options. They often feature ergonomic keyboards and long battery life to ensure comfort and productivity during long work hours."));
        categoriesItems.add(new CategoriesItems("Students Laptops", R.drawable.students_view, "https://www.lenovo.com/us/en/student/?orgRef=https%253A%252F%252Fwww.google.com%252F", "Lenovo understands the needs of students and offers laptops that are perfect for academic pursuits. These laptops are lightweight, portable, and durable, making them ideal for carrying between classes. They feature long battery life to ensure uninterrupted productivity throughout the day. Lenovo student laptops come with a range of processors and memory options, allowing students to handle their coursework and multitasking efficiently. They also offer vibrant displays and immersive audio for multimedia needs, and many models include a variety of connectivity options and ports for easy integration with other devices."));
        categoriesItems.add(new CategoriesItems("UltraBooks", R.drawable.laptop, "https://www.lenovo.com/ng/en/laptops/ideapad/c/ideaPad?orgRef=https%253A%252F%252Fwww.google.com%252F", "Lenovo Ultrabook laptops are designed for users seeking a perfect balance between portability, performance, and style. These laptops are slim, lightweight, and highly portable, making them ideal for users on the go. They offer powerful processors, ample memory, and fast storage options for seamless multitasking and productivity. Ultrabook laptops from Lenovo feature long battery life to keep you productive throughout the day. They also come with high-resolution displays, advanced audio systems, and a range of connectivity options to enhance the overall user experience."));
        categoriesItems.add(new CategoriesItems("ChromeBooks", R.drawable.lenovo6, "https://www.lenovo.com/us/en/d/chromebook-laptop/?orgRef=https%253A%252F%252Fwww.google.com%252F", "Lenovo Chromebook laptops are designed for users who prioritize simplicity, speed, and cloud-based computing. These laptops run on the Chrome OS, providing fast boot times and efficient web-based applications. Chromebooks offer a seamless integration with Google services, allowing users to access and sync their data easily. Lenovo Chromebook laptops come with lightweight designs, long battery life, and fast processors to ensure smooth web browsing, media streaming, and productivity. They also feature built-in virus protection and automatic updates for a secure and hassle-free computing experience."));
        categoriesItems.add(new CategoriesItems("Budget Laptops", R.drawable.lenovo5, "https://www.lenovo.com/ng/en/laptops/c/Laptops?orgRef=https%253A%252F%252Fwww.google.com%252F", "Lenovo budget laptops provide affordable options for users who require essential computing functionalities without breaking the bank. These laptops offer a balance between performance and price, allowing users to handle everyday tasks such as browsing the web, word processing, and light multitasking. Lenovo budget laptops typically come with energy-efficient processors and sufficient memory to handle basic tasks smoothly. While they may have more modest specifications compared to higher-end models, they still offer reliable performance for everyday use. These laptops often feature compact and lightweight designs, making them portable and suitable for users on a budget who need a laptop for school, work, or personal use. Lenovo budget laptops also provide a range of connectivity options, including USB ports and HDMI, to connect external devices and peripherals as needed."));
        categoriesItems.add(new CategoriesItems("Multimedia Laptops", R.drawable.lenovo1, "https://www.lenovo.com/ng/en/laptops/lenovo/c/lenovo?orgRef=https%253A%252F%252Fwww.google.com%252F", "Lenovo multimedia laptops are tailored for users who prioritize entertainment and media consumption. These laptops come with vibrant displays, high-quality audio systems, and powerful processors to handle multimedia tasks smoothly. They offer sharp and vivid visuals for movies, photos, and creative projects. Lenovo multimedia laptops often include dedicated graphics cards and ample storage space for handling graphics-intensive applications and storing large media files. They also feature enhanced connectivity options, allowing users to connect external devices and peripherals easily."));
        categoriesItems.add(new CategoriesItems("Rugged Laptop", R.drawable.lenovo2,"https://www.lenovo.com/us/en/thinkpad-milspec/?orgRef=https%253A%252F%252Fwww.google.com%252F", "Lenovo rugged laptops are built to withstand harsh environments and demanding usage. They are designed to be durable, resistant to drops, shocks, and extreme temperatures. These laptops feature reinforced frames, spill-resistant keyboards, and extra protection for the display. They often undergo rigorous testing to meet military-grade durability standards. Rugged laptops from Lenovo also offer reliable performance, long battery life, and a range of connectivity options for professionals working in challenging conditions, such as fieldwork or outdoor environments."));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new CategoriesRecyclerView(getContext(), categoriesItems,this));

    }

    @Override
    public void onItemClicked(CategoriesItems categoriesItems) {
        Intent intent = new Intent(getActivity(), CategoriesItemViewActivity.class);
        intent.putExtra("itemName", categoriesItems.getNames());
        intent.putExtra("itemImage", categoriesItems.getImages());
        intent.putExtra("itemDesc", categoriesItems.getDesc());
        intent.putExtra("itemDetails", categoriesItems.getDetails());
        startActivity(intent);

    }
}