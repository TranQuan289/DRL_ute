package com.example.android.drl.Student_ui;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.android.drl.R;
import com.example.android.drl.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class HomeFragment extends Fragment {
    public int sum1 = 0, sum2 = 0, sum3 = 0, sum4 = 0, sum5 = 0, sum = 1;
    String level = "Error mark";
    boolean rb1_check, rb2_check;
    Button btn_drl;
    TextView txt_sum, txt_level;
    CheckBox cb1, cb2, cb3, cb4, cb5;
    CheckBox cb1_2, cb2_2, cb3_2, cb4_2;
    CheckBox cb1_3, cb2_3, cb3_3, cb4_3;
    CheckBox cb1_4, cb2_4, cb3_4, cb4_4, cb5_4;
    CheckBox cb1_5, cb2_5, cb3_5, cb4_5;
    TextView txt_sum1, txt_sum2, txt_sum3, txt_sum4, txt_sum5;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        txt_sum1 = v.findViewById(R.id.sum1);
        txt_sum2 = v.findViewById(R.id.sum2);
        txt_sum3 = v.findViewById(R.id.sum3);
        txt_sum4 = v.findViewById(R.id.sum4);
        txt_sum5 = v.findViewById(R.id.sum5);


        txt_sum = v.findViewById(R.id.sum);
        txt_level = v.findViewById(R.id.txt_level);
        btn_drl = v.findViewById(R.id.bnt_drl);

        cb1 = v.findViewById(R.id.cb1);
        cb2 = v.findViewById(R.id.cb2);
        cb3 = v.findViewById(R.id.cb3);
        cb4 = v.findViewById(R.id.cb4);
        cb5 = v.findViewById(R.id.cb5);
        TextView txt_II = v.findViewById(R.id.II);
        TextView txt_III = v.findViewById(R.id.III);
        TextView txt_IV = v.findViewById(R.id.IIII);
        TextView txt_V = v.findViewById(R.id.V);
        TextView txt_VI = v.findViewById(R.id.VI);

        cb1_2 = v.findViewById(R.id.cb1_2);
        cb2_2 = v.findViewById(R.id.cb2_2);
        cb3_2 = v.findViewById(R.id.cb3_2);
        cb4_2 = v.findViewById(R.id.cb4_2);
        TextView txt_II_2 = v.findViewById(R.id.II_2);
        TextView txt_III_2 = v.findViewById(R.id.III_2);
        TextView txt_IV_2 = v.findViewById(R.id.IV_2);
        TextView txt_V_2 = v.findViewById(R.id.V_2);

        cb1_3 = v.findViewById(R.id.cb1_3);
        cb2_3 = v.findViewById(R.id.cb2_3);
        cb3_3 = v.findViewById(R.id.cb3_3);
        cb4_3 = v.findViewById(R.id.cb4_3);
        TextView txt_II_3 = v.findViewById(R.id.II_3);
        TextView txt_III_3 = v.findViewById(R.id.III_3);
        TextView txt_IV_3 = v.findViewById(R.id.IV_3);
        TextView txt_V_3 = v.findViewById(R.id.V_3);

        cb1_4 = v.findViewById(R.id.cb1_4);
        cb2_4 = v.findViewById(R.id.cb2_4);
        cb3_4 = v.findViewById(R.id.cb3_4);
        cb4_4 = v.findViewById(R.id.cb4_4);
        cb5_4 = v.findViewById(R.id.cb5_4);
        TextView txt_II_4 = v.findViewById(R.id.II_4);
        TextView txt_III_4 = v.findViewById(R.id.III_4);
        TextView txt_IV_4 = v.findViewById(R.id.IV_4);
        TextView txt_V_4 = v.findViewById(R.id.V_4);
        TextView txt_VI_4 = v.findViewById(R.id.VI_4);

        cb1_5 = v.findViewById(R.id.cb1_5);
        cb2_5 = v.findViewById(R.id.cb2_5);
        cb3_5 = v.findViewById(R.id.cb3_5);
        cb4_5 = v.findViewById(R.id.cb4_5);
        TextView txt_II_5 = v.findViewById(R.id.II_5);
        TextView txt_III_5 = v.findViewById(R.id.III_5);
        TextView txt_IV_5 = v.findViewById(R.id.IV_5);
        TextView txt_V_5 = v.findViewById(R.id.V_5);


        RadioGroup grd = v.findViewById(R.id.grd);
        RadioButton rb1 = v.findViewById(R.id.rd1);
        RadioButton rb2 = v.findViewById(R.id.rd2);
        RadioButton rb3 = v.findViewById(R.id.rd3);
        txt_II.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cb1.toggle();
                cb1();
            }
        });
        cb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cb1();
            }
        });
        txt_III.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cb2.toggle();
                cb2();
            }
        });
        cb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cb2();
            }
        });
        txt_IV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cb3.toggle();
                cb3();
            }
        });
        cb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cb3();
            }
        });

        txt_V.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cb4.toggle();
                cb4();
            }
        });
        cb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cb4();
            }
        });

        txt_VI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cb5.toggle();
                cb5();
            }
        });
        cb5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cb5();
            }
        });

        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rb1.isChecked()) {
                    sum1 += 4;
                    if (rb1_check)
                        sum1 -= 4;
                    rb1_check = true;
                    if (rb2_check) {
                        rb2_check = false;
                        sum1 -= 2;
                    }
                    txt_sum1.setText("Cộng mục I:" + " " + String.valueOf(sum1));
                    totalDisplay();
                }

            }
        });
        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rb2.isChecked()) {
                    sum1 += 2;
                    if (rb2_check)
                        sum1 -= 2;
                    rb2_check = true;
                    if (rb1_check) {
                        rb1_check = false;
                        sum1 -= 4;
                    }
                    txt_sum1.setText("Cộng mục I:" + " " + String.valueOf(sum1));
                    totalDisplay();
                }
            }
        });
        rb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rb1_check) {
                    sum1 -= 4;
                    txt_sum1.setText("Cộng mục I:" + " " + String.valueOf(sum1));
                    totalDisplay();
                }
                if (rb2_check) {
                    sum1 -= 2;
                    txt_sum1.setText("Cộng mục I:" + " " + String.valueOf(sum1));
                    totalDisplay();
                }
                rb1_check = false;
                rb2_check = false;
            }
        });
        txt_II_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cb1_2.toggle();
                cb1_2();
            }
        });
        cb1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cb1_2();
            }
        });
        txt_III_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cb2_2.toggle();
                cb2_2();
            }
        });

        cb2_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cb2_2();
            }
        });
        txt_IV_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cb3_2.toggle();
                cb3_2();
            }
        });
        cb3_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cb3_2();
            }
        });
        txt_V_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cb4_2.toggle();
                cb4_2();
            }
        });

        cb4_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cb4_2();
            }
        });
        txt_II_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cb1_3.toggle();
                cb1_3();
            }
        });
        cb1_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cb1_3();
            }
        });
        txt_III_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cb2_3.toggle();
                cb2_3();
            }
        });
        cb2_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cb2_3();
            }
        });
        txt_IV_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cb3_3.toggle();
                cb3_3();
            }
        });
        cb3_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cb3_3();
            }
        });
        txt_V_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cb4_3.toggle();
                cb4_3();
            }
        });

        cb4_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cb4_3();
            }
        });
        txt_II_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cb1_4.toggle();
                cb1_4();
            }
        });
        cb1_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cb1_4();
            }
        });
        txt_III_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cb2_4.toggle();
                cb2_4();
            }
        });

        cb2_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cb2_4();
            }
        });
        txt_IV_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cb3_4.toggle();
                cb3_4();
            }
        });
        cb3_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cb3_4();
            }
        });
        txt_V_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cb4_4.toggle();
                cb4_4();
            }
        });
        cb4_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cb4_4();
            }
        });
        txt_VI_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cb5_4.toggle();
                cb5_4();
            }
        });

        cb5_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cb5_4();
            }
        });
        txt_II_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cb1_5.toggle();
                cb1_5();
            }
        });
        cb1_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cb1_5();
            }
        });
        txt_III_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cb2_5.toggle();
                cb2_5();
            }
        });

        cb2_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cb2_5();}
        });
        txt_IV_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cb3_5.toggle();
                cb3_5();
            }
        });
        cb3_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cb3_5();
            }
        });
        txt_V_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cb4_5.toggle();
                cb4_5();
            }
        });
        cb4_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cb4_5();
            }
        });
        btn_drl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickPushData();
