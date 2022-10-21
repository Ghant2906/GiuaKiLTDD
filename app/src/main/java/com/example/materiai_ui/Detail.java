package com.example.materiai_ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Detail extends AppCompatActivity {
    TextView tvTenMon, tvChiTietMon;
    ImageView imageViewMon;
    Button btnBack;
    ArrayList<Item> itemArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        tvTenMon = (TextView) findViewById(R.id.textViewTenMon_Detail);
        tvChiTietMon = (TextView) findViewById(R.id.textViewChiTietMon_Detail);
        imageViewMon = (ImageView) findViewById(R.id.image_Detail);
        btnBack = (Button) findViewById(R.id.backButton_Detail);
        itemArrayList = List.itemArrayList;

        tvTenMon.setText(itemArrayList.get(List.viTri).getTieuDe());
        imageViewMon.setImageResource(itemArrayList.get(List.viTri).getHinh());
        switch (List.viTri){
            case 0:
                tvChiTietMon.setText("Tuy không phải là một món ăn nóng hổi, kem bơ lại được ưu ái cho vào danh sách bởi sự mát lạnh, ngọt thơm và béo bùi hoà quyện cũng sẽ giúp tâm trạng bạn vui vẻ hơn vào những ngày lạnh đó.");
                // tuy không phải là một món ăn nóng hổi, kem bơ lại được ưu ái cho vào danh sách bởi sự mát lạnh, thơn ngon và béo bùi hòa quyện cũng sẽ giúp tâm trạng bạn vui vẻ hơn vào những ngày lạnh đó
                break;
            case 1:
                tvChiTietMon.setText("Thịt gà được nấu mềm nhưng vẫn giữ được độ dai nhẹ, những trái ớt xanh cay và thơm lừng rất hấp dẫn. Hơn nữa, nước dùng ngọt thanh, bổ dưỡng là tinh tuý của gà, các loại gia vị như sả, tỏi, kỷ tử, hành tây, bạn có thể ăn kèm với bún hay mì đều rất ngon đó!");
                // Thịt gà được nấu mềm nhưng vẫn giữ được độ dai nhẹ, những trái ớt xanh cay và thơm lừng rất hấp dẫn. Hơn nữa nước dùng ngọt thanh, bổ dưỡng là tinh túy của gà, các loại gia vị như sả, tỏi, kỷ tử, hành tây, bạn có thể ăn kèm với bún hay mì đều rất ngon đó!
                break;
            case 2:
                tvChiTietMon.setText("Gà kho gừng là một món kho quen thuộc, gắn liền với bữa cơm của người Việt ta. Không chỉ với hương vị thơm ngon, gà kho gừng còn giúp cơ thể được ấm hơn vào những ngày lạnh nữa.");
                //Gà kho gừng là một món ăn kho quen thuộc, gắn liền với bữa cơm của người Việt ta. Không chỉ với hương vị thơm ngon, gà kho gừng còn giúp cơ thể được ấm hơn vào những ngày lạnh nữa
                break;
            case 3:
                tvChiTietMon.setText("Những lát thịt ba chỉ mềm mại, mỡ và thịt xen lẫn thật đều, kho cùng hành tím, nước mắm liu riu trên lửa nhỏ cho đến khi sánh lại vô cùng hấp dẫn. Luộc thêm các loại rau củ, ăn kèm với thịt kho quẹt là xuất sắc lắm đó nha.");
                //Những lát thịt ba chỉ mềm mại, mở và thịt xen lẫn thật đều, kho cùng hành tím, nước mắm liu riu trên lửa nhỏ cho đến khi sánh lại vô cùng hấp dẫn. Luộc thêm các loại rau củ, ăn kèm với thịt kho quẹt là xuất sắc lắ,
                break;
            case 4:
                tvChiTietMon.setText("Mực được sơ chế thật sạch, không còn mùi tanh. Sau đó, mực được hấp cùng gừng, hành lá lại càng thơm ngon hơn nữa. Cắt mực thành từng lát, chấm với nước mắm chua ngọt, nhâm nhi chút bia lạnh thì tuyệt bạn nhỉ.");
                break;
            case 5:
                tvChiTietMon.setText("Cá lóc được kho trong tộ, giữ được độ nóng lâu rất hấp dẫn. Cá có màu vàng nâu bắt mắt, phía trên là tiêu, hành lá, ớt cắt lát thơm nồng nàn. Hơn nữa, phần nước kho đậm đà, dẻ thêm miếng cá, ăn cùng cơm nóng thì hết sẩy.");
                break;
        }

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent list = new Intent(Detail.this, List.class);
                startActivity(list);
            }
        });
    }
}