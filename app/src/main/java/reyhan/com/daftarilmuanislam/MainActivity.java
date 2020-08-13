package reyhan.com.daftarilmuanislam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class MainActivity extends AppCompatActivity {

    String[] namaIlmuan = {
            "Al Khawarizmi",
            "Al Zahrawi",
            "Ibnu al-Baithar",
            "Ibnu al-Nafis",
            "Ibnu Haitham",
            "Ibnu Khaldun",
            "Ibnu Sina",
            "Jabir Ibn- Hayyan",
            "Thbit ibn Qurra",
            "Umar Khayyam"
    };

    int[] gambarIlmuan = {
            R.drawable.alkhawarizmi,
            R.drawable.ibnualbhaitar,
            R.drawable.ibnualnafis,
            R.drawable.ibnuhaitman,
            R.drawable.ibnukhaldun,
            R.drawable.ibnusina,
            R.drawable.jabilibnhayyan,
            R.drawable.thbitibnqurra,
            R.drawable.umarkhayyam
    };

    String[] url = {
            "https://id.wikipedia.org/wiki/Mu%E1%B8%A5ammad_bin_M%C5%ABs%C4%81_al-Khaw%C4%81rizm%C4%AB",
            "https://id.wikipedia.org/wiki/Abu_al-Qasim_al-Zahrawi",
            "https://id.wikipedia.org/wiki/Ibnu_al-Baithar",
            "https://id.wikipedia.org/wiki/Ibnu_al-Nafis",
            "https://id.wikipedia.org/wiki/Ibnu_Haitham",
            "https://id.wikipedia.org/wiki/Ibnu_Khaldun",
            "https://id.wikipedia.org/wiki/Ibnu_Sina",
            "https://id.wikipedia.org/wiki/Abu_Musa_Jabir_bin_Hayyan",
            "https://id.wikipedia.org/wiki/Tsabit_bin_Qurrah",
            "https://id.wikipedia.org/wiki/Umar_Khayy%C4%81m"
    };

    ListView listSunnah;
    CarouselView carouselView;
    int[] listImage = {R.drawable.alkhawarizmi, R.drawable.alzahrawi, R.drawable.ibnualbhaitar, R.drawable.ibnualnafis, R.drawable.ibnuhaitman, R.drawable.ibnukhaldun, R.drawable.ibnusina, R.drawable.jabilibnhayyan, R.drawable.thbitibnqurra, R.drawable.umarkhayyam};
    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(listImage[position]);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listiIlmuan = findViewById(R.id.listIlmuan);
        CustomListAdapter adapter = new CustomListAdapter();
        listiIlmuan.setAdapter(adapter);

        listiIlmuan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetaililmuanActivity.class);
                intent.putExtra("NAMA", namaIlmuan[i]);
                intent.putExtra("URL", url[i]);
                startActivity(intent);
            }
        });

        carouselView = findViewById(R.id.crView);
        carouselView.setPageCount(listImage.length);
        carouselView.setImageListener(imageListener);

    }

    class CustomListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return gambarIlmuan.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.raw_list, null);

            ImageView imageView = view.findViewById(R.id.ivRaw);
            TextView textView = view.findViewById(R.id.tvRaw);

            imageView.setImageResource(gambarIlmuan[i]);
            textView.setText(namaIlmuan[i]);

            return view;
        }
    }

}