// show dialog nen

            }
        });
        return v;
    }

    private void cb4_5() {
        if (cb4_5.isChecked()) {
            sum5 += 2;
            txt_sum5.setText("Cộng mục V:" + " " + String.valueOf(sum5));
            totalDisplay();
        } else {
            sum5 -= 2;
            txt_sum5.setText("Cộng mục V:" + " " + String.valueOf(sum5));
            totalDisplay();
        }
    }

    private void cb3_5() {
        if (cb3_5.isChecked()) {
            sum5 += 3;
            txt_sum5.setText("Cộng mục V:" + " " + String.valueOf(sum5));
            totalDisplay();
        } else {
            sum5 -= 3;
            txt_sum5.setText("Cộng mục V:" + " " + String.valueOf(sum5));
            totalDisplay();
        }
    }

    private void cb2_5() {
        if (cb2_5.isChecked()) {
            sum5 += 2;
            txt_sum5.setText("Cộng mục V:" + " " + String.valueOf(sum5));
            totalDisplay();
        } else {
            sum5 -= 2;
            txt_sum5.setText("Cộng mục V:" + " " + String.valueOf(sum5));
            totalDisplay();
        }
    }

    private void cb1_5() {
        if (cb1_5.isChecked()) {
            sum5 += 3;
            txt_sum5.setText("Cộng mục V:" + " " + String.valueOf(sum5));
            totalDisplay();
        } else {
            sum5 -= 3;
            txt_sum5.setText("Cộng mục V:" + " " + String.valueOf(sum5));
            totalDisplay();
        }
    }

    private void cb5_4() {
        if (cb5_4.isChecked()) {
            sum4 += 2;
            txt_sum4.setText("Cộng mục IV:" + " " + String.valueOf(sum4));
            totalDisplay();
        } else {
            sum4 -= 2;
            txt_sum4.setText("Cộng mục IV:" + " " + String.valueOf(sum4));
            totalDisplay();
        }
    }

    private void cb4_4() {
        if (cb4_4.isChecked()) {
            sum4 += 4;
            txt_sum4.setText("Cộng mục IV:" + " " + String.valueOf(sum4));
            totalDisplay();
        } else {
            sum4 -= 4;
            txt_sum4.setText("Cộng mục IV:" + " " + String.valueOf(sum4));
            totalDisplay();
        }
    }

    private void cb3_4() {
        if (cb3_4.isChecked()) {
            sum4 += 5;
            txt_sum4.setText("Cộng mục IV:" + " " + String.valueOf(sum4));
            totalDisplay();
        } else {
            sum4 -= 5;
            txt_sum4.setText("Cộng mục IV:" + " " + String.valueOf(sum4));
            totalDisplay();
        }
    }

    private void cb2_4() {
        if (cb2_4.isChecked()) {
            sum4 += 10;
            txt_sum4.setText("Cộng mục IV:" + " " + String.valueOf(sum4));
            totalDisplay();
        } else {
            sum4 -= 10;
            txt_sum4.setText("Cộng mục IV:" + " " + String.valueOf(sum4));
            totalDisplay();
        }
    }

    private void cb1_4() {
        if (cb1_4.isChecked()) {
            sum4 += 4;
            txt_sum4.setText("Cộng mục IV:" + " " + String.valueOf(sum4));
            totalDisplay();
        } else {
            sum4 -= 4;
            txt_sum4.setText("Cộng mục IV:" + " " + String.valueOf(sum4));
            totalDisplay();
        }
    }

    private void cb4_3() {
        if (cb4_3.isChecked()) {
            sum3 += 2;
            txt_sum3.setText("Cộng mục III:" + " " + String.valueOf(sum3));
            totalDisplay();
        } else {
            sum3 -= 2;
            txt_sum3.setText("Cộng mục III:" + " " + String.valueOf(sum3));
            totalDisplay();
        }
    }

    private void cb3_3() {
        if (cb3_3.isChecked()) {
            sum3 += 2;
            txt_sum3.setText("Cộng mục III:" + " " + String.valueOf(sum3));
            totalDisplay();
        } else {
            sum3 -= 2;
            txt_sum3.setText("Cộng mục III:" + " " + String.valueOf(sum3));
            totalDisplay();
        }
    }

    private void cb2_3() {
        if (cb2_3.isChecked()) {
            sum3 += 6;
            txt_sum3.setText("Cộng mục III:" + " " + String.valueOf(sum3));
            totalDisplay();
        } else {
            sum3 -= 6;
            txt_sum3.setText("Cộng mục III:" + " " + String.valueOf(sum3));
            totalDisplay();
        }
    }

    private void cb1_3() {
        if (cb1_3.isChecked()) {
            sum3 += 10;
            txt_sum3.setText("Cộng mục III:" + " " + String.valueOf(sum3));
            totalDisplay();
        } else {
            sum3 -= 10;
            txt_sum3.setText("Cộng mục III:" + " " + String.valueOf(sum3));
            totalDisplay();
        }
    }

    private void cb4_2() {
        if (cb4_2.isChecked()) {
            sum2 += 5;
            txt_sum2.setText("Cộng mục II:" + " " + String.valueOf(sum2));
            totalDisplay();
        } else {
            sum2 -= 5;
            txt_sum2.setText("Cộng mục II:" + " " + String.valueOf(sum2));
            totalDisplay();
        }
    }

    private void cb3_2() {
        if (cb3_2.isChecked()) {
            sum2 += 10;
            txt_sum2.setText("Cộng mục II:" + " " + String.valueOf(sum2));
            totalDisplay();
        } else {
            sum2 -= 10;
            txt_sum2.setText("Cộng mục II:" + " " + String.valueOf(sum2));
            totalDisplay();
        }
    }

    private void cb2_2() {
        if (cb2_2.isChecked()) {
            sum2 += 4;
            txt_sum2.setText("Cộng mục II:" + " " + String.valueOf(sum2));
            totalDisplay();
        } else {
            sum2 -= 4;
            txt_sum2.setText("Cộng mục II:" + " " + String.valueOf(sum2));
            totalDisplay();
        }
    }

    private void cb1_2() {
        if (cb1_2.isChecked()) {
            sum2 += 6;
            txt_sum2.setText("Cộng mục II:" + " " + String.valueOf(sum2));
            totalDisplay();
        } else {
            sum2 -= 6;
            txt_sum2.setText("Cộng mục II:" + " " + String.valueOf(sum2));
            totalDisplay();
        }
    }

    private void cb5() {
        if (cb5.isChecked()) {
            sum1 = sum1 + 2;
            txt_sum1.setText("Cộng mục I:" + " " + String.valueOf(sum1));
            totalDisplay();
        } else {
            sum1 = sum1 - 2;
            txt_sum1.setText("Cộng mục I:" + " " + String.valueOf(sum1));
            totalDisplay();
        }
    }

    private void cb4() {
        if (cb4.isChecked()) {
            sum1 = sum1 + 6;
            txt_sum1.setText("Cộng mục I:" + " " + String.valueOf(sum1));
            totalDisplay();
        } else {
            sum1 = sum1 - 6;
            txt_sum1.setText("Cộng mục I:" + " " + String.valueOf(sum1));
            totalDisplay();
        }
    }

    private void cb3() {
        if (cb3.isChecked()) {
            sum1 = sum1 + 2;
            txt_sum1.setText("Cộng mục I:" + " " + String.valueOf(sum1));
            totalDisplay();
        } else {
            sum1 = sum1 - 2;
            txt_sum1.setText("Cộng mục I:" + " " + String.valueOf(sum1));
            totalDisplay();
        }
    }

    private void cb2(){
        if (cb2.isChecked()) {
            sum1 += 2;
            txt_sum1.setText("Cộng mục I:" + " " + String.valueOf(sum1));
            totalDisplay();
        } else {
            sum1 -= 2;
            txt_sum1.setText("Cộng mục I:" + " " + String.valueOf(sum1));
            totalDisplay();
        }
    }
    private void cb1() {
        if (cb1.isChecked()) {
            sum1 += 4;
            txt_sum1.setText("Cộng mục I:" + " " + String.valueOf(sum1));
            totalDisplay();
        } else {
            sum1 -= 4;
            txt_sum1.setText("Cộng mục I:" + " " + String.valueOf(sum1));
            totalDisplay();
        }
    }

    private void totalDisplay() {
        sum = sum1 + sum2 + sum3 + sum4 + sum5;
        txt_sum.setText("VI. TỔNG SỐ ĐIỂM:" + " " + String.valueOf(sum));
        if (sum >= 90) {
            level = "Xuất Sắc";
        } else if (sum >= 80) {
            level = "Tốt";
        } else if (sum >= 65) {
            level = "Khá";
        } else if (sum >= 50) {
            level = "Trung Bình";
        } else if (sum >= 35) {
            level = "Yếu";
        } else {
            level = "Kém";

        }
        txt_level.setText("Xếp Loại :" + "" + level);
    }

    private void onClickPushData() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String email = user.getEmail();
        String[] emailCopy = email.split("@");
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("user/" + emailCopy[0] + "/sum");
        myRef.setValue(sum);
        DatabaseReference myRef2 = database.getReference("user/" + emailCopy[0] + "/level");
        myRef2.setValue(level);
        openDialog(Gravity.CENTER);
    }
    private void openDialog(int gravity){
        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_mark);
        Window window = dialog.getWindow();
        if(window == null){
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.gravity = gravity;
        window.setAttributes(layoutParams);
        if(Gravity.BOTTOM == gravity){
            dialog.setCancelable(true);
        }else {
            dialog.setCancelable(false);
        }
        Button btn_ok = dialog.findViewById(R.id.btn_ok);
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}