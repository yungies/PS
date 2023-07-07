package sg.edu.rp.c364.id22037903.ps;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editTextTitle, editTextSingers, editTextYear;
    Button btnInsert, btnGetSongs;
    ListView listViewSongs;
    ArrayAdapter<Song> aaSongs;
    ArrayList<Song> songList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTitle = findViewById(R.id.editTextTitle);
        editTextSingers = findViewById(R.id.editTextSingers);
        editTextYear = findViewById(R.id.editTextYear);
        btnInsert = findViewById(R.id.btnInsert);
        btnGetSongs = findViewById(R.id.btnGetSongs);
        listViewSongs = findViewById(R.id.listViewSongs);

        songList = new ArrayList<>();
        aaSongs = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, songList);
        listViewSongs.setAdapter(aaSongs);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = editTextTitle.getText().toString().trim();
                String singers = editTextSingers.getText().toString().trim();
                int year = Integer.parseInt(editTextYear.getText().toString().trim());

                if (!title.isEmpty() && !singers.isEmpty()) {
                    Song song = new Song(title, singers, year);
                    songList.add(song);
                    aaSongs.notifyDataSetChanged();

                    Toast.makeText(MainActivity.this, "Song inserted successfully", Toast.LENGTH_SHORT).show();

                    editTextTitle.setText("");
                    editTextSingers.setText("");
                    editTextYear.setText("");
                } else {
                    Toast.makeText(MainActivity.this, "Please enter title and singers", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnGetSongs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve songs from the database here
                // Replace this code with your actual implementation
                songList.clear();
                aaSongs.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Get Songs clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
